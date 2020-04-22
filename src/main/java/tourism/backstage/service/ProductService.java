package tourism.backstage.service;

import tourism.backstage.entity.Product;

import java.util.List;

/**
 * 业务层接口
 *
 * @author 孙启新
 */
public interface ProductService {
    /**
     * 查询所有产品信息,分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<Product> FindAllProduct(int page, int pageSize);

    /**
     * 保存产品信息
     *
     * @param product
     */
    void saveProduct(Product product);

    /**
     * 根据id删除产品信息
     *
     * @param id
     */
    void deleteProduct(String id);

    /**
     * 根据实体类的数据修改产品信息
     *
     * @param product
     */
    void updateProduct(Product product);

    /**
     * 根据id查询产品信息
     *
     * @param id
     */
    Product findProductById(String id);

    /**
     * 根据搜索信息模糊查询并分页展示
     *
     * @param page
     * @param pageSize
     * @param searchMsg
     * @return
     */
    List<Product> findAllProductByMsg(int page, int pageSize, String searchMsg);
}
