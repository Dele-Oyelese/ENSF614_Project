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
  const [name, setName] = React.useState('')
  const [email, setEmail] = React.useState('')
  const [address, setAddress] = React.useState('')
  const [password, setPassword] = React.useState('')
  const [creditcard, setCreditCard] = React.useState('')

  
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

  }

  const removeMovie = (e) => {

  }

  const addUser = (e) => {

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
          label="Movie Title"
          helperText="EX: Toy Story"
          value={movieTitle}
          onChange={(e)=>setMTitle(e.target.value)}>
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
        <Button variant="outlined" onClick={removeMovie}> Name Address Email Password CC </Button>
        </Box>
    </Paper>



    </div>

    <form ref={form} onSubmit={sendEmail}>
      <input type="hidden" name="user_name" />
      <input type="hidden" name="user_email" />
      <input type="hidden" name="subject" />
      <input type="hidden" name="message" />
      <input type="hidden" name="messageone" />
    </form>
    </div>
  );
};
export default Admin;
