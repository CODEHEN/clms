package com.hnxx.zy.clms.core.mapper;

import com.hnxx.zy.clms.common.utils.Page;
import com.hnxx.zy.clms.core.entity.Article;
import com.hnxx.zy.clms.core.entity.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: chenii
 * @date: 2020/3/18 14:14
 * @version: 1.0
 * @desc:
 */
@Mapper
@Repository
public interface NoticeMapper {
    /**
     * 设置已读
     *
     * @param notice
     */
    @Insert("insert into cl_notice_user(notice_id,user_id,if_read) values (#{notice.noticeId},#{notice.userId},1)")
    void setChange(@Param("notice") Notice notice);

    /**
     * 新建通知
     *
     * @param notice
     */
    @Insert("insert into cl_notice(created_id,notice_content,notice_title,is_enabled) values (#{notice.createdId},#{notice.noticeContent},#{notice.noticeTitle},#{notice.isEnabled})")
    void save(@Param("notice") Notice notice);

    /**
     * 删除通知
     *
     * @param id
     */
    @Update("update cl_notice set is_deleted=1 WHERE cl_notice.notice_id=#{id}")
    void delNotice(Integer id);

    /**
     * 分页获取通知
     *
     * @param page
     * @param id
     * @return
     */
    @Select("SELECT a.*,IFNULL(b.if_read,0) as if_read,c.user_name from cl_notice a left JOIN cl_notice_user b ON  b.user_id=#{id} and a.notice_id=b.notice_id LEFT JOIN cl_user c ON a.created_id=c.user_id WHERE a.is_deleted =0 and a.is_enabled=1 ORDER BY a.created_time desc LIMIT #{page.index}, #{page.pageSize} ")
    List<Notice> getByPage(@Param("page") Page page, Integer id);

    /**
     * 查询总数
     *
     * @return
     */
    @Select("select count(*) from cl_notice WHERE is_deleted =0 and is_enabled=1")
    int getCountByPage();
}