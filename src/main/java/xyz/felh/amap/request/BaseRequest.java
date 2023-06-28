package xyz.felh.amap.request;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
//@Builder
@SuperBuilder(toBuilder = true)
public abstract class BaseRequest implements Serializable {

    /**
     * 用户在高德地图官网申请Web服务API类型Key
     */
    @JsonProperty("key")
    @JSONField(name = "key")
    private String key;

    /**
     * https://lbs.amap.com/faq/quota-key/key/41169
     */
    @JsonProperty("sig")
    @JSONField(name = "sig")
    private String sig;

    /**
     * 可选输入内容包括：JSON，XML。设置 JSON 返回结果数据将会以JSON结构构成；如果设置 XML 返回结果数据将以 XML 结构构成。
     */
    @JsonProperty("output")
    @JSONField(name = "output")
    private RequestOutputType output;

    /**
     * callback 值是用户定义的函数名称，此参数只在 output 参数设置为 JSON 时有效。
     */
    @JsonProperty("callback")
    @JSONField(name = "callback")
    private String callback;

    public Map<String, String> toQueryMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        if (sig != null) {
            map.put("sig", sig);
        }
        if (output != null) {
            map.put("output", output.value());
            if (output == RequestOutputType.JSON && callback != null) {
                map.put("callback", callback);
            }
        } else {
            map.put("output", RequestOutputType.JSON.value());
        }
        return map;
    }

}
