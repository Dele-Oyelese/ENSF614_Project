import '../../App.css';
import React from 'react';
import { useNavigate } from 'react-router-dom';

function LogIn(){

    const[password,setPassword] = React.useState('')
    const[email,setEmail] = React.useState('')
    const[check,setCheck] = React.useState('')
    const[validate,setValidate] = React.useState(false)
    let navigate = useNavigate();

    const SubmitLogin = (e) => {
        e.preventDefault()
        const user={email,password}
        setCheck(email)
    }

    const handleClick = (e) => {
      setEmail('');
      localStorage.clear();
      navigate('/allmovies');
  }

    const loginClick = (e) =>{
        fetch("http://localhost:8080/api/v1/user/Email/".concat(email) )
        .then(res => res.json())
        .then((result)=>{
          if(result.status !== 500  && (result.email === email ) && result.password === password){
            localStorage.setItem("email",result.email)
            setValidate(true)
            navigate('/allmovies');
          }
          if(result.status === 500){
            alert("You are not a registered user. Please register, or continue as a guest")
            setCheck(false)
            setEmail('')
            setPassword('')
          }
          else{
            setCheck(false)
            setEmail('')
            setPassword('')
          }
        }
        )
      }

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

export default LogIn;