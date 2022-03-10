import React from "react";
const brands = (props) =>{
    return (
        <div className={"container mb-4"}>
            <div className= {"row"}>
                <div className= {"row"}>
                    <table className= {"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}> Brand name</th>
                        </tr>
                        </thead>

                        <tbody>
                          {props.brands.map((term) => {
                              return (
                                  //vrati go imeto
                                  <tr>
                                      <td><img src={term.image} width={100} height={100}/></td>
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
export default brands;
