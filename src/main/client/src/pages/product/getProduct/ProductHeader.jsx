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
                <h1>{data.product.title}</h1>
            </Row>
            <Row>        
                <Col id="header" md={5}>                                        
                    <img src={hoveredIndex}></img>
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
                <Col md={7}>2 of 2</Col>
            </Row>
      </Container>
        
    )
}

export default ProductHeader;