package com.project.property.dao;

import com.project.property.entity.ActivityRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 活动室预约数据访问接口
 */
@Mapper
public interface ActivityRoomMapper {
    /**
     * 根据主键删除
     *
     * @param ids 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(String ids);

    /**
     * 插入记录
     *
     * @param record 记录
     * @return 影响行数
     */
    int insertSelective(ActivityRoom record);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 记录
     */
    ActivityRoom selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新
     *
     * @param record 记录
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(ActivityRoom record);

    /**
     * 根据参数查询
     *
     * @param activityRoom 参数
     * @return 记录列表
     */
    List<ActivityRoom> selectByParam(ActivityRoom activityRoom);

    /**
     * 根据参数查询总数
     *
     * @param activityRoom 参数
     * @return 记录总数
     */
    int selectCountByParam(ActivityRoom activityRoom);

    /**
     * 分页查询
     *
     * @param activityRoom 参数
     * @param page 页码
     * @param limit 每页记录数
     * @return 记录列表
     */
    List<ActivityRoom> selectDataByPage(ActivityRoom activityRoom, Integer page, Integer limit);
} 