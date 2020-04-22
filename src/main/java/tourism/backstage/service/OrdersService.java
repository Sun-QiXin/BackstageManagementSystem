package tourism.backstage.service;

import tourism.backstage.entity.Orders;

import java.util.List;

/**
 * Orders的业务层接口
 *
 * @author 孙启新
 */
public interface OrdersService {

    /**
     * 查询所有订单
     *
     * @param page     页码
     * @param pageSize 每页显示条数
     * @return
     */
    List<Orders> findAllOrders(int page, int pageSize);

    /**
     * 根据id查询订单详情信息（多表查询）
     * @param ordersId
     * @return
     */
    Orders findOrdersById(String ordersId);
}
