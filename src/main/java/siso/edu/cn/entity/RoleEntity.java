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
@Table(name = "role", schema = "electric_iot", catalog = "")
public class RoleEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("is_delete")
    private int isDelete;
    @JsonIgnore
    private Collection<BindUserDepartmentRoleEntity> bindUserDepartmentRolesById;
    @JsonIgnore
    private Collection<RoleRightRelationEntity> roleRightRelationsById;

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
    @Column(name = "comment", nullable = true, length = 200)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (isDelete != that.isDelete) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + isDelete;
        return result;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<BindUserDepartmentRoleEntity> getBindUserDepartmentRolesById() {
        return bindUserDepartmentRolesById;
    }

    public void setBindUserDepartmentRolesById(Collection<BindUserDepartmentRoleEntity> bindUserDepartmentRolesById) {
        this.bindUserDepartmentRolesById = bindUserDepartmentRolesById;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<RoleRightRelationEntity> getRoleRightRelationsById() {
        return roleRightRelationsById;
    }

    public void setRoleRightRelationsById(Collection<RoleRightRelationEntity> roleRightRelationsById) {
        this.roleRightRelationsById = roleRightRelationsById;
    }
}
