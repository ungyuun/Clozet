import React, { useEffect,useState } from 'react';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import axios from 'axios';
import "../../../styles/product.css"; 

function Editor({ editorData, onChange,setDesc,desc}){

  const [flag,setFlag] = useState(false);

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
            axios.post(`${process.env.PUBLIC_URL}/api/product/img`,data)
              .then((res)=>{
                onChange(res.data);
                
                resolve({
                  
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