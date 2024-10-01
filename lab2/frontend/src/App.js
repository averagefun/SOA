import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import RouteList from './components/RouteList';
import CreateRoute from './components/CreateRoute';
import FindRoutesByName from './components/FindRoutesByName';

const App = () => {
  return (
      <Router>
        <div>
          <nav>
            <a href="/">Все маршруты</a> |{' '}
            <a href="/create">Создать новый маршрут</a> |{' '}
            <a href="/search">Найти маршруты по названию</a>
          </nav>

          <Routes>
            <Route path="/" element={<RouteList />} />
            <Route path="/create" element={<CreateRoute />} />
            <Route path="/search" element={<FindRoutesByName />} />
          </Routes>
        </div>
      </Router>
  );
};

export default App;
