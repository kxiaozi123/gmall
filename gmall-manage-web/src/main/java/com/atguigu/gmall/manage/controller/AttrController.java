package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.user.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.user.bean.PmsBaseAttrValue;
import com.atguigu.gmall.user.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.user.service.AttrService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AttrController  {

    @Reference
    AttrService attrService;


    @RequestMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        String success = attrService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }

    @RequestMapping("attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){

        return attrService.attrInfoList(catalog3Id);
    }
    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){

        return attrService.baseSaleAttrList();
    }
    @RequestMapping("getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){

        return attrService.getAttrValueList(attrId);
    }
}
