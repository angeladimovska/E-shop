import React from 'react';
import {useNavigate} from 'react-router-dom';

const ProductEdit = (props) => {

    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        name: "",
        price: 0,
        quantity: 0,
        category: 0,
        brand: 0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.product.name;
        const price = formData.price !== 0 ? formData.price : props.product.price;
        const quantity = formData.quantity !== 0 ? formData.quantity : props.product.quantity;
        const category = formData.category !== 0 ? formData.category : props.product.category.id;
        const brand = formData.brand !== 0 ? formData.brand : props.product.brand.id;

        props.onEditProduct(props.product.id, name, price, quantity, category, brand);
        navigate("/products");
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Product name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.product.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Price</label>
                        <input type="text"
                               className="form-control"
                               id="price"
                               name="price"
                               placeholder={props.product.price}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Quantity</label>
                        <input type="text"
                               className="form-control"
                               id="quantity"
                               name="quantity"
                               placeholder={props.product.quantity}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) => {
                                if(props.product.category !== undefined &&
                                    props.product.category.id === term.id)
                                    return <option selected={props.product.category.id} value={term.id}>{term.name}</option>
                                else return <option value={term.id}>{term.name}</option>
                            })}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Brand</label>
                        <select name="brand" className="form-control" onChange={handleChange}>
                            {props.brands.map((term) => {
                                if(props.product.brand !== undefined &&
                                    props.product.brand.id === term.id)
                                    return <option selected={props.product.brand.id} value={term.id}>{term.name}</option>
                                else return <option value={term.id}>{term.name}</option>
                            })}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}
export default ProductEdit;
