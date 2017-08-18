/*
 * @ClassName ISysRoleService
 * @Description
 * @version 1.0
 * @Date 2017/6/30 11:58:51
 */
package com.zoucl.server.service.sys;

import com.zoucl.server.model.sys.SysRole;
import com.zoucl.server.model.sys.SysUserRole;
import com.zoucl.server.service.IBaseService;

import java.util.List;
import java.util.Map;

public interface ISysRoleService extends IBaseService<SysRole> {
    List<Map<String, String>>  selectRolePermit(SysRole sysRole);
    List<SysRole> selectUserRole(SysUserRole sysUserRole);

    /**
     * 删除，同时删除关联菜单
     * @param bean
     * @return
     */
    int deleteWithMenu(SysRole bean) throws Exception;
}
