/*
 * @ClassName SysPermitServiceImpl
 * @Description
 * @version 1.0
 * @Date 2017/6/30 5:54:20
 */
package com.zoucl.server.service.sys.impl;

import com.zoucl.server.dao.sys.SysPermitMapper;
import com.zoucl.server.model.sys.SysPermit;
import com.zoucl.server.service.sys.ISysPermitService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class SysPermitServiceImpl implements ISysPermitService {
    @Autowired
    private SysPermitMapper sysPermitMapper;

    @Transactional(rollbackFor=Exception.class)
    public int deleteById(SysPermit bean) throws Exception{
        return sysPermitMapper.deleteByPrimaryKey(bean.getId());
    }

    @Transactional(rollbackFor=Exception.class)
    public int save(SysPermit bean) throws Exception{
        return sysPermitMapper.insert(bean);
    }

    @Transactional(rollbackFor=Exception.class)
    public int update(SysPermit bean) throws Exception{
        return sysPermitMapper.updateByPrimaryKeySelective(bean);
    }

    public SysPermit findDataById(SysPermit bean){
        return sysPermitMapper.selectByPrimaryKey(bean.getId());
    }

    public List<SysPermit> findDataIsPage(SysPermit bean) {
        if(bean.getPage() != null && bean.getRows() != null){
            PageHelper.startPage(bean.getPage(),bean.getRows());
        }
        return sysPermitMapper.selectList(bean);
    }

    public List<SysPermit> findDataIsList(SysPermit bean) {
        return sysPermitMapper.selectList(bean);
    }


    public int deleteByElementId(String elementId) throws Exception{
        return sysPermitMapper.deletePermitByElementId(elementId);
    }
}
