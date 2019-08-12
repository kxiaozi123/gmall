package com.atguigu.gmall.user.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class PmsSearchParam implements Serializable{

    private String catalog3Id;

    private String keyword;

    private String[] valueId;


}
