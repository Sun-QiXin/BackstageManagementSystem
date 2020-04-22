package tourism.backstage.dao;

import org.apache.ibatis.annotations.Mapper;
import tourism.backstage.entity.Orders;

import java.util.List;

/**
 * Orders的持久层接口
 * @author 孙启新
 */
@Mapper
public interface OrdersDao {

    /**
     * 查询所有订单
     * @return
     */
    List<Orders> findAllOrders();

    /**
     * 根据id查询订单详情信息（多表查询）
     * @param ordersId
     * @return
     */
    Orders findOrdersById(String ordersId);
}
