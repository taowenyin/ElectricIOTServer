package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "view_bind_user_department_role", schema = "electric_iot", catalog = "")
public class ViewBindUserDepartmentRoleEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("department_id")
    private Long departmentId;
    @JsonProperty("department_name")
    private String departmentName;
    @JsonProperty("department_level")
    private int departmentLevel;
    @JsonProperty("department_create_time")
    private String departmentCreateTime;
    @JsonProperty("department_is_delete")
    private int departmentIsDelete;
    @JsonProperty("department_parent_id")
    private long departmentParentId;
    @JsonProperty("user_id")
    private long userId;
    @JsonProperty("user_login_name")
    private String userLoginName;
    @JsonProperty("user_login_password")
    private String userLoginPassword;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_create_time")
    private String userCreateTime;
    @JsonProperty("user_mobile")
    private String userMobile;
    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("user_is_delete")
    private int userIsDelete;
    @JsonProperty("role_id")
    private Long roleId;
    @JsonProperty("role_name")
    private String roleName;
    @JsonProperty("role_create_time")
    private String roleCreateTime;
    @JsonProperty("role_comment")
    private String roleComment;
    @JsonProperty("role_is_delete")
    private Integer roleIsDelete;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "department_id", nullable = true)
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "department_name", nullable = false, length = 255)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Basic
    @Column(name = "department_level", nullable = false)
    public int getDepartmentLevel() {
        return departmentLevel;
    }

    public void setDepartmentLevel(int departmentLevel) {
        this.departmentLevel = departmentLevel;
    }

    @Basic
    @Column(name = "department_create_time", nullable = false)
    public String getDepartmentCreateTime() {
        return departmentCreateTime;
    }

    public void setDepartmentCreateTime(String departmentCreateTime) {
        this.departmentCreateTime = departmentCreateTime;
    }

    @Basic
    @Column(name = "department_is_delete", nullable = false)
    public int getDepartmentIsDelete() {
        return departmentIsDelete;
    }

    public void setDepartmentIsDelete(int departmentIsDelete) {
        this.departmentIsDelete = departmentIsDelete;
    }

    @Basic
    @Column(name = "department_parent_id", nullable = false)
    public long getDepartmentParentId() {
        return departmentParentId;
    }

    public void setDepartmentParentId(long departmentParentId) {
        this.departmentParentId = departmentParentId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_login_name", nullable = false, length = 45)
    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    @Basic
    @Column(name = "user_login_password", nullable = false, length = 45)
    public String getUserLoginPassword() {
        return userLoginPassword;
    }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 45)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_create_time", nullable = false)
    public String getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(String userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    @Basic
    @Column(name = "user_mobile", nullable = true, length = 45)
    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    @Basic
    @Column(name = "user_email", nullable = true, length = 45)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_is_delete", nullable = false)
    public int getUserIsDelete() {
        return userIsDelete;
    }

    public void setUserIsDelete(int userIsDelete) {
        this.userIsDelete = userIsDelete;
    }

    @Basic
    @Column(name = "role_id", nullable = true)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name", nullable = true, length = 45)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_create_time", nullable = true)
    public String getRoleCreateTime() {
        return roleCreateTime;
    }

    public void setRoleCreateTime(String roleCreateTime) {
        this.roleCreateTime = roleCreateTime;
    }

    @Basic
    @Column(name = "role_comment", nullable = true, length = 200)
    public String getRoleComment() {
        return roleComment;
    }

    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment;
    }

    @Basic
    @Column(name = "role_is_delete", nullable = true)
    public Integer getRoleIsDelete() {
        return roleIsDelete;
    }

    public void setRoleIsDelete(Integer roleIsDelete) {
        this.roleIsDelete = roleIsDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewBindUserDepartmentRoleEntity that = (ViewBindUserDepartmentRoleEntity) o;
        return id == that.id &&
                departmentLevel == that.departmentLevel &&
                departmentIsDelete == that.departmentIsDelete &&
                departmentParentId == that.departmentParentId &&
                userId == that.userId &&
                userIsDelete == that.userIsDelete &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(departmentCreateTime, that.departmentCreateTime) &&
                Objects.equals(userLoginName, that.userLoginName) &&
                Objects.equals(userLoginPassword, that.userLoginPassword) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userCreateTime, that.userCreateTime) &&
                Objects.equals(userMobile, that.userMobile) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(roleCreateTime, that.roleCreateTime) &&
                Objects.equals(roleComment, that.roleComment) &&
                Objects.equals(roleIsDelete, that.roleIsDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, departmentId, departmentName, departmentLevel, departmentCreateTime, departmentIsDelete, departmentParentId, userId, userLoginName, userLoginPassword, userName, userCreateTime, userMobile, userEmail, userIsDelete, roleId, roleName, roleCreateTime, roleComment, roleIsDelete);
    }
}
