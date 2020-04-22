package tourism.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tourism.backstage.dao.UserDao;
import tourism.backstage.entity.Role;
import tourism.backstage.entity.UserInfo;
import tourism.backstage.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户的权限操作实现类
 *
 * @author 孙启新
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 对密码加密时使用的类
     */
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * 获取request对象存储用户数据
     */
    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * 获取dao对象
     */
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 用户的权限操作
     * <p>
     * 根据用户名找到用户。在实际的实现中，搜索可能区分大小写，或者不区分大小写，具体取决于实现实例的配置方式。在这种情况下，
     * 返回的<code> UserDetails </ code> 对象的用户名可能与实际请求的不同。
     *
     * @param username 接收客户端传过来的用户名
     * @return 完全填充的用户记录（从不<null </ null>）
     * @throws UsernameNotFoundException 如果找不到该用户或该用户没有就抛出异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findUserByUsername(username);

        //将查询出的用户信息存入session域中
        userInfo.setLoginTime(new Date());
        request.getSession().setAttribute("userInfo", userInfo);

        //处理自己查询出的用户对象封装成UserDetails
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 返回一个list集合，集合中是角色描述
     *
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }


    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<UserInfo> findAllUser(int page, int pageSize) {
        //分页插件参数 pageNum:页码值，pageSize：每页显示条数
        PageHelper.startPage(page, pageSize);
        return userDao.findAllUser();
    }

    /**
     * 保存用户
     *
     * @param userInfo
     */
    @Override
    public void saveUser(UserInfo userInfo) {
        //对密码进行加密操作,否则登录时不加"{noop}"无法登录
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.saveUser(userInfo);
    }

    /**
     * 修改用户密码
     *
     * @param id
     * @param newPassword
     */
    @Override
    public void updateUserById(String id, String newPassword) {
        //对密码进行加密操作,否则登录时不加"{noop}"无法登录
        newPassword = bCryptPasswordEncoder.encode(newPassword);
        userDao.updateUserById(id, newPassword);
    }

    /**
     * 根据id查询用户信息以及角色和权限信息
     *
     * @param id
     * @return
     */
    @Override
    public UserInfo findUserById(String id) {
        return userDao.findUserById(id);
    }

    /**
     * 根据id删除用户信息（注意：有中间表的约束）
     *
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        //删除用户时先删除中间表Users_Role中的数据
        userDao.deleteUsers_Role(id);
        //再删除用户表中的数据
        userDao.deleteUser(id);
    }

    /**
     * 根据用户的id查询除已有的角色还可以添加的角色
     *
     * @param id
     * @return
     */
    @Override
    public List<Role> findOtherRole(String id) {
        return userDao.findOtherRole(id);
    }

    /**
     * 给用户添加角色
     *
     * @param userId
     * @param roleIds
     */
    @Override
    public void saveRoleToUser(String userId, String[] roleIds) {
        //遍历roleIds数组取出每个角色id,依次插入表中
        for (String roleId : roleIds) {
            userDao.saveRoleToUser(userId, roleId);
        }
    }

    /**
     * 删除用户已经添加的角色
     *
     * @param userId
     * @param roleId
     */
    @Override
    public void deleteUserRole(String userId, String roleId) {
        userDao.deleteUserRole(userId, roleId);
    }
}
