import {useState,useEffect} from 'react';
import { useLocation } from 'react-router-dom';
import axiosInstance from '../common/AxiosInstance';
import CartSpan from './CartSpan';
import {Container,Row,Col,CloseButton,Form } from 'react-bootstrap';

function CartList(){
    const location = useLocation();
    const [cartList,setCartList] = useState([]);
    useEffect(()=>{
        axiosInstance.get(`${process.env.PUBLIC_URL}/cart/`,{
            params: {
                pathname: location.pathname,
              },
        })
        .then((response) => {
            console.log(response.data);   
            setCartList(response.data);
          })
          .catch((error) => {
          });
    },[])

    const [selectData, setSelectData] = useState({
        all: false,
        check: false,
      });
    // handleChange 에서 전체선택, 개별선택값에 따라 name에 맞는 checked 값을 변경한다.
      const handleChange = (e) => {
        const { checked, name } = e.target;
    
        if (name === "all") {
          setSelectData((prev) => {
            const newData = { ...prev };
            for (let key in newData) {
              newData[key] = checked;
            }
            console.log("마지막", newData);
            return newData;
          });
        } else {
          setSelectData({
            ...selectData,
            [name]: checked,
          });
        }
      };
        
    
    return(
        <Container>
            <Row>        
                <Col id="header" md={6}>                                        
                    <Row className="prodNm">
                        <div>
                            <Form.Check onChange={handleChange} name={"all"} type="radio" checked={selectData.all}>
                                전체선택
                            </Form.Check>
                        </div>
                        <h4>전체 개수</h4>
                        <CloseButton aria-label="Hide"/>
                    </Row><hr />
                    <Row>
                        {
                          cartList.map((cart,idx)=>{
                              if (cart){
                                return <CartSpan cart={cart} handleChange={handleChange} selectData={selectData}/>
                              }
                              return null;
                            })
                          
                        }
                        
                    </Row>
                </Col>
                <Col md={6}>

                </Col>
            </Row>
      </Container>
    )
}

export default CartList;