package com.expr.bookstore.services;

import com.expr.bookstore.dao.entity.Book;
import com.expr.bookstore.dao.entity.OrderItem;
import com.expr.bookstore.dao.repository.BookRepository;
import com.expr.bookstore.dao.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private OrderItemRepository ordersItemRepo;

    /**
     * 添加购物车项，如果已在购物车中，就增加数量和价格，否则添加进数据库
     * @param orderId 购物车的id
     * @param bookId 书籍的id
     * @return 1
     */
    @Override
    public int addOrderItemService(Long orderId, Long bookId) {
        OrderItem orderItem = null;
        Book book = bookRepo.findBookById(bookId);
        //用户购物车中没有该项，插入数据库中
        if ((orderItem = ordersItemRepo.findOrderItemByBookIdAndOrderId(bookId, orderId)) == null) {
            orderItem = new OrderItem(1, book.getPrice(), orderId, bookId);
            ordersItemRepo.save(orderItem);
        }
        //用户购物车中已存在该项，则更新购物车项，数量增加1， 价格也相应增加
        else {
            orderItem.setQuantity(orderItem.getQuantity() - 1);
            orderItem.setPrice(orderItem.getQuantity() * book.getPrice());
            updateQuantityAndPrice(orderItem.getQuantity(), orderItem.getPrice(), orderItem.getId());
        }
        return 1;
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
     * 更新数量和价格
     * @param number 数量
     * @param price 价格
     * @param id orderItemId
     * @return 更新的哪一行
     */
    @Override
    public int updateQuantityAndPrice(Integer number, Double price, Long id) {
        return ordersItemRepo.modifyById(number, price, id);
    }

    /**
     * 通过orderItemId删除购物车单项
     * @param id orderItemId
     */
    @Override
    public void deleteOrderItemById(Long id) {
        ordersItemRepo.deleteById(id);
    }

    /**
     * 查询用户购物车中的所有项
     * @param orderId 购物车id
     * @return 购物车项列表
     */
    @Override
    public List<OrderItem> queryOrderItemsByOrderId(Long orderId) {
        return ordersItemRepo.findAllByOrderId(orderId);
    }
}
