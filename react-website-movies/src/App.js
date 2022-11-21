import Navbar from './components/navbar';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/pages/Home.js';
import AllMovies from './components/pages/AllMovies.js';

function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/AllMovies' element={<AllMovies />} />
          
        </Routes>
      </Router>

    </>
  );
}

export default App;
