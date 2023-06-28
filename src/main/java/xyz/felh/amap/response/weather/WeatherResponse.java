package xyz.felh.amap.response.weather;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.felh.amap.response.BaseResponse;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class WeatherResponse extends BaseResponse {

    private Integer count;

    /**
     * 实况天气数据信息
     */
    private List<Live> lives;

    /**
     * 预报天气信息数据
     */
    private List<Forecast> forecasts;

}
