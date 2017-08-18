/*
 * @ClassName SysPageElement
 * @Description
 * @version 1.0
 * @Date 2017/6/30 4:59:11
 */
package com.zoucl.server.dao.sys;

import com.zoucl.server.dao.IBaseMapper;
import com.zoucl.server.model.sys.SysPageElement;
import com.zoucl.server.model.sys.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysPageElementMapper extends IBaseMapper<SysPageElement> {
    List<SysPageElement> selectUserMenu(SysUser record);
}
