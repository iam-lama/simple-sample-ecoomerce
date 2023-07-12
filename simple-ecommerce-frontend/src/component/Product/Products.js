import React, { useEffect, useState } from 'react';
import ProductService from '../axios/ProductService';

export function Product(props){
    const[products, setProducts] = useState();

    useEffect(()=>{
        getProducts()
    },[])
    const getProducts=()=>{
        ProductService.getAllProduct()
        .then((response) => {
            setProducts(response.data);
            console.log(response.data);
        })
    }
    return(<></>)
} 

