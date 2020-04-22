package tourism.backstage.dao;

import tourism.backstage.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author @孙启新
 * @InterfaceName PermissionDao
 * @Description (Permission)表持久层接口
 * @date 2020-04-02 14:44:50
 **/
@Mapper
public interface PermissionDao {

    /**
     * @param permission 实例对象
     * @return 影响行数
     * @Description 添加Permission
     */
    int savePermission(Permission permission);

    /**
     * 根据id删除权限信息（注意：先删除中间表）
     *
     * @param id 主键
     * @return 影响行数
     */
    int deletePermissionById(String id);

    /**
     * 删除匹配的role_permission表中的权限信息
     * @param id
     * @return
     */
    int deleteRole_permissionById(String id);

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
    List<Permission> findAllPermission();
}