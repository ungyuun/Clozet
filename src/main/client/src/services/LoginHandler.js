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
        sessionStorage.setItem('email',res.data.kakao_account.email);
        sessionStorage.setItem('JWT', res.headers.authorization);
        sessionStorage.setItem('nickname', res.data.properties.nickname);
        sessionStorage.setItem('profile', res.data.properties.thumbnail_image);

        navigate(localStorage.getItem("currentPage"));
        localStorage.removeItem("currentPage");
      });
    };
    kakaoLogin();
    console.log(`code : ${code}`);
  }, [code]);
};

export default LoginHandeler;