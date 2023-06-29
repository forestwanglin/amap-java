package xyz.felh.amap.response.district;

import lombok.Data;

import java.io.Serializable;

@Data
public class Suggestion implements Serializable {

    private String keywords;

    private String cities;

}
