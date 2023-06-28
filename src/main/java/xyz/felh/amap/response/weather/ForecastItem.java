package xyz.felh.amap.response.weather;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ForecastItem implements Serializable {


    private String date;
    private String week;
    @JsonProperty("dayweather")
    @JSONField(name = "dayweather")
    private String dayWeather;
    @JsonProperty("daytemp")
    @JSONField(name = "daytemp")
    private String dayTemperature;
    @JsonProperty("daywind")
    @JSONField(name = "daywind")
    private String dayWind;
    @JsonProperty("daypower")
    @JSONField(name = "daypower")
    private String dayWindPower;
    @JsonProperty("nightweather")
    @JSONField(name = "nightweather")
    private String nightWeather;
    @JsonProperty("nighttemp")
    @JSONField(name = "nighttemp")
    private String nightTemperature;
    @JsonProperty("nightwind")
    @JSONField(name = "nightwind")
    private String nightWind;
    @JsonProperty("nightpower")
    @JSONField(name = "nightpower")
    private String nightWindPower;

}
