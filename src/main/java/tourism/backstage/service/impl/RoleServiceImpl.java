package tourism.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import tourism.backstage.entity.Permission;
import tourism.backstage.entity.Role;
import tourism.backstage.dao.RoleDao;
import tourism.backstage.entity.UserInfo;
import tourism.backstage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author @孙启新
 * @ClassName RoleServiceImpl
 * @Description (Role)表业务层接口实现类
 * @date 2020-04-02 13:37:16
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    protected RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * @param role 实例对象
     * @return 是否成功
     * @Description 添加Role
     */
    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    /**
     * 根据id删除角色（注意：多表关联，先删除中间表）
     *
     * @param id 主键
     * @Description 删除Role
     */
    @Override
    public void deleteById(String id) {
        //删除Users_Role中间表中的角色信息
        roleDao.deleteUsers_Role(id);
        //删除Role_permission中间表中的角色信息
        roleDao.deleteRole_permission(id);
        //最后删除角色表中的信息
        roleDao.deleteById(id);
    }

    /**
     * 根据id查询角色信系以及相关的权限信息
     *
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    @Override
    public Role findRoleById(String id) {
        return roleDao.findRoleById(id);
    }

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    @Override
    public List<Role> findAllRole(int page, int pageSize) {
        //分页插件参数 pageNum:页码值，pageSize：每页显示条数
        PageHelper.startPage(page, pageSize);
        return roleDao.findAllRole();
    }

    /**
     * 查询除已有权限外角色还可以添加的权限
     *
     * @param id
     * @return
     */
    @Override
    public List<Permission> findOtherPermission(String id) {
        return roleDao.findOtherPermission(id);
    }

    /**
     * 给角色添加权限
     *
     * @param roleId
     * @param permissionIds
     */
    @Override
    public void savePermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.savePermissionToRole(roleId, permissionId);
        }
    }

    /**
     * 删除角色已经添加的权限
     *
     * @param roleId
     * @param permissionId
     */
    @Override
    public void deleteRolePermission(String roleId, String permissionId) {
        roleDao.deleteRolePermission(roleId, permissionId);
    }

}