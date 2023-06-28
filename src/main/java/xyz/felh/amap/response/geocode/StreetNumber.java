package xyz.felh.amap.response.geocode;

import lombok.Data;

import java.io.Serializable;

@Data
public class StreetNumber implements Serializable {

    private String street;
    private String number;
    private String location;
    private String direction;
    private String distance;

}
