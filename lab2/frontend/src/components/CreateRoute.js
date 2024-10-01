import React, { useState } from 'react';
import { createRoute } from '../api/routeService';

const CreateRoute = () => {
    const [name, setName] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const newRoute = { name }; // Можно добавить другие поля
            await createRoute(newRoute);
            alert('Маршрут успешно создан');
            setName(''); // Очистить форму
        } catch (error) {
            console.error('Ошибка создания маршрута:', error);
        }
    };

    return (
        <div>
            <h1>Создать новый маршрут</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>
                        Название:
                        <input
                            type="text"
                            value={name}
                            onChange={(e) => setName(e.target.value)}
                            required
                        />
                    </label>
                </div>
                <button type="submit">Создать</button>
            </form>
        </div>
    );
};

export default CreateRoute;
