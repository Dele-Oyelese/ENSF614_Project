import '../../App.css';
import React, { useState } from 'react';
import { useRef } from 'react';
import emailjs from 'emailjs-com';

function CancelTicket() {

    const [ticketId, setticketid] = useState('');
    const [ticket, setticket] = useState([]);
    const [buyerStatus, setStatus] = useState('');
    const [email, setEmail] = useState('')

    const handleClick = (e) => {
        e.preventDefault();


        fetch("http://localhost:8080/api/v1/ticket/" + ticketId)
            .then(res => res.json())
            .then((result) => {
                setticket(result);
                console.log(result);
                setStatus(
                    Array.isArray(ticket)
                        ? ticket.map(item => {
                            return (item.buyerStatus)
                        })
                        : null
                )
            }
            )

        // @PutMapping("api/v1/boxOffice/cancel/{ticketId})
        const url = "http://localhost:8080/api/v1/boxOffice/cancel/" + ticketId;
        console.log(url)
        fetch(url, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
        })

        if (buyerStatus == true) {
            alert("You are true")
        }
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

                        <input type="email" 
                        class="form-control" 
                        value={email} onChange={(e) => setEmail(e.target.value)}
                        placeholder="Enter your Email Address, e.g. John.Smith@gmail.com">
                        </input>

                        <button
                        type="submit"
                        onClick={sendEmail}
                        class="btn btn-primary" >Send Confirmation Email</button>
                </form>

            </div>
            <form ref={form} onSubmit={sendEmail}>
      <input type="hidden" name="user_name" defaultValue={"Greetings "}/>
      <input type="hidden" name="user_email" defaultValue={email}/>
      <input type="hidden" name="subject" defaultValue={"Movie Theater Cancellation Confirmation"}/>
      <input type="hidden" name="message" defaultValue={"Confirming your cancelation for ticketID: " + ticketId + ", in the future please use the follwing Coupon Code for 15% off your next purchase: 15MOVIE15"} />
      <input type="hidden" name="messageone" defaultValue={"We hope to see you at the movies"}/>
    </form>
        </>
    


    );
}

export default CancelTicket;