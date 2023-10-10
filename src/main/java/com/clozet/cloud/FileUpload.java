package com.clozet.cloud;


import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



@Component
@RequiredArgsConstructor
public class FileUpload {
    private final S3Config s3Config;
    
    public String tempFileUpload(MultipartFile multipartFile) throws IOException {
        // axios로 받은 file의 정보를 사용해 NCP의 Object Storage에 저장
        String originalFilename = multipartFile.getOriginalFilename();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());

        s3Config.getS3().putObject(s3Config.getBucketName(), originalFilename, multipartFile.getInputStream(), metadata);
        setObjectACL(s3Config.getBucketName(), originalFilename);  // 저장하고 Access 권한까지 업데이트 해줘야함
        return s3Config.getS3().getUrl(s3Config.getBucketName(), originalFilename).toString();
    }
    public void setObjectACL(String bucketName,String objectName){
        try {
            // 현재 ACL의 정보를 가져온다
            AccessControlList accessControlList = s3Config.getS3().getObjectAcl(bucketName, objectName);

            // 읽기권한을 모든 유저에게 줌
            accessControlList.grantPermission(GroupGrantee.AllUsers, Permission.Read);

            //설정을 버킷에 적용시킨다.
            s3Config.getS3().setObjectAcl(bucketName, objectName, accessControlList);
        } catch (AmazonS3Exception e) {
            e.printStackTrace();
        } catch(SdkClientException e) {
            e.printStackTrace();
        }
    }


}
