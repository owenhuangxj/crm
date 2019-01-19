package com.ss.service;
import com.ss.entity.Log;
import java.util.List;
public interface LogService<PageData> {


    /*添加日志*/
    Integer getInsertLog(Log log);
    /*查询日志所有内容*/
    List<Log> getSelectLog(Log log);
    /*按要求查找日志内容*/
    List<Log> getAsyncSelectLog(String logType, Integer userId, String userName, String startTime, String endTime);

}
