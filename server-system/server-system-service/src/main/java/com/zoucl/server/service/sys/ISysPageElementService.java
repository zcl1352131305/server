/*
 * @ClassName ISysPageElementService
 * @Description
 * @version 1.0
 * @Date 2017/6/30 4:59:11
 */
package com.zoucl.server.service.sys;

import com.zoucl.server.model.sys.SysMenu;
import com.zoucl.server.model.sys.SysPageElement;
import com.zoucl.server.model.sys.SysUser;
import com.zoucl.server.service.IBaseService;

import java.util.List;


public interface ISysPageElementService extends IBaseService<SysPageElement> {
    List<SysMenu> findPageElementsByRoleId(SysUser user);
}
