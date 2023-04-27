package br.com.jsnsoftware.model;

public class InventoryModel {


    private Integer id ;

    private String status ;
    private String desc ;
    private String product ;

    private Integer quantity ;
    private String price ;
    private Integer orderId ;

    public InventoryModel(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "InventoryModel{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", price='" + price + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
