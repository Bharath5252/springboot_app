// import React, { useState } from 'react';
// import './LoginPage.css';
// import logo from './Enphase-Logo-1.png';
// import {Routes, Route, useNavigate} from 'react-router-dom';
// import {AddProductfun} from './AddProductfun';
// import axios from 'axios';






// export const Addproduct = (props) => {

//     const [name, setName] = useState('');
//     const [price, setPrice] = useState('');
//     const[description, setDescription] = useState('');
//     const navigate = useNavigate();
    
//     const handleSubmit = async (e) => {
      
//         e.preventDefault();
        
//         try {
//             const apiUrl = '/api/addproduct'; // Replace with your actual API URL
        
//             const data = {
//               name: name,
//               price: price,
//               description: description,
//             };
        
//             const response = await axios.post(apiUrl, data);
//             navigate('/ProductList');
      
//             console.log('Product added successfully!', response.data);
//             // You can handle the response data or display a success message here.
//           } catch (error) {
//             console.error('Error adding product:', error);
//             // Handle error scenarios here.
//         }

//         //AddProductfun(name, price, description);
//     }

//     return (
//         <div className="login-container">
//             <form >
//                 <div className="login-box">

//                     <div className="logo">
//                         <img src={logo} width={100} height={100} alt="Enphase Logo" />
//                     </div>

//                     <h3>
//                         Add Product
//                     </h3>
//                     <input value={name} onChange={(e) => setName(e.target.value)} type="Name" placeholder="Name" />
//                     <input value={price} onChange={(e) => setPrice(e.target.value)} type="Price" placeholder="Price" />
//                     <input value={description} onChange={(e) => setDescription(e.target.value)} type="Description" placeholder="Description" />
                   
//                     &nbsp;
//                     <div style={{ flexDirection: "row" }} >
                        
//                             <button  onClick={handleSubmit} name="submit" >submit</button>
//                     </div>


//                 </div>
//             </form>


//         </div>
//     );
// };


// export default Addproduct;



import React, { useState } from 'react';
import './LoginPage.css';
import logo from './Enphase-Logo-1.png';
import {Routes, Route, useNavigate} from 'react-router-dom';
import {AddProductfun} from './AddProductfun';
import axios from 'axios';
import mqtt from "paho-mqtt";
import { MQTT_HOST } from './constants';



export const Addproduct = (props) => {

    const [name, setName] = useState('');
    const [price, setPrice] = useState('');
    const[description, setDescription] = useState('');
    const navigate = useNavigate();
    
    const handleSubmit = (e) => {
      
        e.preventDefault();
        
        try {

            const data = {
                name: name,
                price: price,
                description: description,
              };
            
             
           
            const client = new mqtt.Client(MQTT_HOST, Number(8083), "/ws", "React-Frontend");

            client.onConnectionLost = onConnectionLost;
            //client.onMessageArrived = onMessageArrived;

            // connect the client
            client.connect({ onSuccess: onConnect });

            function onConnect() {
              // Once a connection has been made, make a subscription and send a message.
              console.log("onConnect");
              var message = new mqtt.Message(JSON.stringify(data));
              message.destinationName = 'data/write';

              console.log(message);

              client.send(message);
              navigate('/ProductList');
            }

            function onConnectionLost(responseObject) {
              if (responseObject.errorCode !== 0) {
                console.log("onConnectionLost:" + responseObject.errorMessage);
              }
            }
            


            console.log("hgoierbg");
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
                        Add Product
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


export default Addproduct;

