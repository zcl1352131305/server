/*
 * @ClassName SysRolePermit
 * @Description 
 * @version 1.0
 * @Date 2017-06-20 11:30:12
 */
package com.zoucl.server.model.sys;

import com.zoucl.server.model.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRolePermit extends BaseBean {
    /**
     * @Fields roleId 
     */
    private String roleId;
    /**
     * @Fields permitId 权限id
     */
    private String permitId;
    /**
     * @Fields companyId 公司ID
     */
    private String companyId;

    /**
     * 结果用
     */
    private String url;
}