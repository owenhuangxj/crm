package com.ss.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_emp")
@EqualsAndHashCode(callSuper = false)
public class Employee extends Model<Employee> {

    @TableId
    /**员工id*/
    private Long empId;
    /**员工姓名*/
    private String empName;


}
