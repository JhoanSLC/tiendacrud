import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:1402/api/categoria';

export const listCategoria = () => axios.get(REST_API_BASE_URL);

export const createCategoria = (categoria) => axios.post(REST_API_BASE_URL,categoria); 

export const getCategoria = (categoriaId) => axios.get(REST_API_BASE_URL + '/' + categoriaId);

export const updateCategoria = (categoriaId, categoria) => axios.put(REST_API_BASE_URL + '/' + categoriaId, categoria);

export const deleteCategoria = (categoriaId) => axios.delete(REST_API_BASE_URL + '/' + categoriaId);