import React, { useEffect,useState } from 'react';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import axios from 'axios';
import "../../../styles/product.css"; 

function Editor({ editorData, onChange,setDesc,desc}){

  const [flag,setFlag] = useState(false);
  const imgLink = "http://localhost:3000/images/"

  function customUploadAdapter(loader){
    return{
      upload(){
        return new Promise ((resolve,reject)=>{
          const data = new FormData();
          loader.file.then((file)=>{
            data.append("objectName",file.name);
            data.append("file",file);
            console.log(data)
            console.log(file)
            axios.post('http://localhost:8081/product/img',data)
              .then((res)=>{
                console.log(`레스 ${res}`);
                console.log(res.data);
                
                // setContext(res.data);
                onChange(res.data);
                console.log(` post 들어옴 ${res.data}`);
                
                resolve({
                  // default: `${imgLink}/${res.data}`
                  default : res.data
                });
              })
              .catch((err)=>reject(err));
            
          })
          console.log(data);
        })
        
      }
    }
  }

  function uploadPlugin(editor){
    editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
      return customUploadAdapter(loader);
    }
  }

    return(
        <div>
          
                <CKEditor
                    editor={ ClassicEditor }
                    config={{ // (4)
                      extraPlugins: [uploadPlugin]
                  }}
                    data={editorData}
                    onReady={ (editor) => {
                    } }
                    onChange={(event, editor) => {
                        const newData = editor.getData();
                        onChange(newData); 
                      }}
                    onBlur={ ( event, editor ) => {
                    } }
                    onFocus={ ( event, editor ) => {
                    } }
                /> 
            
        </div>
    );
}

export default Editor;