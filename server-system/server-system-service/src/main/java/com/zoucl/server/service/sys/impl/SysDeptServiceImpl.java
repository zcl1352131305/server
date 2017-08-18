/*
 * @ClassName SysDeptServiceImpl
 * @Description
 * @version 1.0
 * @Date 2017/8/1 5:30:20
 */
package com.zoucl.server.service.sys.impl;

import com.zoucl.server.dao.sys.SysDeptMapper;
import com.zoucl.server.model.sys.SysDept;
import com.zoucl.server.service.sys.ISysDeptService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class SysDeptServiceImpl implements ISysDeptService{
    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Transactional(rollbackFor=Exception.class)
    public int deleteById(SysDept bean) throws Exception{
        return sysDeptMapper.deleteByPrimaryKey(bean.getId());
    }

    @Transactional(rollbackFor=Exception.class)
    public int save(SysDept bean) throws Exception{
        SysDept bean1 = sysDeptMapper.selectByPrimaryKey(bean.getId());
        if(null != bean1){
            return 1;
        }
        else{
            return sysDeptMapper.insert(bean);
        }
    }

    @Transactional(rollbackFor=Exception.class)
    public int update(SysDept bean) throws Exception{
        return sysDeptMapper.updateByPrimaryKeySelective(bean);
    }

    public SysDept findDataById(SysDept bean){
        return sysDeptMapper.selectByPrimaryKey(bean.getId());
    }

    public List<SysDept> findDataIsPage(SysDept bean) {
        if(bean.getPage() != null && bean.getRows() != null){
            PageHelper.startPage(bean.getPage(),bean.getRows());
        }
        return sysDeptMapper.selectList(bean);
    }

    public List<SysDept> findDataIsList(SysDept bean) {
        return sysDeptMapper.selectList(bean);
    }

}
