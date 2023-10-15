import { useNavigate } from "react-router-dom";
import axios from "axios";

function LogoutHandler(){
    // const navigate = useNavigate();
    
    const url = 'https://kapi.kakao.com/v1/user/logout';
    const access_token = localStorage.getItem("access_token");

    const headers = {
    'Content-Type': 'application/x-www-form-urlencoded',
    'Authorization': `Bearer ${access_token}`,
    };
    console.log(`삭제할 토큰 ${access_token}`)
    axios.post(url, null, { headers })
    .then(response => {
        
        localStorage.removeItem("access_token");
        localStorage.removeItem("JWT");
        localStorage.removeItem("nickname");
        window.location.href = '/'
    })
    .catch(error => {
        console.error(error);
        if (error.response.data.code === -401) {
            window.location.href = '/'
          }
    });
}

export default LogoutHandler;