package com.atguigu.gmall.user.service;


import com.atguigu.gmall.user.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.user.bean.PmsBaseAttrValue;
import com.atguigu.gmall.user.bean.PmsBaseSaleAttr;

import java.util.List;
import java.util.Set;


public interface AttrService {
    /**
     * @param catalog3Id
    * @return java.util.List<com.atguigu.gmall.user.bean.PmsBaseAttrInfo>
    * @author k
    * @date 2019/8/6 12:49
     * 获取属性列表
    */
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);
    /**
     * @param pmsBaseAttrInfo
    * @return java.lang.String
    * @author k
    * @date 2019/8/6 12:50
     * 类目下的属性
    */
    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
    /**
     * @param attrId
    * @return java.util.List<com.atguigu.gmall.user.bean.PmsBaseAttrValue>
    * @author k
    * @date 2019/8/6 12:50
     *根据属性id获取属性值
    */
    List<PmsBaseAttrValue> getAttrValueList(String attrId);
    /**
     * @param
    * @return java.util.List<com.atguigu.gmall.user.bean.PmsBaseSaleAttr>
    * @author k
    * @date 2019/8/6 12:58
     * 获取基础属性
    */
    List<PmsBaseSaleAttr> baseSaleAttrList();

    List<PmsBaseAttrInfo> getAttrValueListByValueId(Set<String> valueIdSet);
}
