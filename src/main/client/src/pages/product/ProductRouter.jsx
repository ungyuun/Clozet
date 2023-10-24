import React from 'react';
import { Route, Routes } from "react-router-dom";
import Product from "../product/getProduct/Product"
import ProductForm from "./addProduct/ProductForm"
import Main from './main/Main';

function ProductRouter(){
    return(
        <Routes>
            <Route path="/:prodNo" element={<Product />}/>
            <Route />
            <Route path="/form" element={<ProductForm />} />
            <Route path="/main" element={<Main />}/>
        </Routes>
    );
}

export default ProductRouter;