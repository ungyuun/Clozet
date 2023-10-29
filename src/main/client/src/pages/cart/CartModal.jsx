import {CloseButton,Card} from 'react-bootstrap';
import {useNavigate } from 'react-router-dom';
import { Button } from "antd";
import { useEffect } from 'react';
function CartModal({setShowCartModal}){
    const navigate = useNavigate();

    const getCart = ()=>{
        navigate(`/cart`);
    }
    
    return(
        <Card className="mt-3">
            <Card.Body>
                <h4>장바구니에 상품이 담겼습니다</h4>
                <Button className="m-3"onClick={getCart}>장바구니 이동</Button>
                <CloseButton aria-label="Hide" onClick={()=>setShowCartModal(false)}/>
            </Card.Body>
        </Card>
    )
}
export default CartModal;