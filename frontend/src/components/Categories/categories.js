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
                        {/*brands.MAP iterira niz listata toest e kako th:each="term : ${brands}" */}
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
//da mozes da pristapuvas do brands nadvor od ovaa komponenta
export default categories;