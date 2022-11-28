import '../../App.css';

import React, { useState} from 'react';



function AllMovies() {
    const [movie, setMovie] = useState([])
    

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


           



        </div>

        

        </>
    );
}

export default AllMovies;

