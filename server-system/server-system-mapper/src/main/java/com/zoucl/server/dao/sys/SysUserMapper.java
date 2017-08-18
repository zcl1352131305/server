/*
 * @ClassName SysUserMapper
 * @Description 
 * @version 1.0
 * @Date 2017-06-20 11:25:01
 */
package com.zoucl.server.dao.sys;

import com.zoucl.server.dao.IBaseMapper;
import com.zoucl.server.model.BaseBean;
import com.zoucl.server.model.sys.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserMapper extends IBaseMapper<SysUser> {
    SysUser selectByUserName(BaseBean bean);

}