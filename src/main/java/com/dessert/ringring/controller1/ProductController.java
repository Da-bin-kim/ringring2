package com.dessert.ringring.controller1;

import com.dessert.ringring.domain.DTOGoods;
import com.dessert.ringring.domain.DTOMember;
import com.dessert.ringring.service.ServiceCart;
import com.dessert.ringring.service.ServiceGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ServiceGoods goods;
    @Autowired
    DTOGoods dtoGoods;
    @Autowired
    DTOMember member;
    @Autowired
    ServiceCart cart;
    //상품 리스트 불러오기
    @GetMapping("/productList")
    public String productList(HttpServletRequest req, RedirectAttributes redirect) {
        String category1 = req.getParameter("category1");
        String category2 = req.getParameter("category2");

        List<DTOGoods> goodsList=goods.listGoods();
        req.getSession().setAttribute("list",goodsList);

        redirect.addAttribute("contentPage","goods/listGoods.jsp");
        return "redirect:mainForm";
    }

    //상품 디테일 불러오기
    @GetMapping("/goodsDetail")
    public String productDetail(HttpServletRequest req,RedirectAttributes redirect){
        int idx=Integer.parseInt(req.getParameter("idx"));
        dtoGoods=goods.getInfoGoods(idx);
        System.out.println(dtoGoods);
        req.getSession().setAttribute("goods",dtoGoods);
        redirect.addAttribute("contentPage","goods/goodsDetail.jsp");
        return "redirect:mainForm";
    }

    //상품 등록하기
    @GetMapping("/insertGoods")
    String openGoodsInsertForm(RedirectAttributes redirect){
        redirect.addAttribute("contentPage","goods/goodsInsert.jsp");
        return "redirect:mainForm";
    }

    @PostMapping("/insertGoods")
    String insertGoods(HttpServletRequest req, Model model, MultipartFile file) throws IOException {
        System.out.println(file);
        int result = goods.insertGoods(req,file);
        if (result>0){
            model.addAttribute("msg","상품이 등록되었습니다");
            model.addAttribute("url","/");
        }else{
            model.addAttribute("msg","상품등록 실패하였습니다");
            model.addAttribute("url","/");
        }
        return "redirect";
    }

    //상품 삭제
    @PostMapping("/goodsDelete")
    String goodsDelete(HttpServletRequest req,Model model){
        int idx=goods.deleteGoods(Integer.parseInt(req.getParameter("idx")));
        goods.deleteGoods(idx);

        model.addAttribute("msg","상품삭제되었습니다");
        model.addAttribute("url","goods/listGoods");
        return "redirect";

    }

    //상품 수정
    @GetMapping("/modifyGoods")
    String goodsModifyOpen(HttpServletRequest req,RedirectAttributes redirect){
        int idx = Integer.parseInt(req.getParameter("idx"));
        dtoGoods=goods.getInfoGoods(idx);
        req.getSession().setAttribute("goods",goods);

        redirect.addAttribute("contentPage","goods/goodsModify");

        return "redirect:mainForm";
    }

    @PostMapping("/modifyGoods")
    String goodsModify(HttpServletRequest req,Model model){
        goods.updateGoods(req);
        model.addAttribute("msg","상품수정되었습니다");
        model.addAttribute("url","goods/listGoods");
        return "redirect";
    }

    @PostMapping("/addCart")
    public String addCart(HttpSession session,HttpServletRequest req,Model model){
        member=(DTOMember)session.getAttribute("member");
        System.out.println(member.getIdx());
        int result=0;
        if(member != null){
            cart.insertCart(req,member);
            result=1;
        }
        if(result==1) {
            model.addAttribute("msg", "상품이 담겼습니다");
            model.addAttribute("url", "goods/productList");
        }
        if(result==0) {
            model.addAttribute("msg", "다시 시도해주세요");
            model.addAttribute("url", "goods/productList");
        }

    return "redirect";
    }

}
