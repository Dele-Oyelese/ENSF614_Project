import '../../App.css';
import jsondata from './movie.json';
import {Link, useNavigate} from 'react-router-dom';
import React, { useState} from 'react';
import { Navigate } from 'react-router-dom';

function AllMovies() {
    const [movie, setMovie] = useState([])
    let navigate = useNavigate();
    
    const handleClick = (e) => {
        navigate('/login');
    }


    const searchMovie = async () => {
        const url = '...' + movie;
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                Accept: 'application/json',
            },
        });
        const result = await response.json();
        setMovie(result);
        setMovie('');        
    }


    return (
        <>
        <div className='movie'>
        
            <div className="input-group">
                <input type="text" value={movie} onChange={(e) => setMovie(e.target.value)} className="form-control" placeholder="Search for a movie, e.g. Black Panther"></input>                        
                <button onClick={searchMovie} className="btn btn-dark" type="button">Search</button>                        
            </div>
            <p>Display the searched movie with showtimes below:</p>
            <div>
                {jsondata.filter((val)=>{
                    if(movie == "") {
                        return val
                    } else if (val.movie_name.toLowerCase().includes(movie.toLowerCase())) {
                        return val
                    } return "" 
                }).map((val, key)=>{
                    return <div>
                    <button onClick={handleClick} type="button">{val.movie_name}</button>
                    {/* {val.movie_name}  */}
                    <p></p>
                    <img src={val.movie_name + ".jpg"} width="200" length ="200"/>
                    </div>;
                })}
                
            </div>

        </div>

        

        </>
    );
}

export default AllMovies;

