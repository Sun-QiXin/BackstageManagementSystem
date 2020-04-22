package tourism.backstage.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tourism.backstage.entity.Product;

import java.util.List;

/**
 * 持久层接口
 *
 * @author 孙启新
 */
@Mapper
public interface ProductDao {

    /**
     * 查询所有产品信息
     *
     * @return list集合
     */
    @Select("select id, productNum, productName, cityName, departureTime,productPrice,productDesc,productStatus from product")
    List<Product> FindAllProduct();

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
    @Delete("delete product where id=#{id}")
    void deleteProduct(String id);

    /**
     * 根据实体类的数据修改产品信息
     * @param product
     */
    void updateProduct(Product product);

    /**
     * 根据id查询产品信息
     * @param id
     * @return Product
     */
    @Select("select productNum, productName, cityName, departureTime,productPrice,productDesc,productStatus from product where id = #{id}")
    Product findProductById(String id);

    /**
     * 根据搜索信息模糊查询并分页展示
     *
     * @param searchMsg
     * @return
     */
    List<Product> findAllProductByMsg(String searchMsg);
}
