package xyz.felh.amap.request.district;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class DistrictRequest extends BaseRequest {

    /**
     * 查询关键字
     * <p>
     * 规则：只支持单个关键词语搜索关键词支持：行政区名称、citycode、adcode
     * 例如，在subdistrict=2，搜索省份（例如山东），能够显示市（例如济南），区（例如历下区）
     */
    private String keywords;

    /**
     * 子级行政区
     * <p>
     * 规则：设置显示下级行政区级数（行政区级别包括：国家、省/直辖市、市、区/县、乡镇/街道多级数据）
     * 可选值：0、1、2、3等数字，并以此类推
     * 0：不返回下级行政区；
     * 1：返回下一级行政区；
     * 2：返回下两级行政区；
     * 3：返回下三级行政区；
     * <p>
     * 需要在此特殊说明，目前部分城市和省直辖县因为没有区县的概念，故在市级下方直接显示街道。
     * 例如：广东-东莞、海南-文昌市
     */
    @JsonProperty("subdistrict")
    @JSONField(name = "subdistrict")
    private Integer subDistrict;

    /**
     * 需要第几页数据
     * <p>
     * 最外层的districts最多会返回20个数据，若超过限制，请用page请求下一页数据。
     * 例如page=2；page=3。默认page=1
     */
    private Integer page;

    /**
     * 最外层返回数据个数 default: 20
     */
    private Integer offset;

    /**
     * 返回结果控制, default: base
     * <p>
     * 此项控制行政区信息中返回行政区边界坐标点； 可选值：base、all;
     * base:不返回行政区边界坐标点；
     * all:只返回当前查询district的边界值，不返回子节点的边界值；
     * 目前不能返回乡镇/街道级别的边界值
     */
    private Extensions extensions;

    /**
     * 根据区划过滤
     * <p>
     * 按照指定行政区划进行过滤，填入后则只返回该省/直辖市信息
     * 需填入adCode，为了保证数据的正确，强烈建议填入此参数
     */
    private String filter;


    @Override
    public Map<String, String> toQueryMap() {
        Map<String, String> map = super.toQueryMap();
        if (keywords != null) {
            map.put("keywords", keywords);
        }
        if (subDistrict != null) {
            map.put("subdistrict", subDistrict.toString());
        }
        if (page != null) {
            map.put("page", page.toString());
        }
        if (offset != null) {
            map.put("offset", offset.toString());
        }
        if (extensions != null) {
            map.put("extensions", extensions.value());
        }
        if (filter != null) {
            map.put("filter", filter);
        }
        return map;
    }

}
