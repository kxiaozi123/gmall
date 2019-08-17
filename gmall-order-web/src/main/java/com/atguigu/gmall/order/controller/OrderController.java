package com.atguigu.gmall.order.controller;

import com.atguigu.gmall.util.annotations.LoginRequired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
@Controller
public class OrderController {

    @RequestMapping("/toTrade")
    @LoginRequired(loginSuccess = true)
    public String toTrade(HttpServletRequest request, String isChecked, String skuId, ModelMap modelMap)
    {
        String memberId= (String) request.getAttribute("memberId");
        String nickname= (String) request.getAttribute("nickname");
        return "trade";
    }
}
