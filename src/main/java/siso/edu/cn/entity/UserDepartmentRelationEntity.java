package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user_department_relation", schema = "electric_iot", catalog = "")
public class UserDepartmentRelationEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("user_id")
    private long userId;
    @JsonProperty("department_id")
    private long departmentId;

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
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "department_id", nullable = false)
    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDepartmentRelationEntity that = (UserDepartmentRelationEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (departmentId != that.departmentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (departmentId ^ (departmentId >>> 32));
        return result;
    }
}
