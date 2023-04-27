package br.com.jsnsoftware.notification.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="notification")
public class NotificationModel implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notification_id")
    private Integer id;
    @Column(name="notification_status")
    private String status ;
    @Column(name="notification_type")
    private String type ;
    @Column(name="notification_date")
    private String date ;
    @Column(name="notification_desc")
    private String desc ;
    @Column(name="order_id")
    private Integer orderId ;

    public NotificationModel(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "NotificationModel{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", desc='" + desc + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
