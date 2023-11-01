import react from 'react';
import { useNavigate,NavLink } from 'react-router-dom';
import {Container,Row,Col,Form,Button } from 'react-bootstrap';

import formatDateToYYYYMMDD from '../../../services/FormatDateTo';
import formatMoney from '../../../services/SeperaterMoney';

function MyPurchase({ data, lastItemRef,index}){
    const navigate = useNavigate();

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
        {data.purchaseList.map((item,idx)=>(
            <Row><hr/>
                <Col md={1}>           
                </Col>
                <Col className="cartthumbnail" md={2}>
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
        
        <span
                ref={lastItemRef}
            > .
            </span>
        </Container>

        // <div key={data.prodNo} onClick={handleCardClick}>
        //     <p><img className="product-image-container" src={data.thumbnail} /></p>
        //     <p>
        //         {data.title}
        //     </p>           
            
        //     <span>
        //         {formatMoney(data.price)}원
        //     </span>
        // </div>
    );
}
export default MyPurchase;