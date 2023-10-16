
import React,{useState} from 'react';
import {Login} from "./Login"
import { Register } from './Register';
import {ProductList} from './ProductList'
import {Addproduct} from './Addproduct'
import {Edit} from './Edit'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';



const App = () => {
  const [currentForm, setCurrentForm] = useState('login');

  const toggleForm = (formName) => {
    setCurrentForm(formName);
  }



  return (
    <Router>
       <Routes>
         <Route exact path ="/" element = {<Login/>}/>
         <Route path ='/Register' exact ={true} element ={<Register/>}/>
         <Route path ='/ProductList' element ={<ProductList/>}/>
         <Route path ='/Addproduct' element ={<Addproduct/>}/>
         <Route path ='/Edit/:id' element = {<Edit/>}/>
       </Routes>
    </Router>
    //currentForm === "Login" ? <Login onFormSwitch={toggleForm} /> : <Register onFormSwitch={toggleForm} />
  );
};

export default App;





