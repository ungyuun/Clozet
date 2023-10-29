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
            console.log(data)
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
            <Container className="userInfo"><br/>
                <h5>배송지</h5><hr/>
                <Row>        
                    <Row id="name" className="mb-3">
                        <Col>{user.kakaoNickname} {user.receive} </Col>
                        <Col><Button variant="primary" onClick={editUser}>수정</Button> </Col>
                    </Row>
                    <Row id="phone" className="mb-3">
                        <Col>{user.cellPhone}</Col>
                    </Row>
                    <Row id="address" className="mb-3">
                        <Col>({user.postCode}) {user.address} {user.detailAddress} {user.addressDetail}</Col>
                    </Row><hr/>
                </Row>
            </Container>
        }
        </>
    )
}

export default MyInfo;