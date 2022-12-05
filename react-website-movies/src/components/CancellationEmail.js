import '../App.css';
import React, { useState } from 'react';
import { useRef } from 'react';
import emailjs from 'emailjs-com';

function CancellationEmail(){
    const [email, setEmail] = useState('')
    

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
                <input type="hidden" name="message" defaultValue={"Confirming your cancelation for ticketID: " + localStorage.getItem("ticketID") + ", in the future please use the follwing Coupon Code for 15% off your next purchase: 15MOVIE15"} />
                <input type="hidden" name="messageone" defaultValue={"We hope to see you at the movies"} />
            </form>


        </>
    );
}

export default CancellationEmail;