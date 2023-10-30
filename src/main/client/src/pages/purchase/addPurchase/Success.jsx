import {react} from "react";
import { Navigate, useLocation, useNavigate } from "react-router-dom";
import {Container,Row,Col,Form,Button } from 'react-bootstrap';
import PurchaseSpan from "./PurchaseSpan";
import SeperaterMoney from '../../../services/SeperaterMoney';
const Success = () =>{
    const {data} = useLocation().state;
    const navigate = useNavigate();
    const productList = () => {
        return data.product.map((cart,idx)=>{
            if (cart){
              return <PurchaseSpan key={idx} id={idx} cart={cart} />
            }
            return null;
          })
    }
    return (
        <Container><br /><br />
            <Row>
                <Col md={3}></Col>
                <Col md={6}>
                    <Row>
                        <h4>주문 완료</h4>
                    </Row><hr/><br/>
                    <Row className="d-flex justify-content-between">
                        <Col className="text-start">주문 번호</Col>
                        <Col className="text-end">{data.paymentId}</Col>
                    </Row><br/>
                    <Row className="d-flex justify-content-between">
                        <Col className="text-start">주문 일자</Col>
                        <Col className="text-end">{`${data.regDate[0]}-${data.regDate[1]}-${data.regDate[2]}`}</Col>
                    </Row><br/>
                    <Row>
                        { productList() }
                    </Row><br/>
                    
                    <Row>        
                        <h5>결제 정보</h5><hr/>
                        <Row id="name" className="mb-3">
                            <Col>{data.user.kakaoNickname} {data.user.receive} </Col>
                        </Row>
                        <Row id="phone" className="mb-3">
                            <Col>{data.user.cellPhone}</Col>
                        </Row>
                        <Row id="address" className="mb-3">
                            <Col>{data.user.postCode} {data.user.address} {data.user.detailAddress} {data.user.addressDetail}</Col>
                        </Row><hr/>
                        <Row id="delevery" className="mb-3">
                            <Col>{data.deleveryOption}</Col>
                        </Row><hr/>
                        <Row className="d-flex justify-content-between mb-3">
                        <Col className="text-start">{data.selectedPayment} 결제</Col>
                        <Col className="text-end">{SeperaterMoney(data.totalPrice)} 원</Col>
                    </Row><hr/><br/>
                    <div className="d-grid gap-2 mt-4">
                        <Button onClick={()=>navigate('/product/main')}>확인</Button>
                    </div>
                    </Row>

                </Col>
                <Col md={3}></Col>
            </Row>
        </Container>
    )
}
export default Success;