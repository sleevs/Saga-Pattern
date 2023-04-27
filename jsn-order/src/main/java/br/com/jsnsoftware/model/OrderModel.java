package br.com.jsnsoftware.model;



import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="orders")
public class OrderModel implements Serializable {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @Id
    private Integer id ;
    @Column(name = "order_date")
    private String date ;
    @Column(name = "order_type")
    private String type ;
    @Column(name = "order_status")
    private String status ;
    @Column(name = "product_code")
    private String productCode ;
    @Column(name = "order_desc")
    private String desc ;

    @Column(name = "user_id")
    private Integer userId ;

    public OrderModel(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", productCode='" + productCode + '\'' +
                ", desc='" + desc + '\'' +
                ", userId=" + userId +
                '}';
    }
}
