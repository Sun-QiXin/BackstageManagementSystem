package tourism.backstage.service;

import tourism.backstage.entity.Permission;
import tourism.backstage.entity.Role;
import java.util.List;

/**
 * @InterfaceName RoleService
 * @Description (Role)表业务层接口
 * @author @孙启新
 * @date 2020-04-02 13:37:15
 **/
public interface RoleService {

    /**
     * @Description 添加Role
     * @param role 实例对象
     * @return 是否成功
     */
    void saveRole(Role role);

    /**
     * @Description 根据id删除角色（注意：多表关联，先删除中间表）
     * @param id 主键
     */
    void deleteById(String id);

    /**
     * @Description 根据id查询角色信系以及相关的权限信息
     * @param id 主键
     * @return 实例对象
     */
    Role findRoleById(String id);

    /**
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     * @param page
     * @param pageSize
     * @return
     */
    List<Role> findAllRole(int page, int pageSize);

    /**
     * 查询除已有权限外角色还可以添加的权限
     * @param id
     * @return
     */
    List<Permission> findOtherPermission(String id);

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionIds
     */
    void savePermissionToRole(String roleId, String[] permissionIds);

    /**
     * 删除角色已经添加的权限
     *
     * @param permissionId
     * @param roleId
     */
    void deleteRolePermission(String roleId, String permissionId);
}