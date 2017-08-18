/*
 * @ClassName SysDictionary
 * @Description
 * @version 1.0
 * @Date 2017/8/1 2:28:6
 */
package com.zoucl.server.model.sys;

import com.zoucl.server.model.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDictionary extends BaseBean {
	/**
	 * @Fields userName 名称
	 */
	private String name;
	/**
	 * @Fields userName 值
	 */
	private String val;
	/**
	 * @Fields userName 备注
	 */
	private String note;
	/**
	 * @Fields userName 是否开放
	 */
	private String isOpen;
	/**
	 * @Fields userName 类别
	 */
	private String type;

}
