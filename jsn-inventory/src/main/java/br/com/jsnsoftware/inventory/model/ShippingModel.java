package br.com.jsnsoftware.inventory.model;

public class ShippingModel {


    private String status ;
    private Integer orderId;
    private String product ;
    private String type ;
    private String desc ;

    public ShippingModel(){}

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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    @Override
    public String toString() {
        return "ShippingModel{" +
                "status='" + status + '\'' +
                ", orderId=" + orderId +
                ", product='" + product + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
