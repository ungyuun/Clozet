
import axiosInstance from "../pages/common/AxiosInstance";

const CheckStock = (errorCallback,product,location) => {
    console.log(product)
    return new Promise((resolve, reject) => {
        axiosInstance.post(`${process.env.PUBLIC_URL}/cart/check`,product,{
            params: {
                pathname: location.pathname,
            },
        
            }).then((response) => {
                console.log("good");
                resolve();
            }).catch((error) => {
                console.log("error");
                errorCallback(error.response.data);
                reject(error);
            });
    })
}

export default CheckStock;