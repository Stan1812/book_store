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
     * @param ordersId 购物车的id
     * @param bookId 书籍的id
     * @return 1
     */
    @Override
    public int addOrderItemService(Long ordersId, Long bookId) {
        OrderItem orderItem = null;
        Book book = bookRepo.findBookById(bookId);
        if ((orderItem = ordersItemRepo.findByBookIdAndOrderId(bookId, ordersId)) == null) {
            orderItem = new OrderItem(1, book.getPrice(), ordersId, bookId);
            ordersItemRepo.save(orderItem);
        }
        else {
            addQuantityAndPriceByStep(orderItem, book);
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

    /**
     * 更新购物车项，加1
     * @param orderItem 购物车项
     * @return 更新哪一行
     */
    @Override
    public int addQuantityAndPriceByStep(OrderItem orderItem, Book book) {
        orderItem.setQuantity(orderItem.getQuantity() + 1);
        orderItem.setPrice(orderItem.getQuantity() * book.getPrice());
        return updateQuantityAndPrice(orderItem, orderItem.getQuantity());
    }

    @Override
    public int decQuantityAndPriceByStep(OrderItem orderItem) {
        return 0;
    }

    @Override
    public int updateQuantityAndPrice(OrderItem orderItem, Integer number) {
        return 0;
    }

    @Override
    public int deleteOrderItemById(Long id) {
        return 0;
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
