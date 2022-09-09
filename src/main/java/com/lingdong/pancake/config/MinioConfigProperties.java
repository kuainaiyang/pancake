package com.lingdong.pancake.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "minio")
@Setter
@Getter
public class MinioConfigProperties {

    private String endpoint;
    private String bucket;
    private String accessKey;
    private String secretKey;
    private int port;
    private boolean secure;
}
