import React, { Component } from "react";
import productsData from "./data.json";
import Product from "./product/Product";
import './shoppingMall.css';

class ShoppingMall extends Component {
  render() {
    return (
      <section className="Products">
        {productsData.map((item) => (
          <Product
            key={item.id}
            imageUrl={item.imageUrl}
            name={item.name}
            price={item.price}
            unit={item.unit}
          />
        ))}
      </section>
    );
  }
}

export default ShoppingMall;
