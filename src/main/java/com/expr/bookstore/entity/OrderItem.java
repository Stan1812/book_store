package com.expr.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：订单项
 */
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;//该项所具有同种商品的数量

    private Double price;//价格

    private Long orderId;//所属用户的所有订单

    private Long bookId;//书籍的id



    private String bookName;

    public OrderItem() {
    }

    public OrderItem(Integer quantity, Double price, Long orderId, Long bookId, String bookName) {
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderId=" + orderId +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }


}
