package com.atguigu.gmall.user.service;


import com.atguigu.gmall.user.bean.PmsSkuInfo;

import java.util.List;

public interface SkuService {
    //保存SkuInfo
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);
    //根据skuId获取SkuInfo
    PmsSkuInfo getSkuById(String skuId);
    //获取sku的销售属性
    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);
    //根据三级类目获取SkuInfo集合
    List<PmsSkuInfo> getAllSku();
}
