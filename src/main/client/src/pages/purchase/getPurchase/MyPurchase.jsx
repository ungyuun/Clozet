import react from 'react';
import { useNavigate,NavLink } from 'react-router-dom';
import {Container,Row,Col,Form } from 'react-bootstrap';
import { Button } from "antd";

import formatDateToYYYYMMDD from '../../../services/FormatDateTo';
import formatMoney from '../../../services/SeperaterMoney';

function MyPurchase({ data, lastItemRef,index}){
    const navigate = useNavigate();

    const handleCardClick = (item) => {
        navigate(`/product/${item.prodNo}`);
      };

    const getPurchase = () => {
        navigate(`/purchase/${data.paymentId}`)
    }
    return (
        <Container><hr/>
        <Row id="ih" className="d-flex justify-content-between" onClick={getPurchase}>
            <Col className="text-start">
                결제번호 {data.paymentId}
            </Col>
            <Col className="text-end">{formatDateToYYYYMMDD(data.regDate)}</Col>
        </Row><br/>
        <Row>
            <Col>
            {/* 상품 상태 정의 */}
            </Col>
        </Row>
        {data.purchaseList.map((item,idx)=>(
            <Row><hr/>
                <Col md={1}>           
                </Col>
                <Col className="cartthumbnail" md={2} onClick={()=>handleCardClick(item)}>
                    <img src={item.thumbnail} />
                </Col>  
                <Col md={1}>           
                </Col>
                <Col id="header" md={6}><br/>           
                    <Row className="d-flex justify-content-between">
                        <Col className="text-start"><h5>{item.title}</h5></Col>
                    </Row><br/>
                    <Row className="d-flex justify-content-between">
                        <Col className="text-start"><span>수량 {item.amount} | {item.size}</span></Col>
                        <Col className="text-end"><h5>{formatMoney(item.price)}원</h5></Col>
                    </Row>
                </Col><hr/>
            </Row>
        ))}
        <Row className="d-grid gap-2 mt-4">
            <Col className="text-end"><Button>결제 취소</Button></Col>
        </Row>
        
        <span
                ref={lastItemRef}
            > .
            </span>
        </Container>

    );
}
export default MyPurchase;