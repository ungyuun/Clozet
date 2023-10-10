import React, { forwardRef } from 'react';

// forwardRef 함수를 사용하여 ref를 전달할 수 있는 컴포넌트로 래핑합니다.
const End = forwardRef((props, ref) => {
    return (
        <>
            
            <div id="end" ref={ref}>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                a
            </div>
        </>
    );
});

export default End;