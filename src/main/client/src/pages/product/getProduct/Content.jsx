import React from 'react';

function Content({data}){
    console.log(`gd ${data.product}`);
    return(
        <>          
          <div id="content" dangerouslySetInnerHTML={{ __html: data.product.content }} />          
        </>
    )
}
export default Content;