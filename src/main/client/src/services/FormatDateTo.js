function formatDateToYYYYMMDD(dateArray) {
    const year = dateArray[0];
    const month = String(dateArray[1]).padStart(2, '0'); // 월은 1부터 시작하므로 2자리로 포맷팅
    const day = String(dateArray[2]).padStart(2, '0'); // 일도 2자리로 포맷팅
    return `${year}-${month}-${day}`;
  }

export default formatDateToYYYYMMDD;