package com.ycz.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @Author scott
 * @since 2018-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 登录账号
     */
    @ExcelProperty(value = "用户名", index = 0)
    @ColumnWidth(12)
    private String username;

    /**
     * 真实姓名
     */
    @ExcelProperty(value = "真实姓名", index = 0)
    @ColumnWidth(12)
    private String realname;

    /**
     * 密码
     */
    private String password;

    /**
     * md5密码盐
     */
    private String salt;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 生日
     */
    @ExcelProperty(value = "生日", index = 0)
    @ColumnWidth(12)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 性别（1：男 2：女）
     */
    @ExcelProperty(value = "性别", index = 0)
    @ColumnWidth(12)
    private Integer sex;

    /**
     * 电子邮件
     */
    @ExcelProperty(value = "电子邮件", index = 0)
    @ColumnWidth(12)
    private String email;

    /**
     * 电话
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private String phone;

    /**
     * 部门code(当前选择登录部门)
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private String orgCode;

    /**部门名称*/
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private transient String orgCodeTxt;

    /**
     * 状态(1：正常  2：冻结 ）
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private Integer status;

    /**
     * 删除状态（0，正常，1已删除）
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private Integer delFlag;

    /**
     * 工号，唯一键
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private String workNo;

    /**
     * 职务，关联职务表
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private String post;

    /**
     * 座机号
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private String telephone;

    /**
     * 创建人
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private String createBy;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private Date createTime;

    /**
     * 更新人
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private String updateBy;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private Date updateTime;
    /**
     * 同步工作流引擎1同步0不同步
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private Integer activitiSync;

    /**
     * 身份（0 普通成员 1 上级）
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private Integer userIdentity;

    /**
     * 负责部门
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private String departIds;

    /**
     * 多租户id配置，编辑用户的时候设置
     */
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private String relTenantIds;

    /**设备id uniapp推送用*/
    @ExcelProperty(value = "电话", index = 0)
    @ColumnWidth(12)
    private String clientId;
}
