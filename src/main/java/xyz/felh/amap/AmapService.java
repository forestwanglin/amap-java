package xyz.felh.amap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import xyz.felh.amap.request.geocode.GeoCodeRegeoRequest;
import xyz.felh.amap.request.geocode.GeoCodeRequest;
import xyz.felh.amap.response.geocode.GeoCodeRegeoResponse;
import xyz.felh.amap.response.geocode.GeoCodeResponse;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AmapService {

    private static final String BASE_URL = "https://restapi.amap.com";
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(30);

    private final String key;
    private final AmapApi api;
    private final OkHttpClient client;

    public AmapService(final String key) {
        this(key, buildApi(DEFAULT_TIMEOUT), defaultClient(DEFAULT_TIMEOUT));
    }

    public AmapService(final String key, final AmapApi api, final OkHttpClient client) {
        this.key = key;
        this.api = api;
        this.client = client;
    }

    public static <T> T execute(Single<T> apiCall) {
        try {
            return apiCall.blockingGet();
        } catch (HttpException e) {
            try {
                if (e.response() == null || e.response().errorBody() == null) {
                    throw e;
                }
                String errorBody = e.response().errorBody().string();
                throw new AmapHttpException(errorBody, e);
            } catch (IOException ex) {
                throw e;
            }
        }
    }

    public static AmapApi buildApi(Duration timeout) {
        ObjectMapper mapper = defaultObjectMapper();
        OkHttpClient client = defaultClient(timeout);
        Retrofit retrofit = defaultRetrofit(client, mapper);
        return retrofit.create(AmapApi.class);
    }

    public static ObjectMapper defaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return mapper;
    }

    public static OkHttpClient defaultClient(Duration timeout) {
        return new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(10, 4, TimeUnit.SECONDS))
                .readTimeout(timeout.toMillis(), TimeUnit.MILLISECONDS)
                .build();
    }

    public static Retrofit defaultRetrofit(OkHttpClient client, ObjectMapper mapper) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    // api below

    public GeoCodeResponse geoCode(GeoCodeRequest request) {
        request.setKey(key);
        return execute(api.geoCode(request.toQueryMap()));
    }

    public GeoCodeRegeoResponse geoCodeRegeo(GeoCodeRegeoRequest request) {
        request.setKey(key);
        return execute(api.geoCodeRegeo(request.toQueryMap()));
    }

}
