import React from 'react';
import axios from 'axios';
import {useParams} from 'react-router-dom';
import {useState,useEffect} from 'react';

import Content from './Content';
import ProductHeader from './ProductHeader';
// import Comment from './Comment';

function Product(){
    const { prodNo  } = useParams();
    const [data,setData] = useState();
    useEffect(() => {
      console.log("aa")
      axios.get(`${process.env.PUBLIC_URL}/api/product/${prodNo}`) 
              .then((response) => {
                console.log("GET 요청 성공");
                console.log(response.data);
                setData(response.data);
                
              })
              .catch((getError) => {
                console.log(`GET 요청 에러: ${getError}`);
              });
      },[prodNo]);
    return(
        <>
          {data && <ProductHeader data={data} />}<hr />     {/* 상품의 썸네일, 가격, 주문정보를 입력하는 컴포넌트 */}
          {data && <Content data={data} />}           {/* 상품의 정보가 담겨있는 메인 컴포넌트 */}
          {/* {/* {data && <Comment data={data} />}          댓글 컴포넌트 */}
        </>
    )
}

export default Product;