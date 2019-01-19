package com.ss.service.impl;

import com.ss.dao.TargetMapper;
import com.ss.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("ALL")
public class TargetServiceImpl implements TargetService {
    @Autowired
    private TargetMapper targetMapper;


    @Override
    public Integer selectTargetMonthId() {
        return targetMapper.targetGetMonthType();
    }

    @Override
    public Integer selectTargetDayId() {
        return targetMapper.targetGetDayType();
    }
}
