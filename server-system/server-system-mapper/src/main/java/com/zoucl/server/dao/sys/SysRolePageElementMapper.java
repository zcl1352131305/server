/*
 * @ClassName SysRolePageElement
 * @Description
 * @version 1.0
 * @Date 2017/7/3 4:19:35
 */
package com.zoucl.server.dao.sys;

import com.zoucl.server.dao.IBaseMapper;
import com.zoucl.server.model.sys.SysRolePageElement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysRolePageElementMapper extends IBaseMapper<SysRolePageElement> {
    int deleteByRoleId(String roleId);

    int deleteByPageElementId(String pageElementId);
}
