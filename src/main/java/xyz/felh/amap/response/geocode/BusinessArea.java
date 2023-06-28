package xyz.felh.amap.response.geocode;

import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessArea implements Serializable {

    private String location;
    private String name;
    private String id;

}
