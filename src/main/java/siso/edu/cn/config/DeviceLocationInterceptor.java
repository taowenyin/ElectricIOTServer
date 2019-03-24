package siso.edu.cn.config;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import siso.edu.cn.entity.DeviceLocationEntity;

import java.io.Serializable;

public class DeviceLocationInterceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {
        return super.onPrepareStatement(sql);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

        if (entity instanceof DeviceLocationEntity) {
            System.out.println("=====DeviceLocationEntity=====");
        }

        return super.onSave(entity, id, state, propertyNames, types);
    }
}
