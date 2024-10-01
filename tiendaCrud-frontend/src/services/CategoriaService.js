import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:1402/api/categoria';

export const listCategoria = () => axios.get(REST_API_BASE_URL);