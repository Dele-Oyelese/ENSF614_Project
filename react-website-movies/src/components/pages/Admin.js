import React, { useRef } from 'react';
import emailjs from 'emailjs-com';
import Paper from '@mui/material/Paper';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container';

export const Admin = () => {
  const paperStyle={padding:'50px 20px', width:600,margin:'10px auto'}
  const [movieTitle, setMTitle] = React.useState('')
  const [movieID, setMovieID] = React.useState('')
  const [name, setName] = React.useState('')
  const [email, setEmail] = React.useState('')
  const [address, setAddress] = React.useState('')
  const [password, setPassword] = React.useState('')
  const [creditcard, setCreditCard] = React.useState('')
  const [message, setMessage] = React.useState('')
  const [userID, setUserID] = React.useState('')

  
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

  const addMovie = (e) => {
    e.preventDefault()
    const movie={movieTitle}
    console.log(movie)
    fetch("http://localhost:8080/api/v1/movie/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(movie)
    }).then(()=>{
      console.log("New Student Added")
    })
  }

  const removeMovie = (e) => {
    e.preventDefault()
    const movie={movieID}
    console.log(movie)
    fetch("http://localhost:8080/api/v1/movie/" + {movieID},{
      method:"DELETE",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(movie)
    }).then(()=>{
      console.log("Movie Deleted")
    })
  }

  const addUser = (e) => {
    e.preventDefault()
    const user={name, address,creditcard,email,password}
    console.log(user)
    fetch("http://localhost:8080/api/v1/movie/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(user)
    }).then(()=>{
      console.log("New User Added")
    })
  }

  const removeUser = (e) => {
    e.preventDefault()
    const userID={userID}
    console.log(userID)
    fetch("http://localhost:8080/api/v1/user/" + {userID},{
      method:"DELETE",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(userID)
    }).then(()=>{
      console.log("User Deleted")
    })
  }


  return (
    <div>
    <div>
      <h1>Admin View</h1>
      <Paper elevation={6} style={paperStyle}>
      <p>Add New Movie To Catalogue</p>
      <Box
      component="form"
      sx={{'& .MuiTextField-root': { m: 1, width: '25ch' },}}
      noValidate
      autoComplete="off">

      <TextField
          id="outlined-read-only-input"
          label="Movie Title"
          helperText="EX: Toy Story"
          value={movieTitle}
          onChange={(e)=>setMTitle(e.target.value)}>
       </TextField>

       <br></br>       
        <Button variant="outlined" onClick={addMovie}> Add Movie </Button>
        </Box>
    </Paper>

    <Paper elevation={6} style={paperStyle}>
      <p>Remove Movie To Catalogue</p>
      <Box
      component="form"
      sx={{'& .MuiTextField-root': { m: 1, width: '25ch' },}}
      noValidate
      autoComplete="off">

      <TextField
          id="outlined-read-only-input"
          label="Movie ID"
          helperText="EX: 1 or 2"
          value={movieTitle}
          onChange={(e)=>setMovieID(e.target.value)}>
       </TextField>

       <br></br>       
        <Button variant="outlined" onClick={removeMovie}> Remove Movie </Button>
        </Box>
    </Paper>

    <Paper elevation={6} style={paperStyle}>
      <p>Add User To Database</p>
      <Box
      component="form"
      sx={{'& .MuiTextField-root': { m: 1, width: '25ch' },}}
      noValidate
      autoComplete="off">

      <TextField
          id="outlined-read-only-input"
          label="Name"
          helperText="EX: John Smith"
          value={name}
          onChange={(e)=>setName(e.target.value)}>
       </TextField>
       <TextField
          id="outlined-read-only-input"
          label="Address"
          helperText="EX: 567 Sun Road Way"
          value={address}
          onChange={(e)=>setAddress(e.target.value)}>
       </TextField>
       <TextField
          id="outlined-read-only-input"
          label="Email"
          helperText="EX: John.smith@gmail.com"
          value={email}
          onChange={(e)=>setEmail(e.target.value)}>
       </TextField>
       <TextField
          id="outlined-read-only-input"
          label="Password"
          helperText="EX: Jax123"
          value={password}
          onChange={(e)=>setPassword(e.target.value)}>
       </TextField>
       <TextField
          id="outlined-read-only-input"
          label="Credit Card #"
          helperText="EX: 123456789123456"
          value={creditcard}
          onChange={(e)=>setCreditCard(e.target.value)}>
       </TextField>

       <br></br>       
        <Button variant="outlined" onClick={addUser}> Add User </Button>
        </Box>
    </Paper>

    <Paper elevation={6} style={paperStyle}>
      <p>Remove User From Database</p>
      <Box
      component="form"
      sx={{'& .MuiTextField-root': { m: 1, width: '25ch' },}}
      noValidate
      autoComplete="off">

      <TextField
          id="outlined-read-only-input"
          label="User Email"
          helperText="EX: John.smith@gmail.com"
          value={email}
          onChange={(e)=>setEmail(e.target.value)}>
       </TextField>
       <br></br>       
        <Button variant="outlined" onClick={removeUser}> Remove User </Button>
        </Box>
    </Paper>
    <Paper elevation={6} style={paperStyle}>
      <p>Send Public Announcment</p>
      <Box
      component="form"
      sx={{'& .MuiTextField-root': { m: 1, width: '25ch' },}}
      noValidate
      autoComplete="off">

      <TextField
          id="outlined-read-only-input"
          label="New Movie Name"
          helperText="EX: Toy Story"
          value={movieTitle}
          onChange={(e)=>setMTitle(e.target.value)}>
       </TextField>
       <TextField
          id="outlined-read-only-input"
          label="Email"
          helperText="EX: John.smith@gmail.com"
          value={email}
          onChange={(e)=>setEmail(e.target.value)}>
       </TextField>
       <br></br>       
        <Button variant="outlined" onClick={sendEmail}> Send Public Announcment </Button>
        </Box>
    </Paper>



    </div>

    <form ref={form} onSubmit={sendEmail}>
      <input type="hidden" name="user_name" defaultValue={"Greetings " + name}/>
      <input type="hidden" name="user_email" defaultValue={email}/>
      <input type="hidden" name="subject" defaultValue={"Movie Theater Public Announcment"}/>
      <input type="hidden" name="message" defaultValue={"Keep an eye out for tickets! " + movieTitle + " has been added to the upcoming movies"} />
      <input type="hidden" name="messageone" defaultValue={"We hope to see you at the movies"}/>
    </form>
    </div>
  );
};
export default Admin;
