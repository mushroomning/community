package com.project.property.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.project.property.entity.ActivityRoom;
import com.project.property.entity.ResultMessage;
import com.project.property.service.ActivityRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 活动室预约管理控制器
 */
@Controller
@RequestMapping("/activityRoom")
public class ActivityRoomController {

    /**
     * 业务对象
     */
    @Autowired
    private ActivityRoomService activityRoomService;

    /**
     * 条件 分页查询  适用于Layui数据表格
     *
     * @param activityRoom 查询条件
     * @param page        当前页
     * @param limit       每页显示的条数
     * @return ResultMessage
     */
    @GetMapping("/getDataByPage")
    @ResponseBody
    public ResultMessage getDataByPage(ActivityRoom activityRoom, Integer page, Integer limit) {
        // 查询数据
        try {
            if (StrUtil.isNotBlank(activityRoom.getCreateDate())) {
                String[] split = activityRoom.getCreateDate().split(" - ");
                if (split.length == 2) {
                    activityRoom.setCreateDateStart(DateUtil.parse(split[0], "yyyy-MM-dd HH:mm:ss").toJdkDate());
                    activityRoom.setCreateDateEnd(DateUtil.parse(split[1], "yyyy-MM-dd HH:mm:ss").toJdkDate());
                }
            }

            List<ActivityRoom> dataList = activityRoomService.selectDataByPage(activityRoom, page, limit);
            Integer count = activityRoomService.selectCountByParam(activityRoom);
            if (dataList != null && dataList.size() > 0) {
                return new ResultMessage(0, "查询成功！", dataList, count, limit);
            } else {
                return new ResultMessage(1, "暂无相关数据！");
            }
        } catch (Exception e) {
            return new ResultMessage(1, "查询出现异常：" + e.getMessage());
        }
    }

    /**
     * 插入方法
     *
     * @param activityRoom 插入的对象
     * @return ResultMessage
     */
    @PostMapping("insertInfo")
    @ResponseBody
    public ResultMessage insertInfo(@RequestBody ActivityRoom activityRoom) {
        try {
            // 执行新增方法
            activityRoom.setCreateDate(DateUtil.now());
            activityRoom.setStatus("0"); // 设置初始状态为待审核
            int result = activityRoomService.insertSelective(activityRoom);
            if (result > 0) {
                return new ResultMessage(0, "预约申请提交成功！");
            } else {
                return new ResultMessage(207, "预约申请提交失败！请稍后重试！");
            }
        } catch (Exception e) {
            return new ResultMessage(500, "操作出现异常：" + e.getMessage());
        }
    }

    /**
     * 删除方法
     *
     * @param ids 要删除的ID, 多个用逗号隔开
     * @return ResultMessage
     */
    @GetMapping("/deleteInfo")
    @ResponseBody
    public ResultMessage deleteInfo(String ids) {
        try {
            // 执行更新方法
            int result = activityRoomService.deleteByPrimaryKey(ids);
            if (result > 0) {
                return new ResultMessage(0, "操作成功！");
            } else {
                return new ResultMessage(207, "操作失败！请稍后重试！");
            }
        } catch (Exception e) {
            return new ResultMessage(500, "操作出现异常：" + e.getMessage());
        }
    }

    /**
     * 审核预约申请
     *
     * @param id     预约ID
     * @param status 审核状态（1：通过，2：拒绝）
     * @return ResultMessage
     */
    @PostMapping("/review")
    @ResponseBody
    public ResultMessage review(Integer id, String status) {
        try {
            ActivityRoom activityRoom = new ActivityRoom();
            activityRoom.setId(id);
            activityRoom.setStatus(status);
            int result = activityRoomService.updateByPrimaryKeySelective(activityRoom);
            if (result > 0) {
                return new ResultMessage(0, "审核操作成功！");
            } else {
                return new ResultMessage(207, "审核操作失败！请稍后重试！");
            }
        } catch (Exception e) {
            return new ResultMessage(500, "操作出现异常：" + e.getMessage());
        }
    }
}
