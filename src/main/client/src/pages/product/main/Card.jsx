import react from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';


function Card({ data, lastItemRef,index,setNow}){
    const navigate = useNavigate();
    const handleCardClick = () => {
        navigate(`/product/view/${data.prodNo}`);
        setNow(0);
      };
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
                {data.price}원
            </span>
        </div>
    );
}
export default Card;