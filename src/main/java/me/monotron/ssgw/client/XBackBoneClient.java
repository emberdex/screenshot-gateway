package me.monotron.ssgw.client;

import me.monotron.ssgw.model.proxy.XBackBoneUploadResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface XBackBoneClient {

    @Multipart
    @POST("/upload")
    Call<XBackBoneUploadResponse> uploadFile(
        @Part MultipartBody.Part file,
        @Part("token") RequestBody token,
        @Part("text") RequestBody text);
}
