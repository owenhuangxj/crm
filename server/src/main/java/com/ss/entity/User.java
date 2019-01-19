package com.ss.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("s_user")
public class User extends Model<User> {
    @Override
    protected Serializable pkVal() {
        return userId;
    }
    @TableId
    private Integer userId;
    private String createDate;
    private String createId;
    private Data editDate;
    private String editId;
    private String email;
    private boolean enableStatus;
    private boolean isManage;
    private String login;
    private String userName;
    private boolean onjobStatus;
    private String orgId;
    private String password;
    private String phone;
    private String remark;
    private int sex;
    private boolean status;
    private int type;
}
