package me.monotron.ssgw.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.monotron.ssgw.exception.ScreenshotUploadException;
import me.monotron.ssgw.model.response.ErrorResponse;
import me.monotron.ssgw.service.XBackboneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static java.lang.String.format;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("/screenshot")
@Slf4j
@AllArgsConstructor
public class ScreenshotUploadController {

    XBackboneService screenshotService;

    @PostMapping("/upload")
    public ResponseEntity uploadScreenshot(
        @RequestHeader(value = "X-Downstream-Auth-Token", required = false) String personalUploadToken,
        @RequestBody(required = false) MultipartFile file
    ) {
        if(isNull(personalUploadToken) || personalUploadToken.isEmpty()) {
            return ResponseEntity.badRequest().body(
                new ErrorResponse("No authentication token was specified in the request."));
        }

        if(isNull(file) || file.isEmpty()) {
            return ResponseEntity.badRequest().body(
                new ErrorResponse("No file was specified in the request."));
        }

        try {
            return ResponseEntity.ok(screenshotService.uploadScreenshot(personalUploadToken, file));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(format("An error occurred: %s", exception.getMessage())));
        }
    }
}
