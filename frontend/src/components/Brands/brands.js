import React from "react";

//props e isto OBJEKT i e mnozina od properties koi moze da se predadat
//toa shto ke imame vo props e toa sto ke predade nekoja parent komponenta kon ovaa
//i vo slucajov brands e svojstvo na props zatoa pravis props.brands.map
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
                          {/*brands.MAP iterira niz listata toest e kako th:each="term : ${brands}" */}
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
//da mozes da pristapuvas do brands nadvor od ovaa komponenta
export default brands;