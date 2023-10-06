import { Form, Row, Col,Button} from 'react-bootstrap';

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
            imgUrl : imgUrl
          };
          console.log(JSON.stringify(formData));
          axios.post("http://localhost:8081/product/newproduct",formData,{
            headers: {"Content-Type": "application/json",},
          })
          .then((response) => {
            const prodNo = response.data.prodNo; 
            navigate(`/product/getProduct/${prodNo}`);
          })
          .catch((error) => {
            console.log(`error : ${error}`);
          })
    };
    const handleEditorChange = (newData) => {
        setEditorData(newData);
    };
    
    return(
        <Form className="mb-5" onSubmit={handleSubmit(onSubmit)}>
            <Title register={register}/>
            <Editor editorData={editorData} onChange={handleEditorChange} />
            <div className='mt-5'>
                <h1>상품 정보추가</h1>
                <Thumbnail img={thumbnail} setImg={setThumbnail}/>
                <AdditionalImage img={imgUrl} setImg ={setImgUrl}/>
                <ProductDetail options={options} setOptions={setOptions}/>
            </div>
        </Form>
    );
}

export default ProductForm;