import {Container,Row,Col,CloseButton } from 'react-bootstrap';
import { Modal, Button } from "antd";
import {useState,useEffect} from 'react';
import { useLocation } from 'react-router-dom';
import '../../styles/cart.css'
import axiosInstance from '../common/AxiosInstance';
import {NavLink} from "react-router-dom";

function CartSpan({cart,id,setToken,checkItemHandler,isAllChecked}){
    const location = useLocation();
    const [checked, setChecked] = useState(false); // 체크 여부 판단
    const [itemPrice,setItemPrice] = useState(cart.price*cart.amount)

    function formatMoney(amount) {
        return amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      }

    const checkHandled = ({target}) => {
      setChecked(!checked);
      console.log(target.id, target.checked)
      checkItemHandler(target.id,cart,target.checked);
    }
    const allCheckHandler = () => setChecked(isAllChecked);

    const deleteCart = () =>{
        axiosInstance.delete(`${process.env.PUBLIC_URL}/api/cart/${cart.id}`,{
            params: {
                pathname: location.pathname,
              },
        }).then((response) => {
            console.log("done"); 

            setToken(true);  
        })
        .catch((error) => {
        });
    }
    

    useEffect(() => (allCheckHandler()), [isAllChecked]); 
    return(
        <>
            <Container>
                <Row>
                    <Col md={1}>
                        <input id={id} className="check_btn" type="checkbox" checked={checked} onChange={(e) => checkHandled(e)} />
                        <label for="check_btn"></label>
                    </Col>
                    <Col className="cartthumbnail" md={5}>
                        <NavLink to={`/product/${cart.prodNo}`}>
                            <img src={cart.thumbnail} />
                        </NavLink>
                    </Col>  
                    <Col id="header" md={8}>                                        
                            <Row className="d-flex justify-content-between">
                                <Col className="text-start"><h5>{cart.title}</h5></Col>
                                <Col className="text-end"><CloseButton aria-label="Hide" onClick={deleteCart}/></Col>
                            </Row><br/>
                            <Row className="d-flex justify-content-between">
                                <Col className="text-start"><span>수량 {cart.amount} | {cart.size}</span></Col>
                                <Col className="text-end">{formatMoney(cart.price)}원</Col>
                            </Row><br/>
                            <Row className="d-flex justify-content-between mb-3">
                                <Col className="text-start"><Button> 수량|옵션 </Button></Col>
                                <Col className="text-end"><h5>{formatMoney(itemPrice)}원</h5></Col>
                            </Row>
                        <Row>
                                                    
                            
                        </Row>
                    </Col>
                </Row>
            </Container><hr/>
        </>
    )
}

export default CartSpan;