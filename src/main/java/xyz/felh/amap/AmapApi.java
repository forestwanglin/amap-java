package xyz.felh.amap;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import xyz.felh.amap.response.geocode.GeoCodeRegeoResponse;
import xyz.felh.amap.response.geocode.GeoCodeResponse;

import java.util.Map;

/**
 * Retrofit2 API interface
 */
public interface AmapApi {

    /**
     * 地理编码/逆地理编码 API 是通过 HTTP/HTTPS 协议访问远程服务的接口，提供结构化地址与经纬度之间的相互转化的能力。
     *
     * @return GeoCodeResponse
     */
    @GET("/v3/geocode/geo")
    Single<GeoCodeResponse> geoCode(@QueryMap Map<String, String> map);

    /**
     * 提供结构化地址与经纬度之间的相互转化的能力
     */
    @GET("/v3/geocode/regeo")
    Single<GeoCodeRegeoResponse> geoCodeRegeo(@QueryMap Map<String, String> map);


}
