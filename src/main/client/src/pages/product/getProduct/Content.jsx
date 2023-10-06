import React from 'react';

function Content({data}){
    return(
        <>
          {data.title}
          {data.category}
          {data.content}
        </>
    )
}

export default Content;