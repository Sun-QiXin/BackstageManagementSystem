package tourism.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourism.backstage.dao.OrdersDao;
import tourism.backstage.entity.Orders;
import tourism.backstage.service.OrdersService;

import java.util.List;

/**
 * Orders的业务层实现类
 *
 * @author 孙启新
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    private OrdersDao ordersDao;

    @Autowired
    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    /**
     * 查询所有订单
     *
     * @param page     页码
     * @param pageSize 每页显示条数
     * @return
     */
    @Override
    public List<Orders> findAllOrders(int page, int pageSize) {
        //参数 pageNum:页码值，pageSize：每页显示条数
        PageHelper.startPage(page, pageSize);
        return ordersDao.findAllOrders();
    }

    /**
     * 根据id查询订单详情信息（多表查询）
     *
     * @param ordersId
     * @return
     */
    @Override
    public Orders findOrdersById(String ordersId) {
        return ordersDao.findOrdersById(ordersId);
    }

}
