import Navbar from './components/navbar';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/pages/Home.js';
import AllMovies from './components/pages/AllMovies.js';
import Registration from './components/pages/Registration';


function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/allmovies' element={<AllMovies />} />
          <Route path='/register' element={<Registration />} />
          
          
        </Routes>
      </Router>

    </>
  );
}

export default App;
