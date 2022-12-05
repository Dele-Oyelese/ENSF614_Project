import '../../App.css';
import React, { useState } from 'react';
import { useRef } from 'react';
import emailjs from 'emailjs-com';

function CancelTicket() {

    const [ticketId, setticketid] = useState('');
    const [ticket, setticket] = useState([]);
    const [buyerStatus, setStatus] = useState('');
    const [showTime, setshowtime] = useState('');
    const [email, setEmail] = useState('')
    const now = new Date();
    const dayTime = 24 * 60 * 60 * 1000;

    const handleClick = (e) => {
        e.preventDefault();

        fetch("http://localhost:8080/api/v1/ticket/" + ticketId)

            .then(res => res.json())

            .then((result) => {

                setticket(result);

                console.log(result);
                console.log(result.boxOffices[0].movie.showTime)
                console.log(ticket)
                setStatus(
                    Array.isArray(result)
                        ? result.map(item => {
                            return (item.buyerStatus)
                        })
                        : null
                )

                setshowtime(
                    Array.isArray(result)
                        ? result.map(item => {
                            console.log(item.boxOffices[0].movie.showTime)
                            return (item.boxOffices[0].movie.showTime)
                        })
                        : null
                )

                if (result.boxOffices[0].movie.showTime != null) {
                    const date = result.boxOffices[0].movie.showTime;
                    const stringDate = date.substring(0, 10);
                    const hr = date.substring(12, 13)
                    const min = date.substring(15, 16)
                    const sec = date.substring(18, 19)
                    console.log(stringDate)
                    console.log(hr)

                    const myArray = stringDate.split("-");
                    const payDate = new Date()
                    console.log(myArray)
                    payDate.setFullYear(myArray[0], myArray[1] - 1, myArray[2])
                    payDate.setHours(hr, min, sec)
                    console.log(payDate)
                    const timeDiff = (payDate - now) / dayTime;
                    console.log(timeDiff);

                    if (timeDiff >= 3) {
                        alert("Sorry, users are able to cancel their ticket only up to 72 hours prior to show");
                    } else {
                        //first deleting the ticket 
                        const url = "http://localhost:8080/api/v1/boxOffice/cancel/" + ticketId;
                        console.log(url)
                        fetch(url, {
                            method: "PUT",
                            headers: { "Content-Type": "application/json" },
                        })

                        if (buyerStatus == true) {
                            alert("Please type your email to recieve your coupon valued at $10");
                        }

                        if (buyerStatus == false) {
                            alert("Please type your email to recieve your coupon valued at $8");
                        }
                    }
                }
            })

    }

    const form = useRef();

    const sendEmail = (e) => {
        e.preventDefault();
        emailjs.sendForm('gmail', 'template_7woudlf', form.current, 'GE7vkWWcHkEMc_LhW')
            .then((result) => {
                console.log(result.text);
            }, (error) => {
                console.log(error.text);
            });
    };

    return (
        <>
            <div className='movie'>
                <form>
                    <div class="form-group">
                        <p>Please enter your ticket ID number below, found on the confirmation email sent to you</p>
                        <label >Ticket ID Number</label>
                        <input
                            type="text"
                            class="form-control"
                            value={ticketId}
                            onChange={(e) => setticketid(e.target.value)}
                            placeholder="Enter your ticket ID number, e.g. 69907"></input>
                    </div>

                    <button
                        type="submit"
                        onClick={handleClick}
                        class="btn btn-primary" >Request Cancellation</button>
                    <br></br>
                    <hr></hr>
                    <input
                        type="text"
                        class="form-control"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        placeholder="Enter your email address, e.g. john.smith@gmail.com"></input>
                    <br></br>
                    <button
                        type="submit"
                        onClick={sendEmail}
                        class="btn btn-primary" >Send Email Confirmation</button>
                </form>
            </div>
            <form ref={form} onSubmit={sendEmail}>
                <input type="hidden" name="user_name" defaultValue={"Greetings "} />
                <input type="hidden" name="user_email" defaultValue={email} />
                <input type="hidden" name="subject" defaultValue={"Movie Theater Cancellation Confirmation"} />
                <input type="hidden" name="message" defaultValue={"Confirming your cancelation for ticketID: " + ticketId + ", in the future please use the follwing Coupon Code for 15% off your next purchase: 15MOVIE15"} />
                <input type="hidden" name="messageone" defaultValue={"We hope to see you at the movies"} />
            </form>


        </>
    );
}

export default CancelTicket;