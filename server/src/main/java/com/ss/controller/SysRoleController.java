package com.ss.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ss.annotation.PermInfo;
import com.ss.constant.PermType;
import com.ss.entity.SysPerm;
import com.ss.entity.SysRole;
import com.ss.entity.SysRolePerm;
import com.ss.service.SysPermService;
import com.ss.service.SysRolePermService;
import com.ss.service.SysRoleService;
import com.ss.service.SysUserRoleService;
import com.ss.vo.Json;
import com.ss.vo.UpdateRolePermVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@PermInfo(value = "系统角色模块")
@RestController
@RequiresPermissions("a:sys:role")
@RequestMapping("/sys_role")
public class SysRoleController {

    private static final Logger log = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysPermService permService;
    @Autowired
    private SysUserRoleService userRoleService;
    @Autowired
    private SysRolePermService rolePermService;

    @PostMapping
    public Json add(@RequestBody String body) {

        String oper = "add role";
        SysRole role = JSON.parseObject(body, SysRole.class);

        if (StringUtils.isBlank(role.getRval())) {
            return Json.fail(oper, "权限值不能为空");
        }

        SysRole roleDB = roleService.getOne(new QueryWrapper<SysRole>().eq("rval", role.getRval()));
        if (roleDB != null) {
            return Json.fail(oper, "角色值已存在：" + role.getRval());
        }

        //保存新用户数据
        role.setCreated(new Date());
        boolean success = roleService.save(role);
        return Json.result(oper, success)
                .data("rid",role.getRid())
                .data("created",role.getCreated());
    }

    @DeleteMapping
    public Json delete(@RequestBody String body) {

        String oper = "delete role";
        log.info("{}, body: {}", oper, body);

        JSONObject jsonObj = JSON.parseObject(body);
        String rid = jsonObj.getString("rid");

        if (StringUtils.isBlank(rid)) {
            return Json.fail(oper, "无法删除角色：参数为空（角色id）");
        }

        boolean success = roleService.removeById(rid);
        return Json.result(oper, success);
    }

    @PostMapping("/query")
    public Json query(@RequestBody String body) {

        String oper = "query role";
        log.info("{}, body: {}", oper, body);

        JSONObject json = JSON.parseObject(body);
        String rname = json.getString("rname");

        int current = json.getIntValue("current");
        int size = json.getIntValue("size");
        if (current == 0) current = 1;
        if (size == 0) size = 10;

        QueryWrapper<SysRole> queryParams = new QueryWrapper<>();
        queryParams.orderByAsc(false,"created","updated");
        if (StringUtils.isNotBlank(rname)) {
            queryParams.like("rname",rname);
        }

        IPage<SysRole> page = roleService.page(new Page<>(current, size), queryParams);
        return Json.succ(oper).data("page", page);
    }

    @PatchMapping("/info")
    public Json update(@RequestBody String body) {

        String oper = "update role";
        log.info("{}, body: {}", oper, body);

        SysRole role = JSON.parseObject(body, SysRole.class);
        if (StringUtils.isBlank(role.getRid())) {
            return Json.fail(oper, "无法更新角色：参数为空（角色id）");
        }
        role.setUpdated(new Date());
        boolean success = roleService.updateById(role);
        return Json.result(oper, success).data("updated", role.getUpdated());
    }


    @PatchMapping("/perm")
    public Json updateRolePerm(@RequestBody UpdateRolePermVo vo) {

        String oper = "update role's permissions";

        if (StringUtils.isBlank(vo.getRid())) {
            return Json.fail(oper, "无法更新角色的权限：参数为空（角色id）");
        }
        if (vo.getPtype()==null){
            return Json.fail(oper, "无法更新角色的权限：参数为空（权限类型）");
        }
        final String rid = vo.getRid();
        final Integer ptype = vo.getPtype();
        final List<String> pvals = vo.getPvals();

        Wrapper<SysRolePerm> deleteRelationParam = new QueryWrapper<SysRolePerm>().eq("role_id", rid).eq("perm_type", ptype);
        boolean deleteRelationSucc = rolePermService.remove(deleteRelationParam);
        if (!deleteRelationSucc) return Json.fail(oper, "无法解除原来的角色-权限关系");

        if (!pvals.isEmpty()){
            List<SysRolePerm> list = vo.getPvals().stream().map(pval -> new SysRolePerm(rid, pval,ptype)).collect(Collectors.toList());
            boolean addSucc = rolePermService.saveBatch(list);
            return Json.result(oper, addSucc);
        }
        return Json.succ(oper);
    }


    @PostMapping("/perm")
    public Json addPerm(@RequestBody String body){
        String oper = "add role's permissions";

        JSONObject json = JSON.parseObject(body);
        String rid = json.getString("rid");
        Integer ptype = json.getInteger("ptype");
        String pval = json.getString("pval");

        boolean success = rolePermService.save(new SysRolePerm(rid, pval, ptype));
        return Json.result(oper,success);
    }


    @DeleteMapping("/perm")
    public Json deletePerm(@RequestBody String body){
        String oper = "delete role's permissions";

        JSONObject json = JSON.parseObject(body);
        String rid = json.getString("rid");
        Integer ptype = json.getInteger("ptype");
        String pval = json.getString("pval");

        Wrapper<SysRolePerm> deleteParam = new QueryWrapper<SysRolePerm>()
                .eq("role_id", rid)
                .eq("perm_val", pval)
                .eq("perm_type", ptype);
        boolean success = rolePermService.remove(deleteParam);
        return Json.succ(oper,success);
    }


    @GetMapping("/{rid}/perms")
    public Json findRolePerms(@PathVariable String rid){
        String oper = "find role perms";
        log.info("{}, rid: {}", oper, rid);
        if (StringUtils.isBlank(rid)){
            return Json.fail(oper, "无法查询当前角色的权限值：参数为空（角色id）");
        }
        SysRole role = roleService.getById(rid);
        List<SysPerm> perms = permService.getPermsByRoleId(rid);
        Map<Integer, List<SysPerm>> permMap = perms.stream().collect(Collectors.groupingBy(SysPerm::getPtype));

        List<String> menuPvals = permMap.getOrDefault(PermType.MENU, new ArrayList<>()).stream()
                .filter(perm->perm.getLeaf()==true).map(SysPerm::getPval).collect(Collectors.toList());

        List<String> btnPvals = permMap.getOrDefault(PermType.BUTTON, new ArrayList<>()).stream()
                .map(SysPerm::getPval).collect(Collectors.toList());

        List<String> apiPvals = permMap.getOrDefault(PermType.API, new ArrayList<>()).stream()
                .filter(perm->perm.getLeaf()==true).map(SysPerm::getPval).collect(Collectors.toList());

        return Json.succ(oper)
                .data("role",role)
                .data("menuPvals",menuPvals)
                .data("btnPvals",btnPvals)
                .data("apiPvals",apiPvals);
    }

}
