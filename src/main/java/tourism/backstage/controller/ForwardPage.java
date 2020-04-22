package tourism.backstage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 负责WEB-INF目录下页面相互转发
 * @author 孙启新
 */
@Controller
@RequestMapping("/forward")
public class ForwardPage {
    /**
     * 通过视图解析器转发到WEB-INF下的product-add.jsp页面(WEB-INF下的资源时受保护的客户端不能直接访问)
     *
     * @return
     */
    @GetMapping("forwardProductAdd")
    public String forwardProductAdd() {
        return "product-add";
    }

    /**
     * 转发到changePassword.jsp页面
     * @return
     */
    @GetMapping("forwardChangePassword")
    public String forwardChangePassword(){
        return "changePassword";
    }

    /**
     * 转发到user-add.jsp页面
     * @return
     */
    @GetMapping("forwardUserAdd")
    public String forwardUserAdd(){
        return "user-add";
    }

    /**
     * 转发到role-add.jsp页面
     * @return
     */
    @GetMapping("forwardRoleAdd")
    public String forwardRoleAdd(){
        return "role-add";
    }

    /**
     * 转发到Permission-add.jsp页面
     * @return
     */
    @GetMapping("forwardPermissionAdd")
    public String forwardPermissionAdd(){
        return "permission-add";
    }
}
