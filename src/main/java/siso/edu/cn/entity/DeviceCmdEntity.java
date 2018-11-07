package siso.edu.cn.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "device_cmd", schema = "electric_iot", catalog = "")
public class DeviceCmdEntity {
    private int id;
    private byte[] cmd;
    private byte isSend;
    private long deviceId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cmd", nullable = false)
    public byte[] getCmd() {
        return cmd;
    }

    public void setCmd(byte[] cmd) {
        this.cmd = cmd;
    }

    @Basic
    @Column(name = "is_send", nullable = false)
    public byte getIsSend() {
        return isSend;
    }

    public void setIsSend(byte isSend) {
        this.isSend = isSend;
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

        DeviceCmdEntity that = (DeviceCmdEntity) o;

        if (id != that.id) return false;
        if (isSend != that.isSend) return false;
        if (deviceId != that.deviceId) return false;
        if (!Arrays.equals(cmd, that.cmd)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(cmd);
        result = 31 * result + (int) isSend;
        result = 31 * result + (int) (deviceId ^ (deviceId >>> 32));
        return result;
    }
}
