/*
 * @ClassName SysDept
 * @Description
 * @version 1.0
 * @Date 2017/8/1 5:30:20
 */
package com.zoucl.server.dao.sys;

import com.zoucl.server.dao.IBaseMapper;
import com.zoucl.server.model.sys.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysDeptMapper extends IBaseMapper<SysDept> {

}
