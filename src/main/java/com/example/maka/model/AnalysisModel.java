package com.example.maka.model;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AnalysisModel implements Serializable {

    @DateTimeFormat("yyyy-MM-dd")
    private Date beginDate;

    @DateTimeFormat("yyyy-MM-dd")
    private Date endDate;

    private String result;
}
