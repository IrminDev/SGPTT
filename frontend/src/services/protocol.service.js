import axios from "axios";

const API_URL = import.meta.env.VITE_PROTOCOL_SERVICE_URL;

const axiosInstance = axios.create({
    baseURL: API_URL
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

const getProtocols = async () => {
    const response = await axiosInstance.get('/api/protocols');
    return response.data;
}

const getProtocol = async (id) => {
    const response = await axiosInstance.get(`/api/protocols/get?protocolId=${id}`);
    return response.data;
}

const getStudentProtocols = async (id) => {
    const response = await axiosInstance.get(`/api/protocols/get?studentId=${id}`);
    return response.data;
}

const getAllProtocols = async () => {
    const response = await axiosInstance.get('/api/protocols/all');
    return response.data;
}

const getProfessorProtocols = async (id) => {
    const response = await axiosInstance.get(`/api/protocols/get?professorId=${id}`);
    return response.data;
}

const getCATTProtocols = async (id) => {
    const response = await axiosInstance.get(`/api/protocols/get?cattId=${id}`);
    return response.data;
}

const uploadProtocol = async (data) => {
    const response = await axiosInstance.put('/api/protocols/upload', data);
    return response.data;
}

export default {
    getProtocols,
    getProtocol,
    getStudentProtocols,
    getAllProtocols,
    getProfessorProtocols,
    uploadProtocol,
    getCATTProtocols
}