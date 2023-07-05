package com.example.maka.Controller.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class SaveRequest implements Serializable {
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date end;
}
