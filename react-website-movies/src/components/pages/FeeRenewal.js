import '../../App.css';
import React from 'react';
import { useNavigate } from 'react-router-dom';

function FeeRenewal(){


    return(
        <>
        <div className='movie'>
            <form onSubmit={SubmitLogin}>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" placeholder="Enter email" value={email} onChange={(e)=>setEmail(e.target.value)}></input>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" value = {password} onChange={(e)=>setPassword(e.target.value)}></input>
                </div>
                <button onClick={loginClick} type="submit" class="btn btn-primary">LogIn</button>
            </form>

            <hr></hr>

            <button type="submit" class="btn btn-primary" onClick={handleClick}>Continue as Guest</button>   
        </div>            
        </>
    );
}

export default FeeRenewal;