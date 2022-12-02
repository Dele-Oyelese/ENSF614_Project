
import {Link} from 'react-router-dom';

import './navbar.css';

function Navbar() {
    
  return (
    <>
    <nav className='navbar'>
        <div className='navbar-container'>
            <Link to='/' className='navbar-logo'>
                Movie Theatre
            </Link>

            <ul className='nav-menu active'>
                <li className='nav-item'>
                    <Link to='/cancelticket' className='nav-links' > Cancel Ticket </Link>
                </li>
                <li className='nav-item'>
                    <Link to='/register' className='nav-links' > Register </Link>
                </li>
                <li className='nav-item'>
                    <Link to='/ContactUs' className='nav-links' > Contact Us </Link>
                </li>

                <li className='nav-item'>
                    <Link to='/login' className='nav-links' > Log In </Link>
                </li>

            </ul>
                      
        </div>

    </nav>
    </>
  )
}

export default Navbar