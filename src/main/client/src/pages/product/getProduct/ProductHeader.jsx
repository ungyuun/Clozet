import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import {useState} from 'react';
import ProductOrder from './ProductOrder';

function ProductHeader({data}){

    const [hoveredIndex, setHoveredIndex] = useState(data.product.thumbnail);

    console.log(data);
    return(
        <Container>
            <Row className="prodNm">
                <h4>{data.product.title}</h4>
            </Row><hr />
            <Row>        
                <Col id="header" md={6}>                                        
                    <div className="thumbnail">
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
<<<<<<< HEAD
                <Col md={7}>2 of 2</Col>
=======
                <Col md={6}>
                    <ProductOrder data={data}/>
                    
                </Col>
>>>>>>> develop
            </Row>
      </Container>
        
    )
}

export default ProductHeader;