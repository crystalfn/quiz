import React, { Component } from "react";
import Product from "./product/Product";
import './shoppingMall.css';

class ShoppingMall extends Component {
  state = {
    productsData: [],
  }

  componentDidMount() {
    const url = "http://localhost:8080/products";
    fetch(url)
      .then((response) => response.json())
      .then((data) => {
        this.setState({
          productsData: data,
        });
      });
  }

  render() {
    return (
      <section className="Products">
        {this.state.productsData.map((item) => (
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
