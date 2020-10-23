import React, { Component } from "react";
import { NavLink } from "react-router-dom";
import "./header.css";

class Header extends Component {
  state = {
    messageList: [
      { url: "/shopping-mall", name: "商城", img: '../../assets/header/home.png' },
      { url: "/order", name: "订单", img: "../../assets/header/shoppingcar.png" },
      { url: "/add-product", name: "添加商品", img: "../../assets/header/plus.png" },
    ],
  };

  render() {
    return (
      <header className="header">
        <ul>
          {this.state.messageList.map((item) => (
            <li>
              <NavLink
                className="link"
                to={item.url}
                activeStyle={{
                  color: "#fff",
                  backgroundColor: "#00BFFF",
                  fontSize: "18px"
                }}
              >
                {item.name}
              </NavLink>
            </li>
          ))}
        </ul>
      </header>
    );
  }
}

export default Header;
