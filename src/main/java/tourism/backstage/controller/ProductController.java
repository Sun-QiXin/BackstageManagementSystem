package tourism.backstage.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tourism.backstage.entity.Product;
import tourism.backstage.service.ProductService;

import javax.jws.WebParam;
import java.util.List;

/**
 * Product的表现层实现类
 *
 * @author 孙启新
 */
@Controller
@RequestMapping("product")
public class ProductController {
    private String uuid;

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 查询所有产品信息，附带分页展示
     * @RolesAllowed注解： 只有Product角色才可以访问这个方法
     *                  (jsr250的方式：需要先在Security配置文件中开启,可以省略ROLE_前缀)
     *
     * @PreAuthorize("permitAll()") : 所有用户都可查看
     * @return
     */
    /**@RolesAllowed("Product")*/
    @GetMapping("findAllProduct")
    @PreAuthorize("permitAll()")
    public ModelAndView findAllProduct(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.FindAllProduct(page, pageSize);
        //pageInfo就是一个分页的Bean,里面包含基本的分页信息
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 保存产品信息
     *
     * @param product 客户端提交的数据
     * @PreAuthorize注解： 只有用户名是孙启新或admin的才可以访问这个方法
     */
    @PostMapping("saveProduct")
    @PreAuthorize("authentication.principal.username=='孙启新' || authentication.principal.username=='admin'")
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        //重定向
        String view = "redirect:findAllProduct";
        return view;
    }

    /**
     * 根据id删除产品信息
     *
     * @param id
     * @return
     */
    @GetMapping("deleteProduct")
    @PreAuthorize("authentication.principal.username=='孙启新' || authentication.principal.username=='admin'")
    public void deleteProduct(String id) {
        productService.deleteProduct(id);
    }

    /**
     * 根据id查询产品信息
     *
     * @param id
     * @return
     */
    @GetMapping("findProductById")
    @PreAuthorize("permitAll()")
    public ModelAndView findProductById(String id) {
        ModelAndView mv = new ModelAndView();
        Product product = productService.findProductById(id);
        mv.addObject("product", product);
        mv.setViewName("product-details");
        return mv;
    }

    /**
     * 根据id查询产品信息
     *
     * @param id
     * @return
     */
    @GetMapping("findProductById2")
    @PreAuthorize("permitAll()")
    public ModelAndView findProductById2(String id) {
        ModelAndView mv = new ModelAndView();
        //存储id
        uuid = id;
        Product product = productService.findProductById(id);
        mv.addObject("product", product);
        mv.setViewName("product-edit");
        return mv;
    }

    /**
     * 根据实体类的数据修改产品信息
     *
     * @param product
     */
    @RequestMapping("updateProduct")
    @PreAuthorize("authentication.principal.username=='孙启新' || authentication.principal.username=='admin'")
    public String updateProduct(Product product) {
        if (uuid != null && !"".equals(uuid)) {
            product.setId(uuid);
        }
        productService.updateProduct(product);
        uuid = null;
        //重定向
        String view = "redirect:findAllProduct";
        return view;
    }

    /**
     * 根据搜索信息模糊查询并分页展示
     * @param page
     * @param pageSize
     * @param searchMsg
     * @return
     */
    @GetMapping("findAllProductByMsg")
    public ModelAndView findAllProductByMsg(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize,String searchMsg){
        ModelAndView mv = new ModelAndView();
        mv.addObject("searchMsg", searchMsg);
        List<Product> products = productService.findAllProductByMsg(page, pageSize,searchMsg);
        //pageInfo就是一个分页的Bean,里面包含基本的分页信息
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list-search");
        return mv;
    }
}
