package me.monotron.ssgw.config;

import lombok.AllArgsConstructor;
import me.monotron.ssgw.client.XBackBoneClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

@Configuration
@AllArgsConstructor
public class XBackBoneClientConfig {

    Retrofit retrofit;

    @Bean
    public XBackBoneClient getXBackBoneClient() {
        return retrofit.create(XBackBoneClient.class);
    }
}
