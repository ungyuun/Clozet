import React from 'react';
import { Route, Routes } from "react-router-dom";
import LoginHandler from '../../services/LoginHandler';
import LogoutHandler from '../../services/LogoutHandler';
import EditInfo from '../user/info/EditInfo';
import MyInfo from './info/MyInfo';
import UserInfo from './info/UserInfo';
import CartList from '../cart/CartList';

function UserRouter(){
    return(
        <Routes>
            <Route path="/info" element={<UserInfo />}>
                <Route path="my" element={<MyInfo/>} />
                <Route path="edit" element={<EditInfo/>} />
                <Route path="cart" element={<CartList/>} />
            </Route>
            <Route path="/kakao/callback" element={<LoginHandler />} />
            {/* <Route path="/kakao/logout/callback" element={<LogoutHandler />} /> */}
            <Route></Route>
        </Routes>
    );
}

export default UserRouter;