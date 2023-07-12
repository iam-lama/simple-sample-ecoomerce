import React, { useState } from "react";
import ProductService from '../axios/ProductService';


export function Checkout(props){
    const{ProductOrders, total} = props;
    const[status, setStatus] = useState(false);

    const SaveOrder=()=>{
        saveProductsOrder();
    }
    const saveProductsOrder=()=>{
       
        let toSaveOrder = {"productOrders": ProductOrders};
        console.log('pay')
        console.log(toSaveOrder);
       
        ProductService.saveOrder(toSaveOrder)
        .then((response)=>{
            console.log(response);
        })
    
    }
    return(
    <>
    <h2 className="text-center">ORDER</h2>

    {ProductOrders.map((order)=>
        <div>
            <ul>
                <li>
                    {order.product.name} - ${order.product.price} x {order.quantity}
                </li>
            </ul>
        </div>
    )}
        <h3 className="text-right">Total amount: ${total}</h3>
        <button className="btn btn-primary btn-block"
        onClick={SaveOrder}>Pay</button>
        
        <div className="alert alert-success" role="alert">
            <strong>Congratulation!</strong> You successfully made the order.
        </div>
    </>

    )

}

/*
{
"productOrders":
[
	{
	"product":{
	"id":1,
	"name":"test",
	"price": 200,
	"pictureUrl": null
	},
	"quantity":1
    }
]
}
*/