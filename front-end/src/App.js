
import { Route, Routes } from 'react-router';
import './App.css';
import Appbar from './components/Appbar';
import Student from './components/Student';

function App() {
  return (
    <div className="App">
      <Appbar/>
      <Routes>
      <Route path='/student' element={<Student/>}/>
      {/* <Route path='/student/:id' element={<UpdateStudent/>}/> */}
      
      </Routes>
    </div>
  );
}

export default App;
