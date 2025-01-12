package com.hnxx.zy.clms.core.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: chenii
 * @date: 2020/3/18 15:02
 * @version: 1.0
 * @desc:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Notice implements Serializable {

    private static final long serialVersionUID = 5721157101645238691L;

    /**
     * 通知id
     */
    private Integer noticeId;

    /**
     * 创建人id
     */
    private Integer createdId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 通知内容
     */
    private String noticeContent;

    /**
     * 通知标题
     */
    private String noticeTitle;

    /**
     * 是否删除
     */
    private Boolean isDeleted;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 创建者姓名
     */
    private String userName;

    /**
     * 是否启用-1是0否
     */
    @JsonProperty("isEnabled")
    private boolean isEnabled;

    /**
     * 是否已阅：1是0否
     */
    @JsonProperty("ifRead")
    private boolean ifRead;

}
