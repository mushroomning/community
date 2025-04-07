package com.project.property.service;

import com.project.property.dao.ActivityRoomMapper;
import com.project.property.entity.ActivityRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 活动室预约业务层
 */
@Service
public class ActivityRoomService {

    @Autowired
    private ActivityRoomMapper activityRoomMapper;

    /**
     * 根据主键删除
     *
     * @param ids 主键
     * @return 影响行数
     */
    public int deleteByPrimaryKey(String ids) {
        return activityRoomMapper.deleteByPrimaryKey(ids);
    }

    /**
     * 插入记录
     *
     * @param record 记录
     * @return 影响行数
     */
    public int insertSelective(ActivityRoom record) {
        return activityRoomMapper.insertSelective(record);
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 记录
     */
    public ActivityRoom selectByPrimaryKey(Integer id) {
        return activityRoomMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据主键更新
     *
     * @param record 记录
     * @return 影响行数
     */
    public int updateByPrimaryKeySelective(ActivityRoom record) {
        return activityRoomMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据参数查询
     *
     * @param activityRoom 参数
     * @return 记录列表
     */
    public List<ActivityRoom> selectByParam(ActivityRoom activityRoom) {
        return activityRoomMapper.selectByParam(activityRoom);
    }

    /**
     * 根据参数查询总数
     *
     * @param activityRoom 参数
     * @return 记录总数
     */
    public int selectCountByParam(ActivityRoom activityRoom) {
        return activityRoomMapper.selectCountByParam(activityRoom);
    }

    /**
     * 分页查询
     *
     * @param activityRoom 参数
     * @param page 页码
     * @param limit 每页记录数
     * @return 记录列表
     */
    public List<ActivityRoom> selectDataByPage(ActivityRoom activityRoom, Integer page, Integer limit) {
        return activityRoomMapper.selectDataByPage(activityRoom, page, limit);
    }
} 