import '../../App.css';
import React, { useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import { useState, useEffect } from "react";
import emailjs from 'emailjs-com';

function Payment(props) {
    const form = useRef();

    const [name, setname] = useState("");
    const [address, setaddress] = useState("");
    const [email, setemail] = useState("");
    const [creditcard, setcreditcard] = useState("");
    const [user, setUser] = useState([]);    
    const [flag, setFlag] = useState(1);

    useEffect(() => {
        if (localStorage.getItem("email") == null) {
            setFlag(0);
        }
        
        const url = "http://localhost:8080/api/v1/user/Email/".concat(localStorage.getItem("email"));
        const fetchData = async () => {
            try {
                const response = await fetch(url);
                const json = await response.json();
                setUser(json);                
            } catch (error) {
                console.log("error", error);
            }
        };
        fetchData();
    }, []);

    const sendEmail = (e) => {
        e.preventDefault();
        emailjs.sendForm('gmail', 'template_7woudlf', form.current, 'GE7vkWWcHkEMc_LhW')
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
        console.log("TicketID is: " + props.ticketValue);
        console.log("Flag is" + flag);
        const url = "http://localhost:8080/api/v1/boxOffice/purchase/" + props.ticketValue + "/movie/" + movieID + "/seat/" + seatID + "/ru/" + flag;
        props.updateTicket()           
        fetch(url, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
        }).then(() => {
            alert("Ticket successfully added");            
            setname("");
            setaddress("");
            setcreditcard("");
            setemail("");
          })
        
    }

    return (
        <>
            {/* @PutMapping("*/}
            <div className="movie">
                <div>
                    <p> Your selections are: </p>
                    <p name="movie_id">Movie ID: {localStorage.getItem("id")}</p>
                    <p name="movie_name">Movie Name: {localStorage.getItem("title")}</p>
                    <p name="show_time">Show Time: {localStorage.getItem("showTime")}</p>
                    <p> Seat Number: {localStorage.getItem("seatid")}</p>
                </div>

                <form>

                    <div className="form-group">
                        <label >Name</label>
                        <input
                            name="user_name"
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
                            name="user_address"
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
                            name="user_email"
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
                    <button type="submit" className="btn btn-primary" onClick={purchaseTicket}>
                        Purchase Ticket
                    </button>
                    <p></p>
                    <button type="submit" className="btn btn-primary" onClick={sendEmail}>
                        Send Confirmation Email
                    </button>
                </form>
                <form ref={form} onSubmit={sendEmail}>

                    <input type="hidden" name="user_name" defaultValue={"Greetings " + name} />

                    <input type="hidden" name="user_email" defaultValue={email} />

                    <input type="hidden" name="subject" defaultValue={"Movie Theater Confirmation Ticket"} />

                    <input type="hidden" name="message" defaultValue={"We hope you enjoy your showing of " + localStorage.getItem("title") + ", your movie information is: TicketID: " + props.ticketValue + ", Movie Showtime: " + localStorage.getItem("showTime") + ", in seat #: " + localStorage.getItem("seatid")} />

                    <input type="hidden" name="messageone" defaultValue={"If you would like to cancel your ticket please go to the following website and put in your Ticket ID:  https://localhost:3000/cancelticket"} />

                </form>
            </div>
        </>
    )



}

export default Payment;