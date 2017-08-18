/*
 * @ClassName SysRolePageElementServiceImpl
 * @Description
 * @version 1.0
 * @Date 2017/7/3 4:19:35
 */
package com.zoucl.server.service.sys.impl;

import com.zoucl.server.dao.sys.SysRolePageElementMapper;
import com.zoucl.server.model.sys.SysRolePageElement;
import com.zoucl.server.service.sys.ISysRolePageElementService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class SysRolePageElementServiceImpl implements ISysRolePageElementService {
    @Autowired
    private SysRolePageElementMapper sysRolePageElementMapper;

    @Transactional(rollbackFor=Exception.class)
    public int deleteById(SysRolePageElement bean) throws Exception{
        return sysRolePageElementMapper.deleteByPrimaryKey(bean.getId());
    }

    @Transactional(rollbackFor=Exception.class)
    public int save(SysRolePageElement bean) throws Exception{
        return sysRolePageElementMapper.insert(bean);
    }

    @Transactional(rollbackFor=Exception.class)
    public int update(SysRolePageElement bean) throws Exception{
        return sysRolePageElementMapper.updateByPrimaryKeySelective(bean);
    }

    public SysRolePageElement findDataById(SysRolePageElement bean){
        return sysRolePageElementMapper.selectByPrimaryKey(bean.getId());
    }

    public List<SysRolePageElement> findDataIsPage(SysRolePageElement bean) {
        if(bean.getPage() != null && bean.getRows() != null){
            PageHelper.startPage(bean.getPage(),bean.getRows());
        }
        return sysRolePageElementMapper.selectList(bean);
    }

    public List<SysRolePageElement> findDataIsList(SysRolePageElement bean) {
        return sysRolePageElementMapper.selectList(bean);
    }

    public int deleteByRoleId(String roleId){
        return sysRolePageElementMapper.deleteByRoleId(roleId);
    }

}
