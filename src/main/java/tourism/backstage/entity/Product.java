package tourism.backstage.entity;

import org.springframework.format.annotation.DateTimeFormat;
import tourism.backstage.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * PRODUCT实体类
 *
 * @author
 */
public class Product implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 编号 唯一
     */
    private String productNum;

    /**
     * 名称
     */
    private String productName;

    /**
     * 出发城市
     */
    private String cityName;

    /**
     * 出发时间
     */
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm")
    private Date departureTime;
    private String departureTimeStr;

    /**
     * 产品价格
     */
    private Double productPrice;

    /**
     * 产品信息
     */
    private String productDesc;

    /**
     * 状态 0 关闭 1 开启
     */
    private Integer productStatus;
    private String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (departureTime != null) {
            departureTimeStr = DateUtils.dateToString(departureTime, "yyyy-mm-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus != null) {
            //状态 0 关闭 1 开启
            if (productStatus == 0) {
                productStatusStr = "关闭";
            } else {
                productStatusStr = "开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}