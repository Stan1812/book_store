package com.expr.bookstore.controllers;

import com.expr.bookstore.entity.ShoppingCart;
import com.expr.bookstore.services.ShoppingCartServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServce scService;

    /**
     * 添加购物车项，点击加入购物车时调用，多次点击只会更新数量，在点击购物车上的+按钮也可调用此方法
     * @param userId 用户id
     * @param bookId 书籍id
     * @return Json格式的数据
     */
    @PostMapping("/add")
    @ResponseBody
    public ShoppingCart addShoppingCart(@RequestParam Long userId, @RequestParam Long bookId) {
        return scService.addNewShoppingCart(userId, bookId);
    }

    /**
     * 更新购物车，如点击+、-，或者直接修改数量，不可以减到0
     * @param number 数量
     * @param id 购物车的id
     * @return 返回更新数据库所返回的整数
     */
    @PostMapping("/modify")
    @ResponseBody
    public int modify(@RequestParam Integer number, @RequestParam Long id) {
        return scService.updateShoppingCart(number, id);
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
}
