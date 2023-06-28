package xyz.felh.amap.response.geocode;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class RegeoCode implements Serializable {

    @JSONField(name = "formatted_address")
    @JsonProperty("formatted_address")
    private String formattedAddress;

    @JSONField(name = "addressComponent")
    @JsonProperty("addressComponent")
    private AddressComponent addressComponent;

    /**
     * poi信息列表
     * 请求参数 extensions 为 all 时返回如下内容
     */
    @JSONField(name = "pois")
    @JsonProperty("pois")
    private List<Poi> pois;

    @JSONField(name = "roads")
    @JsonProperty("roads")
    private List<Road> roads;

    @JSONField(name = "roadinters")
    @JsonProperty("roadinters")
    private List<RoadInter> roadInters;

    /**
     * aoi信息列表
     * 请求参数 extensions 为 all 时返回如下内容
     */
    @JSONField(name = "aois")
    @JsonProperty("aois")
    private List<Aoi> aois;

}
