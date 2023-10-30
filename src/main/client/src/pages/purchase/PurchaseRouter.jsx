import React from 'react';
import { Route, Routes } from "react-router-dom";
import Reciept from './addPurchase/Reciept';
import Success from './addPurchase/Success';

function PurchaseRouter(){
    return(
        <Routes>
            <Route path="/reciept" element={<Reciept />}/>
            <Route path="/success" element={<Success />}/>
            {/* <Route path="/form" element={<ProductForm />} />
            <Route path="/main" element={<Main />}/> */}
        </Routes>
    );
}

export default PurchaseRouter;