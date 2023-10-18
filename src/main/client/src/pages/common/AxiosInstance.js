import axios from 'axios';

const axiosInstance = axios.create({ baseURL: `${process.env.BASE_URL}` });
const jwt = localStorage.getItem("JWT");

axiosInstance.defaults.headers.common['Authorization'] = `Bearer ${jwt}`;

export default axiosInstance;