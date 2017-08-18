/*
 * @ClassName SysDictionary
 * @Description
 * @version 1.0
 * @Date 2017/8/1 2:28:6
 */
package com.zoucl.server.dao.sys;

import com.zoucl.server.dao.IBaseMapper;
import com.zoucl.server.model.sys.SysDictionary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysDictionaryMapper extends IBaseMapper<SysDictionary> {

}
