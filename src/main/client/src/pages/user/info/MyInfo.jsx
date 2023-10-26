import {useState,useEffect} from 'react';

import axiosInstance from '../../common/AxiosInstance';
import { useLocation, useNavigate,Outlet,Link } from 'react-router-dom';
import {Container,Row,Col,Form } from 'react-bootstrap';

import { Button } from "antd";
import '../../../styles/user.css'
const MyInfo = () => {
    const location = useLocation();
    const navigate = useNavigate(); 
    
    const [user,setUser] = useState();

    useEffect(()=>{
        axiosInstance.get(`${process.env.PUBLIC_URL}/user/`,{
            params: {
                pathname: location.pathname,
              },
        }).then(({data}) => {
            setUser(data)
        })
        .catch((error) => {
        })
    },[]);

    const editUser = () =>{
        console.log(user)
        navigate('/user/info/edit',{state : {user} })
    }
    return(
        <>
        {   user && 
            <Container className="userInfo"><br/><br/>
                <Row>        
                    <Row id="name">
                        <Col>{user.kakaoNickname} {user.receive} </Col>
                    </Row>
                    <Row id="phone">
                        <Col>{user.cellPhone}</Col>
                    </Row>
                    <Row id="address">
                        <Col>({user.postCode}) {user.address} {user.detailAddress}</Col>
                    </Row>
                    <Row>
                        <Button variant="primary" onClick={editUser}>수정</Button> 
                    </Row>
                </Row>
            </Container>
        }
        </>
    )
}

export default MyInfo;