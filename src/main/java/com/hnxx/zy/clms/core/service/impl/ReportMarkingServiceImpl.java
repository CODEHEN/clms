package com.hnxx.zy.clms.core.service.impl;

import com.hnxx.zy.clms.common.utils.Page;
import com.hnxx.zy.clms.core.entity.Report;
import com.hnxx.zy.clms.core.entity.ReportMarking;
import com.hnxx.zy.clms.core.mapper.ReportMarkingMapper;
import com.hnxx.zy.clms.core.service.ReportMarkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: clms
 * @description: 报告批阅service实现类
 * @author: nile
 * @create: 2020-03-24 16:17
 **/
@Service
public class ReportMarkingServiceImpl implements ReportMarkingService {

    @Autowired
    private ReportMarkingMapper reportMarkingMapper;

    @Override
    public List<Report> getGroupMarking(Page<Report> page) {
        return reportMarkingMapper.getGroupMarking(page);
    }

    @Override
    public void setGroupMarking(List<ReportMarking> reportMarkings) {
        reportMarkingMapper.setGroupMarking(reportMarkings);
    }

    @Override
    public void setCheck(Integer reportId) {
        reportMarkingMapper.setCheck(reportId);
    }

    @Override
    public List<ReportMarking> getMyMarking(Page<ReportMarking> page) {
        return reportMarkingMapper.getMyMarking(page);
    }
}
