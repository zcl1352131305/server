/*
 * @ClassName ISysPermitService
 * @Description
 * @version 1.0
 * @Date 2017/6/30 5:54:20
 */
package com.zoucl.server.service.sys;

import com.zoucl.server.model.sys.SysPermit;
import com.zoucl.server.service.IBaseService;

public interface ISysPermitService extends IBaseService<SysPermit> {
    int deleteByElementId(String elementId) throws Exception;
}
