package xyz.felh.amap.response.geocode;

import lombok.Data;

import java.io.Serializable;

@Data
public class Building implements Serializable {

    private String name;
    private String type;

}
