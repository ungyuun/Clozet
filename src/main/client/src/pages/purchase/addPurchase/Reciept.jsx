import { useLocation,useNavigate } from "react-router-dom";
import { useState,useEffect } from "react";
import {Container,Row,Col,Form,Button } from 'react-bootstrap';
import PurchaseSpan from "./PurchaseSpan";
import MyInfo from "../../user/info/MyInfo";
import '../../../styles/purchase.css';
import SeperaterMoney from '../../../services/SeperaterMoney';

import CheckStock from "../../../services/CheckStock";
import StockModal from "../../../components/StockModal";
import Payment from "../../../services/Payment";

const Reciept = () => {
    const {state} = useLocation();
    const location = useLocation();    
    const navigate = useNavigate();     
    const [user,setUser] = useState('');
    const [deleveryOption,setDeleveryOption] = useState(["부재 시 경비실에 맡겨주세요","부재 시 택배함에 넣어주세요",
                                                    "부재 시 집 앞에 놔주세요","배송 전 연락 바랍니다","파손의 위험이 있는 상품입니다. 배송시 주의해주세요."  
                                                ]);
    const [selectedPayment, setSelectedPayment] = useState();
    const [totalPrice,setTotalPrice] = useState(0)      
    const [isOpen, setIsOpen] = useState(false);
    const [stock,setStock]=useState();         

    const handleDivClick = (value) => {
        setSelectedPayment(value);
    };
    const [selectedOption, setSelectedOption] = useState(""); 

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value); 
    };
    
    const getUser = (data) => {
        setUser(data)
    }

    
    const onToggleModal = () => {
        setIsOpen((prev) => !prev);
      };
    const errorCallback = (x) =>{
        setStock(x)
        setIsOpen(true)
    }
                                                
    const productList = () => {
        let newTotalPrice = 0;
        return state.product.map((cart,idx)=>{
            if (cart){
                console.log(cart)
                const itemTotalPrice = cart.price*cart.amount
                newTotalPrice += itemTotalPrice 
              return <PurchaseSpan key={idx} id={idx} cart={cart} />
            }
            return null;
            setTotalPrice(newTotalPrice)
          })
    }
    const countPrice = () => {
        let newTotalPrice = 0;
        return state.product.map((cart)=>{
                console.log(cart)
                const itemTotalPrice = cart.price*cart.amount
                newTotalPrice += itemTotalPrice 
                setTotalPrice(newTotalPrice)
        })
    }
    const isStock = () => {
        const newPurchaseOption = {
            product: state.product,
            deleveryOption: selectedOption,
            selectedPayment: selectedPayment,
            totalPrice: totalPrice,
            user: user
        };
        
        console.log(newPurchaseOption);
        CheckStock(errorCallback,state.product,location)
        .then(() => {
            newPurchaseOption.user = user;
            Payment(newPurchaseOption,location,navigate);
        })
        .catch((error) => {
          console.log(error)
        });
        
        
        
    }
    useEffect(()=>{
        countPrice()
        
    },[selectedPayment])

    return(
        <Container className="cart"><br /><br />
            <Row>
                <h4>주문 페이지</h4>
            </Row><hr/><br/>
            <Row>     
                <Col md={5}>   
                    <h4>상품목록</h4>     
                    <Row>
                        { productList() }
                    </Row>
                </Col>
                <Col md={1}></Col>
                <Col md={6}>
                    <Row>
                        <MyInfo getUser={getUser}/>
                    </Row>
                    <Row>
                        <Form.Select value={selectedOption} onChange={handleOptionChange}>
                            <option>배송 시 요청사항을 선택해주세요</option>
                            {deleveryOption.map((opt,idx)=>(
                                <option key={idx} value={opt}>{opt}</option>
                            ))}
                        </Form.Select>
                    </Row><hr/>
                    <Row>
                    <Form>
                        <Col className="mt-3 mb-3" onClick={() => handleDivClick('kakao')}>
                            <Form.Check 
                                type="radio"
                                inline
                                id="1"
                                name="paymentMethod"
                                checked={selectedPayment === 'kakao'}
                            />
                            <img src="https://kr.object.ncloudstorage.com/clozet/kakaotalk_sharing_btn_small.png" />
                            <span className="m-3">카카오페이 결제</span>
                        </Col>
                        <Col className="mb-3" onClick={() => handleDivClick('toss')}>
                            <Form.Check
                                type="radio"
                                inline
                                id="2"
                                name="paymentMethod"
                                checked={selectedPayment === 'toss'} 
                            />
                            <img src="https://kr.object.ncloudstorage.com/clozet/Toss-Symbol.png" />
                            <span className="m-3">토스페이 결제</span>
                        </Col>
                    </Form>
                    </Row><hr/>
                    <Row>
                        <ul className="purchaseList">
                            <li>
                                <Row className="d-flex justify-content-between">
                                    <Col className="text-start">상품 금액</Col>
                                    <Col className="text-end">{SeperaterMoney(totalPrice)}원</Col>
                                </Row>
                            </li>
                            <li>
                                <Row className="d-flex justify-content-between">
                                    <Col className="text-start">배송비 합계</Col>
                                    <Col className="text-end">배송비 무료</Col>
                                </Row>
                            </li>
                            <li>
                                <Row className="d-flex justify-content-between">
                                    <Col className="text-start">할인 합계</Col>
                                    <Col className="text-end"></Col>
                                </Row>
                            </li>
                            <li>
                                <Row className="d-flex justify-content-between">
                                    <Col className="text-start">결제 수수료</Col>
                                    <Col className="text-end">0원</Col>
                                </Row>
                            </li>
                            <li>
                                <Row className="d-flex justify-content-between">
                                    <Col className="text-start">결제 금액</Col>
                                    <Col className="text-end">{SeperaterMoney(totalPrice)}원</Col>
                                </Row>
                            </li>
                        </ul>
                    </Row>
                    <div className="d-grid gap-2 mt-4">
                        <Button onClick={isStock}>{SeperaterMoney(totalPrice)} 결제</Button>
                    </div>
                </Col>
            </Row>
            {isOpen && (
                <StockModal stock={stock} onToggleModal={onToggleModal} />
            )}
      </Container>
    )
}

export default Reciept;