import '../../App.css';
import React, { useState, useEffect } from 'react';


function AllCourses() {
    const [courses, setCourse] = useState([])
    useEffect(() => {
        const url = "";    
        const fetchData = async () => {
          try {
            const response = await fetch(url);
            const json = await response.json();
            setCourse(json);
          } catch (error) {
            console.log("error", error);
          }
        };
    
        fetchData();
    }, []);

    return (
        <>
        <div className='hero-container'>
        <div className='allMovies'>
            <h1>Movies: </h1>
            <ul>
                {courses.map(item => (                    
                    <li>                        
                        <h1>Movie name = {item.name} </h1>                        
                        <p>Capacity = {item.capacity}</p>                        
                    </li>
                ))}
            </ul>
            </div>
        </div>            
        </>
    );
}

export default AllCourses;