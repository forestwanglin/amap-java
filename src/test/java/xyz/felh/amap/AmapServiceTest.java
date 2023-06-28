package xyz.felh.amap;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import xyz.felh.amap.request.ExtensionsType;
import xyz.felh.amap.request.geocode.GeoCodeRegeoRequest;
import xyz.felh.amap.request.geocode.GeoCodeRequest;
import xyz.felh.amap.response.geocode.GeoCodeRegeoResponse;
import xyz.felh.amap.response.geocode.GeoCodeResponse;

import java.time.Duration;

import static xyz.felh.amap.AmapService.*;

@Slf4j
public class AmapServiceTest {

    private AmapService getAmapService() {
        String key = System.getenv("KEY");
        ObjectMapper mapper = defaultObjectMapper();
        OkHttpClient client = defaultClient(Duration.ofMillis(300000))
                .newBuilder()
                .build();
        Retrofit retrofit = defaultRetrofit(client, mapper);
        AmapApi api = retrofit.create(AmapApi.class);
        return new AmapService(key, api, client);
    }

    @Test
    public void geoCode() {
        GeoCodeResponse response = getAmapService().geoCode(GeoCodeRequest.builder()
                .address("上海静安区")
                .build());
        log.info("geo code: {}", JSON.toJSONString(response));
    }

    @Test
    public void geoCodeRegeo() {
//        log.info(HttpUtil.get("https://restapi.amap.com/v3/geocode/regeo?key=f8741b3a1a04f59f2301dba1ca404161&location=116.481488,39.990464&extensions=all"));
        GeoCodeRegeoResponse response = getAmapService().geoCodeRegeo(GeoCodeRegeoRequest.builder()
                .location("116.481488,39.990464")
                .extensions(ExtensionsType.ALL)
                .build());
        log.info("regeo code: {}", JSON.toJSONString(response));
    }

}
