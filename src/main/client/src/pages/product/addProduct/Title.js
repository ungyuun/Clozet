import { Form, Row, Col,Button} from 'react-bootstrap';


function Title({register}){
    return(
        <div className='mb-5'>
           
                <Row>
                    <Col>
                        <Form.Group controlId="exampleForm.ControlInput1">
                            <Form.Control type="text" 
                                        placeholder="제목을 입력해주세요" 
                                        {...register('title')}
                            />
                        </Form.Group>
                    </Col>
                    <Col className=''>
                    <Form.Select className='p-2' 
                                 aria-label="카테고리 입력"
                                 {...register('category')}
                    >
                        <option>카테고리</option>
                        <option value="상의">상의</option>
                        <option value="하의">하의</option>
                        <option value="악세서리">악세서리</option>
                    </Form.Select>
                    </Col>
                    <Col>
                        <Button type="submit">저장</Button>
                    </Col>
                </Row>
            
        </div>
    );
}

export default Title;