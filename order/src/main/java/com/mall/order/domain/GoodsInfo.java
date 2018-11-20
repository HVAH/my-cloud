package com.mall.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * GoodsInfo
 * @author fun
 */
@ApiModel
public class GoodsInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @Fields id : id
	 */
	@ApiModelProperty(name = "id", notes = "id")
	private Long id;
	/**
	 * @Fields name : 商品名称
	 */
	@ApiModelProperty(name = "name", notes = "商品名称")
	private String name;
	/**
	 * @Fields title : 商品标题
	 */
	@ApiModelProperty(name = "title", notes = "商品标题")
	private String title;
	
	/**
	 * @Title: getId
	 * @Description: 获取id
	 * @return id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @Title: setId
	 * @Description: 设置id
	 * @param id id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @Title: getName
	 * @Description: 获取商品名称
	 * @return 商品名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @Title: setName
	 * @Description: 设置商品名称
	 * @param name 商品名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @Title: getTitle
	 * @Description: 获取商品标题
	 * @return 商品标题
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @Title: setTitle
	 * @Description: 设置商品标题
	 * @param title 商品标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}

