package com.atguigu.gmall.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.user.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.user.bean.PmsSearchParam;
import com.atguigu.gmall.user.bean.PmsSearchSkuInfo;
import com.atguigu.gmall.user.bean.PmsSkuAttrValue;
import com.atguigu.gmall.user.service.AttrService;
import com.atguigu.gmall.user.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class SearchController {
    @Reference
    SearchService searchService;
    @Reference
    AttrService attrService;
    @RequestMapping("list.html")
    public String list(PmsSearchParam pmsSearchParam, ModelMap modelMap){// 三级分类id、关键字、

        // 调用搜索服务，返回搜索结果
        List<PmsSearchSkuInfo> pmsSearchSkuInfos =  searchService.list(pmsSearchParam);
        modelMap.put("skuLsInfoList",pmsSearchSkuInfos);
        Set<String> valueIdSet=new HashSet<>();
        for (PmsSearchSkuInfo pmsSearchSkuInfo : pmsSearchSkuInfos) {
            List<PmsSkuAttrValue> skuAttrValueList = pmsSearchSkuInfo.getSkuAttrValueList();
            for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
                String valueId = pmsSkuAttrValue.getValueId();
                valueIdSet.add(valueId);
            }
        }
        // 根据valueId将属性列表查询出来
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrService.getAttrValueListByValueId(valueIdSet);
        modelMap.put("attrList", pmsBaseAttrInfos);
        //返回路径
        String urlParam = getUrlParam(pmsSearchParam);
        modelMap.put("urlParam", urlParam);


        return "list";
    }

    private String getUrlParam(PmsSearchParam pmsSearchParam) {
        String keyword = pmsSearchParam.getKeyword();
        String catalog3Id = pmsSearchParam.getCatalog3Id();
        String[] skuAttrValueList = pmsSearchParam.getValueId();
        String urlParam = "";
        if(StringUtils.isNotBlank(keyword))
        {
            urlParam = urlParam + "keyword=" + keyword;
        }
        if(StringUtils.isNotBlank(catalog3Id))
        {
            urlParam = urlParam + "catalog3Id=" + catalog3Id;
        }
        if(skuAttrValueList!=null)
        {
            for (String SkuAttrValue : skuAttrValueList) {
                urlParam = urlParam + "&valueId=" + SkuAttrValue;
            }

        }
        return urlParam;

    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
