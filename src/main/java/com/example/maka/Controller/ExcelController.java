package com.example.maka.Controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import lombok.Data;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @GetMapping("/template")
    public ResponseEntity<ByteArrayResource> downloadExcelTemplate() {
        // 创建ExcelWriterBuilder
        ExcelWriterBuilder writerBuilder = EasyExcel.write();

        // 创建ExcelWriterSheetBuilder
        ExcelWriterSheetBuilder sheetBuilder = writerBuilder.sheet();

        // 设置表头
        sheetBuilder.head(User.class);

        // 构建ExcelWriter
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        writerBuilder.file(outputStream).build().finish();

        // 创建Excel文件字节数组资源
        byte[] excelBytes = outputStream.toByteArray();
        ByteArrayResource resource = new ByteArrayResource(excelBytes);

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "template.xlsx");

        // 返回Excel文件
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    // 用户类，包含用户ID和手机号两列
    @Data
    public static class User {
        @ExcelProperty("用户")
        private String userId;
        @ExcelProperty("手机号")
        private String phoneNumber;
    }
}
