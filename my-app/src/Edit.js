import React, { useState , useEffect } from 'react';
import './LoginPage.css';
import logo from './Enphase-Logo-1.png';
import {Routes, Route, useNavigate, useParams} from 'react-router-dom';
import {AddProductfun} from './AddProductfun';
import axios from './http-common';






export const Edit = (props) => {

    const [name, setName] = useState('');
    const [price, setPrice] = useState('');
    const[description, setDescription] = useState('');

    const {id} = useParams();
    console.log(id);

    useEffect(() => {
        axios.get(`/api/Edit/${id}`)
             .then((response) => {
                console.log(response);
                 setName(response.data.name);
                 setPrice(response.data.price);
                 setDescription(response.data.description);
             })
             .catch((error) => {
                  console.error('Error fetching data:', error);
             });
    },[id]);



    const navigate = useNavigate();
    
    const handleSubmit = async (e) => {
      
        e.preventDefault();
        
        try {
            const apiUrl = `/api/Edit/${id}`; // Replace with your actual API URL
        
            const data = {
                id: id,
              name: name,
              price: price,
              description: description,
            };
        
            const response = await axios.put(apiUrl, data);
            navigate('/ProductList');
      
            console.log('Product added successfully!', response.data);
            // You can handle the response data or display a success message here.
          } catch (error) {
            console.error('Error adding product:', error);
            // Handle error scenarios here.
        }

        //AddProductfun(name, price, description);
    }

    return (
        <div className="login-container">
            <form >
                <div className="login-box">

                    <div className="logo">
                        <img src={logo} width={100} height={100} alt="Enphase Logo" />
                    </div>

                    <h3>
                        Edit Product
                    </h3>
                    <input value={name} onChange={(e) => setName(e.target.value)} type="Name" placeholder="Name" />
                    <input value={price} onChange={(e) => setPrice(e.target.value)} type="Price" placeholder="Price" />
                    <input value={description} onChange={(e) => setDescription(e.target.value)} type="Description" placeholder="Description" />
                   
                    &nbsp;
                    <div style={{ flexDirection: "row" }} >
                        
                            <button  onClick={handleSubmit} name="submit" >submit</button>
                    </div>


                </div>
            </form>


        </div>
    );
};


export default Edit;
