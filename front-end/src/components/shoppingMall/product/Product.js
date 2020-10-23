import React, { Component } from "react";
import './product.css';

class Product extends Component {
  render() {
    const { name, imageUrl, price, unit } = this.props;
    return (
      <section className="product">
        <img src={imageUrl} alt={name}></img>
        <p className="product-name">{name}</p>
        <p className="product-price">
          单价：{price} 元 / {unit}
        </p>
        <button className="add-product">+</button>
      </section>
    );
  }
}

export default Product;
