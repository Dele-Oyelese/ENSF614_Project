import '../../App.css';
import React from 'react';
import { useNavigate } from 'react-router-dom';

function LogIn(){

    const[password,setPassword] = React.useState('')
    const[email,setEmail] = React.useState('')
    const[check,setCheck] = React.useState('')
    const[validate,setValidate] = React.useState(false)
    const getEmail = localStorage.getItem("email")
    let navigate = useNavigate();

    const SubmitLogin = (e) => {
        e.preventDefault()
        const user={email,password}
        setCheck(email)
    }

    React.useEffect(()=> {
        fetch("http://localhost:8080/api/v1/user/Email/".concat(email) )
        .then(res => res.json())
        .then((result)=>{
          if(result.status !== 500  && (result.email === email ) && result.password === password){
            localStorage.setItem("email",result.email)
            const getEmail = localStorage.getItem("email")
            setValidate(true)
            navigate('/allmovies');
          }
          else{
            setCheck(false)
            setEmail('')
            setPassword('')
          }
        }
        )
      },[check])

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
                <button type="submit" class="btn btn-primary">LogIn</button>
            </form>   
        </div>            
        </>
    );
}

export default LogIn;