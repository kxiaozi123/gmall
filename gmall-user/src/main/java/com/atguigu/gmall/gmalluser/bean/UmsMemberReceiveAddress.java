package com.atguigu.gmall.gmalluser.bean;

import lombok.Data;

import javax.persistence.Id;

/**
 * @return
 * @author k
 * @date 2019/8/5 10:03
 */
@Data
public class UmsMemberReceiveAddress {
    @Id
    private String id;
    private String memberId;
    private String  name;
    private String  phoneNumber;
    private int defaultStatus;
    private String postCode;
    private String province;
    private String city;
    private String region;
    private String detailAddress;
}
