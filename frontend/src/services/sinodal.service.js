import axios from "axios";

const API_URL = import.meta.env.VITE_UTILS_SERVICE_URL;

const axiosInstance = axios.create({
    baseURL: API_URL,
});

axiosInstance.interceptors.request.use(
    config => {
        const token = localStorage.getItem("token");
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

const createSinodal = async (data) => {
    const response = await axiosInstance.post('/api/sinodal', data);
    return response.data;
}

const getAllProfessors = async () => {
    const response = await axiosInstance.get('/api/sinodal/professors/all');
    return response.data;
}

const createSinodalByProfessor = async (data) => {
    const response = await axiosInstance.post('/api/sinodal/professor', data);
    return response.data;
}

export default {
    createSinodal,
    getAllProfessors,
    createSinodalByProfessor,
}