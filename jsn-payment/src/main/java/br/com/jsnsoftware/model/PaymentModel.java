package br.com.jsnsoftware.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="payment")
public class PaymentModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id")
    private Integer id ;
    @Column(name="payment_date")
    private String date ;
    @Column(name="payment_value")
    private String value ;
    @Column(name="payment_product")
    private String product ;
    @Column(name="payment_status")
    private String status ;
    @Column(name="order_id")
    private Integer orderId ;

    public PaymentModel(){}

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "PaymentModel{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", value='" + value + '\'' +
                ", product='" + product + '\'' +
                ", status='" + status + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
