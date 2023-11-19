
import axiosInstance from "../pages/common/AxiosInstance";

const CheckStock = (errorCallback,product,location) => {
    console.log(product)
    return new Promise((resolve, reject) => {
        axiosInstance.post(`${process.env.PUBLIC_URL}/api/cart/check`,product,{
            params: {
                pathname: location.pathname,
            },
            }).then((response) => {
                resolve();
            }).catch((error) => {
                errorCallback(error.response.data);
                reject(error);
            });
    })
}

export default CheckStock;