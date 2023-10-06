import React, { useState, useRef } from 'react';

import ImageUpload from '../../common/ImageUpload';
import DeleteImage from './DeleteImage';

function AdditionalImage({img,setImg}) {
    const optionNo = useRef(0);
    const option = useRef(null); // 클릭한 인덱스를 저장할 ref
    const thumbnail = useRef(null);

    const [isDeleteIconVisible, setDeleteIconVisible] = useState(false);

    const handleImageUpload = (imageData) => {
        console.log("업로드");
        setImg([...img,imageData]);
    };
    const handleImageUpdate = (imageData) => {
        console.log(`${optionNo.current}`);
        const newImg = [...img];
        newImg[optionNo.current] = imageData;
        setImg(newImg);
    };

    const handleClick = (index) => {
        if (index !== 99){
            console.log(index);
            optionNo.current = index;
            option.current.click();
        }else{
            thumbnail.current.click();
        }
    };

    const handleMouseEnter = () => {
        setDeleteIconVisible(true);
    };
    
    const handleMouseLeave = () => {
        setDeleteIconVisible(false);
    };

  return (
    <div>
        {img.map((item, index) => (
            <DeleteImage
            key={index}
            imgSrc={item}
            onDeleteClick={() => {
              // 이미지 삭제 로직 구현
              const updatedImages = [...img];
              updatedImages.splice(index, 1); // 해당 인덱스의 이미지 제거
              setImg(updatedImages);
            }}
          />
        ))}
      <img className="profile-image-container" src={`/images/image_icon-icons.com_50366.png`} alt="옵션 이미지" onClick={()=>handleClick(99)} />
      <ImageUpload onImageUpload={handleImageUpload} ref={thumbnail} />;
      <ImageUpload onImageUpload={handleImageUpdate} ref={option} />;
    </div>
  );
}

export default AdditionalImage;