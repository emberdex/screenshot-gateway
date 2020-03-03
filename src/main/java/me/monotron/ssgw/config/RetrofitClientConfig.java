package me.monotron.ssgw.config;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitClientConfig {

    @Value(value = "${gateway.downstream-server-url}")
    private String downstreamServerUrl;

    @Bean
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
            .baseUrl(downstreamServerUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}
