import React, { useState, useRef } from 'react';
import axios from "axios";
import ImageUpload from '../../common/ImageUpload';


function Thumbnail({img,setImg}) {

    const inputRef = useRef(null);

    const handleImageUpload = (imageData) => {
        setImg(imageData);
      };

    const handleClick = () => {
        inputRef.current.click();
    };
    
    return(
        <>
            <img className="profile-image-container" src={img} alt="프로필 이미지" onClick={handleClick} />
            
            <ImageUpload onImageUpload={handleImageUpload} ref={inputRef} />
        </>
    );
}

export default Thumbnail;
