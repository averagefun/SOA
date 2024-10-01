import axios from 'axios';

// Базовый URL для запросов:
const API_URL = 'http://localhost:8080/routes'; // Замените на фактический бэкэнд URL

// Получить все маршруты с пагинацией и сортировкой
export const getAllRoutes = (page = 1, size = 10, sort = '', filter = '', name = '') => {
    return axios.get(API_URL, {
        params: { page, size, sort, filter, name }
    });
};

// Получить маршрут по ID
export const getRouteById = (id) => {
    return axios.get(`${API_URL}/${id}`);
};

// Создать маршрут
export const createRoute = (route) => {
    return axios.post(API_URL, route);
};

// Обновить маршрут по ID
export const updateRoute = (id, route) => {
    return axios.put(`${API_URL}/${id}`, route);
};

// Удалить маршрут по ID
export const deleteRoute = (id) => {
    return axios.delete(`${API_URL}/${id}`);
};

// Найти маршруты по имени
export const findRoutesByName = (name) => {
    return axios.get(`${API_URL}/name/${name}`);
};

// Получить маршрут с максимальным "from"
export const getRouteWithMaxFrom = () => {
    return axios.get(`${API_URL}/from/max`);
};

// Получить количество маршрутов с дистанцией меньше заданной
export const countRoutesByDistanceLowerThan = (distance) => {
    return axios.get(`${API_URL}/distance/lower/${distance}/count`);
};
