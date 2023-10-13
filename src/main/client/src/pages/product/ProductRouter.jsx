import React from 'react';
import { Route, Routes } from "react-router-dom";
import Product from "../product/getProduct/Product"
import Main from './main/Main';

function ProductRouter(){
    return(
        <Routes>
            <Route path="/view/:prodNo" element={<Product />}/>
            <Route />
            <Route path="/main" element={<Main />}/>
        </Routes>
    );
}

export default ProductRouter;