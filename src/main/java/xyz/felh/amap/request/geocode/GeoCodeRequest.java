package xyz.felh.amap.request.geocode;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import xyz.felh.amap.request.BaseRequest;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class GeoCodeRequest extends BaseRequest {

    /**
     * 规则遵循：国家、省份、城市、区县、城镇、乡村、街道、门牌号码、屋邨、大厦，如：北京市朝阳区阜通东大街6号。
     */
    @NonNull
    @JsonProperty("address")
    @JSONField(name = "address")
    private String address;

    /**
     * 可选输入内容包括：指定城市的中文（如北京）、指定城市的中文全拼（beijing）、citycode（010）、adcode（110000），不支持县级市。当指定城市查询内容为空时，会进行全国范围内的地址转换检索。
     * <p>
     * adcode信息可参考城市编码表获取
     */
    @JsonProperty("city")
    @JSONField(name = "city")
    private String city;

    @Override
    public Map<String, String> toQueryMap() {
        Map<String, String> map = super.toQueryMap();
        map.put("address", address);
        if (city != null) {
            map.put("city", city);
        }
        return map;
    }
}
