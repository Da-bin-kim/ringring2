package com.dessert.ringring.service;

<<<<<<< HEAD
import com.dessert.ringring.domain.DTOCart;
import com.dessert.ringring.domain.DTOMember;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ServiceCart {
    int insertCart(HttpServletRequest req, DTOMember member);
    List<DTOCart> listCart(String id);
    int updateCart(HttpServletRequest req);
    int deleteCart(HttpServletRequest req);
    int sumMoney(HttpServletRequest req);
    int deleteAll(HttpServletRequest req);
    int countCart(HttpServletRequest req);
=======
import javax.servlet.http.HttpServletRequest;

public interface ServiceCart {
    int insertCart(HttpServletRequest req);
>>>>>>> mina/main

}
