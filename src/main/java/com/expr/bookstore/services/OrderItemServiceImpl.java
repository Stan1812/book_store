package com.expr.bookstore.services;

import com.expr.bookstore.entity.Book;
import com.expr.bookstore.entity.OrderItem;
import com.expr.bookstore.dao.BookRepository;
import com.expr.bookstore.dao.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository ordersItemRepo;

    @Override
    public OrderItem addOrderItem(Integer quantity, Double price, Long orderId, Long bookId,String bookName) {
        OrderItem orderItem = new OrderItem(quantity, price, orderId, bookId,bookName);
        ordersItemRepo.save(orderItem);
        return orderItem;
    }

//    /**
//     * 判断购物车中是否有该购物车项
//     * @param bookId 书籍的id
//     * @param orderId 购物车的id
//     * @return 存在与否
//     */
//    @Override
//    public boolean isExisted(Long bookId, Long orderId) {
//        return !(ordersItemRepo.findByBookIdAndOrderId(bookId, orderId) == null);
//    }

//    /**
//     * 更新购物车项，数量加一
//     * @param orderItem 购物车项
//     * @return 更新哪一行
//     */
//    @Override
//    public int addQuantityAndPriceByStep(OrderItem orderItem) {
//        Book book = bookRepo.findBookById(orderItem.getBookId());
//        orderItem.setQuantity(orderItem.getQuantity() + 1);
//        orderItem.setPrice(orderItem.getQuantity() * book.getPrice());
//        return updateQuantityAndPrice(orderItem.getQuantity(), orderItem.getPrice(), orderItem.getId());
//    }
//
//    /**
//     * 更新购物车项，数量减一
//     * @param orderItem 购物车项
//     * @return 更新哪一行
//     */
//    @Override
//    public int decQuantityAndPriceByStep(OrderItem orderItem) {
//        Book book = bookRepo.findBookById(orderItem.getBookId());
//        orderItem.setQuantity(orderItem.getQuantity() - 1);
//        orderItem.setPrice(orderItem.getQuantity() * book.getPrice());
//        updateQuantityAndPrice(orderItem.getQuantity(), orderItem.getPrice(), orderItem.getId());
//        return 0;
//    }

    /**
     * 通过orderItemId删除购物车单项
     * @param id orderItemId
     */
    @Override
    public void deleteOrderItemById(Long id) {
        ordersItemRepo.deleteById(id);
    }

    /**
     * 通过id查询订单项
     * @param id 订单项号
     * @return 订单实体
     */
    @Override
    public OrderItem queryOrderItemById(Long id) {
        return ordersItemRepo.findOrderItemById(id);
    }

    /**
     * 通过orderId查询所有订单项
     * @param orderId 购物车id
     * @return 购物车项列表
     */
    @Override
    public List<OrderItem> queryOrderItemsByOrderId(Long orderId) {
        return ordersItemRepo.findAllByOrderId(orderId);
    }
}
