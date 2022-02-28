import React, { Component } from "react";
import CustomerService from "../services/CustomerService";

export default class QueryPage extends Component {
  constructor(props) {
    super(props);

    this.state = {
      queryParam: "",
      queryResponse: [],
    };
  }

  handleOnChange = (event) => {
    this.setState({ queryParam: event.target.value });
  };

  query = (param) => {
    if (!param || param.length !== 11 || isNaN(param)) {
      window.alert("Identity Number must be numeric and 11 digits!");
      return;
    }

    CustomerService.getCreditResultByIdentityNumber(param).then((response) => {
      debugger;
      this.setState({ queryResponse: response.data });
      debugger;
    });
  };

  render() {
    return (
      <div>
        <form onSubmit={(e) => e.preventDefault()}>
          <label for="identityNumber">Identity Number:</label>
          <input
            id="identityNumber"
            onChange={this.handleOnChange}
            value={this.state.queryParam}
          />
          &nbsp;&nbsp;&nbsp;
          <button onClick={() => this.query(this.state.queryParam)}>
            Query
          </button>
          <table className="table table-striped">
            <thead>
              <tr>
                <td>Customer Identity Number</td>
                <td>CreditLimit</td>
                <td>CreditResult</td>
              </tr>
            </thead>
            <tbody>
              <tr key={this.state.queryResponse.identityNumber}>
                <td>{this.state.queryResponse.identityNumber}</td>
                <td>{this.state.queryResponse.creditLimit}</td>
                <td>{this.state.queryResponse.creditResult}</td>
              </tr>
            </tbody>
          </table>
        </form>
      </div>
    );
  }
}
