import React from "react";
import {Link} from "@material-ui/core";

const header= (props)=> {
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark navbar-fixed bg-dark">
                <a className="navbar-brand" href="/products">E-Shop Application</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">

                        <li className="nav-item m-auto">
                            <a className="nav-link active" href="/products">Products</a>
                        </li>

                        <li className="nav-item m-auto">
                            <a className="nav-link active" href="/categories">Categories</a>
                        </li>

                        <li className="nav-item m-auto">
                            <a className="nav-link active" href="/brands">Brands</a>
                        </li>
                    </ul>
                    <form className="form-inline mt-2 mt-md-0 ml-3">
                        <Link className="btn btn-outline-info my-2 my-sm-0" to={"/login"}>Login</Link>
                    </form>
                </div>
            </nav>
        </header>
    )
}
export default header;
