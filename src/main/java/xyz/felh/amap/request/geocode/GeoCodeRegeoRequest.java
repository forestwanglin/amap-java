package xyz.felh.amap.request.geocode;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import xyz.felh.amap.request.BaseRequest;
import xyz.felh.amap.request.ExtensionsType;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class GeoCodeRegeoRequest extends BaseRequest {

    /**
     * 传入内容规则：经度在前，纬度在后，经纬度间以“,”分割，经纬度小数点后不要超过 6 位。
     * 经纬度坐标;最多支持20个坐标点;多个点之间用"|"分割。
     */
    @NonNull
    @JsonProperty("location")
    @JSONField(name = "location")
    private String location;

    @JsonProperty("poitype")
    @JSONField(name = "poitype")
    private String poitype;

    /**
     * radius取值范围在0~3000，默认是1000。单位：米
     */
    @JsonProperty("radius")
    @JSONField(name = "radius")
    private Integer radius;

    /**
     * extensions 参数默认取值是 base，也就是返回基本地址信息；
     * <p>
     * extensions 参数取值为 all 时会返回基本地址信息、附近 POI 内容、道路信息以及道路交叉口信息。
     */
    @JsonProperty("extensions")
    @JSONField(name = "extensions")
    private ExtensionsType extensions;

    /**
     * 以下内容需要 extensions 参数为 all 时才生效。
     * <p>
     * 可选值：0，1
     * 当roadlevel=0时，显示所有道路
     * 当roadlevel=1时，过滤非主干道路，仅输出主干道路数据
     */
    @JsonProperty("roadlevel")
    @JSONField(name = "roadlevel")
    private Integer roadlevel;

    /**
     * 以下内容需要 extensions 参数为 all 时才生效。
     * <p>
     * homeorcorp 参数的设置可以影响召回 POI 内容的排序策略，目前提供三个可选参数：
     * <p>
     * 0：不对召回的排序策略进行干扰。
     * <p>
     * 1：综合大数据分析将居家相关的 POI 内容优先返回，即优化返回结果中 pois 字段的poi顺序。
     * <p>
     * 2：综合大数据分析将公司相关的 POI 内容优先返回，即优化返回结果中 pois 字段的poi顺序。
     */
    @JsonProperty("homeorcorp")
    @JSONField(name = "homeorcorp")
    private Integer homeorcorp;

    @Override
    public Map<String, String> toQueryMap() {
        Map<String, String> map = super.toQueryMap();
        map.put("location", location);
        if (poitype != null) {
            map.put("poitype", poitype);
        }
        if (radius != null) {
            map.put("radius", radius.toString());
        }
        if (extensions != null) {
            map.put("extensions", extensions.value());
            if (extensions == ExtensionsType.ALL) {
                if (roadlevel != null) {
                    map.put("roadlevel", roadlevel.toString());
                }
                if (homeorcorp != null) {
                    map.put("homeorcorp", homeorcorp.toString());
                }
            }
        }
        return map;
    }

}
