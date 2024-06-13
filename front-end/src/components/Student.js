import * as React from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, formControlClasses } from '@mui/material';
import { makeStyles } from '@mui/material';
import { useState } from 'react';

// const useStyles = makeStyles((theme) => ({
//     root: {
//     '& > *': {
//       margin: theme.spacing(1),
     
//     },
//   },
// }));

export default function Student() {
    const paperStyle={padding: '50px 20px', width:600, margin: "20px auto"}
    const[name, setName]=useState('')
    const[address, setAddress]=useState('')
    // const classes = useStyles();

  return (
        
        <Container>
            <Paper elevation={3} style={paperStyle}>
                    <h1 style={{color:"blue"}}><u>Add Student</u></h1>
                <form className={formControlClasses} noValidate autoComplete="off">
   
                    <TextField id="standard-basic" label="Student Name" variant="standard" fullWidth
                    value={name}
                    onChange={(e)=> setName(e.target.value)}/>
                    <TextField id="standard-basic" label="Student Address" variant="standard" fullWidth 
                    value={address}
                    onChange={(e)=> setAddress(e.target.value)}/>
                </form>
                {name}
                {address}
            </Paper>
        </Container>
  );
}
