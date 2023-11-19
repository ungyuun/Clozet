import axios from 'axios';
import { useLocation } from "react-router-dom";

const CLIENT_ID = process.env.REACT_APP_REST_API_KEY;
const REDIRECT_URI = process.env.REACT_APP_CLOZET_CLIENT_REDIRECT_URL;
    
const KAKAO_AUTH_URL = `https://kauth.kakao.com/oauth/authorize?client_id=${CLIENT_ID}&redirect_uri=${REDIRECT_URI}&response_type=code&prompt=login`;


const axiosInstance = axios.create({
    baseURL: process.env.PUBLIC_URL, // 또는 다른 기본 URL 설정
    headers: {
      'Content-Type': 'application/json',
    },
  });

  
  // Request 인터셉터 - 모든 요청 전에 JWT 토큰을 설정
  axiosInstance.interceptors.request.use((config) => {

    const jwt = sessionStorage.getItem('JWT');
    config.headers['Authorization'] = `${jwt}`;
    config.params.pathname = config.params.pathname || '';
    return config;
  });
  
  // Response 인터셉터 - 401 Unauthorized 상태 코드를 처리
  axiosInstance.interceptors.response.use(
    (response) => response,
    (error) => {
      if (error.response && error.response.status === 401) {
        console.log("401 에러 떠서 인터셉터 나옴")
        const location = error.config.params.pathname;
        localStorage.setItem('currentPage', location);
        window.location.href = KAKAO_AUTH_URL;
      }
      return Promise.reject(error);
    }
  );

export default axiosInstance;