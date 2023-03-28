package com.example.maka.handler;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.util.PropertyPlaceholderHelper;

import java.util.List;
import java.util.Properties;

public class AnalysisTitleHandler implements CellWriteHandler {
    private String title;
    PropertyPlaceholderHelper placeholderHelper = new PropertyPlaceholderHelper("${", "}");

    public AnalysisTitleHandler(String title) {
        this.title = title;
    }

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {
        if (head != null) {
            List<String> headNameList = head.getHeadNameList();
            if (CollectionUtils.isNotEmpty(headNameList)) {
                Properties properties = new Properties();
                properties.setProperty("title", title);
                for (int i = 0; i < headNameList.size(); i++) {
                    headNameList.set(i, placeholderHelper.replacePlaceholders(headNameList.get(i), properties));
                }
            }
        }
    }

}
