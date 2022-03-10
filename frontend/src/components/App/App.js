import './App.css';
import React, {Component} from "react";
import Brands from '../Brands/brands';
import EshopService from "../../repository/eshopRepository";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Categories from "../Categories/categories";
import Products from "../Products/ProductList/products";
import Header from "../Header/header"
import EShopService from "../../repository/eshopRepository";
import ProductAdd from "../Products/ProductAdd/productAdd";
import ProductEdit from "../Products/ProductEdit/productEdit";


class App extends Component{
    constructor(props) {
        super(props);
        this.state = { 
            brands : [],
            categories : [],
            products : [],
            selectedProduct: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                    <main>
                        <div className="container">
                            <Routes>
                            <Route path={"/brands"} element={<Brands brands={this.state.brands}/>} exact render/>

                               <Route path={"/categories"} element={<Categories categories={this.state.categories}/>} exact render/>
                         
                                <Route path={"/products/add"}  element={
                                    <ProductAdd categories={this.state.categories}
                                                brands={this.state.brands}
                                                onAddProduct={this.addProduct}/>} exact render/>

                                <Route path={"/products/edit/:id"}  element={
                                    <ProductEdit categories={this.state.categories}
                                                 brands={this.state.brands}
                                                 onEditProduct={this.editProduct}
                                                 product={this.state.selectedProduct}/>} exact render/>

                                <Route path={"/products"}  element={<Products products={this.state.products}
                                                                              onDelete={this.deleteProduct}
                                                                              onEdit={this.getProduct}/> } exact render/>
                            </Routes>
                        </div>
                    </main>
            </Router>

        );
    }

    loadBrands = () => {
        EshopService.fetchBrands()
            .then((data) => {
                this.setState({
                    brands: data.data
                })
            });
    }

    loadCategories = () => {
        EshopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadProducts = () => {
        EshopService.fetchProducts()
            .then((data) => {
                this.setState({
                    products: data.data
                })
            });
    }
    deleteProduct = (id)=>{
        EshopService.deleteProduct(id)
            .then(()=>{
                this.loadProducts();
            })
   }
    addProduct = (name, price, quantity, category, brand) => {
        EShopService.addProduct(name, price, quantity, category, brand)
            .then(() => {
                this.loadProducts();
            });
    }

    getProduct = (id) => {
        EShopService.getProduct(id)
            .then((data) => {
                this.setState({
                    selectedProduct: data.data
                })
            })
    }

    editProduct = (id, name, price, quantity, category, brand) => {
        EShopService.editProduct(id, name, price, quantity, category, brand)
            .then(() => {
                this.loadProducts();
            });
    }


    componentDidMount() {
        this.loadBrands();
        this.loadCategories();
        this.loadProducts();
    }
}
export default App;
