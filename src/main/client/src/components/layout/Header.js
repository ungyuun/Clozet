import LogoutHandler from '../../services/LogoutHandler';
import "../../styles/header.css"; 
import { useNavigate } from 'react-router-dom';
import { useLocation } from "react-router-dom";


function Header() {

    const CLIENT_ID = process.env.REACT_APP_REST_API_KEY;
    const REDIRECT_URI = process.env.REACT_APP_REDIRECT_URL;
    
    const KAKAO_AUTH_URL = `https://kauth.kakao.com/oauth/authorize?client_id=${CLIENT_ID}&redirect_uri=${REDIRECT_URI}&response_type=code&prompt=login`;
    const isLoggedIn = sessionStorage.getItem('JWT');
    const nickname = sessionStorage.getItem('nickname');
    const profile = sessionStorage.getItem('profile');

    const location = useLocation();
    const navigate = useNavigate();

    const KakaoLogin = () =>{
        localStorage.setItem('currentPage', location.pathname);
        window.location.href = KAKAO_AUTH_URL
    }
    const Logout = () =>{
        LogoutHandler(navigate);
    }
    return (
        <>
            <nav className="navbar navbar-expand-lg navbar-dark bg-transparent">
                <div className="container-fluid">
                    <a className="navbar-brand" href="#"></a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/">Home</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/product/main">product</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/productform">addProduct</a>
                            </li>
                        </ul>
                        {
                                isLoggedIn ? (
                                    <>
                                        <button>{nickname}</button>
                                        <img src={profile} />
                                        <button onClick={Logout}>로그아웃</button>
                                        
                                    </>
                                    
                                ) : (
                                    <div className="kakaobtn" onClick={KakaoLogin}>
                                        <img src="/images/kakao_login_medium_narrow.png" />
                                    </div>
                                )
                        }    
                        <form className="d-flex" role="search">
                            <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"></input>
                            <button className="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>  
        </>
    );
}
  
export default Header;
