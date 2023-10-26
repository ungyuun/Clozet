import react from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';


function Card({ data, lastItemRef,index}){
    const navigate = useNavigate();
    const handleCardClick = () => {
        navigate(`/product/${data.prodNo}`);
      };
    function formatMoney(amount) {
        return amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    }
    return (

        <div key={data.prodNo} onClick={handleCardClick}>
            <p><img className="product-image-container" src={data.thumbnail} /></p>
            <p>
                {data.title}
            </p>           
            <span
                ref={lastItemRef}
            > 
            </span>
            <span>
                {formatMoney(data.price)}원
            </span>
        </div>
    );
}
export default Card;