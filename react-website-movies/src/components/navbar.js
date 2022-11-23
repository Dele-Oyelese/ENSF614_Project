import React,{useState, useEffect} from 'react';
import {Link} from 'react-router-dom';
import { Button } from './Button';
import './navbar.css';

function Navbar() {
    const [click,setClick] = useState(false);
    const [button, setButton] = useState(true);
    const closeMobileMenu = () => setClick(false);
    const showButton = () => {
        if(window.innerWidth <= 960){
            setButton(false)
        } else {
            setButton(true)
        }
    }

    useEffect(() => {
        showButton()
    },[])
    window.addEventListener('resize', showButton);
  return (
    <>
    <nav className='navbar'>
        <div className='navbar-container'>
            <Link to='/' className='navbar-logo' onClick = {closeMobileMenu}>
                Movie Theatre
            </Link>

            <ul className={click ? 'nav-menu active':'nav-menu'}>
                <li className='nav-item'>
                    <Link to='/' className='nav-links' onClick={closeMobileMenu}> Home </Link>
                </li>
                <li className='nav-item'>
                    <Link to='/search' className='nav-links' onClick={closeMobileMenu}> Search </Link>
                </li>
                <li className='nav-item'>
                    <Link to='/allmovies' className='nav-links' onClick={closeMobileMenu}> All Movies </Link>
                </li>
            </ul>
            {button && <Button buttonStyle='btn--outline'>Log In</Button>}            
        </div>

    </nav>
    </>
  )
}

export default Navbar