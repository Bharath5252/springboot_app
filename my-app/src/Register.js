import React, { useState } from 'react';
import './LoginPage.css';
import logo from './Enphase-Logo-1.png';
import { useNavigate } from 'react-router-dom';
import axios from './http-common';




export const Register = (props) => {

    const [name,setName] = useState('');
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');
    const [confpassword,setConfpassword] = useState('');
    

    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(name);
        console.log(email);
        try{
            
            const apiUrl='/api/signup';
            const data ={
                name:name,
                email:email,
                password:pass,
            };

            const response = await axios.post(apiUrl, data);
            console.log(response);
            navigate('/');

        }catch(error){
            console.error('Error Adding the product', error);
        }


        navigate('/');
    }
    


    return (
        <div className="login-container">
            <form >
                <div className="login-box">

                    <div className="logo">
                        <img src={logo} width={100} height={100} alt="Enphase Logo" />
                    </div>

                    <input value ={name} onChange={(e) => setName(e.target.value)}  type ="name" placeholder="Name" />
                    <input value={email} onChange={(e) => setEmail(e.target.value)}  type="email" placeholder="email" />
                    <input value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="Password" />
                    <input value={confpassword} onChange={(e) => setConfpassword(e.target.value)} type="password" placeholder="Confirm Password" />
                  
                        

                            <button onClick={handleSubmit}>Sign Up</button>
                       
                 

                </div>
            </form>

        </div>
    );
};

export default Register;