package siso.edu.cn.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siso.edu.cn.dao.DepartmentDao;
import siso.edu.cn.entity.DepartmentEntity;

import java.util.Iterator;
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

    // 组织的数据访问对象
    private DepartmentDao departmentDao = null;
    // 组织最大层级
    private int maxDepartmentLevel = 0;

    // Log对象
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    public DepartmentService(DepartmentDao dao) {
        super(dao);
        this.departmentDao = dao;
    }

    /**
     * 获取整个组织结构
     * @return JSON对象
     */
    public JsonNode getOrganizationStructure() {
        // 获取最大层级
        this.maxDepartmentLevel = maxDepartmentLevel();
        ObjectMapper objectMapper = new ObjectMapper();
        List<DepartmentEntity> departmentList = this.departmentDao.findByParams(
                SQL_GET_ORGANIZATION_STRUCTURE, new Object[]{0, 0L, 0});

        JsonNode rootNode = objectMapper.convertValue(departmentList, JsonNode.class);

        Iterator<JsonNode> nodeIterator = rootNode.elements();
        while (nodeIterator.hasNext()) {
            ObjectNode node = (ObjectNode) nodeIterator.next();
            JsonNode nodeList = listChildren(node);
            if (nodeList != null) {
                node.set("children", listChildren(node));
            }
        }

        return rootNode;
    }

    /**
     * 获取层级的最大值，从0开始
     * @return 最大值层级值
     */
    private int maxDepartmentLevel() {
        return departmentDao.findMaxValue(SQL_MAX_LEVEL);
    }

    /**
     * 返回子节点对象
     * @param parentNode 父节点对象
     * @return JsonNode 子节点对象
     */
    private JsonNode listChildren(JsonNode parentNode) {
        // 查询下一级所有的组织
        ObjectMapper objectMapper = new ObjectMapper();
        DepartmentEntity entity = objectMapper.convertValue(parentNode, DepartmentEntity.class);
        if (entity.getLevel() < maxDepartmentLevel) {
            List<DepartmentEntity> departmentList = this.departmentDao.findByParams(
                    SQL_GET_ORGANIZATION_STRUCTURE, new Object[]{entity.getLevel() + 1, entity.getId(), 0});

            if (departmentList.size() == 0) {
                return null;
            }

            // 把所有组织转化为JSON对象
            JsonNode rootNode = objectMapper.convertValue(departmentList, JsonNode.class);
            Iterator<JsonNode> nodeIterator = rootNode.elements();
            while (nodeIterator.hasNext()) {
                ObjectNode node = (ObjectNode) nodeIterator.next();
                JsonNode nodeList = listChildren(node);
                if (nodeList != null) {
                    node.set("children", listChildren(node));
                }
            }

            return rootNode;
        }

        return null;
    }
}
