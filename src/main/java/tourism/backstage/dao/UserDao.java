package tourism.backstage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tourism.backstage.entity.Role;
import tourism.backstage.entity.UserInfo;

import java.util.List;

/**
 * 用户的持久层接口
 * @author 孙启新
 */
@Mapper
public interface UserDao {

    /**
     * 根据用户名去查询用户的信息
     * @param username
     * @return
     */
    UserInfo findUserByUsername(String username);

    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAllUser();

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
    void updateUserById(@Param("userId") String id, @Param("newPassword") String newPassword);

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
     * 根据id删除用户信息（注意：有中间表的约束）
     * @param id
     */
    void deleteUsers_Role(String id);

    /**
     * 根据用户的id查询除已有的角色还可以添加的角色
     * @param id
     * @return
     */
    List<Role> findOtherRole(String id);

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     */
    void saveRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 删除用户已经添加的角色
     * @param userId
     * @param roleId
     */
    void deleteUserRole(@Param("userId") String userId, @Param("roleId") String roleId);
}
