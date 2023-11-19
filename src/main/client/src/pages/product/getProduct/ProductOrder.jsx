import react from 'react';
import {useState,useEffect} from 'react';
import Dropdown from 'react-bootstrap/Dropdown';
import { Form, Row, Col,Button} from 'react-bootstrap';
import axiosInstance from '../../common/AxiosInstance';
import CartModal from '../../cart/CartModal';
import { useLocation, useNavigate } from 'react-router-dom';
import formatMoney from '../../../services/SeperaterMoney';
import StockModal from '../../../components/StockModal';
import CheckStock from '../../../services/CheckStock';
function ProductOrder({data}){

    const [options,setOptions] = useState({});
    const location = useLocation();
    const navigate = useNavigate();
    const price = data.product.price;
    const [sum, setSum] = useState(0);
    const [showCartModal, setShowCartModal] = useState(false);
    const [cart,setCart] = useState();
    const [isOpen, setIsOpen] = useState(false);
    const [stock,setStock]=useState();         

    const handleOptionSelect = (idx, opt, price) => {
        // 동적 키를 가진 새 객체를 만듭니다
        const newOptions = { ...options };

    // 해당 idx에 대한 옵션 정보 업데이트 또는 추가
        newOptions[idx] = {
            prodNo: data.product.prodNo,
            title: data.product.title,
            thumbnail:data.product.thumbnail,
            email:sessionStorage.getItem("email"),
            size: opt,
            price: price,
            amount: 1 // 초기값으로 1을 설정
        };

        // 상태 업데이트
        setOptions(newOptions);
      };
    console.log(data)
    const handleAmountChange = (idx, newAmount) => {
        // 해당 idx에 대한 amount를 업데이트
        setOptions((prevOptions) => ({
          ...prevOptions,
          [idx]: {
            ...prevOptions[idx],
            amount: newAmount
          }
        }));
      };
    const handlePriceChange = (idx, newPrice) => {
    // 해당 idx에 대한 amount를 업데이트
        setOptions((prevOptions) => ({
            ...prevOptions,
            [idx]: {
            ...prevOptions[idx],
            price: newPrice
            }
        }));
    };
      

    const handleDecrease = (idx) => {
      console.log(idx)
      if (options[idx].amount > 1) {
        let prevPrice = options[idx].price;  
        prevPrice = prevPrice - price;
        handleAmountChange(idx, options[idx].amount - 1);
        handlePriceChange(idx,prevPrice);
      }
    };
  
    const handleIncrease = (idx) => {
      let prevPrice = options[idx].price;  
      prevPrice = prevPrice + price;
      handleAmountChange(idx, options[idx].amount + 1);
      handlePriceChange(idx,prevPrice);
    };
    const handleRemove = (idx) => {
      const newOptions = { ...options };
      delete newOptions[idx]; // 해당 idx에 해당하는 옵션 제거
      setOptions(newOptions);
    };
      
    const updateSum = () => {
      const totalPrice = Object.values(options).reduce((acc, option) => {
        console.log(options);
        return acc + option.price;
      }, 0);
      setSum(totalPrice);
    };

    
    const onToggleModal = () => {
      setIsOpen((prev) => !prev);
    };
    
    const errorCallback = (x) =>{
      setStock(x)
      setIsOpen(true)
    }

    function addCart(){
      
      CheckStock(errorCallback,Object.values(options),location)
          .then(() => {
              axiosInstance.post(`${process.env.PUBLIC_URL}/api/cart/`, Object.values(options),{
                params: {
                    pathname: location.pathname, 
                  },
              })
              .then((response) => {
                  console.log(response.data);       
                  setCart(response.data);   
                  setShowCartModal(true);                  
                 })
                .catch((error) => {
                });
          })
          .catch((error) => {
            console.log(error)
          });
    }
    const addReciept = () =>{
      const product = Object.values(options);
      CheckStock(errorCallback,product,location)
          .then(() => {
              navigate("/purchase/reciept", { state: { product } });
          })
          .catch((error) => {
            console.log(error)
          });
    
    }
    useEffect(()=>(
        updateSum()
    ),[options])
    return(
        <div className="orderBox"><hr />
          <Dropdown className="d-inline mx-2">
              <Dropdown.Toggle id="dropdown-autoclose-true">
              옵션 선택
              </Dropdown.Toggle><hr />

              <Dropdown.Menu>
                  {data.productDetail.map((datas, idx) => (
                      <Dropdown.Item key={idx} href="#" onClick={() => handleOptionSelect(idx,datas.size,price)}>
                          {datas.size}
                      </Dropdown.Item>
                  ))}
              </Dropdown.Menu>
          </Dropdown>
          <ul className="optList">
            {Object.entries(options).map(([key, option]) => (
              <li key={key}>
                <Row>
                  <Col md={5}>
                    <span className="opt">{option.size}</span>
                  </Col>
                  <Col md={3}>
                    <span className="amount">
                      <button variant="danger" onClick={() => handleDecrease(key)}>
                        &nbsp;-&nbsp;
                      </button>
                      <input
                        type="number"
                        value={option.amount}
                        onChange={(e) => handleAmountChange(key, parseInt(e.target.value))}
                        inputMode="none"
                      />
                      <button onClick={() => handleIncrease(key)}>&nbsp;+&nbsp;</button>
                    </span>
                  </Col>
                  <Col md={3}>
                    <span className="price">{formatMoney(option.price)}원</span>
                  </Col>
                  <Col md={1}>
                    <span>
                      <button onClick={() => handleRemove(key)}>-</button>
                    </span>
                  </Col>
                </Row>
                <input type="hidden" name="buy_list_option_info" value={option.size} />
              </li>
            ))}
          </ul>
          <div className="orderOption">
            <Row id="totalPrice">
              
              <Col md={4}><h5>&nbsp;&nbsp;&nbsp;총 상품금액</h5></Col>
              <Col md={4}></Col>
              <Col md={3}><h5>{formatMoney(sum)}원</h5></Col>
            </Row>
            <hr />
            <Row className="bottom_bt">
                <Col md={6}>
                    <Button className="primary" onClick={addCart}>장바구니</Button>
                </Col>
                <Col md={6}>
                    <Button className="primary" onClick={addReciept}>구매</Button>
                </Col>
            </Row>
            {showCartModal && <CartModal setShowCartModal={setShowCartModal} />}
          </div>
          
          {isOpen && (
                <StockModal stock={stock} onToggleModal={onToggleModal} />
            )}
        </div>
    )
}

export default ProductOrder;
