package xyz.felh.amap.request.ip;

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
public class IpRequest extends BaseRequest {

    /**
     * 需要搜索的IP地址（仅支持国内）
     * <p>
     * 若用户不填写IP，则取客户http之中的请求来进行定位
     */
    private String ip;

    @Override
    public Map<String, String> toQueryMap() {
        Map<String, String> map = super.toQueryMap();
        map.put("ip", ip);
        return map;
    }
}
