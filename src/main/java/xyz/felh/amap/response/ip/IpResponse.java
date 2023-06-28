package xyz.felh.amap.response.ip;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.felh.amap.response.BaseResponse;

@EqualsAndHashCode(callSuper = true)
@Data
public class IpResponse extends BaseResponse {

    /**
     * 若为直辖市则显示直辖市名称；
     * 如果在局域网 IP网段内，则返回“局域网”；
     * 非法IP以及国外IP则返回空
     */
    private String province;

    /**
     * 若为直辖市则显示直辖市名称；
     * 如果为局域网网段内IP或者非法IP或国外IP，则返回空
     */
    private String city;

    @JsonProperty("adcode")
    @JSONField(name = "adcode")
    private String adCode;

    /**
     * 所在城市矩形区域范围
     */
    private String rectangle;

}
