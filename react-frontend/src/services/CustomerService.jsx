import axios from "axios";

const CUSTOMERS_REST_API_URL = "http://localhost:9191/api/customer";

class CustomerService {
  getCustomers() {
    return axios.get(CUSTOMERS_REST_API_URL);
  }

  createCustomer(customer) {
    return axios.post(CUSTOMERS_REST_API_URL, customer);
  }

  getCustomerByIdentiyNumber(id) {
    return axios.get(CUSTOMERS_REST_API_URL + "?identity=" + id);
  }

  deleteCustomerByIdentityNumber(id) {
    return axios.delete(CUSTOMERS_REST_API_URL + "/" + id);
  }

  getCreditResultByIdentityNumber(identityNumber) {
    return axios.get(CUSTOMERS_REST_API_URL + "/result/" + identityNumber);
  }

  updateCustomer(detail) {
    return axios.put(CUSTOMERS_REST_API_URL + "/" + detail.identityNumber, {
      identityNumber: detail.identityNumber,
      customerName: detail.customerName,
      customerSurname: detail.customerSurname,
      customerPhoneNumber: detail.customerPhoneNumber,
      customerSalary: detail.customerSalary,
    });
  }
}

export default new CustomerService();
