import '../App.css'
import { useNavigate } from 'react-router-dom';
import './navbar.css';
import './Seating.css'
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
                {filtered.length === 0 ?
                <button type="button" onClick={displaySeats} class="btn-outline-success btn-lg seat">Display Seating For Movie</button>
                 :
                <ul>
                    {Array.isArray(filtered)
                        ? filtered.map(item => {
                            return (
                                <><p> </p>
                                <p>Movie: {item.title}</p>
                                <p>ShowTime: {item.showTime}</p>                                
                                <div class="container">
                                <p>{item.seat1 === true ? <button type="button" class="btn btn-success" onClick={() => handleClick(1)} >1</button> : <button type="button" class="btn btn-danger" >1</button>}</p>
                                <p>{item.seat2 === true ? <button type="button" class="btn btn-success" onClick={() => handleClick(2)} >2</button> : <button type="button" class="btn btn-danger" >2</button>}</p>
                                <p>{item.seat3 === true ? <button type="button" class="btn btn-success" onClick={() => handleClick(3)} >3</button> : <button type="button" class="btn btn-danger">3</button>}</p>
                                <p>{item.seat4 === true ? <button type="button" class="btn btn-success" onClick={() => handleClick(4)} >4</button> : <button type="button" class="btn btn-danger">4</button>}</p>
                                <p>{item.seat5 === true ? <button type="button" class="btn btn-success" onClick={() => handleClick(5)} >5</button> : <button type="button" class="btn btn-danger">5</button>}</p>
                                <p>{item.seat6 === true ? <button type="button" class="btn btn-success" onClick={() => handleClick(6)} >6</button> : <button type="button" class="btn btn-danger">6</button>}</p>
                                <p>{item.seat7 === true ? <button type="button" class="btn btn-success" onClick={() => handleClick(7)} >7</button> : <button type="button" class="btn btn-danger">7</button>}</p>
                                <p>{item.seat8 === true ? <button type="button" class="btn btn-success" onClick={() => handleClick(8)} >8</button> : <button type="button" class="btn btn-danger">8</button>}</p>
                                <p>{item.seat9 === true ? <button type="button" class="btn btn-success" onClick={() => handleClick(9)} >9</button> : <button type="button" class="btn btn-danger">9</button>}</p>
                                <p>{item.seat10 === true ? <button type="button" class="btn btn-success" onClick={() => handleClick(10)} >10</button> : <button type="button" class="btn btn-danger">10</button>}</p>    
                                </div>
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