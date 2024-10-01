import React, { useState } from 'react';
import { findRoutesByName } from '../api/routeService';

const FindRoutesByName = () => {
    const [name, setName] = useState('');
    const [routes, setRoutes] = useState([]);

    const handleSearch = async (e) => {
        e.preventDefault();
        try {
            const response = await findRoutesByName(name);
            setRoutes(response.data);
        } catch (error) {
            console.error('Ошибка поиска маршрутов:', error);
        }
    };

    return (
        <div>
            <h1>Найти маршруты по названию</h1>
            <form onSubmit={handleSearch}>
                <label>
                    Название:
                    <input
                        type="text"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                </label>
                <button type="submit">Искать</button>
            </form>
            {routes.length > 0 && (
                <ul>
                    {routes.map((route) => (
                        <li key={route.id}>{route.name}</li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default FindRoutesByName;
