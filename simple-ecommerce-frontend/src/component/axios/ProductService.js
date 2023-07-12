import axios from "axios";

const PRODUCT_API_BASE_URL = 'http://localhost:8080/api/products';
const ORDER_API_BASE_URL = 'http://localhost:8080/api/orders';



class ProductService{
    getAllProduct(){
        return axios.get(PRODUCT_API_BASE_URL);
    }
    saveOrder(order){
        return axios.post(ORDER_API_BASE_URL, order);
    }
}

export default new ProductService();