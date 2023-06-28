package xyz.felh.amap.response.geocode;

import lombok.Data;

import java.io.Serializable;

@Data
public class Road implements Serializable {

    private String id;
    private String name;
    private String distance;
    private String direction;
    private String location;

}
