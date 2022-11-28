import '../../App.css';
import React from 'react';

function LogIn(){
    return(
        <>
        <div className='movie'>
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" placeholder="Enter email"></input>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"></input>
                </div>
                <button type="submit" class="btn btn-primary">LogIn</button>
            </form>   

        </div>
            
        </>
    );
}

export default LogIn;