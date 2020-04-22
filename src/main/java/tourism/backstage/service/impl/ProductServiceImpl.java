package tourism.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourism.backstage.dao.ProductDao;
import tourism.backstage.service.ProductService;
import tourism.backstage.entity.Product;

import java.util.List;

/**
 * 业务层实现类
 *
 * @author 孙启新
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * 查询所有产品信息,分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<Product> FindAllProduct(int page,int pageSize) {
        //分页插件参数 pageNum:页码值，pageSize：每页显示条数
        PageHelper.startPage(page, pageSize);
        return productDao.FindAllProduct();
    }

    /**
     * 保存产品信息
     *
     * @return
     */
    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    /**
     * 根据id删除产品信息
     *
     * @param id
     */
    @Override
    public void deleteProduct(String id) {
        productDao.deleteProduct(id);
    }

    /**
     * 根据实体类的数据修改产品信息
     *
     * @param product
     */
    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    /**
     * 根据id查询产品信息
     *
     * @param id
     */
    @Override
    public Product findProductById(String id) {
        return productDao.findProductById(id);
    }

    /**
     * 根据搜索信息模糊查询并分页展示
     *
     * @param page
     * @param pageSize
     * @param searchMsg
     * @return
     */
    @Override
    public List<Product> findAllProductByMsg(int page, int pageSize, String searchMsg) {
        //分页插件参数 pageNum:页码值，pageSize：每页显示条数
        PageHelper.startPage(page, pageSize);
        return productDao.findAllProductByMsg(searchMsg);
    }
}
