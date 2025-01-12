package com.hnxx.zy.clms.core.service.impl;

import com.hnxx.zy.clms.common.utils.Page;
import com.hnxx.zy.clms.core.entity.Notice;
import com.hnxx.zy.clms.core.mapper.NoticeMapper;
import com.hnxx.zy.clms.core.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenii
 * @date: 2020/3/18 15:15
 * @version: 1.0
 * @desc:
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public void setChange(Notice notice) {
        noticeMapper.setChange(notice);
    }

    @Override
    public void save(Notice notice) {
        noticeMapper.save(notice);
    }

    @Override
    public void delNotice(Integer id) {
        noticeMapper.delNotice(id);
    }

    @Override
    public Page<Notice> getByPage(Page<Notice> page, Integer id) {
        List<Notice> notices = noticeMapper.getByPage(page, id);
        page.setList(notices);

        int totalCount = noticeMapper.getCountByPage();
        page.setTotalCount(totalCount);
        return page;
    }
}
