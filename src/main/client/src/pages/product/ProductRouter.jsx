import React from 'react';
import { Route, Routes } from "react-router-dom";
import Product from "../product/getProduct/Product"

function ProductRouter(){
    return(
        <Routes>
            <Route path="/:prodNo" element={<Product />}/>
            <Route />
        </Routes>
    );
}

export default ProductRouter;