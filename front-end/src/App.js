import React from "react";
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect,
} from "react-router-dom";
import Header from "./components/header/Header";
import ShoppingMall from "./components/shoppingMall/ShoppingMall";
import Order from "./components/order/Order";
import AddProduct from "./components/addProduct/AddProduct";
import "./App.css";

function App() {
  return (
    <Router>
      <Header />
      <Switch>
        <Route exact path="/shopping-mall" component={ShoppingMall} />
        <Route exact path="/order" component={Order} />
        <Route exact path="/add-product" component={AddProduct} />
        <Redirect form="/" to="/shopping-mall"></Redirect>
      </Switch>
    </Router>
  );
}

export default App;
