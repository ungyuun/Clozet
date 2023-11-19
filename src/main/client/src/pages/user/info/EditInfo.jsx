import {useState,useEffect} from 'react';
import { useLocation, useNavigate,Outlet,Link } from 'react-router-dom';

import axiosInstance from '../../common/AxiosInstance';
import {Container,Row,Col,Form } from 'react-bootstrap';
import DaumPostcode from "react-daum-postcode";
import { Modal, Button } from "antd";
import '../../../styles/user.css'
const EditInfo = () => {
    const location = useLocation();
    const navigate = useNavigate(); 
    const {state} = useLocation();
    console.log(state) 
    console.log(location)
    const [isOpen, setIsOpen] = useState(false);
    
    const initialValue = {
        kakaoNickname: state.user.kakaoNickname,
        receive: state.user.receive,
        cellPhone: state.user.cellPhone,
        postCode: state.user.postCode,
        address: state.user.address,
        addressDetail: state.user.addressDetail,
    };
    const [inputValues, setInputValues] = useState(initialValue);
    const {kakaoNickname, receive, cellPhone, addressDetail,address,postCode} = inputValues;	//비구조화 할당
    const onChangeInput = event => {
        const {value, name: inputName} = event.target;
        setInputValues({...inputValues, [inputName]: value});	//spread 연산자
    }
    
    const onToggleModal = () => {
        setIsOpen((prev) => !prev);
      };

    const handleComplete = (data) => {
        console.log(data)
        onToggleModal(false);
        setInputValues({
            ...inputValues,
            address: data.address,
            postCode: data.zonecode,
          });
      };

    const edit = () =>{
        console.log(location)
        axiosInstance.put(`${process.env.PUBLIC_URL}/api/user/`,inputValues,{
            params: {
                pathname: location.pathname,
              },
        }).then((response) => {
            console.log(response)
            navigate('/user/info/my')
            
        })
        .catch((error) => {
            console.log(error)
        })
    }

    return(
        <Container className="userInfo"><br/><br/><hr/>
            <Row>    
                <Row id="name" className="mb-3">
                    <Col md={3}>
                        <Row className="mb-1">이름</Row>
                        <Row><Form.Control name ="kakaoNickname" value={kakaoNickname} onChange={onChangeInput}></Form.Control></Row>
                    </Col>
                    <Col md={1}></Col>
                    <Col md={7}>                    
                        <Row className="mb-1">배송지 명</Row>
                        <Row><Form.Control name ="receive" value={receive} onChange={onChangeInput}></Form.Control></Row>
                    </Col>
                </Row>
                <Row id="phone"  className="mb-5">
                    <Row className="mb-1">핸드폰</Row>
                    <Row><Form.Control name ="cellPhone" value={cellPhone} onChange={onChangeInput}></Form.Control></Row>
                </Row>
                <hr/>
                <Row id="address" className="mb-3">
                    <Row className="d-flex justify-content-between ">
                        <Col className="text-start mb-3">
                            <Form.Control placeholder="우편번호" name ="postCode" value={postCode} readOnly onChange={onChangeInput}></Form.Control>    
                        </Col>
                        <Col>
                            <Button variant="primary" onClick={onToggleModal}>주소 변경</Button>   
                        </Col>
                    </Row>
                    <Row className="mb-3">
                        <Col>
                            <Form.Control placeholder="도로명 주소" name ="address" value={address} readOnly onChange={onChangeInput}></Form.Control>
                        </Col>
                    </Row>
                    <Row className="mb-3">
                        <Col>
                            <Form.Control placeholder="상세 주소" name ="addressDetail" value={addressDetail} onChange={onChangeInput}></Form.Control>
                        </Col>
                    </Row><hr/>
                </Row><br/>
                
                <Row>
                    <Button variant="primary" onClick={edit} >수정</Button> 
                </Row>
                    {isOpen && (
                        <Modal title="배송지 설정" visible={true} onOk={onToggleModal} onCancel={onToggleModal}>
                            <DaumPostcode onComplete={handleComplete} />
                        </Modal>
                    )}

            </Row>
      </Container>
    )
}

export default EditInfo;