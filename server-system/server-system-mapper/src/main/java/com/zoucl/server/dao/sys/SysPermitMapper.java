/*
 * @ClassName SysPermit
 * @Description
 * @version 1.0
 * @Date 2017/6/30 5:54:20
 */
package com.zoucl.server.dao.sys;

import com.zoucl.server.dao.IBaseMapper;
import com.zoucl.server.model.sys.SysPermit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysPermitMapper extends IBaseMapper<SysPermit> {
    int deletePermitByElementId(String pageElementId) throws Exception;
}
