import React from 'react';
import axios from 'axios';
import {useParams} from 'react-router-dom';
import {useState,useEffect} from 'react';

import Content from './Content';

function Product(){
    const { prodNo  } = useParams();
    const [data,setData] = useState();
    useEffect(() => {
      axios.get(`http://localhost:8081/product/${prodNo}`) 
              .then((response) => {
                console.log("GET 요청 성공");
                console.log(response.data);
                setData(response.data);
                <Content data={data}/>
              })
              .catch((getError) => {
                console.log(`GET 요청 에러: ${getError}`);
              });
      },[]);
    return(
        <>
          <h1>{prodNo }</h1>
          
        </>
    )
}

export default Product;