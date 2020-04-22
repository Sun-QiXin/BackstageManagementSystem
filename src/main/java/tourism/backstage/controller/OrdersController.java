package tourism.backstage.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tourism.backstage.entity.Orders;
import tourism.backstage.service.OrdersService;

import java.util.List;

/**
 * Orders的表现层实现类
 *
 * @author 孙启新
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    private OrdersService ordersService;

    @Autowired
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    /**
     * 查询所有订单信息,附带分页
     * @Secured注解： 只有Product角色才可以访问这个方法
     *              (Spring Security的方式：需要先在Security配置文件中开启并且需要写前缀名ROLE_)
     * @param page
     * @param pageSize
     * @PreAuthorize("permitAll()") : 所有用户都可查看
     * @return
     */
    /**@Secured("ROLE_PRODUCT")*/
    @GetMapping("findAllOrders")
    @PreAuthorize("permitAll()")
    public ModelAndView findAllOrders(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAllOrders(page, pageSize);
        //pageInfo就是一个分页的Bean,里面包含基本的分页信息
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    /**
     * 根据id查询订单详情信息（多表查询）
     * @param ordersId
     * @return
     */
    @GetMapping("findOrdersById")
    @PreAuthorize("permitAll()")
    public ModelAndView findOrdersById(@RequestParam(name = "id",required = true) String ordersId){
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findOrdersById(ordersId);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
