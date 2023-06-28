package xyz.felh.amap;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import xyz.felh.amap.response.geocode.GeoCodeRegeoResponse;
import xyz.felh.amap.response.geocode.GeoCodeResponse;
import xyz.felh.amap.response.ip.IpResponse;
import xyz.felh.amap.response.weather.WeatherResponse;

import java.util.Map;

/**
 * Retrofit2 API interface
 */
public interface AmapOpenApi {

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


    /**
     * IP定位是一套简单的HTTP接口，根据用户输入的IP地址，能够快速的帮用户定位IP的所在位置。
     * IP定位：仅支持IPV4，不支持国外IP解析。
     */
    @GET("/v3/ip")
    Single<IpResponse> ip(@QueryMap Map<String, String> map);

    /**
     * 天气查询是一个简单的HTTP接口，根据用户输入的adcode，查询目标区域当前/未来的天气情况，数据来源是中国气象局。
     */
    @GET("/v3/weather/weatherInfo")
    Single<WeatherResponse> weather(@QueryMap Map<String, String> map);

}
