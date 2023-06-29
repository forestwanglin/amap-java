package xyz.felh.amap.response.district;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.felh.amap.response.BaseResponse;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DistrictResponse extends BaseResponse {

    private Suggestion suggestion;

    private List<District> districts;

}
