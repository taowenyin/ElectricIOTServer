package siso.edu.cn.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.DepartmentDao;
import siso.edu.cn.entity.DepartmentEntity;

import java.util.List;

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DepartmentService extends IServiceImpl<DepartmentEntity> {

    public final static String SQL_MAX_LEVEL =
            "SELECT max(department.level) FROM DepartmentEntity department";

    public final static String SQL_GET_ORGANIZATION_STRUCTURE =
            "SELECT department FROM DepartmentEntity department WHERE " +
                    "department.level = ?1 AND " +
                    "department.parentId = ?2 AND " +
                    "department.isDelete = ?3";

    private DepartmentDao departmentDao = null;

    @Autowired
    public DepartmentService(DepartmentDao dao) {
        super(dao);
        this.departmentDao = dao;
    }

    /**
     * 获取整个组织结构
     * @return JSON对象
     */
    public ArrayNode getOrganizationStructure() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<DepartmentEntity> departmentList = this.departmentDao.findByParams(
                SQL_GET_ORGANIZATION_STRUCTURE, new Object[]{0, 0L, 0});

//        ArrayNode root = objectMapper.createArrayNode();
//
//        DepartmentEntity object = departmentList.get(0);
//
//        for (int i = 0; i < departmentList.size(); i++) {
//            DepartmentEntity entity = departmentList.get(i);
//
//            JsonNode node = objectMapper.convertValue(entity, JsonNode.class);
//            root.add(node);
//        }

//        JsonNode rootNode = objectMapper.convertValue(departmentList, JsonArray.class);

//        JsonNode rootNode = objectMapper.createObjectNode().set("structure",
//                objectMapper.convertValue(departmentList, JsonNode.class));

        return null;
    }

    /**
     * 获取层级的最大值，从0开始
     * @return 最大值层级值
     */
    private int maxLevel() {
        return departmentDao.findMaxValue(SQL_MAX_LEVEL);
    }
}
