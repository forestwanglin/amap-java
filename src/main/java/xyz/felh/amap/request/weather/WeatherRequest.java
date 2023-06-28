package xyz.felh.amap.request.weather;

import lombok.*;
import lombok.experimental.SuperBuilder;
import xyz.felh.amap.request.BaseRequest;
import xyz.felh.amap.request.Extensions;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class WeatherRequest extends BaseRequest {

    /**
     * 输入城市的adcode
     */
    private String city;

    /**
     * 可选值：base/all
     * base:返回实况天气
     * all:返回预报天气
     */
    private Extensions extensions;

    @Override
    public Map<String, String> toQueryMap() {
        Map<String, String> map = super.toQueryMap();
        map.put("city", city);
        if (extensions != null) {
            map.put("extensions", extensions.value());
        }
        return map;
    }
}
