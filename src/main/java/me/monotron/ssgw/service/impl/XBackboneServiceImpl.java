package me.monotron.ssgw.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.monotron.ssgw.client.XBackBoneClient;
import me.monotron.ssgw.exception.ScreenshotUploadException;
import me.monotron.ssgw.model.proxy.XBackBoneUploadResponse;
import me.monotron.ssgw.model.response.ScreenshotUploadResponse;
import me.monotron.ssgw.service.XBackboneService;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.Response;

import java.util.Objects;

import static java.util.Objects.isNull;

@Service
@Slf4j
@AllArgsConstructor
public class XBackboneServiceImpl implements XBackboneService {

    XBackBoneClient client;

    @Override
    @SneakyThrows
    public ScreenshotUploadResponse uploadScreenshot(String personalUploadToken, MultipartFile file) {

        RequestBody fileBody = RequestBody.create(MediaType.parse(Objects.requireNonNull(file.getContentType())), file.getBytes());

        Response<XBackBoneUploadResponse> response = client.uploadFile(
            MultipartBody.Part.createFormData("file", file.getOriginalFilename(), fileBody),
            RequestBody.create(MultipartBody.FORM, personalUploadToken),
            null).execute();

        if (!response.isSuccessful()) {
            throw new ScreenshotUploadException("Failed to upload screenshot to downstream service.");
        }

        XBackBoneUploadResponse uploadResponse = response.body();

        if(isNull(uploadResponse)) {
            throw new ScreenshotUploadException("Downstream service returned an invalid response.");
        }

        return ScreenshotUploadResponse.builder()
            .url(uploadResponse.getUrl())
            .rawImageUrl(uploadResponse.getUrl() + "/raw")
            .deletionUrl(uploadResponse.getUrl() + "/delete/" + personalUploadToken)
            .build();
    }
}
