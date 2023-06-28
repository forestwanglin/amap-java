package xyz.felh.amap.response.weather;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Forecast implements Serializable {

    private String province;
    private String city;
    @JsonProperty("adcode")
    @JSONField(name = "adcode")
    private String adCode;
    @JsonProperty("reporttime")
    @JSONField(name = "reporttime")
    private String reportTime;

    private List<ForecastItem> casts;

}
