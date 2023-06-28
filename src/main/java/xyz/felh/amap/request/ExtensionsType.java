package xyz.felh.amap.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ExtensionsType {

    BASE("base"),
    ALL("all");

    private final String value;

    ExtensionsType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public ExtensionsType fromValue(String value) {
        return Arrays.stream(values()).filter(it ->
                it.getValue().equals(value)).findFirst().orElse(null);
    }

}
