import React, { useEffect, useState } from 'react';

import './product.css' 
import { AddToCart } from '../Cart/AddToCart';

export function Product(props){
    const {theproduct, addCart, removeCart, productInOrder} = props;
    const[quantity, setQuantity] = useState(0);
    const [showRemove, setShowRemove] = useState(false);
    console.log('showRemove: '+showRemove);
    // productInOrder.find(id => id=product.id)
    // productInOrder.find(({ id }) => id === product.id);
    
    useEffect(() =>{
        console.log('product effect');
        console.log(theproduct);
        console.log(productInOrder);
        let item = productInOrder.find((i) => i.product.id === theproduct.id);
        console.log(item);
        if(item !== undefined){
            console.log('item in cart'+ item);
            setShowRemove(true);
        }
        else{
            setShowRemove(false);
        }

    },[theproduct,addCart,removeCart])
    
    return(
    <>   
    <div className="card-header">
        <h4>{theproduct.name}</h4>
    </div>
    <div className="card-body">             
        <h5 className="card-title">{theproduct.price}$</h5>  
        <div className="row">
            <div className="col-4 padding-0">
            Quantity input
            <input type="number" name="quantity"  min="0" 
            disabled = {showRemove} className="form-control"
            onChange={(e) => setQuantity(e.target.value)} />
            </div>
            <div className="col-4 padding-0">
            <button className="btn btn-primary" 
            disabled = {showRemove}
            onClick={(e)=>addCart(theproduct,quantity)}>
                    Add To Cart
            </button>
            </div>
            {showRemove &&
           <div className="col-12">
            <button className="btn btn-primary btn-block" 
            onClick={()=>removeCart(theproduct.id)}>
                Remove From Cart
            </button>
            </div> 
            }
        </div>              
    </div>  
    </>)
} 

