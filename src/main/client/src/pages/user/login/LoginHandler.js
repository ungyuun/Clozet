import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
import axios from "axios";

const LoginHandeler = (props) => {
  const navigate = useNavigate();
  const code = new URL(window.location.href).searchParams.get("code");

//인가코드 백으로 보내는 코드
  useEffect(() => {
    const kakaoLogin = async () => {
      await axios({
        method: "GET",
        url: `${process.env.REACT_APP_REDIRECT_URL}/?code=${code}`,
        
      }).then((res) => { //백에서 완료후 우리사이트 전용 토큰 넘겨주는게 성공했다면
        console.log(res);
        if (res.data.KakaoTokenDto.id_token) {
            localStorage.setItem('access_token',res.data.KakaoTokenDto.access_token);
            localStorage.setItem('JWT', res.data.KakaoTokenDto.id_token);
            localStorage.setItem('nickname', res.data.UserDto.nickname);
            
          }
        console.log(res.data.KakaoTokenDto.id_token)

        navigate(localStorage.getItem("currentPage"));
        localStorage.removeItem("currentPage");
      });
    };
    localStorage.setItem("token",code);
    kakaoLogin();
    console.log(`code : ${code}`);
  }, [code]);
};

export default LoginHandeler;