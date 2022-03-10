import axios from '../custom-axios/axios';

const EshopService= {
    fetchBrands: () => {
        return axios.get("/brands");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchProducts : () => {
        return axios.get("/products");
    },
    //za evaluiranje izraz so `` backticks
    deleteProduct: (id)=>{
        return axios.delete(`/products/delete/${id}`)
    },

    //ke treba da mu pratime celosen objekt - REQUESTBODY
    //ova sho e data odi vo request body
    addProduct: (name, price, quantity, category, brand) => {
        return axios.post("/products/add", {
            "name" : name,
            "price" : price,
            "quantity" : quantity,
            "category" : category,
            "brand" : brand
        });
    },
    editProduct: (id, name, price, quantity, category, brand) => {
        return axios.put(`/products/edit/${id}`, {
            "name" : name,
            "price" : price,
            "quantity" : quantity,
            "category" : category,
            "brand" : brand
        });
    },
    getProduct: (id) => {
        return axios.get(`/products/${id}`);
    }

}
export default EshopService;
