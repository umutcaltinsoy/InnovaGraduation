import React, { Component } from "react";
import CustomerService from "../services/CustomerService";

class CreateCustomerComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      identityNumber: "",
      customerName: "",
      customerSurname: "",
      customerSalary: "",
      customerPhoneNumber: "",
    };

    this.changeIdentityNumberHandler =
      this.changeIdentityNumberHandler.bind(this);
    this.changeCustomerNameHandler = this.changeCustomerNameHandler.bind(this);
    this.changeCustomerSurnameHandler =
      this.changeCustomerSurnameHandler.bind(this);
    this.changeCustomerSalaryHandler =
      this.changeCustomerSalaryHandler.bind(this);
    this.changePhoneNumberHandler = this.changePhoneNumberHandler.bind(this);

    this.saveCustomer = this.saveCustomer.bind(this);
  }

  saveCustomer = (e) => {
    e.preventDefault();

    if (
      !this.state.identityNumber ||
      isNaN(this.state.identityNumber) ||
      this.state.identityNumber.length !== 11
    ) {
      window.alert("Kimlik Numarası nümerik ve 11 hane olmali");
      return;
    }

    if (!this.state.customerName || !isNaN(this.state.customerName)) {
      window.alert("Müşteri İsmi doğru girilmeli");
      return;
    }
    if (!this.state.customerSurname || !isNaN(this.state.customerSurname)) {
      window.alert("Müşteri Soyadi doğru girilmeli");
      return;
    }
    if (!this.state.customerSalary || isNaN(this.state.customerSalary)) {
      window.alert("Müşteri Maaş bilgisi Nümerik olmali...");
      return;
    }
    if (
      !this.state.customerPhoneNumber ||
      isNaN(this.state.customerPhoneNumber)
    ) {
      window.alert("Müşteri Telefon Numarası Nümeril Olmali !!");
      return;
    }

    let customer = {
      identityNumber: this.state.identityNumber,
      customerName: this.state.customerName,
      customerSurname: this.state.customerSurname,
      customerSalary: this.state.customerSalary,
      customerPhoneNumber: this.state.customerPhoneNumber,
    };

    CustomerService.createCustomer(customer).then((res) => {
      if (!res.data) {
        window.alert("Bu TC kullanılmaktadır.");
        return;
      }
      this.props.history.push("/customers");
    });
  };

  changeIdentityNumberHandler = (event) => {
    this.setState({ identityNumber: event.target.value });
  };

  changeCustomerNameHandler = (event) => {
    this.setState({ customerName: event.target.value });
  };

  changeCustomerSurnameHandler = (event) => {
    this.setState({ customerSurname: event.target.value });
  };

  changeCustomerSalaryHandler = (event) => {
    this.setState({ customerSalary: event.target.value });
  };

  changePhoneNumberHandler = (event) => {
    this.setState({ customerPhoneNumber: event.target.value });
  };

  cancel() {
    this.props.history.push("/customers");
  }

  render() {
    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md3">
              <h3 className="text-center">Add Customer</h3>
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label>Identity Number</label>
                    <input
                      placeholder="Identity"
                      name="identityNumber"
                      className="form-control"
                      value={this.state.identityNumber}
                      onChange={this.changeIdentityNumberHandler}
                    ></input>
                  </div>
                  <div className="form-group">
                    <label>Customer Name</label>
                    <input
                      placeholder="Customer Name"
                      name="customerName"
                      className="form-control"
                      value={this.state.customerName}
                      onChange={this.changeCustomerNameHandler}
                    ></input>
                  </div>
                  <div className="form-group">
                    <label>Customer Surname</label>
                    <input
                      placeholder="Customer Surname"
                      name="customerSurname"
                      className="form-control"
                      value={this.state.customerSurname}
                      onChange={this.changeCustomerSurnameHandler}
                    ></input>
                  </div>
                  <div className="form-group">
                    <label>Salary</label>
                    <input
                      placeholder="Salary"
                      name="customerSalary"
                      className="form-control"
                      value={this.state.customerSalary}
                      onChange={this.changeCustomerSalaryHandler}
                    ></input>
                  </div>
                  <div className="form-group">
                    <label>Phone Number</label>
                    <input
                      placeholder="Phone Number"
                      name="customerPhoneNumber"
                      className="form-control"
                      value={this.state.customerPhoneNumber}
                      onChange={this.changePhoneNumberHandler}
                    ></input>
                  </div>

                  <button
                    className="btn btn-success"
                    onClick={this.saveCustomer}
                  >
                    Save
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={this.cancel.bind(this)}
                    style={{ marginLeft: "10px" }}
                  >
                    Cancel
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default CreateCustomerComponent;
