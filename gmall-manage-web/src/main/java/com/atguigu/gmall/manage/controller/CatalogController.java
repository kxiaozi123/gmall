package com.atguigu.gmall.manage.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.user.bean.PmsBaseCatalog1;
import com.atguigu.gmall.user.bean.PmsBaseCatalog2;
import com.atguigu.gmall.user.bean.PmsBaseCatalog3;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.atguigu.gmall.user.service.CatalogService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CatalogController {

    @Reference
    CatalogService catalogService;

    @RequestMapping("getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){

       return catalogService.getCatalog3(catalog2Id);
    }


    @RequestMapping("getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){

        return catalogService.getCatalog2(catalog1Id);
    }

    @RequestMapping("getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){

        return catalogService.getCatalog1();
    }
}
