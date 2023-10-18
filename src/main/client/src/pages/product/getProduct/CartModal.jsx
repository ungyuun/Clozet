
import CloseButton from 'react-bootstrap/CloseButton';
import axios from 'axios';
import axiosInstance from '../../common/AxiosInstance';


//누르면 이동 axios get 요청을 함.
function CartModal(){

    function getCart(){
        axios.get(`${process.env}/cart`,{
            headers: {
            'Authorization': 'Bearer ' + localStorage.getItem("JWT"),
        }})
        .then((response) => {
            console.log(response.data);            
          })
          .catch((getError) => {
            console.log(`GET 요청 에러: ${getError}`);
          });
    }
    return(
        <div>
            <h4>장바구니에 상품이 담겼습니다</h4>
            <button onClick={getCart}>장바구니 이동</button>
            <CloseButton aria-label="Hide" />
        </div>
    )
}
export default CartModal;