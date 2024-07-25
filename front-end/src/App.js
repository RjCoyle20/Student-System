
import { Route, Routes } from 'react-router';
import './App.css';
import Appbar from './components/Appbar';
import Student from './components/Student';
import UpdateStudent from './components/addOrUpdate/UpdateStudent';
import {ThemeProvider, createTheme} from '@mui/material/styles';
import { cyan, pink } from '@mui/material/colors';


const theme = createTheme({
  palette: {
    primary: cyan,
    secondary: pink,
  },
});

function App() {


  return (
    <ThemeProvider theme={theme}>
    <div className="App" >
    
      <Appbar/>
      
      <Routes>
      <Route path='/student' element={<Student/>}/>
      <Route path='/student/:id' element={<UpdateStudent/>}/>
      
      </Routes>
    </div>
    </ThemeProvider>
  );
}

export default App;
