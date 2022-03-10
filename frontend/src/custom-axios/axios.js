import axios from "axios";

const instance = axios.create({
    baseURL : 'http://localhost:8080/api',
    headers: {
        'Access-Control-Allow-Origin' : '*'
    }
})
//ova za da mozam da ja pristapam od drugi delovi
export default instance;