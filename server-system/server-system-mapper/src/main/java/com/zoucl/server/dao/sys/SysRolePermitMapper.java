/*
 * @ClassName SysRolePermitMapper
 * @Description 
 * @version 1.0
 * @Date 2017-06-20 11:30:12
 */
package com.zoucl.server.dao.sys;

import com.zoucl.server.dao.IBaseMapper;
import com.zoucl.server.model.BaseBean;
import com.zoucl.server.model.sys.SysRolePermit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysRolePermitMapper extends IBaseMapper<SysRolePermit> {
    List<SysRolePermit> selectAllPermit(BaseBean bean);
}