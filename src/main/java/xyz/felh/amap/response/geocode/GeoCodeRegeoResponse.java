package xyz.felh.amap.response.geocode;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xyz.felh.amap.response.BaseResponse;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class GeoCodeRegeoResponse extends BaseResponse {

    @JsonProperty("regeocode")
    @JSONField(name = "regeocode")
    private RegeoCode regeoCode;

}
