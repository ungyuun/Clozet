import axios from 'axios';

const axiosInstance = axios.create({ baseURL: 'https://api.example.com' });
const token = localStorage.getItem("token");

axiosInstance.defaults.headers.common['Authorization'] = `Bearer ${token}`;

export default axiosInstance;