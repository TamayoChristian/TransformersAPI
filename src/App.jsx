import './App.css';
import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Personajes from './components/Personajes';
import Documentacion from './components/Documentacion';
import Inicio from './components/Inicio';

const App = () => {

  return (
    <div className='App'>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="/personajes" element={<Personajes/>} />
        <Route path="/documentacion" element={<Documentacion/>} />
      </Routes>
    </div>
  );
};

export default App
