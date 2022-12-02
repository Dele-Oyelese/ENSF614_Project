import Navbar from './components/navbar';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/pages/Home.js';
import AllMovies from './components/pages/AllMovies.js';
import Registration from './components/pages/Registration';
import LogIn from './components/pages/LogIn';
import CancelTicket from './components/pages/CancelTicket';
import Seating from './components/Seating';
import Payment from './components/pages/Payment';
import ContactUs from './components/pages/ContactUs';


function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/allmovies' element={<AllMovies />} />
          <Route path='/register' element={<Registration />} />
          <Route path='/login' element={<LogIn />} /> 
          <Route path='/cancelticket' element={<CancelTicket />} />
          <Route path='/seating' element={<Seating />} />
          <Route path='/payment' element={<Payment />} />
          <Route path='/contactus' element={<ContactUs />} />
          
          
        </Routes>
      </Router>

    </>
  );
}

export default App;
