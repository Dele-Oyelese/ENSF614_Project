import '../../App.css';
import { Link, useNavigate } from 'react-router-dom';
import React, { useState, useEffect } from 'react';

function AllMovies() {
    const [movie, setMovie] = useState([])
    const [val, setVal] = useState('')
    let navigate = useNavigate();

    useEffect(() => {
        const url = "http://localhost:8080/api/v1/movie";

        const fetchData = async () => {
            try {
                const response = await fetch(url);
                const json = await response.json();
                setMovie(json);
                
                            
            } catch (error) {
                console.log("error", error);
            }
        };
        fetchData();
        
    }, []);

    const handleClick = (e) => {
        navigate('/login');
    }

    const searchMovie = (e) => {
        {
            console.log(movie);  
            movie.filter((val) => {
                if (movie == "") {
                    return val
                } else if (val.title.toLowerCase().includes(movie.title.toLowerCase())) {
                    return val
                } return ""
            }).map((val, key) => {
                return <div>
                    <button onClick={handleClick} type="button">{val.showTime}</button>
                    <p></p>
                    <img src={val.title + ".jpg"} width="200" length="200" />
                </div>;
            })
        }


    }


    return (

        <>
            <div className='movie'>
                <div className="input-group">
                    <input type="text" value={val} onChange={(e) => setVal(e.target.value)} className="form-control" placeholder="Search for a movie, e.g. Black Panther"></input>
                    <button className="btn btn-dark" type="button" onClick={searchMovie}>Search</button>
                </div>

                <ul>
                    {Array.isArray(movie)
                        ? movie.map(item => {
                            return (
                                <><p>name = {item.title} </p>
                                    <img src={item.title + ".jpg"} width="200" length="200" />
                                    <p>showTime = {item.showTime} </p>
                                </>)
                        })
                        : null}
                </ul>




            </div>



        </>

    );
}

export default AllMovies;

