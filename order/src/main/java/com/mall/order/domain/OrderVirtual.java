package com.mall.order.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * OrderVirtual
 * @author fun
 */
@ApiModel
public class OrderVirtual implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @Fields pk_id : 主键
	 */
	@ApiModelProperty(name = "pkId", notes = "主键")
	private Long pkId;
	/**
	 * @Fields create_user : 创建用户
	 */
	@ApiModelProperty(name = "createUser", notes = "创建用户")
	private Long createUser;
	/**
	 * @Fields create_time : 创建时间
	 */
	@ApiModelProperty(name = "createTime", notes = "创建时间")
	private Date createTime;
	/**
	 * @Fields update_user : 更新用户
	 */
	@ApiModelProperty(name = "updateUser", notes = "更新用户")
	private Long updateUser;
	/**
	 * @Fields update_time : 更新时间
	 */
	@ApiModelProperty(name = "updateTime", notes = "更新时间")
	private Date updateTime;
	/**
	 * @Fields del_mark : 删除标识(1正常, 2已删除)
	 */
	@ApiModelProperty(name = "delMark", notes = "删除标识(1正常, 2已删除)")
	private Integer delMark;
	/**
	 * @Fields add_time : 下单时间
	 */
	@ApiModelProperty(name = "addTime", notes = "下单时间")
	private Date addTime;
	/**
	 * @Fields virtual_order_no : 虚拟订单编号
	 */
	@ApiModelProperty(name = "virtualOrderNo", notes = "虚拟订单编号")
	private String virtualOrderNo;
	/**
	 * @Fields order_status : 订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 80未付款已失效)
	 */
	@ApiModelProperty(name = "orderStatus", notes = "订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 80未付款已失效)")
	private Integer orderStatus;
	/**
	 * @Fields pay_type : 支付方式(微信wx, 支付宝alipay, 农行abChina, 快钱bill, 农行对公abChina_pub)
	 */
	@ApiModelProperty(name = "payType", notes = "支付方式(微信wx, 支付宝alipay, 农行abChina, 快钱bill, 农行对公abChina_pub)")
	private String payType;
	/**
	 * @Fields total_price : 订单总价
	 */
	@ApiModelProperty(name = "totalPrice", notes = "订单总价")
	private Double totalPrice;
	/**
	 * @Fields freight_money : 运费
	 */
	@ApiModelProperty(name = "freightMoney", notes = "运费")
	private Double freightMoney;
	/**
	 * @Fields pay_money : 在线支付金额
	 */
	@ApiModelProperty(name = "payMoney", notes = "在线支付金额")
	private Double payMoney;
	/**
	 * @Fields gold_money : 货郎豆金额
	 */
	@ApiModelProperty(name = "goldMoney", notes = "货郎豆金额")
	private Double goldMoney;
	/**
	 * @Fields deposit_money : 可使用金额
	 */
	@ApiModelProperty(name = "depositMoney", notes = "可使用金额")
	private Double depositMoney;
	/**
	 * @Fields activation_money : 激活金额
	 */
	@ApiModelProperty(name = "activationMoney", notes = "激活金额")
	private Double activationMoney;
	/**
	 * @Fields coupon_money : 优惠券金额
	 */
	@ApiModelProperty(name = "couponMoney", notes = "优惠券金额")
	private Double couponMoney;
	/**
	 * @Fields coupon_id : 优惠券ID
	 */
	@ApiModelProperty(name = "couponId", notes = "优惠券ID")
	private Long couponId;
	/**
	 * @Fields user_id : 用户ID
	 */
	@ApiModelProperty(name = "userId", notes = "用户ID")
	private Long userId;
	/**
	 * @Fields consignee : 收货人
	 */
	@ApiModelProperty(name = "consignee", notes = "收货人")
	private String consignee;
	/**
	 * @Fields consignee_tel : 收货人联系电话
	 */
	@ApiModelProperty(name = "consigneeTel", notes = "收货人联系电话")
	private String consigneeTel;
	/**
	 * @Fields address_id : 收货地址ID
	 */
	@ApiModelProperty(name = "addressId", notes = "收货地址ID")
	private Long addressId;
	/**
	 * @Fields address_id_name : 收货地址名称
	 */
	@ApiModelProperty(name = "addressIdName", notes = "收货地址名称")
	private String addressIdName;
	/**
	 * @Fields address_id_zip : 邮政编码
	 */
	@ApiModelProperty(name = "addressIdZip", notes = "邮政编码")
	private String addressIdZip;
	/**
	 * @Fields is_wholesale : 是否集采(1是, 2否)
	 */
	@ApiModelProperty(name = "isWholesale", notes = "是否集采(1是, 2否)")
	private Integer isWholesale;
	
	/**
	 * @Title: getPkId
	 * @Description: 获取主键
	 * @return 主键
	 */
	public Long getPkId() {
		return this.pkId;
	}

	/**
	 * @Title: setPkId
	 * @Description: 设置主键
	 * @param pkId 主键
	 */
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	
	/**
	 * @Title: getCreateUser
	 * @Description: 获取创建用户
	 * @return 创建用户
	 */
	public Long getCreateUser() {
		return this.createUser;
	}

	/**
	 * @Title: setCreateUser
	 * @Description: 设置创建用户
	 * @param createUser 创建用户
	 */
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	
	/**
	 * @Title: getCreateTime
	 * @Description: 获取创建时间
	 * @return 创建时间
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * @Title: setCreateTime
	 * @Description: 设置创建时间
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @Title: getUpdateUser
	 * @Description: 获取更新用户
	 * @return 更新用户
	 */
	public Long getUpdateUser() {
		return this.updateUser;
	}

	/**
	 * @Title: setUpdateUser
	 * @Description: 设置更新用户
	 * @param updateUser 更新用户
	 */
	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}
	
	/**
	 * @Title: getUpdateTime
	 * @Description: 获取更新时间
	 * @return 更新时间
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * @Title: setUpdateTime
	 * @Description: 设置更新时间
	 * @param updateTime 更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * @Title: getDelMark
	 * @Description: 获取删除标识(1正常, 2已删除)
	 * @return 删除标识(1正常, 2已删除)
	 */
	public Integer getDelMark() {
		return this.delMark;
	}

	/**
	 * @Title: setDelMark
	 * @Description: 设置删除标识(1正常, 2已删除)
	 * @param delMark 删除标识(1正常, 2已删除)
	 */
	public void setDelMark(Integer delMark) {
		this.delMark = delMark;
	}
	
	/**
	 * @Title: getAddTime
	 * @Description: 获取下单时间
	 * @return 下单时间
	 */
	public Date getAddTime() {
		return this.addTime;
	}

	/**
	 * @Title: setAddTime
	 * @Description: 设置下单时间
	 * @param addTime 下单时间
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	/**
	 * @Title: getVirtualOrderNo
	 * @Description: 获取虚拟订单编号
	 * @return 虚拟订单编号
	 */
	public String getVirtualOrderNo() {
		return this.virtualOrderNo;
	}

	/**
	 * @Title: setVirtualOrderNo
	 * @Description: 设置虚拟订单编号
	 * @param virtualOrderNo 虚拟订单编号
	 */
	public void setVirtualOrderNo(String virtualOrderNo) {
		this.virtualOrderNo = virtualOrderNo;
	}
	
	/**
	 * @Title: getOrderStatus
	 * @Description: 获取订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 80未付款已失效)
	 * @return 订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 80未付款已失效)
	 */
	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	/**
	 * @Title: setOrderStatus
	 * @Description: 设置订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 80未付款已失效)
	 * @param orderStatus 订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 80未付款已失效)
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	/**
	 * @Title: getPayType
	 * @Description: 获取支付方式(微信wx, 支付宝alipay, 农行abChina, 快钱bill, 农行对公abChina_pub)
	 * @return 支付方式(微信wx, 支付宝alipay, 农行abChina, 快钱bill, 农行对公abChina_pub)
	 */
	public String getPayType() {
		return this.payType;
	}

	/**
	 * @Title: setPayType
	 * @Description: 设置支付方式(微信wx, 支付宝alipay, 农行abChina, 快钱bill, 农行对公abChina_pub)
	 * @param payType 支付方式(微信wx, 支付宝alipay, 农行abChina, 快钱bill, 农行对公abChina_pub)
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	/**
	 * @Title: getTotalPrice
	 * @Description: 获取订单总价
	 * @return 订单总价
	 */
	public Double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * @Title: setTotalPrice
	 * @Description: 设置订单总价
	 * @param totalPrice 订单总价
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * @Title: getFreightMoney
	 * @Description: 获取运费
	 * @return 运费
	 */
	public Double getFreightMoney() {
		return this.freightMoney;
	}

	/**
	 * @Title: setFreightMoney
	 * @Description: 设置运费
	 * @param freightMoney 运费
	 */
	public void setFreightMoney(Double freightMoney) {
		this.freightMoney = freightMoney;
	}
	
	/**
	 * @Title: getPayMoney
	 * @Description: 获取在线支付金额
	 * @return 在线支付金额
	 */
	public Double getPayMoney() {
		return this.payMoney;
	}

	/**
	 * @Title: setPayMoney
	 * @Description: 设置在线支付金额
	 * @param payMoney 在线支付金额
	 */
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
	
	/**
	 * @Title: getGoldMoney
	 * @Description: 获取货郎豆金额
	 * @return 货郎豆金额
	 */
	public Double getGoldMoney() {
		return this.goldMoney;
	}

	/**
	 * @Title: setGoldMoney
	 * @Description: 设置货郎豆金额
	 * @param goldMoney 货郎豆金额
	 */
	public void setGoldMoney(Double goldMoney) {
		this.goldMoney = goldMoney;
	}
	
	/**
	 * @Title: getDepositMoney
	 * @Description: 获取可使用金额
	 * @return 可使用金额
	 */
	public Double getDepositMoney() {
		return this.depositMoney;
	}

	/**
	 * @Title: setDepositMoney
	 * @Description: 设置可使用金额
	 * @param depositMoney 可使用金额
	 */
	public void setDepositMoney(Double depositMoney) {
		this.depositMoney = depositMoney;
	}
	
	/**
	 * @Title: getActivationMoney
	 * @Description: 获取激活金额
	 * @return 激活金额
	 */
	public Double getActivationMoney() {
		return this.activationMoney;
	}

	/**
	 * @Title: setActivationMoney
	 * @Description: 设置激活金额
	 * @param activationMoney 激活金额
	 */
	public void setActivationMoney(Double activationMoney) {
		this.activationMoney = activationMoney;
	}
	
	/**
	 * @Title: getCouponMoney
	 * @Description: 获取优惠券金额
	 * @return 优惠券金额
	 */
	public Double getCouponMoney() {
		return this.couponMoney;
	}

	/**
	 * @Title: setCouponMoney
	 * @Description: 设置优惠券金额
	 * @param couponMoney 优惠券金额
	 */
	public void setCouponMoney(Double couponMoney) {
		this.couponMoney = couponMoney;
	}
	
	/**
	 * @Title: getCouponId
	 * @Description: 获取优惠券ID
	 * @return 优惠券ID
	 */
	public Long getCouponId() {
		return this.couponId;
	}

	/**
	 * @Title: setCouponId
	 * @Description: 设置优惠券ID
	 * @param couponId 优惠券ID
	 */
	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}
	
	/**
	 * @Title: getUserId
	 * @Description: 获取用户ID
	 * @return 用户ID
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * @Title: setUserId
	 * @Description: 设置用户ID
	 * @param userId 用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * @Title: getConsignee
	 * @Description: 获取收货人
	 * @return 收货人
	 */
	public String getConsignee() {
		return this.consignee;
	}

	/**
	 * @Title: setConsignee
	 * @Description: 设置收货人
	 * @param consignee 收货人
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	/**
	 * @Title: getConsigneeTel
	 * @Description: 获取收货人联系电话
	 * @return 收货人联系电话
	 */
	public String getConsigneeTel() {
		return this.consigneeTel;
	}

	/**
	 * @Title: setConsigneeTel
	 * @Description: 设置收货人联系电话
	 * @param consigneeTel 收货人联系电话
	 */
	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}
	
	/**
	 * @Title: getAddressId
	 * @Description: 获取收货地址ID
	 * @return 收货地址ID
	 */
	public Long getAddressId() {
		return this.addressId;
	}

	/**
	 * @Title: setAddressId
	 * @Description: 设置收货地址ID
	 * @param addressId 收货地址ID
	 */
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	/**
	 * @Title: getAddressIdName
	 * @Description: 获取收货地址名称
	 * @return 收货地址名称
	 */
	public String getAddressIdName() {
		return this.addressIdName;
	}

	/**
	 * @Title: setAddressIdName
	 * @Description: 设置收货地址名称
	 * @param addressIdName 收货地址名称
	 */
	public void setAddressIdName(String addressIdName) {
		this.addressIdName = addressIdName;
	}
	
	/**
	 * @Title: getAddressIdZip
	 * @Description: 获取邮政编码
	 * @return 邮政编码
	 */
	public String getAddressIdZip() {
		return this.addressIdZip;
	}

	/**
	 * @Title: setAddressIdZip
	 * @Description: 设置邮政编码
	 * @param addressIdZip 邮政编码
	 */
	public void setAddressIdZip(String addressIdZip) {
		this.addressIdZip = addressIdZip;
	}
	
	/**
	 * @Title: getIsWholesale
	 * @Description: 获取是否集采(1是, 2否)
	 * @return 是否集采(1是, 2否)
	 */
	public Integer getIsWholesale() {
		return this.isWholesale;
	}

	/**
	 * @Title: setIsWholesale
	 * @Description: 设置是否集采(1是, 2否)
	 * @param isWholesale 是否集采(1是, 2否)
	 */
	public void setIsWholesale(Integer isWholesale) {
		this.isWholesale = isWholesale;
	}
}

