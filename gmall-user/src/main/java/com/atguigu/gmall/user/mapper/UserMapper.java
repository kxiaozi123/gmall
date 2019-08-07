package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.user.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
* @return
* @author k
* @date 2019/8/5 10:08
*/
public interface UserMapper extends Mapper<UmsMember> {
    /**
     * @param
    * @return java.util.List<com.atguigu.gmall.gmalluser.bean.UmsMember>
    * @author k
    * @date 2019/8/5 10:12
    */
    List<UmsMember> selectAllUser();
}
