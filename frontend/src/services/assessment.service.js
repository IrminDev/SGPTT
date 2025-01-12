import axios from 'axios';
const API_URL = import.meta.env.VITE_ASSESSMENT_SERVICE_URL;

const axiosInstance = axios.create({
    baseURL: API_URL
})

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
)

const createAssessment = async (data) => {
    const response = await axiosInstance.put('/api/assessment/evaluate', data);
    return response.data;
}

const assignAcademy = async (data) => {
    const response = await axiosInstance.put('/api/assessment/assign', data);
    return response;
}

const getEvaluations = async (id) => {
    const response = await axiosInstance.get(`/api/assessment/evaluations/protocol/${id}`);
    return response.data;
}

export default {
    createAssessment,
    assignAcademy,
    getEvaluations
}