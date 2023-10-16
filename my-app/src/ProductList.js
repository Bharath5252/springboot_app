import React, {useEffect, useState}  from 'react';
import axios from './http-common';
import { Button } from '@mui/material';
import { styled } from '@mui/material/styles';
import './proguctpage.css'
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';





export const ProductList = (props) => {
  const [products, setproducts]=useState([]);
  useEffect(() => {
    axios.get('/api/findAllproducts')
         .then((response) => {
              
             setproducts(response.data);
         })
         .catch((error) => {
              console.error('Error fetching data:', error);
         });
  },[]);

  const navigate=useNavigate();

  const handlechangeproduct =(e) =>{
      navigate('/Addproduct'); 
  }
   
  const handledelete = async (id) => {
       console.log(id);
       const response = await axios.delete(`/api/delete/${id}`);
       let product = [...products].filter(i => i.id!=id);
       setproducts(product);
       console.log(response);
       navigate('/ProductList');
  }
  

  


return (
  <div>
    <h1>Product List</h1>
    <ul>
       {products.map((temp) => (
        
        <div className='content'>
          <div className='Detials'>
              <div className='TitleTop'>
                <div className='Title'>{temp.name}</div>
              </div>

              <div className='Details1'>
                {temp.description}
              </div>

              <div className='Details1'>
                {temp.price}
              </div>

              <div className='ButtonContained'>
                 <button > <Link to = {"/Edit/" + temp.id}>Edit </Link> </button>
              </div>

              <div className='ButtonContained'>
                  <button onClick={() => handledelete(temp.id)}> Delete </button>
              </div>
          </div>
        </div>


      
       

       ))}
    </ul>

    <div className='ButtonContained'>
            <button onClick={handlechangeproduct}> Add Product</button>
    </div>


  </div>
);

};

export default ProductList;
