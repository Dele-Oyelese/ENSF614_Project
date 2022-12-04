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
import Admin from './components/pages/Admin';
import FeeRenewal from './components/pages/FeeRenewal';
import { useState, useEffect } from "react";

function App() {
  const [ticketId, setticketid] = useState(1);

  const updateTicket = (e) => {
    setticketid(ticketId+1)
  }

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
          <Route path='/admin' element={<Admin />} />
          <Route path='/payment' element={<Payment updateTicket = {updateTicket} ticketValue = {ticketId}/>} />
          <Route path='/contactus' element={<ContactUs />} />
          <Route path='/feeRenewal' element={<FeeRenewal />} />
          
        </Routes>
      </Router>

    </>
  );
}

export default App;
