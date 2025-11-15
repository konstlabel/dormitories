package com.konstl.dormitories.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonPropertyOrder({
        "success",
        "message"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse implements Serializable {

    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonProperty("success")
    private final Boolean success;

    @JsonProperty("message")
    private final String message;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
