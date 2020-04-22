package tourism.backstage.service;

import tourism.backstage.entity.Permission;

import java.util.List;

/**
 * @author @孙启新
 * @InterfaceName PermissionService
 * @Description (Permission)表业务层接口
 * @date 2020-04-02 14:44:50
 **/
public interface PermissionService {

    /**
     * @param permission 实例对象
     * @return 是否成功
     * @Description 添加Permission
     */
    void savePermission(Permission permission);

    /**
     * 根据id删除权限信息（注意：先删除中间表）
     *
     * @param id 主键
     * @return 是否成功
     */
    void deletePermissionById(String id);

    /**
     * 根据id查询拥有Permission权限的用户
     *
     * @param id 主键
     * @return 实例对象
     */
    Permission findPermissionById(String id);

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Permission> findAllPermission(int page, int pageSize);
}