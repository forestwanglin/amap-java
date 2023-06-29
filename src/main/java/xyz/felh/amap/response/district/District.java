package xyz.felh.amap.response.district;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class District implements Serializable {

    @JsonProperty("citycode")
    @JSONField(name = "citycode")
    private String cityCode;

    @JsonProperty("adcode")
    @JSONField(name = "adcode")
    private String adCode;

    private String name;

    /**
     * 行政区边界坐标点
     * <p>
     * 当一个行政区范围，由完全分隔两块或者多块的地块组
     * 成，每块地的 polyline 坐标串以 | 分隔 。
     * 如北京 的 朝阳区
     */
    private String polyline;

    /**
     * country:国家
     * province:省份（直辖市会在province显示）
     * city:市（直辖市会在province显示）
     * district:区县
     * street:街道
     */
    private String level;

    /**
     * 区域中心点
     */
    private String center;

    /**
     * 下级行政区列表，包含district元素
     */
    private List<District> districts;

}
