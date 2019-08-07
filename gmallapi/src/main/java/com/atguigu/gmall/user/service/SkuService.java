package com.atguigu.gmall.user.service;


import com.atguigu.gmall.user.bean.PmsSkuInfo;

public interface SkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);
    PmsSkuInfo getSkuById(String skuId);
}
