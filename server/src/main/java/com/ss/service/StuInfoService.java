package com.ss.service;


import com.ss.entity.StudentInfo;

public interface StuInfoService {

    Boolean addStuResume(StudentInfo info);

    StudentInfo getStuInfo(String stuNumber);

    Integer updateStuInfo(StudentInfo info);

}

