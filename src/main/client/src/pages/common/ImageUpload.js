
import axios from "axios";

import React, { forwardRef } from 'react';

const ImageUpload = forwardRef(({ onImageUpload }, ref) => {
    // 파일 선택(input 요소)의 변경 이벤트 핸들러
    const handleFileChange = (event) => {
      const file = event.target.files[0]; // 선택한 파일
  
      if (file) {
        const formData = new FormData(); // FormData 객체 생성
        formData.append('file', file); // 파일을 FormData에 추가
  
        // Axios를 사용하여 스프링 서버로 파일 업로드 요청 보내기
        axios.post(`${process.env.PUBLIC_URL}/product/img`, formData, {
          headers: {
            'Content-Type': 'multipart/form-data', // 파일 업로드를 위한 헤더 설정
          },
        })
          .then((response) => {
            if (onImageUpload) {
              onImageUpload(response.data);
            }
          })
          .catch((error) => {
            console.error('파일 업로드 실패:', error);
          });
      }
    };
    return(
        <input ref={ref} type="file" style={{ display: 'none' }} onChange={handleFileChange}/>
    );
})

export default ImageUpload;
