import CloseButton from 'react-bootstrap/CloseButton';
import {useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
function CartModal({setShowCartModal}){
    const navigate = useNavigate();

    const getCart = ()=>{
        navigate(`/cart`);
    }
    
    return(
        <div>
            <h4>장바구니에 상품이 담겼습니다</h4>
            <button onClick={getCart}>장바구니 이동</button>
            <CloseButton aria-label="Hide" onClick={()=>setShowCartModal(false)}/>
        </div>
    )
}
export default CartModal;