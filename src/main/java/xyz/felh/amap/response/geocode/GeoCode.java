package xyz.felh.amap.response.geocode;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class GeoCode implements Serializable {

    @JSONField(name = "formatted_address")
    @JsonProperty("formatted_address")
    private String formattedAddress;

    /**
     * 国家
     */
    private String country;

    /**
     * 地址所在的省份名
     */
    private String province;

    /**
     * 地址所在的城市名
     */
    private String city;

    /**
     * 城市编码
     */
    @JsonProperty("citycode")
    @JSONField(name = "citycode")
    private String cityCode;

    /**
     * 地址所在的区
     */
    private String district;

    /**
     * 街道
     */
    private String street;

    /**
     * 门牌
     */
    private String number;

    /**
     * 区域编码
     */
    @JsonProperty("adcode")
    @JSONField(name = "adcode")
    private String adCode;

    /**
     * 坐标点 经度，纬度
     */
    private String location;

    /**
     * 匹配级别
     */
    private String level;

}
