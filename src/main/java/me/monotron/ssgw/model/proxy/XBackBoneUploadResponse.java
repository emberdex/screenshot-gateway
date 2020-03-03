package me.monotron.ssgw.model.proxy;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class XBackBoneUploadResponse {
    private String message;
    private String version;
    @NotNull private String url;
}
