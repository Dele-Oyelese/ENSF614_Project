import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container } from '@mui/system';
import { Paper } from '@mui/material';
import Button from '@mui/material/Button';
import { useNavigate } from 'react-router-dom';
import { useRef } from 'react';
import emailjs from 'emailjs-com';


export default function Login() {

  const[email,setEmail]= React.useState('')
  const[check,setCheck]= React.useState('')
  const[validate,setValidate]= React.useState(false)
  const[textBody,setTextBody]= React.useState('Status')
  const[paymentPrompt,setPaymentPrompt]= React.useState('')
  const[confirmation,setConfirmation]= React.useState('')
  const[user,setUser]= React.useState('')

    const now = new Date();
    const year = now.getUTCFullYear();
    const month = now.getUTCMonth() + 1;
    const day = now.getUTCDate();
    const yearTime = 24*60*60*1000*365;
    const today = [year, month, day].join('-');

    const [showButton, setShowButton] = React.useState(false);


  const handleClick2=(e) =>{
    e.preventDefault()
 
    const url = "http://localhost:8080/api/v1/user/updateDate/"+user;
    console.log(url)
    fetch(url, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
    })

    setConfirmation("A confirmation email was sent to " + email + " please check you email!")
  }

  const handleClick =(e) =>{
    e.preventDefault()
 
    setCheck(email)
    console.log("check1")
  }
  React.useEffect(()=> {
    fetch("http://localhost:8080/api/v1/user/Email/".concat(email) )
    .then(res =>res.json())
    .then((result)=>{
      console.log(result.status)
      
      console.log(validate)
      console.log(result.id)
      console.log(result)
      console.log(email)
      console.log(typeof email)
    


      if(result.status !== 500  && (result.email ===email )){
        console.log("hello")
        setUser(result.id)
        let payday = result.regDate;
        const myArray = payday.split("-");
        const payDate = new Date()
        payDate.setFullYear(myArray[0],myArray[1]-1,myArray[2])
        const yearDiff = (now-payDate)/yearTime;
        console.log(yearDiff)

        setValidate(true)
      if(yearDiff>=1){

        setTextBody("You last paid " + payday + " todays date is " + today + " it has been "+
        yearDiff + " years please pay your dues")

        setPaymentPrompt("Click the button below to make payment and recieve email confirmation!")
        setShowButton(true)
      }
      else{
        setTextBody("Your fees are all paid enjoy your movie :)!")
      }
   
      }
      else{
        setTextBody("INVALID USER")
        }
    }
    )
  },[check])

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


  
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}

    return (
    
    <Container>
    <Paper elevation ={3} style = {paperStyle}>
        <h2 style ={{color:"blue"}}><u>Check Subscription Status</u></h2>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1 },
      }}
      noValidate
      autoComplete="off"
    >
    
      <TextField id="outlined-basic" label="Email Address" variant="outlined" fullWidth value={email}
         onChange={(e)=>setEmail(e.target.value)}
      />
    
        <Button variant="contained" onClick={handleClick} >
      Verify
      </Button>

        <Paper elevation={6} style={{margin:'10px', padding:'15px', textAlign:"left"}} >
                    {textBody}
        </Paper>
        <Paper elevation={6} style={{margin:'10px', padding:'15px', textAlign:"left"}} >
                    {paymentPrompt}
        </Paper>
        {showButton && <button onClick = {handleClick2}>Click to Make Payement!</button>}
        <Paper elevation={6} style={{margin:'10px', padding:'15px', textAlign:"left"}} >
                    {confirmation}
        </Paper>
        
        <button
                        type="submit"
                        onClick={sendEmail}
                        class="btn btn-primary" >Send Confirmation Email</button>
        
    </Box>
    </Paper>
    <form ref={form} onSubmit={sendEmail}>
    <input type="hidden" name="user_name" defaultValue={"Greetings "}/>
    <input type="hidden" name="user_email" defaultValue={email}/>
    <input type="hidden" name="subject" defaultValue={"Movie Theater Fee Renewal Confirmation"}/>
    <input type="hidden" name="message" defaultValue={"This is a confirmation email that your fee renewal for your account has been successful"} />
    <input type="hidden" name="messageone" defaultValue={"We hope to see you at the movies"}/>
  </form>
    </Container>
    


  );
}


