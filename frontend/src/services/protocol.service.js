import axios from "axios";
const API_URL = import.meta.env.VITE_PROTOCOL_SERVICE_URL;

const getProtocols = async (token) => {
    const response = await axios.get(`${API_URL}/api/protocols`, {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    });

    return response.data;
}

const getProtocol = async (token, id) => {
    const response = await axios.get(`${API_URL}/api/protocols/${id}`, {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    });

    return response.data;
}

const getStudentProtocols = async (token, id) => {
    const response = await axios.get(`${API_URL}/api/protocols/get?studentId=1${id}`, {
        headers: {
            'Authorization': `Bearer ${token}`
        }   
    });

    return response.data;
}

const getAllProtocols = async (token) => {
    const response = await axios.get(`${API_URL}/api/protocols/all`, {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    });

    return response.data;
}

const getProfessorProtocols = async (token, id) => {
    const response = await axios.get(`${API_URL}/api/protocols/get?professorId=${id}`, {
        headers: {
            'Authorization': `Bearer ${token}`
    }});

    return response.data;
}

const uploadProtocol = async (token, data) => {
    const response = await axios.put(`${API_URL}/api/protocols/upload`, data, {
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'multipart/form-data'
        }
    });

    return response.data;
}

export default {
    getProtocols,
    getProtocol,
    getStudentProtocols,
    getAllProtocols,
    getProfessorProtocols,
    uploadProtocol
}