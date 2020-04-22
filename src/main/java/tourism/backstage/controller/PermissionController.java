package tourism.backstage.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import tourism.backstage.entity.Permission;
import tourism.backstage.entity.Role;
import tourism.backstage.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Permission)表表现层
 *
 * @author @孙启新
 * @since 2020-04-02 14:44:50
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    /**
     * Service对象
     */
    private PermissionService permissionService;

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * 查询所有数据并分页展示
     *
     * @param page
     * @param pageSize
     * @return 所有数据
     */
    @GetMapping("findAllPermission")
    public ModelAndView findAllPermission(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAllPermission(page, pageSize);
        //pageInfo就是一个分页的Bean,里面包含基本的分页信息
        PageInfo pageInfo = new PageInfo(permissionList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("permissionList", permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    /**
     * 添加角色
     *
     * @param permission
     * @return
     */
    @PostMapping("savePermission")
    public String savePermission(Permission permission) {
        permissionService.savePermission(permission);
        String View = "redirect:findAllPermission";
        return View;
    }

    /**
     * 根据id查询拥有Permission权限的用户
     * @param id
     * @return
     */
    @GetMapping("findPermissionById")
    public ModelAndView findPermissionById(String id){
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.findPermissionById(id);
        mv.addObject("permission", permission);
        mv.setViewName("permission-show");
        return mv;
    }

    /**
     * 根据id删除权限信息（注意：先删除中间表）
     * @param id
     * @return
     */
    @GetMapping("deletePermissionById")
    public String deletePermissionById(String id){
        permissionService.deletePermissionById(id);
        String View = "redirect:findAllPermission";
        return View;
    }
}