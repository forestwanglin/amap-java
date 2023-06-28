package xyz.felh.amap.response.geocode;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoadInter implements Serializable {

    /**
     * 交叉路口到请求坐标的距离, 米
     */
    private String distance;

    private String direction;

    /**
     * 路口经纬度
     */
    private String location;

    @JsonProperty("first_id")
    @JSONField(name = "first_id")
    private String firstId;

    @JsonProperty("first_name")
    @JSONField(name = "first_name")
    private String firstName;

    @JsonProperty("second_id")
    @JSONField(name = "second_id")
    private String secondId;

    @JsonProperty("second_name")
    @JSONField(name = "second_name")
    private String secondName;

}
