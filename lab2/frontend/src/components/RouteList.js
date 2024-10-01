import React, { useEffect, useState } from 'react';
import { getAllRoutes, deleteRoute } from '../api/routeService';

const RouteList = () => {
    const [routes, setRoutes] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        loadRoutes();
    }, []);

    const loadRoutes = async () => {
        setLoading(true);
        try {
            const response = await getAllRoutes();
            setRoutes(response.data);
        } catch (error) {
            console.error('Error loading routes:', error);
        } finally {
            setLoading(false);
        }
    };

    const handleDelete = async (id) => {
        try {
            await deleteRoute(id);
            loadRoutes(); // Обновить список маршрутов после удачного удаления
        } catch (error) {
            console.error('Ошибка удаления маршрута:', error);
        }
    };

    if (loading) {
        return <p>Загрузка...</p>;
    }

    return (
        <div>
            <h1>Список маршрутов</h1>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Название</th>
                    <th>Действия</th>
                </tr>
                </thead>
                <tbody>
                {routes.map((route) => (
                    <tr key={route.id}>
                        <td>{route.id}</td>
                        <td>{route.name}</td>
                        <td>
                            <button onClick={() => handleDelete(route.id)}>Удалить</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default RouteList;
