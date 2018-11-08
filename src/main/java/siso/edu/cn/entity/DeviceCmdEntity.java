package siso.edu.cn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "device_cmd", schema = "electric_iot", catalog = "")
public class DeviceCmdEntity {
    @JsonProperty("id")
    private long id;
    @JsonProperty("cmd")
    private String cmd;
    @JsonProperty("is_send")
    private boolean isSend;
    @JsonProperty("device_id")
    private long deviceId;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("send_time")
    private String sendTime;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cmd", nullable = false)
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    @Basic
    @Column(name = "is_send", nullable = false)
    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    @Basic
    @Column(name = "device_id", nullable = false)
    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
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
    @Column(name = "send_time", nullable = true)
    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceCmdEntity that = (DeviceCmdEntity) o;

        if (id != that.id) return false;
        if (isSend != that.isSend) return false;
        if (deviceId != that.deviceId) return false;
        if (cmd != null ? !cmd.equals(that.cmd) : that.cmd != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (sendTime != null ? !sendTime.equals(that.sendTime) : that.sendTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (cmd != null ? cmd.hashCode() : 0);
        result = 31 * result + (isSend ? 1 : 0);
        result = 31 * result + (int) (deviceId ^ (deviceId >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        return result;
    }
}
