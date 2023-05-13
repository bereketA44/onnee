package com.app.onnee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AnalyticsDTO {
    private String header;
    private Object data;

    @Override
    public String toString() {

        return "This is the data /t /t " + header + data.toString();
    }
}
