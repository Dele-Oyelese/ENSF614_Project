import '../App.css'
import { useNavigate } from 'react-router-dom';
import './navbar.css';

function Seating() {
    
    let navigate = useNavigate();

    const handleClick = (e) => {        
        console.log(localStorage.getItem("email"))
        console.log(localStorage.getItem("ticketItems"))
        navigate('/payment');
    }

    return (
        <>
        <div className='movie'>
            
            <h1 > SCREEN </h1>
            <hr color='black'></hr>

            <button type="button" onClick={handleClick} class="btn-outline-success btn-lg seat">A</button>
            <button type="button" class="btn-outline-success btn-lg seat">B</button>
            <button type="button" class="btn-outline-success btn-lg seat">C</button>
            <button type="button" class="btn-outline-success btn-lg seat">D</button>
            <button type="button" class="btn-outline-success btn-lg seat">E</button>
            <button type="button" class="btn-outline-success btn-lg seat">F</button>
            <button type="button" class="btn-outline-success btn-lg seat">G</button>
            <button type="button" class="btn-outline-success btn-lg seat">H</button>
            <button type="button" class="btn-outline-success btn-lg seat">I</button>
            <button type="button" class="btn-outline-success btn-lg seat">J</button>
            <button type="button" class="btn-outline-success btn-lg seat">K</button>         


        </div>

        

        </>
    );
}

export default Seating;