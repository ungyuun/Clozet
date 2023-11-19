import {useState,useEffect} from 'react';
import { useLocation, useNavigate,Outlet,Link } from 'react-router-dom';
import {Container,Row,Col,Button,Form } from 'react-bootstrap';
import '../../../styles/user.css'
function UserInfo(){
    const location = useLocation();
    const navigate = useNavigate(); 

    
    const nickname = sessionStorage.getItem('nickname');
    const profile = sessionStorage.getItem('profile');

    
    return(
        <Container className="userInfo"><br/><br/>
            <Row>        
                <Col md={2}><br/><br/>
                <Row>
                    <ul className="userList">
                        <li onClick={()=>navigate('/user/info/my')}>내 정보</li>
                        <li onClick={()=>navigate('/user/info/purchase')}>구매 내역</li>
                        <li onClick={()=>navigate('/cart')}>장바구니</li>
                        <li>댓글 기록</li>
                        <li>좋아요</li>
                        <li>문의</li>
                        <li onClick={()=>navigate('/user/info/boundary')}>내 동네 인증</li>
                    </ul>
                </Row>
                </Col>
                <Col md={1}></Col>
                <Col md={6}>                      
                  <Row><h4>내 정보</h4><hr/>
                    <Col md={4}> 
                        <img src={profile} />
                    </Col>
                    <Col md={8}> 
                        <span><h3>{nickname}님 안녕하세요</h3></span>
                    </Col>
                  </Row><hr/>
                  <Row id="infoBox">    
                     <Outlet />
                  </Row>
                </Col>
            </Row>
            
      </Container>
    )
}

export default UserInfo;