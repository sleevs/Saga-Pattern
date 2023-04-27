package br.com.jsnsoftware.shipping.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="shipping")
public class ShippingModel implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="shipping_id")
    private Integer id ;
    @Column(name ="shipping_status")
    private String status ;
    @Column(name ="shipping_date")
    private String date ;
    @Column(name ="shipping_type")
    private String type ;
    @Column(name ="shipping_desc")
    private String desc ;
    @Column(name ="shipping_product")
    private String product ;
    @Column(name ="order_id")
    private Integer orderId;


    public ShippingModel(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "ShippingModel{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", product='" + product + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
