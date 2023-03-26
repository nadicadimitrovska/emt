import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from "react-router-dom";
import Manufacturers from "../Manufacturers/manufacturers";
import EShopService from "../../repository/eshopRepository";
import Categories from "../Categories/categories";
import Products from "../Products/ProductList/products";
import Header from "../Header/header";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            manufacturers: [],
            products: [],
            categories: []
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Route path={"/manufacturers"} exact render={() => <Manufacturers manufacturers={this.state.manufacturers}/>}/>
                        <Route path={"/categories"} exact render={() => <Categories categories={this.state.categories}/>}/>
                        <Route path={"/products"} exact render={() => <Products products={this.state.products}/>}/>
                        <Redirect to={"/products"}/>
                    </div>
                </main>
            </Router>
        );
    }

    loadManufacturers = () => {
        EShopService.fetchManufacturers()
            .then((data) => {
                this.setState({
                    manufacturers: data.data
                })
            });
    }

    loadProducts = () => {
        EShopService.fetchProducts()
            .then((data) => {
                this.setState({
                    products: data.data
                })
            });
    }

    loadCategories = () => {
        EShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }


    componentDidMount() {
        this.loadManufacturers();
        this.loadProducts();
        this.loadCategories();
    }
}

export default App;
