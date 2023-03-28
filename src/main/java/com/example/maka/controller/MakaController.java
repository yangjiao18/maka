package com.example.maka.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.maka.handler.AnalysisTitleHandler;
import com.example.maka.model.AnalysisExportModel;
import com.example.maka.service.MakaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("data")
@Slf4j
public class MakaController {

    @Resource
    private MakaService makaService;

    @PostMapping("/getCode")
    public String getCode(String name) {
        return "1993";
    }

    @PostMapping("export")
    public void export(HttpServletResponse response) {
        List<AnalysisExportModel> list = makaService.getExportData();
        try {
            response.setContentType("application/vnd,ms-excel");
            response.setCharacterEncoding("utf-8");
            String exportName = URLEncoder.encode("统计结果", "utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + exportName + ExcelTypeEnum.XLSX.getValue());

            EasyExcel.write(response.getOutputStream(), AnalysisExportModel.class)
                    .autoCloseStream(Boolean.FALSE)
                    .registerWriteHandler(new AnalysisTitleHandler("首页-点击"))
                    .sheet("统计")
                    .doWrite(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
