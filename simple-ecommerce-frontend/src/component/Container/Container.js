import React,{useState, useEffect} from 'react';
import secureLocalStorage from "react-secure-storage";
import ProductService from '../axios/ProductService';

import { Product } from '../Product/Product';
import { Cart } from '../Cart/Cart';

// import { AddToCart } from '../Cart/AddToCart';

export function Container(props){
    const[products, setProducts] = useState();
    const[show, setShow] = useState(false);
    const [productInOrder, setProductInOrder] = useState(secureLocalStorage.getItem("order")? secureLocalStorage.getItem("order"): []);
    // const [selectedProduct, setSelectedProduct]= useState();
    useEffect(()=>{
        getProducts();

    },[])

    const getProducts=()=>{
        ProductService.getAllProduct()
        .then((response) => {
            setProducts(response.data);              
            // let selected = {};   
            
            // response.data.forEach(product => selected[product.id] = false);
            // console.log(selected);
            // response.data.map(product=>{
            //     let id = product.id;
            //     selected = { ...selected, "proid": {id:false} };
            //     // selected.push({"proid":{id:false}});
            //     console.log(selected);
            //     return selected;
            // });

            // setSelectedProduct(selected);
            // console.log(selectedProduct);    
            setShow(true); 
    
        })           
    }
    const handleAddCart=(product,quantity)=>{      
        setProductInOrder((preOrder) => {
            const list = [...preOrder, {'product':product, 'quantity':quantity}];
            secureLocalStorage.setItem("order", list);
            // setSelectedProduct([...selectedProduct, {"pid":product.id,"selected":true}]);            
            return list;
        });  
        // setSelectedProduct(selectedProduct[product.id]=true);
        // console.log(selectedProduct);
      
    }

    const handleRemoveCart=(proid)=>{
        localStorage.clear();
        let list = productInOrder.filter(item => item.product.id !== proid);
        setProductInOrder(list);
        // setSelectedProduct(selectedProduct[proid]=false);    
    }
 
    return(
        <>
        {show &&
        products.map((product) => 
        <div className="row card-deck" key={product.id}>
            <div className="col-lg-4 col-md-6 mb-4">
            <div className="card text-center">
                <Product theproduct={product} productInOrder={productInOrder}
                addCart={handleAddCart} removeCart={handleRemoveCart}/>
            </div>
            </div>
        </div>
        )}

       <div className="card text-white bg-danger mb-3">
        <div className="card-header text-center">Shopping Cart</div>
            <div className="card-body">
                <Cart ProductOrders={productInOrder} /> 
            </div>
        </div>
       </>)
} 

