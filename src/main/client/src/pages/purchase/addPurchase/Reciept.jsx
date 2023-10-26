import { useLocation,Link } from "react-router-dom";
import { useState } from "react";
import {Container,Row,Col,Form } from 'react-bootstrap';
import PurchaseSpan from "./PurchaseSpan";
import DaumPostcode from "react-daum-postcode";
import { Modal, Button } from "antd";

const Reciept = () => {
    const {state} = useLocation();
    const location = useLocation();
    console.log(state.carts)                 // 주소 product, 사용자 정보 결제일
    
    const [isOpen, setIsOpen] = useState(false);
    const [inputAddressValue,setInputAddressValue]=useState();
    const [inputZipCodeValue,setInputZipCodeValue]=useState();

    
    const onToggleModal = () => {
        setIsOpen((prev) => !prev);
      };

    const handleComplete = (data) => {
        console.log(data)
        onToggleModal(false);
        setInputAddressValue(data.address);
        setInputZipCodeValue(data.zonecode);
      };
      
    const productList = () => {
        return state.carts.map((cart,idx)=>{
            if (cart){
              return <PurchaseSpan key={idx} id={idx} cart={cart} />
            }
            return null;
          })
    }

    return(
        <Container className="cart"><br /><br />
            <Row>
                <h4>주문 페이지</h4>
            </Row><hr/><br/>
            <Row>     
                <Col md={6}>   
                    <h4>상품목록</h4>     
                    <Row>
                        { productList() }
                    </Row>
                </Col>
                            
                <Col md={6}>
                    <h4>결제 설정</h4><br/>
                    <Row><hr/>
                        <Row className="d-flex justify-content-between">
                            <Col className="text-start">
                                <Form.Control placeholder="우편번호" value={inputZipCodeValue} readOnly></Form.Control>    
                            </Col>
                            <Col>
                                <Button variant="primary" onClick={onToggleModal}>주소 변경</Button>   
                            </Col>
                        </Row>
                    </Row><br/>
                    <Row>
                        <Col>
                            <Form.Control placeholder="도로명 주소" value={inputAddressValue} readOnly></Form.Control>
                        </Col>
                        
                    </Row><hr/>
                    
                    {isOpen && (
                        <Modal title="배송지 설정" visible={true} onOk={onToggleModal} onCancel={onToggleModal}>
                            <DaumPostcode onComplete={handleComplete} />
                        </Modal>
                    )}
                    
                </Col> // 전화번호 설정 구매방법 설정
            </Row>
            
      </Container>
    )
}

export default Reciept;