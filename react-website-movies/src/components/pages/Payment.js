import '../../App.css';
import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useState, useEffect } from "react";

function Payment() {

    const [name, setname] = useState("");
    const [address, setaddress] = useState("");
    const [email, setemail] = useState("");
    const [creditcard, setcreditcard] = useState("");
    const [user, setUser] = useState([]);
    const ticketId = 1;

    useEffect(() => {
        const url = "http://localhost:8080/api/v1/user/Email/".concat(localStorage.getItem("email"));    
        const fetchData = async () => {
          try {
            const response = await fetch(url);
            const json = await response.json();
            setUser(json);
            console.log(user);
          } catch (error) {
            console.log("error", error);
          }
        };    
        fetchData();
    }, []);

    const purchaseTicket = (e) => {
        e.preventDefault();
        const movieID = localStorage.getItem("id");
        const seatID = localStorage.getItem("seatID");

        if (localStorage.getItem("email") === null) {

            const flag = 0;
            
        } else {

            const flag = 1;
            
        }

        //t expects a 1 for registered User a 0 or anything else for a non registered user
        const url = "api/v1/boxOffice/purchase/"+ ticketId + "/movie/" + movieID + "/seat/" + seatID +"/ru/" + flag;
        ticketId++;
          
        fetch(url, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(course),
        })
          .then((result) => {
            if (result.ok) {
              return result.json();
            }
            return result.json().then((result) => {
              alert(result.message);
              setcoursename("");
              setPrereqname("");
              throw new Error(result.error);
            });
          })
          .then(() => {
            alert("Prerequisite successfully added");
            setcoursename("");
            setPrereqname("");
          })
          .catch((error) =>
            console.log(error)
          );

    }

    return (
        <>
            {/* @PutMapping("*/}

            <div className="movie">

                <div>

                    <p> Your selections are: </p>
                    <p>Movie ID: {localStorage.getItem("id")}</p>
                    <p>Movie Name: {localStorage.getItem("title")}</p>
                    <p>Show Time: {localStorage.getItem("showTime")}</p>


                </div>

                <form>
                    <div className="form-group">
                        <label >Name</label>
                        <input
                            defaultValue={user.name}
                            type="text"
                            onChange={(e) => setname(e.target.value)}
                            className="form-control"
                            placeholder="Enter Your Name, e.g.: John"
                        ></input>
                    </div>
                    <div className="form-group">
                        <label>Address</label>
                        <input
                            type="text"
                            defaultValue={user.address}
                            onChange={(e) => setaddress(e.target.value)}
                            className="form-control"
                            placeholder="Enter your address: 123 Block X, T6X6G8, Calgary, AB"
                        ></input>
                    </div>


                    <div className="form-group">
                        <label>Email</label>
                        <input
                            type="text"
                            defaultValue={user.email}
                            onChange={(e) => setemail(e.target.value)}
                            className="form-control"
                            placeholder="Enter your email: e.g john.smith@gmail.com"
                        ></input>
                    </div>

                    <div className="form-group">
                        <label>Credit Card Number</label>
                        <input
                            type="text"
                            defaultValue={user.creditNum}
                            onChange={(e) => setcreditcard(e.target.value)}
                            className="form-control"
                            placeholder="Enter credit card number: e.g 1234 5678 9101 1213"
                        ></input>
                    </div>

                    <button
                        type="submit"
                        className="btn btn-primary"
                        onClick={purchaseTicket}
                    >
                        Purchase Ticket
                    </button>
                </form>

            </div>
        </>
    )



}

export default Payment;