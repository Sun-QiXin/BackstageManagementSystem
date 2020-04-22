package tourism.backstage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tourism.backstage.entity.Permission;
import tourism.backstage.entity.Role;

import java.util.List;

/**
* @InterfaceName RoleDao
* @Description (Role)表持久层接口
* @author @孙启新
* @date 2020-04-02 13:37:14
**/
@Mapper
public interface RoleDao {

   /**
    * @Description 添加Role
    * @param role 实例对象
    * @return 影响行数
    */
   int saveRole(Role role);

   /**
    * @Description 根据id删除角色（注意：多表关联，先删除中间表）
    * @param id 主键
    * @return 影响行数
    */
   int deleteById(String id);

    /**
     * 删除Users_Role中间表中的角色信息
     * @param id
     */
   void deleteUsers_Role(String id);

    /**
     * 删除Role_permission中间表中的角色信息
     * @param id
     */
   void deleteRole_permission(String id);

   /**
    *根据id查询角色信系以及相关的权限信息
    * @param id 主键
    * @return 实例对象
    */
   Role findRoleById(String id);

   /**
    * @Description 查询全部数据
    * 分页使用MyBatis的插件实现
    * @return 对象列表
    */
   List<Role> findAllRole();

    /**
     * 查询除已有权限外角色还可以添加的权限
     * @param id
     * @return
     */
    List<Permission> findOtherPermission(String id);

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionId
     */
    void savePermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);

    /**
     * 删除角色已经添加的权限
     *
     * @param permissionId
     * @param roleId
     */
    void deleteRolePermission(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}