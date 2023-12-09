export default function Country(props) {
    return (
        <li key={props.listItemIndex}>
            <p>Name: {props.countryData.name}</p>
            <p>Country code: {props.countryData.country_code}</p>
            <p>Capital: {props.countryData.capital}</p>
            <p>Population: {props.countryData.population}</p>
            <p>Flag file URL: {props.countryData.flag_file_url}</p>
        </li>
    )
}