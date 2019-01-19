package com.ss.service;

import com.ss.entity.Student;
import com.ss.entity.Track;
import com.ss.entity.User;
import com.ss.util.ChartData;

import java.util.List;

public interface MonitorService {
    /**
     * 查询公司所有员工
     * @param currentPage
     * @param currentPageSize
     * @return
     */
    List<User> selectAllWorktor(Integer currentPage, Integer currentPageSize);

    /**
     * 查询公司总人数
     * @return
     */
    Integer selectWorktorNum();

    /**
     * 查询员工下面跟踪的学员
     * @param userId
     * @param currentPage
     * @param currentPageSize
     * @return
     */
    List<Student> selectWorktorOfStu(Integer userId, Integer currentPage, Integer currentPageSize);

    /**
     * 查询员工业务的完成情况
     * @param userId
     * @return
     */
    ChartData selectWorkOfBusiness(Integer userId);

    /**
     * 查询某个员工名下学员的跟踪记录信息
     * @param stuNumber
     * @param userId
     * @return
     */
    List<Track> selectWorkOfStuTrak(String stuNumber, Integer userId);
}
