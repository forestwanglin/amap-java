package xyz.felh.amap.response.geocode;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Poi implements Serializable {

    private String id;
    private String name;
    private String type;
    private String tel;
    private String distance;
    private String direction;
    private String address;
    private String location;
    @JsonProperty("businessarea")
    @JSONField(name = "businessarea")
    private String businessArea;
    @JsonProperty("poiweight")
    @JSONField(name = "poiweight")
    private String poiWeight;

}
