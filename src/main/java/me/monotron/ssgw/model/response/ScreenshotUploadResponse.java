package me.monotron.ssgw.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreenshotUploadResponse {

    private String url;
    private String rawImageUrl;
    private String deletionUrl;
}
