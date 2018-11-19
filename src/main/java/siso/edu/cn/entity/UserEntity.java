package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collection;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user", schema = "electric_iot", catalog = "")
public class UserEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("login_name")
    private String loginName;
    @JsonProperty("login_password")
    private String loginPassword;
    @JsonProperty("name")
    private String name;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("email")
    private String email;
    @JsonProperty("is_delete")
    private int isDelete;
    @JsonIgnore
    private Collection<BindUserDepartmentRoleEntity> bindUserDepartmentRolesById;
    @JsonIgnore
    private Collection<DeviceEntity> devicesById;
    @JsonIgnore
    private Collection<UserRightRelationEntity> userRightRelationsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login_name", nullable = false, length = 45)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "login_password", nullable = false, length = 45)
    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 45)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "is_delete", nullable = false)
    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (isDelete != that.isDelete) return false;
        if (loginName != null ? !loginName.equals(that.loginName) : that.loginName != null) return false;
        if (loginPassword != null ? !loginPassword.equals(that.loginPassword) : that.loginPassword != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (loginPassword != null ? loginPassword.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + isDelete;
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<BindUserDepartmentRoleEntity> getBindUserDepartmentRolesById() {
        return bindUserDepartmentRolesById;
    }

    public void setBindUserDepartmentRolesById(Collection<BindUserDepartmentRoleEntity> bindUserDepartmentRolesById) {
        this.bindUserDepartmentRolesById = bindUserDepartmentRolesById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<DeviceEntity> getDevicesById() {
        return devicesById;
    }

    public void setDevicesById(Collection<DeviceEntity> devicesById) {
        this.devicesById = devicesById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserRightRelationEntity> getUserRightRelationsById() {
        return userRightRelationsById;
    }

    public void setUserRightRelationsById(Collection<UserRightRelationEntity> userRightRelationsById) {
        this.userRightRelationsById = userRightRelationsById;
    }
}
