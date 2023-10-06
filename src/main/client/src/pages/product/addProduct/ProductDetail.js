import { Form, Row, Col,Button,Image,InputGroup} from 'react-bootstrap';
import { useMemo,useEffect, useRef, useState } from 'react';
import { v4 as uuidv4 } from 'uuid';
import ImageUpload from '../../common/ImageUpload'
import DeleteImage from './DeleteImage';


function ProductDetail({options,setOptions,price,setPrice}){

    
    const [size,setSize]=useState();
    const [amount,setAmount] = useState(0);
    


    const amountIncrease = () =>{
        setAmount(amount+10);
    }
    const amountDecrease=()=>{
        if (amount > 10) {
            setAmount(amount-10);
        }else {
            setAmount(0);
        }
    }

    const priceIncrease = () =>{
        setPrice(price+1000);
    }
    const priceDecrease=()=>{
        if (price > 1000) {
            setPrice(price-1000);
          } else {
            setPrice(0);
          }
    }

    const addOption = (index) => {
        console.log(`index : ${index}`)
        setOptions([ ...options,{size:size,amount:amount}]);     
    };  

    const deleteOption = (index) =>{
            const newOptions = [...options];
            newOptions.splice(index, 1); // 해당 인덱스의 이미지 제거
            setOptions(newOptions);
          
    }

    return(
        <>
            <Row className='mt-5'>                 
            <Col md="7">
            <Row>
                <Col md="3">
                    <h4>재고 지정</h4>
                </Col>
                <Col md="2">
                <Form.Select className='p-2' 
                                aria-label="카테고리 입력"
                                onChange={(e)=>{
                                setSize(e.target.value)
                                }}
                                
                >
                    <option>사이즈</option>
                    <option value="S">S</option>
                    <option value="M">M</option>
                    <option value="L">L</option>
                    <option value="XL">XL</option>
                    <option value="2XL">2XL</option>
                    <option value="FREE">FREE</option>
                </Form.Select>
                </Col>
                
                <Col md="3">
                    <InputGroup>
                        <Form.Control
                        placeholder="개수"
                        value={amount}
                        onChange={(e)=>{ setAmount(parseInt(e.target.value)) }}
                        />
                        <Button variant="primary" onClick={amountIncrease}>+</Button>
                        <Button variant="danger" onClick={amountDecrease}>-</Button>         
                        
                    </InputGroup>
                </Col>
                <Col md="2">
                    <Button  onClick={addOption} >저장</Button>
                </Col>
                <Row className='mt-1'>
                    {options.map((option,index)=>(
                        <Col md="9">
                            <InputGroup key={index} className='mt-1'>
                                    <Form.Control
                                    placeholder={`${option.size}/${option.amount}`}
                                    disabled
                                />
                                <Button variant="danger" onClick={deleteOption}>
                                    삭제
                                </Button>
                            </InputGroup>
                        </Col>
                    ))}
                </Row>
            </Row>
            </Col>
            <Col md="1">
                <h4>가격</h4>
            </Col>
            <Col md="3">
                <InputGroup>
                    <Form.Control
                    placeholder="가격"
                    value={price}
                    
                    onChange={(e)=>{ setPrice(parseInt(e.target.value)) }}
                    />
                    <Button variant="primary" onClick={priceIncrease}>+</Button>
                    <Button variant="danger" onClick={priceDecrease}>-</Button>
                    
                </InputGroup>
            
            </Col>
            </Row>
        
            
        </>
    );
};

export default ProductDetail;