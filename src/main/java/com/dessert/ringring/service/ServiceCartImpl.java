package com.dessert.ringring.service;

import com.dessert.ringring.domain.DTOCart;
import com.dessert.ringring.domain.DTOMember;
import com.dessert.ringring.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ServiceCartImpl implements ServiceCart {

    @Autowired
    DTOCart cart;

    @Autowired
    CartMapper cartMapper;

    @Override
    public int insertCart(HttpServletRequest req, DTOMember member) {

        cart.setId(member.getId());
        int amount = Integer.parseInt(req.getParameter("amount"));
        cart.setAmount(amount);
        int productIdx = Integer.parseInt(req.getParameter("productIdx"));
        cart.setProductIdx(productIdx);
        int price = Integer.parseInt(req.getParameter("price"));
        cart.setPrice(price);
        return cartMapper.insertCart(cart);
    }

    @Override
    public List<DTOCart> listCart(String id) {
        return cartMapper.listCart(id);
    }

    @Override
    public int updateCart(HttpServletRequest req) {
        return 0;
    }

    @Override
    public int deleteCart(HttpServletRequest req) {
        return 0;
    }

    @Override
    public int sumMoney(HttpServletRequest req) {
        return 0;
    }

    @Override
    public int deleteAll(HttpServletRequest req) {
        return 0;
    }

    @Override
    public int countCart(HttpServletRequest req) {
        return 0;
    }
}
