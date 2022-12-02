import '../App.css'
import { useNavigate } from 'react-router-dom';
import './navbar.css';
import React, { useState, useEffect } from 'react';

function Seating() {
    const [seat, setSeat] = useState([])
    const [val, setVal] = useState('')
    const [filtered, setFiltered] = useState([])
    
    React.useEffect(() => {
        fetch("http://localhost:8080/api/v1/movie")
            .then(res => res.json())
            .then((result) => {
                setSeat(result);
                setVal(localStorage.getItem("id")-1)
            }
            )
    }, [])

    let navigate = useNavigate();

    const handleClick=(seatNum) => {       
        localStorage.setItem("seatid",seatNum) 
        console.log(localStorage.getItem("email"))
        console.log(localStorage.getItem("ticketItems"))
        navigate('/payment');
    }

    const displaySeats = (e) => {
        setFiltered(seat.filter(item => {
            return item.id == localStorage.getItem("id")
        }), console.log(filtered))
        console.log(val)
        setVal('');
    }

    return (
        <>
        <div></div>
        <div className='movie'>
            
            <h1 > SCREEN </h1>
            <hr color='black'></hr>       

            {filtered.length}
                {filtered.length === 0 ?
                <button type="button" onClick={displaySeats} class="btn-outline-success btn-lg seat">Display Seating For Movie</button>
                 :
                <ul>
                    {filtered.length}
                    {Array.isArray(filtered)
                        ? filtered.map(item => {
                            return (
                                <><p>name = {item.id} </p>
                                <p>title = {item.title}</p>
                                <p>{item.seat1 === true ? <button type="button" onClick={() => handleClick(1)} color="green" class="btn-outline-success btn-lg seat">1</button> : <button type="button" color="red" class="btn-outline-success btn-lg seat">1</button>}</p>
                                <p>{item.seat2 === true ? <button type="button" onClick={() => handleClick(2)} color="green" class="btn-outline-success btn-lg seat">2</button> : <button type="button" color="red" class="btn-outline-success btn-lg seat">1</button>}</p>
                                <p>{item.seat3 === true ? <button type="button" onClick={() => handleClick(3)} color="green" class="btn-outline-success btn-lg seat">3</button> : <button type="button" color="red" class="btn-outline-success btn-lg seat">1</button>}</p>
                                <p>{item.seat4 === true ? <button type="button" onClick={() => handleClick(4)} color="green" class="btn-outline-success btn-lg seat">4</button> : <button type="button" color="red" class="btn-outline-success btn-lg seat">1</button>}</p>
                                <p>{item.seat5 === true ? <button type="button" onClick={() => handleClick(5)} color="green" class="btn-outline-success btn-lg seat">5</button> : <button type="button" color="red" class="btn-outline-success btn-lg seat">1</button>}</p>
                                <p>{item.seat6 === true ? <button type="button" onClick={() => handleClick(6)} color="green" class="btn-outline-success btn-lg seat">6</button> : <button type="button" color="red" class="btn-outline-success btn-lg seat">1</button>}</p>
                                <p>{item.seat7 === true ? <button type="button" onClick={() => handleClick(7)} color="green" class="btn-outline-success btn-lg seat">7</button> : <button type="button" color="red" class="btn-outline-success btn-lg seat">1</button>}</p>
                                <p>{item.seat8 === true ? <button type="button" onClick={() => handleClick(8)} color="green" class="btn-outline-success btn-lg seat">8</button> : <button type="button" color="red" class="btn-outline-success btn-lg seat">1</button>}</p>
                                <p>{item.seat9 === true ? <button type="button" onClick={() => handleClick(9)} color="green" class="btn-outline-success btn-lg seat">9</button> : <button type="button" color="red" class="btn-outline-success btn-lg seat">1</button>}</p>
                                <p>{item.seat10 === true ? <button type="button" onClick={() => handleClick(10)} color="green" class="btn-outline-success btn-lg seat">10</button> : <button type="button" color="red" class="btn-outline-success btn-lg seat">1</button>}</p>    
                                </>)
                        })
                        : null}
                </ul>

            }

                      


        </div>
        

        </>
    );
}

export default Seating;