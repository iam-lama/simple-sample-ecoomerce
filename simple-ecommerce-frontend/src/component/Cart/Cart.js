import React, {useEffect, useState} from "react";
import { Checkout } from "../Order/Checkout";


export function Cart(props){

    const {ProductOrders} = props;
    const[total, setTotal] = useState();
    const[goToPay, setGoToPay]= useState(false);

    useEffect(()=>{
        let sum = 0;
        ProductOrders.forEach(item => {
            sum += (item.product.price*item.quantity)
            
        });
        setTotal(sum)
    })
    const payAndSave=()=>{
        setGoToPay(true);
    }

   
   return (<>
            {ProductOrders.length > 0 ?
            <>
            <h5 className="card-title">Total: {total}</h5>
            <h6 className="card-title">Items bought:</h6>

           {  ProductOrders.map((order) => 
                <React.Fragment key={order.product.id}>                
                <ul>
                    <li>
                        {order.product.name} - {order.product.price}$ - {order.quantity}
                    </li>
                </ul>
                </React.Fragment>
            )}
            <button className="btn btn-light btn-block" 
            onClick={payAndSave}>Checkout</button>
            {goToPay &&<Checkout ProductOrders={ProductOrders} total={total} />}
            </>           
            : <div>Cart is Empty</div>
            }
    
    </>)

}