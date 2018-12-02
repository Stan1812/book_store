package com.expr.bookstore.controllers;

import com.expr.bookstore.dao.ShoppingCartRepository;
import com.expr.bookstore.entity.ShoppingCart;
import com.expr.bookstore.services.ShoppingCartServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {

//    @Autowired
//    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ShoppingCartServce scService;

    /**
     * 添加购物车项，点击加入购物车时调用，多次点击只会更新数量，在点击购物车上的+按钮也可调用此方法
     * @param bookId 书籍id
     * @param userId 用户id
     * @return Json格式的数据
     */
    @GetMapping("/add")
    @ResponseBody
    public ShoppingCart addShoppingCart(@RequestParam Integer bookId, @RequestParam Long userId) {
        return scService.addNewShoppingCart((long)bookId,(long)1);
    }

    /**
     * 更新购物车，如点击+、-，或者直接修改数量，不可以减到0
     * @param quantity 数量
     * @param id 购物车的id
     * @return 返回更新数据库所返回的整数
     */
    @PostMapping("/modify")
    @ResponseBody
    public int modify(@RequestParam Integer quantity, @RequestParam Long id) {
        return scService.updateShoppingCart(quantity, id);
    }

    /**
     * 删除购物车项
     * @param id 购物车项的id
     */
    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam Long id) {
        scService.deleteShoppingCart(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public List<ShoppingCart> getAllByUserId(Long userId) {
        return scService.queryAllShoppingCartsByUserId(userId);
    }

//    @PostMapping("/getByBookIdAndUserId")
//    @ResponseBody
//    public ShoppingCart getByBookIdAndUserId(@RequestParam Long bookId, @RequestParam Long userId) {
//        return shoppingCartRepository.findShoppingCartByBookIdAndUserId(bookId, userId);
//    }
}
