/*
 * @ClassName SysUserRoleMapper
 * @Description 
 * @version 1.0
 * @Date 2017-06-20 11:29:27
 */
package com.zoucl.server.dao.sys;

import com.zoucl.server.dao.IBaseMapper;
import com.zoucl.server.model.sys.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserRoleMapper extends IBaseMapper<SysUserRole> {
    int deleteSelective(SysUserRole record);
}