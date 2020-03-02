package me.monotron.ssgw.service;

import me.monotron.ssgw.model.response.ScreenshotUploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface XBackboneService {

    ScreenshotUploadResponse uploadScreenshot(String personalUploadToken, MultipartFile file);
}
