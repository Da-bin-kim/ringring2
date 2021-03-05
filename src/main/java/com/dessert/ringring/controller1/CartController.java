package com.dessert.ringring.controller1;

import com.dessert.ringring.domain.DTOCart;
import com.dessert.ringring.domain.DTOMember;
import com.dessert.ringring.service.ServiceCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    DTOMember member;
    @Autowired
    DTOCart cart;
    @Autowired
    ServiceCart cartMapper;

    @GetMapping("/cart")
    public String OpenCart(RedirectAttributes redirect, HttpServletRequest req, HttpSession session){
        member=(DTOMember)session.getAttribute("member");
        String id=member.getId();
        System.out.println(id);
        List<DTOCart> listCart=cartMapper.listCart(id);

        req.getSession().setAttribute("list",listCart);
        redirect.addAttribute("contentPage","goods/cart.jsp");

        return "redirect:mainForm";
    }
}
