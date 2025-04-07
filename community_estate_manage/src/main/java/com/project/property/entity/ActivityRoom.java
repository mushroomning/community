package com.project.property.entity;

import lombok.Data;

import java.util.Date;

/**
 * 活动室预约表
 */
@Data
public class ActivityRoom {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 预约时间
     */
    private String createDate;

    /**
     * 活动室编号
     */
    private String roomNo;

    /**
     * 活动室类型
     */
    private String roomType;

    /**
     * 预约日期
     */
    private String bookingDate;

    /**
     * 预约时间段（如：9:00-10:00）
     */
    private String timeSlot;

    /**
     * 预约人数
     */
    private Integer peopleCount;

    /**
     * 活动主题
     */
    private String activityTheme;

    /**
     * 备注信息
     */
    private String desc;

    /**
     * 预约的用户 ID
     */
    private Integer userId;

    /**
     * 预约状态（0：待审核，1：已通过，2：已拒绝）
     */
    private String status;

    /**
     * 查询日期（开始）
     */
    private Date createDateStart;

    /**
     * 查询日期（结束）
     */
    private Date createDateEnd;
}