import GeneratePaymentID from "./GeneratePaymentID";
import axiosInstance from "../pages/common/AxiosInstance";

function Payment(option,location,navigate) {

  /* 1. 가맹점 식별하기 */
  const { IMP } = window;
  IMP.init(`${process.env.REACT_APP_IMPORT_DEFINE_CODE}`);
  
  /* 2. 결제 데이터 정의하기 */
  let pg = '';
  if (option.selectedPayment === 'kakao')
    pg = 'kakaopay.TC0ONETIME'
  else if (option.selectedPayment === 'toss')
    pg = 'tosspay.tosstest'

  const data = {                           // PG사
    pg: pg,
    pay_method: 'card',                           // 결제수단
    merchant_uid: `mid_${new Date().getTime()}`,   // 주문번호
    amount: option.totalPrice,                                 // 결제금액
    name: GeneratePaymentID(),                  // 주문명
    buyer_name: option.user.kakaoNickname,                           // 구매자 이름
    buyer_tel: option.user.cellPhone,                     // 구매자 전화번호
    buyer_email: option.user.kakaoEmail,               // 구매자 이메일
    buyer_addr: `${option.user.address} ${option.user.addressDetail}`,                    // 구매자 주소
    buyer_postcode: option.user.postCode,                      // 구매자 우편번호
  };

  /* 4. 결제 창 호출하기 */
  IMP.request_pay(data, (response) => {
    callback(response, option,data,location,navigate);
  });
}

/* 3. 콜백 함수 정의하기 */
function callback(response, option,data,location,navigate) {
  
  option = { 
    ...option,
      merchant_uid: data.merchant_uid,
      paymentId: data.name,
  };
  const {
    success,
    merchant_uid,
    error_msg,
  } = response;
  if (success) {
    
    axiosInstance.post(`${process.env.PUBLIC_URL}/purchase/`, option,{
      params: {
          pathname: location.pathname, 
        },
    })
    .then((response) => {
        navigate("/purchase/success", { state: { data: response.data } });
    })
      .catch((error) => {
        console.log(error)
      });
  } else {
    alert(`결제 실패: ${error_msg}`);
  }
}


export default Payment;