package com.ss.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ss.annotation.PermInfo;
import com.ss.entity.SysRole;
import com.ss.service.SysRoleService;
import com.ss.vo.Json;
import com.ss.vo.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@PermInfo(value = "选项模块", pval = "a:option")
@RestController
@RequestMapping("/option")
public class OptionController {

    private static final Logger log = LoggerFactory.getLogger(OptionController.class);

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/role")
    public Json listRoleOptions() {
        String oper = "list role options";
        log.info(oper);

        QueryWrapper<SysRole> params = new QueryWrapper<>();
        params.select("rid","rname","rval");

        List<SysRole> list = sysRoleService.list(params);
        List<Option> options = list.stream().map(obj -> new Option(obj.getRid(), obj.getRname(),obj.getRval())).collect(Collectors.toList());
        return Json.succ(oper, "options", options);
    }


}
