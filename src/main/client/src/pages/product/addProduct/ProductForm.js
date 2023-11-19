import { Form, Row, Col,Container} from 'react-bootstrap';

import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import {useForm} from "react-hook-form";
import {useState} from "react";
import Title from './Title';
import ProductDetail from './ProductDetail';
import Editor from './Editor';
import Thumbnail from './Thumbnail';
import AdditionalImage from './AdditionalImage';



function ProductForm(){

    const { register,handleSubmit } = useForm();
    const [editorData, setEditorData] = useState('');                                       // content

    const [options, setOptions] = useState([]);                                             //option
    const [price,setPrice] = useState(0);
    const [thumbnail, setThumbnail] = useState(`https://kr.object.ncloudstorage.com/clozet/image_icon-icons.com_50366.png`);   //대표이미지
    const [imgUrl,setImgUrl] = useState([]);                                                // 추가이미지


    const navigate = useNavigate();

    const onSubmit = (data) => {                        // 물품 json 변환
        const formData = {
            title: data.title,
            category: data.category,
            content: editorData,
            thumbnail : thumbnail,
            productDetail: options,
            imgUrl : imgUrl,
            price : price
          };
          console.log(JSON.stringify(formData));
          axios.post(`${process.env.PUBLIC_URL}/api/product/newproduct`,formData,{
            headers: {"Content-Type": "application/json",},
          })
          .then((response) => {
            const prodNo = response.data.prodNo; 
            
            navigate(`/product/${prodNo}`);
          })
          .catch((error) => {
            console.log(`error : ${error}`);
          })
    };
    const handleEditorChange = (newData) => {
        setEditorData(newData);
    };
    
    return(
        
        <Form className="mb-5" onSubmit={handleSubmit(onSubmit)}><br /><br />
        <h4>상품추가</h4><hr/>
            <Title className="mt-5" register={register}/>
            <Editor editorData={editorData} onChange={handleEditorChange} /><hr />
            <Container>
              <Row>
                  <Col className="mt-5" md={3}>
                    <h3>썸네일 등록</h3>
                    <Thumbnail img={thumbnail} setImg={setThumbnail}/>
                  </Col>
                  <Col className="mt-5" md={9}>
                    <h3>추가이미지 등록</h3>
                    <AdditionalImage img={imgUrl} setImg ={setImgUrl}/>
                  </Col>                
              </Row><hr />
              <Row>                  
                  <ProductDetail options={options} setOptions={setOptions} price={price} setPrice={setPrice}/>
              </Row>
            </Container>
        </Form>
    );
}

export default ProductForm;