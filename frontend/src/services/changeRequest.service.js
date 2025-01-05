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

const createChangeRequest = async (data) => {
    const response = await axiosInstance.post('/api/utils/change-request', data);
    return response.data;
}

const getProtocolChangeRequests = async (id) => {
    const response = await axiosInstance.get(`/api/utils/change-request/protocol/${id}`);
    return response.data;
}

export default {
    createChangeRequest,
    getProtocolChangeRequests
}