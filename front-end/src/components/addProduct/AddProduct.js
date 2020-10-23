import React, { Component } from "react";
import "./addProduct.css";

class AddProduct extends Component {
  state = {
    name: "",
    price: 0,
    unit: "",
    imageUrl: "",
    submitButtonDisabled: true,
  };

  isformValuesValid = () => {
    const { name, price, unit, imageUrl } = this.state;
    var regexp = /^[1-9]+\d*/;
    return (name !== "") && (regexp.test(price)) && (unit !== "") && (imageUrl !== "");
  }

  isSubmitButtonDisabled = () => {
    this.setState({
      submitButtonDisabled: !this.isformValuesValid(),
    })
  }

  handleFormSubmit = (event) => {
    event.preventDefault();
    console.log(JSON.stringify(this.state));
    const url = "http://localhost:8080/product";
    fetch(url, {
      mode: 'cors',
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      },
      method: "POST",
      body: JSON.stringify(this.state),
    })
      .then((response) => {
        console.log(response);
        if (response.status === 400) {
          alert("商品名称已存在，请输入新的商品名称！");
          return;
        } else if (response.status === 201) {
          alert("商品添加成功！");
        } else {
          alert("网络错误，请重试！");
        }
      })
  };

  handleFieldChange = (field, event) => {
    this.setState({
      [field]: event.target.value,
    });
    this.isSubmitButtonDisabled();
  };

  render() {
    const { name, price, unit, imageUrl, submitButtonDisabled } = this.state;
    return (
      <div className="add-product-form">
        <h1>添加商品</h1>
        <form onSubmit={this.handleFormSubmit}>
          <div className="form-item">
            <label htmlFor="name">名称：</label>
            <input
              type="text"
              id="name"
              placeholder="名称"
              value={name}
              onChange={(e) => this.handleFieldChange("name", e)}
            />
          </div>

          <div className="form-item">
            <label htmlFor="price">价格：</label>
            <input
              type="number"
              min="0"
              step="1"
              id="price"
              placeholder="价格"
              value={price}
              onChange={(e) => this.handleFieldChange("price", e)}
            />
          </div>

          <div className="form-item">
            <label htmlFor="unit">单位：</label>
            <input
              type="text"
              id="unit"
              placeholder="单位"
              value={unit}
              onChange={(e) => this.handleFieldChange("unit", e)}
            />
          </div>

          <div className="form-item">
            <label htmlFor="imageUrl">图片：</label>
            <input
              type="text"
              id="unit"
              placeholder="URL"
              value={imageUrl}
              onChange={(e) => this.handleFieldChange("imageUrl", e)}
            />
          </div>

          <button className="add-product-submit-btn" disabled={submitButtonDisabled}>提交</button>
        </form>
      </div>
    );
  }
}

export default AddProduct;
