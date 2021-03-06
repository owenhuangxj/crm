package com.ss.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_track")
@EqualsAndHashCode(callSuper = false)
public class Track extends Model<Track> {
    @Override
    protected Serializable pkVal() {
        return null;
    }

    /**
     * 跟踪方式
     */
    private String trackWays;
    /**
     * 优先级：1：无，2：低，3：中，4：高
     */
    private String trackPriority;
    /**
     * 跟踪时间
     */
    private String trackTime;
    /**
     * 跟踪状态/进度情况 1：新增，2：跟踪中，3：待面试，4：面试未通过，5：面试通过，6：已缴未清，7：已缴费，8：入学，9：放弃入学，10：退学，11：放弃
     */
    private String trackStatus;
    /**
     * 下次跟踪时间
     */
    private String trackNextTime;
    /**
     * 跟踪时长
     */
    private Integer trackDuration;
    /**
     * 预计上门时间
     */
    private String trackPredictTime;
    /**
     * 预计成交时间
     */
    private String trackTurnoverTime;
    /**
     * 重要程度
     */
    private String trackImportance;
    /**
     * 是否有效
     */
    private String trackValid;
    /**
     * 跟踪内容
     */
    private String trackDetails;
    /**
     * 学生编号
     */
    private Student stuNumber;

    /**
     * 咨询师id
     */
    private User consultId;
    /**
     * 面试老师id
     */
    private User teacherId;
    /**
     * 更新时间
     */
    private String updateTime;

    public Track(String trackWays, String trackPriority, String trackTime, String trackStatus, String trackNextTime, Integer trackDuration, String trackPredictTime, String trackTurnoverTime, String trackImportance, String trackValid, String trackDetails, Student stuNumber, User consultId, User teacherId) {
        this.trackWays = trackWays;
        this.trackPriority = trackPriority;
        this.trackTime = trackTime;
        this.trackStatus = trackStatus;
        this.trackNextTime = trackNextTime;
        this.trackDuration = trackDuration;
        this.trackPredictTime = trackPredictTime;
        this.trackTurnoverTime = trackTurnoverTime;
        this.trackImportance = trackImportance;
        this.trackValid = trackValid;
        this.trackDetails = trackDetails;
        this.stuNumber = stuNumber;
        this.consultId = consultId;
        this.teacherId = teacherId;
    }
}
