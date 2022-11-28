import '../../App.css';
import React from 'react';

function CancelTicket(){
    return(
        <>
        <div className='movie'>
            <form>
                <div class="form-group">
                    <label >Ticket Number</label>
                    <input type="text" class="form-control" placeholder="Enter your ticket number, e.g. 69907"></input>
                </div>
                <button type="submit" class="btn btn-primary">Request Cancellation</button>
            </form>   

        </div>
            
        </>
    );
}

export default CancelTicket;