package br.com.jsnsoftware.model;

public class PaymentModel {


    private String id ;
    private String date ;
    private String status ;
    private String value ;
    private String product ;

    private Integer orderId ;


    public PaymentModel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", value='" + value + '\'' +
                ", product='" + product + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
