/*
 * @ClassName SysDictionaryServiceImpl
 * @Description
 * @version 1.0
 * @Date 2017/8/1 2:28:6
 */
package com.zoucl.server.service.sys.impl;

import com.zoucl.server.dao.sys.SysDictionaryMapper;
import com.zoucl.server.model.sys.SysDictionary;
import com.zoucl.server.service.sys.ISysDictionaryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class SysDictionaryServiceImpl implements ISysDictionaryService{
    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

    @Transactional(rollbackFor=Exception.class)
    public int deleteById(SysDictionary bean) throws Exception{
        return sysDictionaryMapper.deleteByPrimaryKey(bean.getId());
    }

    @Transactional(rollbackFor=Exception.class)
    public int save(SysDictionary bean) throws Exception{
        SysDictionary bean1 = sysDictionaryMapper.selectByPrimaryKey(bean.getId());
        if(null != bean1){
            return 1;
        }
        else{
            return sysDictionaryMapper.insert(bean);
        }
    }

    @Transactional(rollbackFor=Exception.class)
    public int update(SysDictionary bean) throws Exception{
        return sysDictionaryMapper.updateByPrimaryKeySelective(bean);
    }

    public SysDictionary findDataById(SysDictionary bean){
        return sysDictionaryMapper.selectByPrimaryKey(bean.getId());
    }

    public List<SysDictionary> findDataIsPage(SysDictionary bean) {
        if(bean.getPage() != null && bean.getRows() != null){
            PageHelper.startPage(bean.getPage(),bean.getRows());
        }
        return sysDictionaryMapper.selectList(bean);
    }

    public List<SysDictionary> findDataIsList(SysDictionary bean) {
        return sysDictionaryMapper.selectList(bean);
    }

}
