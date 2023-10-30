function getCurrentDate() {
    const date = new Date();
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}${month}${day}`;
  }
  
  // 지정된 길이의 랜덤한 숫자를 생성하는 함수
  function getRandomNumber(length) {
    return Math.floor(Math.random() * Math.pow(10, length)).toString().padStart(length, '0');
  }
  
  // 결제 일련번호 생성
  function GeneratePaymentID() {
    const currentDate = getCurrentDate(); 
    const randomDigits = getRandomNumber(8);
    return `${currentDate}${randomDigits}`;
  }

export default GeneratePaymentID;