package com.ss.dao;

import com.ss.entity.Track;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrackMapper {

    /**
     * 添加跟踪记录
     * @param track 数据
     * @return 影响行数
     */
    Integer insertTrackRecord(Track track);

    /**
     * 查询学生跟踪信息
     * @param stuNumber 学生编号
     * @return 跟踪信息
     */
    List<Track> getTrackInfo(@Param("stuNumber") String stuNumber);

    /**
     * 修改跟踪状态
     * @param stuNumber 学生编号
     * @param trackStatus 跟踪状态
     * @return 改变行数
     */
    Integer updateTrackStatus(@Param("stuNumber") String stuNumber, @Param("trackStatus") int trackStatus);

    /**
     * 查询跟踪次数
     * @param stuNumber 学生编号
     * @return 跟踪次数
     */
    Integer getTrackCount(@Param("stuNumber") String stuNumber);


}
