package br.com.jsnsoftware.inventory.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="inventory")
public class InventoryModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="inventory_id")
    private Integer id ;
    @Column(name ="inventory_desc")
    private String desc ;
    @Column(name ="inventory_product")
    private String product ;
    @Column(name ="inventory_status")
    private String status ;
    @Column(name ="inventory_quantity")
    private Integer quantity ;
    @Column(name ="inventory_price")
    private String price ;
    @Column(name ="order_id")
    private Integer orderId ;

    public InventoryModel(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "InventoryModel{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", product='" + product + '\'' +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", price='" + price + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
