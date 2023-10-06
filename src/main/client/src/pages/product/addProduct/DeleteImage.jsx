import React, { useState } from 'react';
import { Row, Col,Container,Image, Button, OverlayTrigger, Tooltip } from 'react-bootstrap';

function DeleteImage({ imgSrc, onDeleteClick }) {
    const [isDeleteIconVisible, setDeleteIconVisible] = useState(false);
  
    const handleMouseEnter = () => {
      setDeleteIconVisible(true);
    };
  
    const handleMouseLeave = () => {
      setDeleteIconVisible(false);
    };
  
    return (
      <div
        onMouseEnter={handleMouseEnter}
        onMouseLeave={handleMouseLeave}
      >
        
          <Image className="profile-image-container" src={imgSrc} alt="이미지" fluid />
        
        
        {isDeleteIconVisible && (
          <OverlayTrigger
            placement="top"
            overlay={<Tooltip id="delete-tooltip">삭제</Tooltip>}
          >
            <Button
              variant="danger"
              size="sm"
              className="delete-icon"
              onClick={onDeleteClick}
            >
              X
            </Button>
          </OverlayTrigger>
        )}
        
        
      </div>
    );
  }

export default DeleteImage;