package com.project.property.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 活动室页面跳转控制器
 */
@Controller
@RequestMapping("/activityRoom")
public class ActivityRoomPageController {

    private static final Logger log = LoggerFactory.getLogger(ActivityRoomPageController.class);

    /**
     * 跳转到活动室预约管理页面
     *
     * @return 视图
     */
    @GetMapping("/toDataPage")
    public ModelAndView toDataPage() {
        log.info("Attempting to access /activityRoom/toDataPage");
        ModelAndView model = new ModelAndView();
        model.setViewName("adminPage/activityRoom/activityRoomPage");
        return model;
    }

    /**
     * 跳转到用户活动室预约页面
     *
     * @param userId 用户ID
     * @return 视图
     */
    @GetMapping("/toUserPage")
    public ModelAndView toUserPage(Integer userId) {
        log.info("Attempting to access /activityRoom/toUserPage with userId: {}", userId);
        ModelAndView model = new ModelAndView();
        if (userId != null) {
            model.addObject("userId", userId);
        }
        model.setViewName("webPage/userActivityRoom");
        return model;
    }
} 