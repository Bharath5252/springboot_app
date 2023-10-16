import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export const AddProductfun = async (name, price, description) => {
    const navigate =useNavigate();
    try {
      const apiUrl = '/api/addproduct'; // Replace with your actual API URL
  
      const data = {
        name: name,
        price: price,
        description: description,
      };
  
      const response = await axios.post(apiUrl, data);
      navigate('/ProductList');

      console.log('Product added successfully!', response.data);
      // You can handle the response data or display a success message here.
    } catch (error) {
      console.error('Error adding product:', error);
      // Handle error scenarios here.
    }
};



