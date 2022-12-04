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
    const yearTime = 24 * 60 * 60 * 1000 * 365;   

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

            setshowtime(
                Array.isArray(ticket)
                    ? ticket.map(item => {                        
                        return (item.boxOffices[0].movie.showTime)
                    })
                    : null
            )
        }
        
        )


        // console.log(showTime.getUTCFullYear())
        // const date = showTime.toString()
        // const date = showTime.substring(0,10);
        // console.log(showTime)
        // const timeDiff = (now - showTime) / yearTime;
        // console.log(timeDiff)

        // if (timeDiff >= 3) {
        //     alert("Sorry, it has already been 72 hours from your purchased time. No refund can be processed");
        // } else {
        //     //first deleting the ticket 
        //     const url = "http://localhost:8080/api/v1/boxOffice/cancel/" + ticketId;
        //     console.log(url)
        //     fetch(url, {
        //         method: "PUT",
        //         headers: { "Content-Type": "application/json" },
        //     })

        //     if (buyerStatus == true) {
        //         alert("A refund coupon of $9 has been sent to your email");
        //     }

        //     if (buyerStatus == false) {
        //         alert("A refund coupon of $8 has been sent to your email");
        //     }
        // }

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
                       <input
                            type="text"
                            class="form-control"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            placeholder="Enter your email address, e.g. john.smith@gmail.com"></input>
                       <button
                        type="submit"
                        onClick={sendEmail}
                        class="btn btn-primary" >Send Email Confirmation</button> 
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