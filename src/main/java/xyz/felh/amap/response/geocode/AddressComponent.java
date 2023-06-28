package xyz.felh.amap.response.geocode;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AddressComponent implements Serializable {

    private String province;
    private String city;
    @JsonProperty("citycode")
    @JSONField(name = "citycode")
    private String cityCode;
    private String district;
    @JsonProperty("adcode")
    @JSONField(name = "adcode")
    private String adCode;
    /**
     * 坐标点所在乡镇/街道（此街道为社区街道，不是道路信息）
     */
    @JsonProperty("township")
    @JSONField(name = "township")
    private String townShip;
    /**
     * 乡镇街道编码
     */
    @JsonProperty("towncode")
    @JSONField(name = "towncode")
    private String townCode;

    /**
     * 所属海域信息
     */
    @JsonProperty("seaArea")
    @JSONField(name = "seaArea")
    private String seaArea;

    /**
     * 社区信息
     */
    private Neighborhood neighborhood;

    /**
     * 楼信息
     */
    private Building building;

    /**
     * 门牌信息
     */
    @JsonProperty("streetNumber")
    @JSONField(name = "streetNumber")
    private StreetNumber streetNumber;

    /**
     * 经纬度所属商圈列表
     */
    @JsonProperty("businessAreas")
    @JSONField(name = "businessAreas")
    private List<BusinessArea> businessAreas;

}
