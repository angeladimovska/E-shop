import React, {useState} from 'react';
import {useNavigate} from 'react-router-dom';

//ovaa komponenta prakja post request
const ProductAdd = (props) => {

    //useHistory-MI RAI PROBLEM-NAMESTO TOA USENAVIGATE e za da mozam da redirektiram
    const navigate = useNavigate();

    const [formData, updateFormData] = useState({
        name: "",
        price: 0,
        quantity: 0,
        category: 1,
        brand: 5
    })

    //ova e e nekoj EVENT koj ke se kreira i treba da go ishendlame
    const handleChange = (e) => {
        updateFormData({
            ...formData,
            //od eventot go zemame targetot i imeto na toj target toa ni e key i value e
            [e.target.name]: e.target.value.trim()
        })
    }

    //form-event handler
    const onFormSubmit = (e) => {
        //na ovoj event popreci mu go defaultnoto odnesuvanje- nemoj da gi  prakjas vednas podatocite tuku zastani
        e.preventDefault();
        const name = formData.name;
        const price = formData.price;
        const quantity = formData.quantity;
        const category = formData.category;
        const brand = formData.brand;

        //category i brand se ids
        props.onAddProduct(name, price, quantity, category, brand);
        //ova e redirectot!
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
                               required
                               placeholder="Enter product name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Price</label>
                        <input type="text"
                               className="form-control"
                               id="price"
                               name="price"
                               placeholder="Price"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Quantity</label>
                        <input type="text"
                               className="form-control"
                               id="quantity"
                               name="quantity"
                               placeholder="Quantity"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) =>
                                <option value={term.id}> {term.name} </option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Brand</label>
                        <select name="brand" className="form-control" onChange={handleChange}>
                            {props.brands.map((term) =>
                                <option value={term.id}>{term.name}</option>
                            )}
                        </select>
                    </div>

                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}
export default ProductAdd;
