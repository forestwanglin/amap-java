package xyz.felh.amap;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import xyz.felh.amap.request.Extensions;
import xyz.felh.amap.request.geocode.GeoCodeRegeoRequest;
import xyz.felh.amap.request.geocode.GeoCodeRequest;
import xyz.felh.amap.request.ip.IpRequest;
import xyz.felh.amap.request.weather.WeatherRequest;
import xyz.felh.amap.response.geocode.GeoCodeRegeoResponse;
import xyz.felh.amap.response.geocode.GeoCodeResponse;
import xyz.felh.amap.response.ip.IpResponse;
import xyz.felh.amap.response.weather.WeatherResponse;

import java.time.Duration;

import static xyz.felh.amap.AmapOpenApiService.*;

@Slf4j
public class AmapServiceTest {

    private AmapOpenApiService getAmapService() {
        String key = System.getenv("KEY");
        ObjectMapper mapper = defaultObjectMapper();
        OkHttpClient client = defaultClient(Duration.ofMillis(300000))
                .newBuilder()
                .build();
        Retrofit retrofit = defaultRetrofit(client, mapper);
        AmapOpenApi api = retrofit.create(AmapOpenApi.class);
        return new AmapOpenApiService(key, api);
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
                .extensions(Extensions.ALL)
                .build());
        log.info("regeo code: {}", JSON.toJSONString(response));
    }

    @Test
    public void ip() {
        IpResponse response = getAmapService().ip(IpRequest.builder()
                .ip("114.247.50.2")
                .build());
        log.info("ip: {}", JSON.toJSONString(response));
    }

    @Test
    public void weather() {
        WeatherResponse response = getAmapService().weather(WeatherRequest.builder()
                .city("110101")
                        .extensions(Extensions.ALL)
                .build());
        log.info("weather: {}", JSON.toJSONString(response));
    }

}
