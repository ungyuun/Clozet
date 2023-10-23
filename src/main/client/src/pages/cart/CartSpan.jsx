import {Container,Row,Col,CloseButton,Form } from 'react-bootstrap';

function CartSpan({cart,handleChange,selectData}){

    return(
        <>
            <Container>
                <Col md={1}>
                    <Form.Check
                        onChange={handleChange}
                        name={"check"}
                        type="check"
                        checked={selectData.check}
                    >
                        라벨이름
                    </Form.Check>
                </Col>
                <Col id="header" md={11}>                                        
                    <Row className="prodNm">
                        {cart.title}
                        <CloseButton aria-label="Hide"/>
                    </Row>
                    <Row>
                        <span>수량 {cart.amount} | {cart.size}</span>
                        {cart.price}
                    </Row>
                    <Row>
                        <button> 수량|옵션 </button>                        
                        {cart.price}
                    </Row>
                </Col>
            </Container>
        </>
    )
}

export default CartSpan;