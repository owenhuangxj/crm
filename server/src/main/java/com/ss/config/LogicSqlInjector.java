package com.ss.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.extension.injector.methods.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogicSqlInjector extends AbstractSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList() {
        return Stream.of(
                new Insert(),
                new LogicDelete(),
                new LogicDeleteById(),
                new LogicDeleteByMap(),
                new LogicDeleteBatchByIds(),
                new LogicUpdate(),
                new LogicUpdateById(),
                new LogicSelectById(),
                new LogicSelectBatchByIds(),
                new LogicSelectByMap(),
                new LogicSelectOne(),
                new LogicSelectCount(),
                new LogicSelectCount(),
                new LogicSelectMaps(),
                new LogicSelectObjs(),
                new LogicSelectList(),
                new LogicSelectPage(),
                new LogicSelectMapsPage()
        ).collect(Collectors.toList());
    }
}
