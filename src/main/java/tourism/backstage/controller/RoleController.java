package tourism.backstage.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import tourism.backstage.entity.Permission;
import tourism.backstage.entity.Role;
import tourism.backstage.entity.UserInfo;
import tourism.backstage.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Role)表表现层
 *
 * @author @孙启新
 * @since 2020-04-02 13:37:16
 */
@Controller
@RequestMapping("role")
public class RoleController {
    /**
     * Service对象
     */
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 查询所有数据并分页
     *
     * @param page     开始页数
     * @param pageSize 每页显示条数
     * @return
     */
    @GetMapping("findAllRole")
    public ModelAndView findAllRole(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAllRole(page, pageSize);
        mv.addObject("roleList", roleList);

        //pageInfo就是一个分页的Bean,里面包含基本的分页信息
        PageInfo pageInfo = new PageInfo(roleList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @PostMapping("saveRole")
    public String saveRole(Role role) {
        roleService.saveRole(role);
        String View = "redirect:findAllRole";
        return View;
    }

    /**
     * 根据id删除角色（注意：多表关联，先删除中间表）
     *
     * @param id
     * @return
     */
    @GetMapping("deleteRole")
    public String deleteRole(String id) {
        roleService.deleteById(id);
        String View = "redirect:findAllRole";
        return View;
    }

    /**
     * 根据id查询角色信系以及相关的权限信息
     *
     * @param id
     * @return
     */
    @GetMapping("findRoleById")
    public ModelAndView findRoleById(String id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findRoleById(id);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }

    /**
     * 查询角色以及角色还可以添加的权限
     *
     * @param id
     * @return
     */
    @GetMapping("findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(String id) {
        ModelAndView mv = new ModelAndView();
        //根据角色的id查询角色
        Role role = roleService.findRoleById(id);
        //根据用户的id查询除已有的角色还可以添加的角色
        List<Permission> otherPermissions = roleService.findOtherPermission(id);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    /**
     * 给用户添加角色
     *
     * @param roleId
     * @return
     */
    @PostMapping("savePermissionToRole")
    public String savePermissionToRole(String roleId, String[] PermissionIds) {
        roleService.savePermissionToRole(roleId, PermissionIds);
        String View = "redirect:findRoleByIdAndAllPermission?id="+roleId+"";
        return View;
    }

    /**
     * 删除角色已经添加的权限
     *
     * @param permissionId
     * @param roleId
     * @return
     */
    @GetMapping("deleteRolePermission")
    public String deleteRolePermission(String roleId, String permissionId) {
        roleService.deleteRolePermission(roleId, permissionId);
        String View = "redirect:findRoleByIdAndAllPermission?id="+roleId+"";
        return View;
    }
}