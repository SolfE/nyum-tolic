package com.nyumtolic.nyumtolic.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class S3Service {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileUrl = "https://" + bucket + ".s3." + amazonS3Client.getRegionName() + ".amazonaws.com/" + fileName;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());

        amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
        return fileUrl;
    }

    public String uploadFileWithName(MultipartFile file, String fileName) throws IOException {
        String fileUrl = "https://" + bucket + ".s3." + amazonS3Client.getRegionName() + ".amazonaws.com/" + fileName;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());

        amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
        return fileUrl;
    }

    public void deleteFile(String fileName) {
        amazonS3Client.deleteObject(bucket, fileName);
    }

    public void deleteFileByURL(String URL) {
        String fileName = URL.replaceFirst("^https://[^/]+/", "");
        amazonS3Client.deleteObject(bucket, fileName);
    }
}

