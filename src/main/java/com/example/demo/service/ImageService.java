package com.example.demo.service;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.demo.config.S3Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageService {

    private S3Config s3Config;

    @Autowired
    public ImageService(S3Config s3Config) {

        this.s3Config = s3Config;
    }

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private String localLocation = "C:\\Users\\gozne\\Desktop\\IMG\\";

    public String imageUpload(MultipartRequest request) throws IOException {

        // request 인자에서 이미지 파일을 뽑아냄
        MultipartFile file = request.getFile("upload");

        // 뽑아낸 이미지 파일에서 이름 및 확장자 추출
        String fileName = file.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."));

        // 이미지 파일 이름 유일성을 위해 uuid 생성
        String uuidFileName = UUID.randomUUID() + ext;

        // 서버환경에 저장할 경로 생성
        String localPath = localLocation + uuidFileName;

        // 서버 환경에 이미지 파일에 저장
        File localFile = new File(localPath);
        file.transferTo(localFile);

        // S3에 이미지 업로드
        s3Config.amazonS3Client().putObject(new PutObjectRequest(bucket, uuidFileName, localFile).withCannedAcl(CannedAccessControlList.PublicRead));
        String s3Url = s3Config.amazonS3Client().getUrl(bucket, uuidFileName).toString();

        localFile.delete();
        return s3Url;
    }
}
