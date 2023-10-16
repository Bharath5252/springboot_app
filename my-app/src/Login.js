import React, { useState } from 'react';
import './LoginPage.css';
import logo from './Enphase-Logo-1.png';
import {Routes, Route, useNavigate} from 'react-router-dom';
import axios from './http-common'





export const Login = (props) => {

    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');


    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        console.log(email);
        try{

           const apiurl = '/api/login';

           const data ={
              email:email,
              password:pass,
           };

           const response  =  await axios.post(apiurl,data); 
           //console.log(response);
           //console.log(response.data);

           if(response.data=="1"){
              navigate('/ProductList');
           }
           else{
             console.log("Incorrect Name or Password");
              navigate('/');
           }
           

        } catch(error){
           console.error('Error signing in');
        }
    }

    const handleSignup = (e) => {
        e.preventDefault();
        navigate('/Register');
    }

    return (
        <div className="login-container">
            <form >
                <div className="login-box">

                    <div className="logo">
                        <img src={logo} width={100} height={100} alt="Enphase Logo" />
                    </div>


                    <input value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="email" />
                    <input value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="Password" />
                    &nbsp;
                    <div style={{ flexDirection: "row" }} >
                        
                            <button onClick={handleSubmit} name="Log IN" >Log IN</button>
                            &nbsp;
                            &nbsp;
                            <button onClick={handleSignup} name="Sign Up"> Sign Up </button>
                       
                    </div>


                </div>
            </form>


        </div>
    );
};


export default Login;
