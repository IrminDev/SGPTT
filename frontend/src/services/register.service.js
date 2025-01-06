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

const registerStudent = async (data) => {
    const response = await axiosInstance.post('/api/utils/register/student', data);
    return response.data;
};

const registerProfessor = async (data) => {
    const response = await axiosInstance.post('/api/utils/register/professor', data);
    return response.data;
};

const registerCATT = async (data) => {
    const response = await axiosInstance.post('/api/utils/register/catt', data);
    return response.data;
};

export default {
    registerStudent,
    registerProfessor,
    registerCATT
}