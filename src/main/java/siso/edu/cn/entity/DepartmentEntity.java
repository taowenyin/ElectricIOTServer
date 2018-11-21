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
@Table(name = "department", schema = "electric_iot", catalog = "")
public class DepartmentEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private int level;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("is_delete")
    private int isDelete;
    @JsonProperty("parent_id")
    private long parentId;
    @JsonIgnore
    private Collection<BindUserDepartmentRoleEntity> bindUserDepartmentRolesById;
    @JsonIgnore
    private Collection<DeviceEntity> devicesById;

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
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
    @Column(name = "is_delete", nullable = false)
    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Basic
    @Column(name = "parent_id", nullable = false)
    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (id != that.id) return false;
        if (level != that.level) return false;
        if (isDelete != that.isDelete) return false;
        if (parentId != that.parentId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + isDelete;
        result = 31 * result + (int) (parentId ^ (parentId >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<BindUserDepartmentRoleEntity> getBindUserDepartmentRolesById() {
        return bindUserDepartmentRolesById;
    }

    public void setBindUserDepartmentRolesById(Collection<BindUserDepartmentRoleEntity> bindUserDepartmentRolesById) {
        this.bindUserDepartmentRolesById = bindUserDepartmentRolesById;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<DeviceEntity> getDevicesById() {
        return devicesById;
    }

    public void setDevicesById(Collection<DeviceEntity> devicesById) {
        this.devicesById = devicesById;
    }
}
