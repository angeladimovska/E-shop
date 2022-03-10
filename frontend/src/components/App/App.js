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

//ovaa komponenta e roditel i e STATEFUL!
//toa ke bide najgore i ke ja predavame nadolu
class App extends Component{
    //edna komponenta ima konstruktor, ima render i componentDidMount metod
    constructor(props) {
        super(props);
        //App komponentata cuva state i toa e ovoj objekt state i nie pravime nekoja promena vrz nego podole so set state
        this.state = { //sostojbata e sekogas nekakov objekt i ke davame key-value parovi za properties shto ke gi cuvam
            //props { job : "developer"} i vo nas slucaaj brands i prazna lista
            brands : [],
            categories : [],
            products : [],
            selectedProduct: {}
        }
    }

    //po povikuvanje na konstruktor se povikuva render
    render() {
        return (
            <Router>
                <Header/>
                    <main>
                        <div className="container">
                            <Routes>
                            <Route path={"/brands"} element={<Brands brands={this.state.brands}/>} exact render/>

                                {/*// <Brands brands={this.state.brands}/>}/>*/}

                                <Route path={"/categories"} element={<Categories categories={this.state.categories}/>} exact render/>
                                 {/*<Categories categories={this.state.categories}/>}/>*/}

                                {/*ovde ni treba i callback od productAdd nagore*/}
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
                //pravi promena na sostojba na komponentata sto ni e stateful i novo renderiranje
                this.setState({
                    brands: data.data
                })
            });
    }

    loadCategories = () => {
        EshopService.fetchCategories()
            .then((data) => {
                //pravi promena na sostojba na komponentata sto ni e stateful i novo renderiranje
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
