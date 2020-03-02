package me.monotron.ssgw.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.monotron.ssgw.model.response.ScreenshotUploadResponse;
import me.monotron.ssgw.service.XBackboneService;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class XBackboneServiceImpl implements XBackboneService {

    @Value(value = "${gateway.downstream-server-url}")
    private String downstreamServerUrl;

    private OkHttpClient client;

    @Override
    public ScreenshotUploadResponse uploadScreenshot(String personalUploadToken, MultipartFile file) {
        return ScreenshotUploadResponse.builder().build();
    }
}
