
import React from "react"
import Home from "./pages/common/Home"

import Header from "./components/layout/Header";
import UserRouter from "./pages/user/UserRouter";
import ProductRouter from "./pages/product/ProductRouter";
import PurchaseRouter from "./pages/purchase/PurchaseRouter";
import CartList from "./pages/cart/CartList";
import { FloatButton } from 'antd';
import { animateScroll as scroll } from 'react-scroll';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LoginHandeler from "./services/LoginHandler";

function App() {

  const scrollToHeader = () => {
    scroll.scrollToTop();
  };

  return (
    <>
      
      
      
      <div class="container">
        <Router>
          <Header />
          <Routes>
            
            <Route path="/" element={<Home />} />
            
            <Route path="/user/*" element={<UserRouter />} />
            <Route path="/product/*" element={<ProductRouter />} />
            <Route path="/purchase/*" element={<PurchaseRouter />} />
            <Route path="/auth/kakao/callback" element={<LoginHandeler />} />
            <Route path="/cart" element={<CartList />} />
          </Routes>
          <FloatButton.BackTop style={{ width: '70px', height: '70px' }} colorPrimary/>
        </Router>
      </div>
    </>
  );
}


export default App;
