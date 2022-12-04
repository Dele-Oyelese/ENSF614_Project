import '../../App.css';
import './AllMovies.css'
import { Link, useNavigate } from 'react-router-dom';
import React, { useState, useEffect } from 'react';

function AllMovies() {
    const [movie, setMovie] = useState([])
    const [filtered, setFiltered] = useState([])
    const [val, setVal] = useState('')    
    let navigate = useNavigate();

    React.useEffect(() => {
        fetch("http://localhost:8080/api/v1/movie")
            .then(res => res.json())
            .then((result) => {
                setMovie(result);
            }
            )
    }, [])

    const Search = (e) => {
        setFiltered(movie.filter(item => {
            return item.title.toLowerCase() === val.toLowerCase();
        }))
        setVal('');
    }

    const reset = (e) => {
        setFiltered([])
    }

    const handleClick= (showTime, title, id )  => {   
        localStorage.setItem("id",id)
        localStorage.setItem("title",title)
        localStorage.setItem("showTime", showTime)
        navigate('/seating');
    }

    return (

        <div className='movie'>
            <div className="input-group">
                <input type="text" value={val} onChange={(e) => setVal(e.target.value)} className="form-control" placeholder="Search for a movie, e.g. Black Panther"></input>
                <button onClick={Search} className="btn btn-dark" type="button">Search</button>
                <button onClick={reset} className="btn btn-dark" type="button">Show All</button>

            </div>
            <div className="movie-container">
            {filtered.length === 0 ?
                <ul>
                    {Array.isArray(movie)
                        ? movie.map(item => {
                            return (
                                <>
                                <p>{item.title} </p>                                    
                                <img src={item.title + ".jpg"} width="200" length="200" />
                                <br></br>
                                <button onClick={() => handleClick(item.showTime, item.title, item.id)} type="button" className="btn btn-dark">{item.showTime}</button>
                                </>)
                        })
                        : null}
                </ul>:

                <ul>
                    {Array.isArray(filtered)
                        ? filtered.map(item => {
                            return (
                                <>
                                    <p>name = {item.title} </p>
                                    <img src={item.title + ".jpg"} width="200" length="200" />
                                    <p>showTime = {item.showTime} </p>
                                    
                                </>)
                        })
                        : null}
                        
                </ul>

            }
            </div>
            </div>
        
    );
}

export default AllMovies;

