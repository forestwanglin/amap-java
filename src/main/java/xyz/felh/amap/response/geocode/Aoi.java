package xyz.felh.amap.response.geocode;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Aoi implements Serializable {

    private String id;
    private String name;
    @JsonProperty("adcode")
    @JSONField(name = "adcode")
    private String adCode;
    private String location;
    private String area;
    private String distance;
    private String type;

}
