/*
 * @ClassName SysRole
 * @Description
 * @version 1.0
 * @Date 2017/6/30 11:58:51
 */
package com.zoucl.server.dao.sys;

import com.zoucl.server.dao.IBaseMapper;
import com.zoucl.server.model.sys.SysRole;
import com.zoucl.server.model.sys.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SysRoleMapper extends IBaseMapper<SysRole> {
    List<Map<String, String>> selectRolePermit(SysRole sysRole);
    List<SysRole> selectUserRole(SysUserRole sysUserRole);
}
