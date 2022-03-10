import React from "react";

const categories = (props) =>{
    return (
        <div className={"container mb-4"}>
            <div className= {"row"}>
                <div className= {"row"}>
                    <table className= {"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Category name</th>
                        </tr>
                        </thead>

                        <tbody>
                        {props.categories.map((term) => {
                            return (
                                //vrati go imeto
                                <tr>
                                    <td>{term.name}</td>
                                </tr>
                            );
                        })}
                        </tbody>

                    </table>
                </div>
            </div>
        </div>
    )
}
export default categories;
