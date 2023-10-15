import React from 'react';
import { Route, Routes } from "react-router-dom";
import LoginHandler from './login/LoginHandler';
import LogoutHandler from './login/LogoutHandler';

function UserRouter(){
    return(
        <Routes>
            <Route path="/kakao/callback" element={<LoginHandler />} />
            {/* <Route path="/kakao/logout/callback" element={<LogoutHandler />} /> */}
            <Route></Route>
        </Routes>
    );
}

export default UserRouter;