import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import CustomerComponent from "./components/CustomerComponent";
import HeaderComponent from "./components/HeaderComponent";
import CreateCustomerComponent from "./components/CreateCustomerComponent";
import UpdateCustomerComponent from "./components/UpdateCustomerComponent";
import QueryPage from "./components/QueryPage";

function App() {
  return (
    <div className="App">
      <Router>
        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route path="/" exact component={CustomerComponent}></Route>
            <Route path="/customers" component={CustomerComponent}></Route>
            <Route
              path="/add-customer"
              component={CreateCustomerComponent}
            ></Route>
            <Route
              path="/update-customer/:id"
              component={UpdateCustomerComponent}
            ></Route>
            <Route path="/query" component={QueryPage}></Route>
            <Route path="/hdr" component={HeaderComponent}></Route>
          </Switch>
        </div>
      </Router>
    </div>
  );
}

export default App;
