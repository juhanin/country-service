import {useEffect, useState} from "react";
import Country from "./Country.jsx";

export default function CountryList() {
    const [countries, setCountries] = useState(null);

    useEffect(() => {
        fetch("http://localhost:8080/countries", {
            method: "GET"
        })
            .then(response => response.json())
            .then(data => {
                setCountries(data);
            })
            .catch(error => console.log(error));
    }, []);

    return (
        <div>
            <ul>
                {countries && countries.map((country, index) => {
                    return (
                        <Country countryData={country} listItemIndex={index} />
                    );
                })}
            </ul>
        </div>
    )
}