import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080/', // Cambia esto por la URL de tu backend
  timeout: 10000, // Tiempo de espera opcional
  headers: {
    'Content-Type': 'application/json',
  },
});

export default axiosInstance;
