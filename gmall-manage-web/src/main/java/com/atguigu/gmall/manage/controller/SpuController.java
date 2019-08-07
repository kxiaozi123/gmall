package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.manage.util.PmsUploadUtil;
import com.atguigu.gmall.user.bean.PmsProductImage;
import com.atguigu.gmall.user.bean.PmsProductInfo;
import com.atguigu.gmall.user.bean.PmsProductSaleAttr;
import com.atguigu.gmall.user.service.SpuService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(String catalog3Id) {

        return spuService.spuList(catalog3Id);

    }
    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        // 将图片或者音视频上传到分布式的文件存储系统
        // 将图片的存储路径返回给页面
        String imgUrl = PmsUploadUtil.uploadImage(multipartFile);
        System.out.println(imgUrl);
        return imgUrl;
    }
    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody  PmsProductInfo pmsProductInfo){

        spuService.saveSpuInfo(pmsProductInfo);

        return "success";
    }
    @RequestMapping("spuImageList")
    public List<PmsProductImage> spuImageList(String spuId){

        return spuService.spuImageList(spuId);
    }


    @RequestMapping("spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId){

        return spuService.spuSaleAttrList(spuId);
    }
}
