package com.lingdong.pancake.controller;

import com.lingdong.pancake.config.MinioConfigProperties;
import com.lingdong.pancake.util.CustomMinioClient;
import com.lingdong.pancake.util.MinioUtil;
import io.minio.ListPartsResponse;
import io.minio.messages.Part;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/check")
@RestController
public class CheckController {

    @Autowired
    private MinioConfigProperties minioConfigProperties;

    @GetMapping("/progress")
    public void checkProgress(@RequestParam String objectName, @RequestParam String uploadId) {
        CustomMinioClient customMinioClient = MinioUtil.customMinioClient;
        for (; ; ) {
            try {
                System.out.println("开始查询");
                ListPartsResponse partResult = customMinioClient.listMultipart(minioConfigProperties.getBucket(), null, objectName, 1000, 0, uploadId, null, null);
                System.out.println(partResult.result().partList().size());
                Thread.sleep(5000);
            } catch (Exception e) {
                log.error("失败", e);
            }
        }
    }

}
