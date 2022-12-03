import '../../App.css';
import React, { useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import { useState, useEffect } from "react";
import emailjs from 'emailjs-com';

function Payment() {
    const form = useRef();

    const [name, setname] = useState("");
    const [address, setaddress] = useState("");
    const [email, setemail] = useState("");
    const [creditcard, setcreditcard] = useState("");
    const [user, setUser] = useState([]);
    const [ticketId, setticketId] = useState(1);
    const [flag, setFlag] = useState(1);

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
        setticketId(ticketId + 1);
        console.log(ticketId);
    }, []);

    const sendEmail = (e) => {
        e.preventDefault();
        emailjs.sendForm('gmail', 'template_7woudlf', e.target, 'GE7vkWWcHkEMc_LhW')
          .then((result) => {
              console.log(result.text);
          }, (error) => {
              console.log(error.text);
          });
          e.target.reset()
      };

    const purchaseTicket = (e) => {
        e.preventDefault();
        const movieID = localStorage.getItem("id");
        const seatID = localStorage.getItem("seatid");
        if (localStorage.getItem("email") == null) {
            setFlag(0);
        }
        //t expects a 1 for registered User a 0 or anything else for a non registered user
        const url = "http://localhost:8080/api/v1/boxOffice/purchase/" + ticketId + "/movie/" + movieID + "/seat/" + seatID + "/ru/" + flag;
        console.log(url)
        fetch(url, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
        })
    }

    return (
        <>
            {/* @PutMapping("*/}
            <div className="movie">
                <div>
                <p> Your selections are: </p>
                    <p name = "movie_id">Movie ID: {localStorage.getItem("id")}</p>
                    <p name = "movie_name">Movie Name: {localStorage.getItem("title")}</p>
                    <p name = "show_time">Show Time: {localStorage.getItem("showTime")}</p>
                </div>

                <form ref={form} onSubmit={sendEmail}>

                    

                    <div className="form-group">
                        <label >Name</label>
                        <input
                            name = "user_name"
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
                            name = "user_address"
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
                            name = "user_email"
                            type="email"
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
                    <input
                        type="hidden"
                        className="form-control"
                        name="movie_id"
                         defaultValue={localStorage.getItem("id")}
                        ></input>
                        <input
                        type="hidden"
                        className="form-control"
                        name="movie_name"
                         defaultValue={localStorage.getItem("title")}
                         ></input>
                        <input
                        type="hidden"
                        className="form-control"
                        name="show_time"
                         defaultValue={localStorage.getItem("showTime")}
                         ></input>
                         <input
                        type="hidden"
                        className="form-control"
                        name="movie_id"
                         defaultValue={localStorage.getItem("seatid")}
                         ></input>

                    <button type="submit" className="btn btn-primary" onClick={purchaseTicket}>
                        Purchase Ticket
                    </button>
                    <p></p>
                    <button type="submit" className="btn btn-primary" onClick={sendEmail}>
                        Send Confirmation Email
                    </button>
                </form>
            </div>
        </>
    )



}

export default Payment;