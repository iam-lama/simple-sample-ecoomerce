import React, { useEffect, useState } from "react";
// import { Cart } from "../Cart/Cart";

export function OrderedProducts(props){
    const {product, quantity, total, paid} = props;
    const [productInOrder, setProductInOrder] = useState([]);

    useEffect(() => {
        const updateList= ()=>{
            if(quantity > 0){
                console.log('update list');
                // console.log(product);
                let list = [...productInOrder,product];
                console.log(list);

                setProductInOrder(list);
                console.log(productInOrder);
                // console.log('list'+list.length);
                // console.log('hggh:'+productInOrder.length);
                // console.log(list);
                // console.log(productInOrder);
            }
    }
    updateList();
    }, [product]);


    
    // console.log('Product: '+product.name+product.price);
    console.log('product order'+productInOrder);
   
   return(<div>
        <h1>New Orders</h1>        
    </div>)
}