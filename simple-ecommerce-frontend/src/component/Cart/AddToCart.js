// import React, {useEffect,useState} from "react";
// import { OrderedProducts } from "../Order/OrderedProducts";

// export function AddToCart(props){
//     const{product,quantity,updateOrder,SetUpdateOrder} = props;
//     const [productInOrder, setProductInOrder] = useState([]);

//     useEffect(()=>{
//     setProductInOrder(productInOrder => ([...productInOrder,product]));
//     SetUpdateOrder(false);
      
//     },[updateOrder,SetUpdateOrder,productInOrder])
    
//     return(
//         <>
//         {/* <OrderedProducts product={product} quantity={quantity} /> */}
//         </>
//     )

// }