import {useState,useEffect} from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axiosInstance from '../common/AxiosInstance';
import CartSpan from './CartSpan';
import {Container,Row,Col,Button,Form } from 'react-bootstrap';

//https://egg-programmer.tistory.com/282
function CartList(){
    const location = useLocation();
    const navigate = useNavigate(); 
    const [cartList,setCartList] = useState([]);
    const [checkItems, setCheckItems] = useState(new Set())
    const [isAllChecked, setIsAllChecked] = useState(false);
    const [totalPrice,setTotalPrice] = useState(0);
    const [token,setToken] = useState(false);
    useEffect(()=>{
      const fetchData = async () => {
        try {
          console.log("a");
          const {data} = await axiosInstance.get(`${process.env.PUBLIC_URL}/cart/`, {
            params: {
              pathname: location.pathname,
            },
          });
          return data;
        } catch (error) {
          throw error;
        }
      };
      fetchData()
        .then((data) => {setCartList(data); setToken(false)})
        .catch((error) => {
        });
    }, [token]);

    function formatMoney(amount) {
      return amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    }

    const addReciept = () =>{
      const setToArray = Array.from(checkItems);
      const carts = setToArray.map(item => item.cart); // set을 배열로 변경해 cart 삽입
      if(checkItems.size === 0)
        alert("선택한 상품이 없습니다")
      else{
          navigate("/purchase/reciept",{state: { carts }})
      }
    }

    const checkItemHandler = (id,cart,isChecked) => {
      if (isChecked) {
        // checkItems.add(id);
        console.log(cart)
        checkItems.add({ id: Number(id), cart: cart });
        setCheckItems(checkItems);
      } else if (!isChecked) {
        checkItems.forEach((item) => {
          if (item.id === Number(id)) {
            checkItems.delete(item);
          }
        });
        setCheckItems(checkItems);
      }
      countTotalPrice()
    };
      
      const allCheckedHandler = ({target}) => {
        console.log(cartList.map((cart, index) => ({ id: index, cart: cart })))
        if (target.checked) {
          // setCheckItems(new Set(cartList.map((cart, index) => ({ id: index, cart: cart }))))
          cartList.map((cart, index) => {
            checkItems.add({ id: index, cart: cart })
            setCheckItems(checkItems)
          })
          countTotalPrice()
          setIsAllChecked(true)
          
        } else {
          checkItems.clear();
          setCheckItems(checkItems);
          setIsAllChecked(false)
          setTotalPrice(0)
        }console.log(checkItems)
      }
    const countTotalPrice = () =>{
      let newTotalPrice = 0;
      checkItems.forEach((cart) => {
        // console.log(cart.cart.price)
        const itemTotalPrice = cart.cart.price*cart.cart.amount
        newTotalPrice += itemTotalPrice
      });
      setTotalPrice(newTotalPrice)
    }
    
    return(
        <Container className="cart"><br /><br />
            
            <Row>        
                <Col md={3}>

                </Col>
                <Col md={6}>                      
                  <Row>
                    <h4>장바구니</h4>
                  </Row><hr/>
                    <Row className="d-flex justify-content-between">
                        <Col className="text-start">
                          <input className="check_btn" type="checkbox" onChange={(e) => allCheckedHandler(e)} />&nbsp;&nbsp;&nbsp;&nbsp;
                          <label for="check_btn"><h4>전체 선택</h4></label>
                        </Col>
                        <Col className="text-end"><h4>전체 개수 {cartList.length}</h4></Col>
                    </Row><hr />
                    <Row>
                        {
                          cartList.map((cart,idx)=>{
                              if (cart){
                                return <CartSpan key={idx} id={idx} cart={cart} setToken={setToken} isAllChecked={isAllChecked} checkItemHandler={checkItemHandler}/>
                              }
                              return null;
                            })
                          
                        }
                    </Row>
                    <Row>
                      <Button onClick={addReciept}>총 {checkItems.size}개 | {totalPrice} 결제</Button>
                    </Row>
                </Col>
                <Col md={3}>

                </Col>
            </Row>
            
      </Container>
    )
}

export default CartList;