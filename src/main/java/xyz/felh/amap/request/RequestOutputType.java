package xyz.felh.amap.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum RequestOutputType {

    JSON("JSON"),
    XML("XML");

    private final String value;

    RequestOutputType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public RequestOutputType fromValue(String value) {
        return Arrays.stream(values()).filter(it ->
                it.getValue().equals(value)).findFirst().orElse(null);
    }

}
