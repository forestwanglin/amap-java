package xyz.felh.amap.response.geocode;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xyz.felh.amap.response.BaseResponse;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class GeoCodeResponse extends BaseResponse {

    /**
     * 地理编码信息列表
     */
    @JsonProperty("geocodes")
    @JSONField(name = "geocodes")
    private List<GeoCode> geocodes;

}
