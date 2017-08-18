/*
 * @ClassName SysDept
 * @Description
 * @version 1.0
 * @Date 2017/8/1 5:30:20
 */
package com.zoucl.server.model.sys;

import com.zoucl.server.model.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDept extends BaseBean {
	/**
	 * @Fields userName 部门名称
	 */
	private String name;
	/**
	 * @Fields userName 全称
	 */
	private String fullName;
	/**
	 * @Fields userName 分类
	 */
	private String type;
	/**
	 * @Fields userName 部门序号
	 */
	private String serial;


	//未实例化属性
	/**
	 * @Fields userName 部门类型名称
	 */
	private String typeName;

}
