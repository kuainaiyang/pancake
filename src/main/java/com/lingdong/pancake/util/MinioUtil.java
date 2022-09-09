package com.lingdong.pancake.util;


import com.lingdong.pancake.config.MinioConfigProperties;
import io.minio.MinioAsyncClient;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MinioUtil {

    @Autowired
    private MinioConfigProperties minioConfigProperties;

    public static CustomMinioClient customMinioClient;

    @PostConstruct
    public void init() {
        MinioAsyncClient minioClient = MinioAsyncClient.builder()
            .endpoint(minioConfigProperties.getEndpoint(), minioConfigProperties.getPort(), minioConfigProperties.isSecure())
            .credentials(minioConfigProperties.getAccessKey(), minioConfigProperties.getSecretKey())
            .build();
        this.customMinioClient = new CustomMinioClient(minioClient);
    }

}