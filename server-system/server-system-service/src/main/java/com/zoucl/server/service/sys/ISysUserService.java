package com.zoucl.server.service.sys;

import com.zoucl.server.model.sys.SysUser;
import com.zoucl.server.service.IBaseService;

/**
 * Created by vicqiang on 2017/6/1 0001.
 */
public interface ISysUserService extends IBaseService<SysUser> {
    SysUser findDataByUserName(SysUser bean);
}
