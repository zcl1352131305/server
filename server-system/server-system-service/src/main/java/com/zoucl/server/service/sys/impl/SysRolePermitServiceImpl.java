package com.zoucl.server.service.sys.impl;

import com.zoucl.server.dao.sys.SysRolePermitMapper;
import com.zoucl.server.model.sys.SysRolePermit;
import com.zoucl.server.service.sys.ISysRolePermitService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vicqiang on 2017/6/6 0006.
 */
@Service
@EnableTransactionManagement
public class SysRolePermitServiceImpl implements ISysRolePermitService {
    @Autowired
    private SysRolePermitMapper sysRolePermitMapper;

    public SysRolePermit findDataById(SysRolePermit bean){
        return sysRolePermitMapper.selectByPrimaryKey(bean.getId());
    }

    @Transactional(rollbackFor=Exception.class)
    public int deleteById(SysRolePermit bean) throws Exception{
        return sysRolePermitMapper.deleteByPrimaryKey(bean.getId());
    }

    @Transactional(rollbackFor=Exception.class)
    public int save(SysRolePermit bean) throws Exception{
        return sysRolePermitMapper.insert(bean);
    }

    @Transactional(rollbackFor=Exception.class)
    public int update(SysRolePermit bean) throws Exception{
        return sysRolePermitMapper.updateByPrimaryKeySelective(bean);
    }

    public List<SysRolePermit> findDataIsPage(SysRolePermit bean) {
        if(bean.getPage() != null && bean.getRows() != null){
            PageHelper.startPage(bean.getPage(),bean.getRows());
        }
        return sysRolePermitMapper.selectList(bean);
    }

    public List<SysRolePermit> findDataIsList(SysRolePermit bean) {
        return sysRolePermitMapper.selectList(bean);
    }

    public  List<SysRolePermit> selectAllPermit(SysRolePermit bean){
        return sysRolePermitMapper.selectAllPermit(bean);
    }
}
