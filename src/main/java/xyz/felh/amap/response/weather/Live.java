package xyz.felh.amap.response.weather;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Live implements Serializable {

    private String province;
    private String city;
    @JsonProperty("adcode")
    @JSONField(name = "adcode")
    private String adCode;
    private String weather;
    private String temperature;
    @JsonProperty("winddirection")
    @JSONField(name = "winddirection")
    private String windDirection;
    @JsonProperty("windpower")
    @JSONField(name = "windpower")
    private String windPower;
    private String humidity;
    @JsonProperty("reporttime")
    @JSONField(name = "reporttime")
    private String reportTime;

}
