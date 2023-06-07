package com.example.maka.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.maka.model.AnalysisExportModel;
import com.example.maka.model.AnalysisModel;
import com.example.maka.service.MakaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MakaServiceImpl implements MakaService {

    @Override
    public List<AnalysisExportModel> getExportData() {
        List<AnalysisModel> list = new ArrayList<>();
        AnalysisModel m1 = new AnalysisModel();
        m1.setBeginDate(new Date());
        m1.setEndDate(new Date());
        m1.setResult("12312");
        list.add(m1);

        AnalysisModel m2 = new AnalysisModel();
        m2.setBeginDate(new Date("2023-03-28"));
        m2.setEndDate(new Date());
        m2.setResult("5445000");
        list.add(m2);

        List<AnalysisExportModel> result = list.stream().map(analysisModel -> {
            AnalysisExportModel m = new AnalysisExportModel();
            m.setTimeArea(DateUtil.formatDate(analysisModel.getBeginDate()) + " ~ " + DateUtil.formatDate(analysisModel.getEndDate()));
            m.setResult(analysisModel.getResult());
            return m;
        }).collect(Collectors.toList());
        return result;
    }
}
