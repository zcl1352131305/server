package com.zoucl.server.service.sys;

import com.zoucl.server.model.sys.SysRolePermit;
import com.zoucl.server.service.IBaseService;

import java.util.List;

/**
 * Created by vicqiang on 2017/6/6 0006.
 */
public interface ISysRolePermitService extends IBaseService<SysRolePermit> {
    List<SysRolePermit> selectAllPermit(SysRolePermit bean);
}
