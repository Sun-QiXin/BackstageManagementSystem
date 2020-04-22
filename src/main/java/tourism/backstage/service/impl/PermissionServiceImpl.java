package tourism.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import tourism.backstage.entity.Permission;
import tourism.backstage.dao.PermissionDao;
import tourism.backstage.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author @孙启新
 * @ClassName PermissionServiceImpl
 * @Description (Permission)表业务层接口实现类
 * @date 2020-04-02 14:44:50
 **/
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    protected PermissionDao permissionDao;

    @Autowired
    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    /**
     * @param permission 实例对象
     * @return 是否成功
     * @Description 添加Permission
     */
    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }

    /**
     * 根据id删除权限信息（注意：先删除中间表）
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deletePermissionById(String id) {
        //删除匹配的role_permission表中的权限信息
        permissionDao.deleteRole_permissionById(id);
        //再删除Permission中的权限
        permissionDao.deletePermissionById(id);
    }

    /**
     * 根据id查询拥有Permission权限的用户
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Permission findPermissionById(String id) {
        return permissionDao.findPermissionById(id);
    }

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    @Override
    public List<Permission> findAllPermission(int page, int pageSize) {
        //分页插件参数 pageNum:页码值，pageSize：每页显示条数
        PageHelper.startPage(page, pageSize);
        return permissionDao.findAllPermission();
    }
}