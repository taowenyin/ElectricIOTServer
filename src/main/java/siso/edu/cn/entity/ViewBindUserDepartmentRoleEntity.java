package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

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
    private long roleId;
    @JsonProperty("role_name")
    private String roleName;
    @JsonProperty("role_create_time")
    private String roleCreateTime;
    @JsonProperty("role_comment")
    private String roleComment;
    @JsonProperty("role_is_delete")
    private int roleIsDelete;

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
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
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
    public int getRoleIsDelete() {
        return roleIsDelete;
    }

    public void setRoleIsDelete(int roleIsDelete) {
        this.roleIsDelete = roleIsDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewBindUserDepartmentRoleEntity that = (ViewBindUserDepartmentRoleEntity) o;

        if (id != that.id) return false;
        if (departmentLevel != that.departmentLevel) return false;
        if (departmentIsDelete != that.departmentIsDelete) return false;
        if (departmentParentId != that.departmentParentId) return false;
        if (userId != that.userId) return false;
        if (userIsDelete != that.userIsDelete) return false;
        if (roleId != that.roleId) return false;
        if (roleIsDelete != that.roleIsDelete) return false;
        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (departmentCreateTime != null ? !departmentCreateTime.equals(that.departmentCreateTime) : that.departmentCreateTime != null)
            return false;
        if (userLoginName != null ? !userLoginName.equals(that.userLoginName) : that.userLoginName != null)
            return false;
        if (userLoginPassword != null ? !userLoginPassword.equals(that.userLoginPassword) : that.userLoginPassword != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userCreateTime != null ? !userCreateTime.equals(that.userCreateTime) : that.userCreateTime != null)
            return false;
        if (userMobile != null ? !userMobile.equals(that.userMobile) : that.userMobile != null) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (roleCreateTime != null ? !roleCreateTime.equals(that.roleCreateTime) : that.roleCreateTime != null)
            return false;
        if (roleComment != null ? !roleComment.equals(that.roleComment) : that.roleComment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + departmentLevel;
        result = 31 * result + (departmentCreateTime != null ? departmentCreateTime.hashCode() : 0);
        result = 31 * result + departmentIsDelete;
        result = 31 * result + (int) (departmentParentId ^ (departmentParentId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (userLoginName != null ? userLoginName.hashCode() : 0);
        result = 31 * result + (userLoginPassword != null ? userLoginPassword.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userCreateTime != null ? userCreateTime.hashCode() : 0);
        result = 31 * result + (userMobile != null ? userMobile.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (int) userIsDelete;
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleCreateTime != null ? roleCreateTime.hashCode() : 0);
        result = 31 * result + (roleComment != null ? roleComment.hashCode() : 0);
        result = 31 * result + roleIsDelete;
        return result;
    }
}
