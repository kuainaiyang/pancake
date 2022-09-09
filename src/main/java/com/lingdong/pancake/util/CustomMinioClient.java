package com.lingdong.pancake.util;

import com.google.common.collect.Multimap;
import io.minio.ListPartsResponse;
import io.minio.MinioAsyncClient;
import io.minio.S3Base;


public class CustomMinioClient extends S3Base {

    public CustomMinioClient(MinioAsyncClient client) {
        super(client);
    }

    public ListPartsResponse listMultipart(String bucketName,
        String region, String objectName,
        Integer maxParts, Integer partNumberMarker, String uploadId,
        Multimap<String, String> extraHeaders, Multimap<String, String> extraQueryParams) {
        try {
            return this.listPartsAsync(bucketName, region, objectName, maxParts, partNumberMarker, uploadId, extraHeaders, extraQueryParams).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}