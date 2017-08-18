/*
 * @ClassName ISysRolePageElementService
 * @Description
 * @version 1.0
 * @Date 2017/7/3 4:19:35
 */
package com.zoucl.server.service.sys;


import com.zoucl.server.model.sys.SysRolePageElement;
import com.zoucl.server.service.IBaseService;

public interface ISysRolePageElementService extends IBaseService<SysRolePageElement> {
    int deleteByRoleId(String roleId);

}
