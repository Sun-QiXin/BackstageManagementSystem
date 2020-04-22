package tourism.backstage.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tourism.backstage.entity.Role;
import tourism.backstage.entity.UserInfo;
import tourism.backstage.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * User的表现层
 *
 * @author 孙启新
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查询所有用户，附带分页效果
     *
     * @return
     * @PreAuthorize注解： 只有ADMIN和USER角色才可以访问这个方法
     * (Spring Security的方式：支持Spring EL表达式，需要先在Security配置文件中开启并且需要写前缀名ROLE_)
     */
    @GetMapping("findAllUser")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ModelAndView findAllUser(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = userService.findAllUser(page, pageSize);
        //pageInfo就是一个分页的Bean,里面包含基本的分页信息
        PageInfo pageInfo = new PageInfo(userInfoList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("userList", userInfoList);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 保存用户信息
     *
     * @param userInfo
     * @return
     * @PreAuthorize注解： 只有用户名是孙启新或admin的才可以访问这个方法
     * (Spring Security的方式：支持Spring EL表达式)
     */
    @PostMapping("saveUser")
    @PreAuthorize("authentication.principal.username=='孙启新' || authentication.principal.username=='admin'")
    public String saveUser(UserInfo userInfo) {
        userService.saveUser(userInfo);
        String View = "redirect:findAllUser";
        return View;
    }

    /**
     * 根据用户传入的数据修改用户密码
     *
     * @param id          用户唯一id
     * @param newPassword 新密码
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("updateUserById")
    public void updateUserById(String id, String newPassword, HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.updateUserById(id, newPassword);
        //调用Spring security的退出请求路径
        response.sendRedirect(request.getContextPath() + "/logout");
    }

    /**
     * 根据id查询用户信息以及角色和权限信息
     *
     * @param id
     * @return
     */
    @GetMapping("findUserById")
    public ModelAndView findUserById(String id) {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findUserById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 根据id删除用户信息（注意：有中间表的约束）
     *
     * @param id
     * @return
     */
    @GetMapping("deleteUser")
    @PreAuthorize("authentication.principal.username=='孙启新'")
    public String deleteUser(String id) {
        userService.deleteUser(id);
        String View = "redirect:findAllUser";
        return View;
    }

    /**
     * 查询用户以及用户可以添加的角色
     *
     * @param id
     * @return
     */
    @GetMapping("findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id) {
        ModelAndView mv = new ModelAndView();
        //根据用户的id查询用户
        UserInfo userInfo = userService.findUserById(id);
        //根据用户的id查询除已有的角色还可以添加的角色
        List<Role> otherRoles = userService.findOtherRole(id);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 给用户添加角色
     *
     * @param userId
     * @return
     */
    @PostMapping("saveRoleToUser")
    public String saveRoleToUser(String userId, String[] RoleIds) {
        userService.saveRoleToUser(userId, RoleIds);
        String View = "redirect:findUserByIdAndAllRole?id=" + userId + "";
        return View;
    }

    /**
     * 删除用户已经添加的角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    @GetMapping("deleteUserRole")
    public String deleteUserRole(String userId, String roleId) {
        userService.deleteUserRole(userId, roleId);
        String View = "redirect:findUserByIdAndAllRole?id=" + userId + "";
        return View;
    }
}
