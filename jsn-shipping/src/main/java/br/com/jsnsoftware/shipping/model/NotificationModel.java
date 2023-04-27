package br.com.jsnsoftware.shipping.model;

public class NotificationModel {


    private Integer id;
    private String status ;
    private String type ;
    private String date ;
    private String desc ;
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
