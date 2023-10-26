import {Container,Row,Col,CloseButton } from 'react-bootstrap';
import {useState,useEffect} from 'react';
import {NavLink} from "react-router-dom";

function PurchaseSpan({cart}){
    
    const [itemPrice,setItemPrice] = useState(cart.price*cart.amount)

   
    return(
        <>
            <Container><hr/>
                <Row>
                    <Col md={1}>           
                    </Col>
                    <Col className="cartthumbnail" md={3}>
                        <NavLink to={`/product/${cart.prodNo}`}>
                            <img src={cart.thumbnail} />
                        </NavLink>
                    </Col>  
                    <Col md={2}>           
                    </Col>
                    <Col id="header" md={5}><br/><br/>           
                        <Row className="d-flex justify-content-between">
                            <Col className="text-start"><h5>{cart.title}</h5></Col>
                        </Row><br/>
                        <Row className="d-flex justify-content-between">
                            <Col className="text-start"><span>수량 {cart.amount} | {cart.size}</span></Col>
                            <Col className="text-end"><h5>{itemPrice}원</h5></Col>
                        </Row>
                    </Col>
                </Row>
            </Container><hr/>
        </>
    )
}

export default PurchaseSpan;