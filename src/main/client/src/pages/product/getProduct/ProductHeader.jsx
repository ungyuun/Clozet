import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import {useState} from 'react';

function ProductHeader({data}){

    const [hoveredIndex, setHoveredIndex] = useState(data.product.thumbnail);
    return(
        <Container>
            <Row>
                
                <h4>{data.product.title}</h4>
                <hr />
            </Row>
            <Row>        
                <Col id="header" md={6}>                                        
                    <div className="d-flex justify-content-center">
                        <img src={hoveredIndex} alt="Thumbnail" className="d-block mx-auto" />
                    </div>
                    <div className="image-container">
                        {data.product.imgUrl.map((imgUrl,index)=>(
                            <div
                                className={`img-wrapper ${hoveredIndex === index ? 'hovered' : ''}`}
                                key={index}
                                onMouseEnter={() => setHoveredIndex(imgUrl)}
                                onMouseLeave={() => setHoveredIndex(data.product.thumbnail)}
                            >
                                <img id={index} src={imgUrl} />
                            </div>
                        ))}                    
                    </div>
                </Col>
                <Col md={6}>
                    {data.product.price}

                </Col>
            </Row>
      </Container>
        
    )
}

export default ProductHeader;