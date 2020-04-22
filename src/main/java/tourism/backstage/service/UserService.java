package tourism.backstage.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import tourism.backstage.entity.Role;
import tourism.backstage.entity.UserInfo;
import tourism.backstage.service.impl.UserServiceImpl;

import java.util.List;

/**
 * 用户的业务层接口
 * UserDetailsService：使用Spring security需要继承此接口
 * @author 孙启新
 */
public interface UserService extends UserDetailsService {

    /**
     * 查询所有用户，附带分页
     * @param page
     * @param pageSize
     * @return
     */
    List<UserInfo> findAllUser(int page, int pageSize);

    /**
     * 保存用户
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);

    /**
     * 修改用户密码
     * @param id
     * @param newPassword
     */
    void updateUserById(String id, String newPassword);

    /**
     * 根据id查询用户信息以及角色和权限信息
     * @param id
     * @return
     */
    UserInfo findUserById(String id);

    /**
     * 根据id删除用户信息（注意：有中间表的约束）
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据用户的id查询除已有的角色还可以添加的角色
     * @param id
     * @return
     */
    List<Role> findOtherRole(String id);

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     */
    void saveRoleToUser(String userId, String[] roleIds);

    /**
     * 删除用户已经添加的角色
     * @param userId
     * @param roleId
     */
    void deleteUserRole(String userId, String roleId);
}
