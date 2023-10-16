import React from 'react';

function Content({data}){
    return(
        <>          
          <div id="content" dangerouslySetInnerHTML={{ __html: data.product.content }} />          
        </>
    )
}
export default Content;