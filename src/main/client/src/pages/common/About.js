
import React, { useEffect } from "react";
import axios from 'axios';
import Header from "../../components/layout/Header";

function Home(){

    async function postUser(){
        try{
            await axios.post('http://localhost:8081/user',{
                name: 'sungyuun'

            });

        }catch(e){
            console.error(e);
        }
    }
    async function getHi(){
        try{
            await axios.get('http://localhost:8081/product/download');

        }catch(e){
            console.error(e);
        }
    }
    useEffect(() => {
        // 컴포넌트가 랜더링될 때 postUser 함수를 호출하도록 useEffect를 사용합니다.
        console.log('render')
        // postUser();
        getHi();
    }, []);

    return (
        <div>
            <h1>as</h1>
            
        </div>
    );

    
}
export default Home;