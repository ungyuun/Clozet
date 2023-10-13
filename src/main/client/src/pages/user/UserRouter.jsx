import React from 'react';
import { Route, Routes } from "react-router-dom";
import LoginHandler from './login/LoginHandler';

function UserRouter(){
    return(
        <Routes>
            <Route path="/kakao/callback" element={<LoginHandler />} />
            <Route></Route>
        </Routes>
    );
}

export default UserRouter;