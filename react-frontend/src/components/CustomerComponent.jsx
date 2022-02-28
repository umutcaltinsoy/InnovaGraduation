import React from "react";
import CustomerService from "../services/CustomerService";

class CustomerComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      customers: [],
    };
    this.addCustomer = this.addCustomer.bind(this);
    this.editCustomer = this.editCustomer.bind(this);
  }

  editCustomer(id) {
    this.props.history.push(`/update-customer/${id}`);
  }

  deleteCustomer = (id) => {
    CustomerService.deleteCustomerByIdentityNumber(id).then((resp) => {
      this.componentDidMount(); // allows to rerender !
    });
  };

  componentDidMount() {
    CustomerService.getCustomers().then((response) => {
      this.setState({ customers: response.data });
    });
  }

  addCustomer() {
    this.props.history.push("/add-customer");
  }

  queryPage = () => {
    this.props.history.push("/query");
  };

  render() {
    return (
      <div>
        <h1 className="text-center">Customers List</h1>
        <div>
          <button className="btn btn-primary" onClick={this.addCustomer}>
            Add Customer
          </button>
          &nbsp;&nbsp;&nbsp;
          <button className="btn btn-primary" onClick={this.queryPage}>
            Credit Query Page
          </button>
        </div>

        <table className="table table-striped">
          <thead>
            <tr>
              <td>Customer Identity Number</td>
              <td>Customer First Name</td>
              <td>Customer Last Name</td>
              <td>Customer Salary</td>
              <td>Customer Phone Number</td>
            </tr>
          </thead>
          <tbody>
            {this.state.customers.map((customer) => (
              <tr key={customer.identityNumber}>
                <td>{customer.identityNumber}</td>
                <td>{customer.customerName}</td>
                <td>{customer.customerSurname}</td>
                <td>{customer.customerSalary}</td>
                <td>{customer.customerPhoneNumber}</td>
                <td>
                  <button
                    onClick={() => this.editCustomer(customer.identityNumber)}
                    className="btn btn-info"
                  >
                    Update
                  </button>
                </td>
                <td>
                  <button
                    onClick={() => this.deleteCustomer(customer.identityNumber)}
                    className="btn btn-danger"
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}
export default CustomerComponent;
