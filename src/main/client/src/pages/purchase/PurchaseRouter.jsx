import React from 'react';
import { Route, Routes } from "react-router-dom";
import Reciept from './addPurchase/Reciept';

function PurchaseRouter(){
    return(
        <Routes>
            <Route path="/reciept" element={<Reciept />}/>
            <Route />
            {/* <Route path="/form" element={<ProductForm />} />
            <Route path="/main" element={<Main />}/> */}
        </Routes>
    );
}

export default PurchaseRouter;