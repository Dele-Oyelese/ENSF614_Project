import '../../App.css';
import React, { useState } from 'react';

function CancelTicket() {

    const [ticketId, setticketid] = useState('');
    const [ticket, setticket] = useState([]);
    const [buyerStatus, setStatus] = useState('');

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
                </form>

            </div>

        </>
    );
}

export default CancelTicket;