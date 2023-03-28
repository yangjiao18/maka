package com.example.maka.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.io.Serializable;

@Data
public class AnalysisExportModel implements Serializable {

    @ExcelProperty("时间")
    @ColumnWidth(75)
    private String timeArea;

    @ExcelProperty(value = "${title}")
    @ColumnWidth(25)
    private String result;

}
