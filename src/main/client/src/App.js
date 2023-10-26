
import React from "react"
import Home from "./pages/common/Home"

import Header from "./components/layout/Header";
import UserRouter from "./pages/user/UserRouter";
import ProductRouter from "./pages/product/ProductRouter";
import PurchaseRouter from "./pages/purchase/PurchaseRouter";
import CartList from "./pages/cart/CartList";

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LoginHandeler from "./services/LoginHandler";

function App() {
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
        </Router>
      </div>
    </>
  );
}


export default App;
