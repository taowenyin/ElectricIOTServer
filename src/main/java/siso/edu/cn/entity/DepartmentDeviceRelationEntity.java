package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "department_device_relation", schema = "electric_iot", catalog = "")
public class DepartmentDeviceRelationEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("department_id")
    private long departmentId;
    @JsonProperty("device_id")
    private long deviceId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "department_id", nullable = false)
    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "device_id", nullable = false)
    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentDeviceRelationEntity that = (DepartmentDeviceRelationEntity) o;

        if (id != that.id) return false;
        if (departmentId != that.departmentId) return false;
        if (deviceId != that.deviceId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (departmentId ^ (departmentId >>> 32));
        result = 31 * result + (int) (deviceId ^ (deviceId >>> 32));
        return result;
    }
}
