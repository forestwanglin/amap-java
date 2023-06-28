package xyz.felh.amap.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public abstract class BaseResponse implements Serializable {

    /**
     * 返回值为 0 或 1，0 表示请求失败；1 表示请求成功。
     */
    private int status;

    /**
     * 返回结果的个数。
     */
    private int count;

    /**
     * 当 status 为 0 时，info 会返回具体错误原因，否则返回“OK”。
     */
    private String info;

    /**
     * 对应info的code
     */
    private int infocode;

}
