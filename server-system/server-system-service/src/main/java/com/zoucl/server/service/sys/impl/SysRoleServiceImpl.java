/*
 * @ClassName SysRoleServiceImpl
 * @Description
 * @version 1.0
 * @Date 2017/6/30 11:58:51
 */
package com.zoucl.server.service.sys.impl;

import com.zoucl.server.dao.sys.SysRoleMapper;
import com.zoucl.server.dao.sys.SysRolePageElementMapper;
import com.zoucl.server.model.sys.SysRole;
import com.zoucl.server.model.sys.SysRolePageElement;
import com.zoucl.server.model.sys.SysUserRole;
import com.zoucl.server.service.sys.ISysRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@EnableTransactionManagement
public class SysRoleServiceImpl implements ISysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRolePageElementMapper sysRolePageElementMapper;

    @Transactional(rollbackFor=Exception.class)
    public int deleteById(SysRole bean) throws Exception{
        return sysRoleMapper.deleteByPrimaryKey(bean.getId());
    }

    @Transactional(rollbackFor=Exception.class)
    public int save(SysRole bean) throws Exception{
        //保存角色菜单关联
        if(bean.getSysRolePageElements()!=null){
            List<SysRolePageElement> sysRolePageElements = bean.getSysRolePageElements();
            for(SysRolePageElement sysRolePageElement: sysRolePageElements){
                sysRolePageElementMapper.insert(sysRolePageElement);
            }
        }
        return sysRoleMapper.insert(bean);
    }


    @Transactional(rollbackFor=Exception.class)
    public int update(SysRole bean) throws Exception{

        //保存角色菜单关联
        //删除原有菜单
        sysRolePageElementMapper.deleteByRoleId(bean.getId());
        if(bean.getSysRolePageElements()!=null){
            List<SysRolePageElement> sysRolePageElements = bean.getSysRolePageElements();
            for(SysRolePageElement sysRolePageElement: sysRolePageElements){
                sysRolePageElementMapper.insert(sysRolePageElement);
            }
        }
        return sysRoleMapper.updateByPrimaryKeySelective(bean);
    }

    public SysRole findDataById(SysRole bean){
        return sysRoleMapper.selectByPrimaryKey(bean.getId());
    }

    public List<SysRole> findDataIsPage(SysRole bean) {
        if(bean.getPage() != null && bean.getRows() != null){
            PageHelper.startPage(bean.getPage(),bean.getRows());
        }
        return  sysRoleMapper.selectList(bean);
    }

    public List<SysRole> findDataIsList(SysRole bean) {
        return  sysRoleMapper.selectList(bean);
    }


    /**
     * 查询系统权限与角色关系
     * @param sysRole
     * @return
     * 权限与角色map，
     * K:角色id，
     * Value:链接信息
     */
    @Override
    public List<Map<String, String>>  selectRolePermit(SysRole sysRole){
        return sysRoleMapper.selectRolePermit(sysRole);
    }

    @Override
    public  List<SysRole> selectUserRole(SysUserRole sysUserRole){
        return sysRoleMapper.selectUserRole(sysUserRole);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public int deleteWithMenu(SysRole bean) throws Exception {
        //刪除关联角色
        sysRolePageElementMapper.deleteByRoleId(bean.getId());
        //删除角色
        return sysRoleMapper.deleteByPrimaryKey(bean.getId());
    }

}
