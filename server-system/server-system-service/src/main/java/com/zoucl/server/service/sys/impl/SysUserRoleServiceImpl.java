package com.zoucl.server.service.sys.impl;

import com.zoucl.server.dao.sys.SysUserRoleMapper;
import com.zoucl.server.model.sys.SysUserRole;
import com.zoucl.server.service.sys.ISysUserRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by vicqiang on 2017/6/6 0006.
 */
@Service
@EnableTransactionManagement
public class SysUserRoleServiceImpl implements ISysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    public SysUserRole findDataById(SysUserRole bean){
        return sysUserRoleMapper.selectByPrimaryKey(bean.getId());
    }

    public int deleteById(SysUserRole bean) throws Exception{
        return sysUserRoleMapper.deleteByPrimaryKey(bean.getId());
    }

    public int save(SysUserRole bean) throws Exception{
        return sysUserRoleMapper.insert(bean);
    }

    public int update(SysUserRole bean) throws Exception{
        return sysUserRoleMapper.updateByPrimaryKeySelective(bean);
    }

    public List<SysUserRole> findDataIsPage(SysUserRole bean) {
        if(bean.getPage() != null && bean.getRows() != null){
            PageHelper.startPage(bean.getPage(),bean.getRows());
        }
        return sysUserRoleMapper.selectList(bean);
    }

    public List<SysUserRole> findDataIsList(SysUserRole bean) {
        return sysUserRoleMapper.selectList(bean);
    }
}
