package com.mall.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * GoodsSku
 * @author fun
 */
@ApiModel
public class GoodsSku implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @Fields pkId : pkId
	 */
	@ApiModelProperty(name = "pkId", notes = "pkId")
	private Long pkId;
	/**
	 * @Fields goodsId : 商品id
	 */
	@ApiModelProperty(name = "goodsId", notes = "商品id")
	private Long goodsId;
	/**
	 * @Fields specName : 规格名称
	 */
	@ApiModelProperty(name = "specName", notes = "规格名称")
	private String specName;
	/**
	 * @Fields specValue : 规格值
	 */
	@ApiModelProperty(name = "specValue", notes = "规格值")
	private String specValue;
	/**
	 * @Fields specNum : specNum
	 */
	@ApiModelProperty(name = "specNum", notes = "specNum")
	private Integer specNum;
	/**
	 * @Fields specPrice : 规格价
	 */
	@ApiModelProperty(name = "specPrice", notes = "规格价")
	private BigDecimal specPrice;
	/**
	 * @Fields specNo : 货号
	 */
	@ApiModelProperty(name = "specNo", notes = "货号")
	private Integer specNo;
	
	/**
	 * @Title: getPkId
	 * @Description: 获取pkId
	 * @return pkId
	 */
	public Long getPkId() {
		return this.pkId;
	}

	/**
	 * @Title: setPkId
	 * @Description: 设置pkId
	 * @param pkId pkId
	 */
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	
	/**
	 * @Title: getGoodsId
	 * @Description: 获取商品id
	 * @return 商品id
	 */
	public Long getGoodsId() {
		return this.goodsId;
	}

	/**
	 * @Title: setGoodsId
	 * @Description: 设置商品id
	 * @param goodsId 商品id
	 */
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	
	/**
	 * @Title: getSpecName
	 * @Description: 获取规格名称
	 * @return 规格名称
	 */
	public String getSpecName() {
		return this.specName;
	}

	/**
	 * @Title: setSpecName
	 * @Description: 设置规格名称
	 * @param specName 规格名称
	 */
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	
	/**
	 * @Title: getSpecValue
	 * @Description: 获取规格值
	 * @return 规格值
	 */
	public String getSpecValue() {
		return this.specValue;
	}

	/**
	 * @Title: setSpecValue
	 * @Description: 设置规格值
	 * @param specValue 规格值
	 */
	public void setSpecValue(String specValue) {
		this.specValue = specValue;
	}
	
	/**
	 * @Title: getSpecNum
	 * @Description: 获取specNum
	 * @return specNum
	 */
	public Integer getSpecNum() {
		return this.specNum;
	}

	/**
	 * @Title: setSpecNum
	 * @Description: 设置specNum
	 * @param specNum specNum
	 */
	public void setSpecNum(Integer specNum) {
		this.specNum = specNum;
	}
	
	/**
	 * @Title: getSpecPrice
	 * @Description: 获取规格价
	 * @return 规格价
	 */
	public BigDecimal getSpecPrice() {
		return this.specPrice;
	}

	/**
	 * @Title: setSpecPrice
	 * @Description: 设置规格价
	 * @param specPrice 规格价
	 */
	public void setSpecPrice(BigDecimal specPrice) {
		this.specPrice = specPrice;
	}
	
	/**
	 * @Title: getSpecNo
	 * @Description: 获取货号
	 * @return 货号
	 */
	public Integer getSpecNo() {
		return this.specNo;
	}

	/**
	 * @Title: setSpecNo
	 * @Description: 设置货号
	 * @param specNo 货号
	 */
	public void setSpecNo(Integer specNo) {
		this.specNo = specNo;
	}
}

