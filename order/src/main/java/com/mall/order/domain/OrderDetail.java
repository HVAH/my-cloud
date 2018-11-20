package com.mall.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderDetail
 * @author fun
 */
@ApiModel
public class OrderDetail implements Serializable {
	
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
	 * @Fields confirm_time : 确认收货时间
	 */
	@ApiModelProperty(name = "confirmTime", notes = "确认收货时间")
	private Date confirmTime;
	/**
	 * @Fields order_express_id : 订单物流ID
	 */
	@ApiModelProperty(name = "orderExpressId", notes = "订单物流ID")
	private Long orderExpressId;
	/**
	 * @Fields order_supplier_id : 订单-供应商ID
	 */
	@ApiModelProperty(name = "orderSupplierId", notes = "订单-供应商ID")
	private Long orderSupplierId;
	/**
	 * @Fields order_virtual_id : 虚拟订单ID
	 */
	@ApiModelProperty(name = "orderVirtualId", notes = "虚拟订单ID")
	private Long orderVirtualId;
	/**
	 * @Fields order_no : 订单编号
	 */
	@ApiModelProperty(name = "orderNo", notes = "订单编号")
	private String orderNo;
	/**
	 * @Fields order_status : 订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 13已发货, 14已收货, 15会员已评价, 16双方已评价, 31会员申请退款(等待供应商审核), 32供应商同意退款(等待平台审核), 41会员申请退货退款(等待供应商审核), 42供应商同意退货退款(等待买家发货), 43买家已发货(等待供应商收货), 44供应商已收货(等待平台审核), 60订单已完成, 61退款完成, 62退货退款完成, 63赠送金额转激活金额结束, 64激活金额转可使用金额结束, 66集采奖励结束, 80未付款已失效)
	 */
	@ApiModelProperty(name = "orderStatus", notes = "订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 13已发货, 14已收货, 15会员已评价, 16双方已评价, 31会员申请退款(等待供应商审核), 32供应商同意退款(等待平台审核), 41会员申请退货退款(等待供应商审核), 42供应商同意退货退款(等待买家发货), 43买家已发货(等待供应商收货), 44供应商已收货(等待平台审核), 60订单已完成, 61退款完成, 62退货退款完成, 63赠送金额转激活金额结束, 64激活金额转可使用金额结束, 66集采奖励结束, 80未付款已失效)")
	private Integer orderStatus;
	/**
	 * @Fields pay_type : 支付方式(微信wx, 支付宝alipay, 农行abChina, 快钱bill, 农行对公abChina_pub)
	 */
	@ApiModelProperty(name = "payType", notes = "支付方式(微信wx, 支付宝alipay, 农行abChina, 快钱bill, 农行对公abChina_pub)")
	private String payType;
	/**
	 * @Fields total_price : 商品总价
	 */
	@ApiModelProperty(name = "totalPrice", notes = "商品总价")
	private Double totalPrice;
	/**
	 * @Fields coupon_money : 优惠券金额
	 */
	@ApiModelProperty(name = "couponMoney", notes = "优惠券金额")
	private Double couponMoney;
	/**
	 * @Fields gold_money : 货郎豆金额
	 */
	@ApiModelProperty(name = "goldMoney", notes = "货郎豆金额")
	private Double goldMoney;
	/**
	 * @Fields activation_money : 激活金额
	 */
	@ApiModelProperty(name = "activationMoney", notes = "激活金额")
	private Double activationMoney;
	/**
	 * @Fields deposit_money : 可使用金额
	 */
	@ApiModelProperty(name = "depositMoney", notes = "可使用金额")
	private Double depositMoney;
	/**
	 * @Fields pay_money : 在线支付金额
	 */
	@ApiModelProperty(name = "payMoney", notes = "在线支付金额")
	private Double payMoney;
	/**
	 * @Fields freight_money : 运费
	 */
	@ApiModelProperty(name = "freightMoney", notes = "运费")
	private Double freightMoney;
	/**
	 * @Fields freight_template_id : 运费模版ID
	 */
	@ApiModelProperty(name = "freightTemplateId", notes = "运费模版ID")
	private Long freightTemplateId;
	/**
	 * @Fields express_way : 快递方式(1平邮, 2快递, 3EMS)
	 */
	@ApiModelProperty(name = "expressWay", notes = "快递方式(1平邮, 2快递, 3EMS)")
	private Integer expressWay;
	/**
	 * @Fields coupon_id : 优惠券ID-优惠券领取记录ID
	 */
	@ApiModelProperty(name = "couponId", notes = "优惠券ID")
	private Long couponId;
	/**
	 * @Fields user_id : 用户ID
	 */
	@ApiModelProperty(name = "userId", notes = "用户ID")
	private Long userId;
	/**
	 * @Fields goods_count : 商品数量
	 */
	@ApiModelProperty(name = "goodsCount", notes = "商品数量")
	private Integer goodsCount;
	/**
	 * @Fields goods_id : 商品ID
	 */
	@ApiModelProperty(name = "goodsId", notes = "商品ID")
	private Long goodsId;
	/**
	 * @Fields goods_id_price : 商品单价
	 */
	@ApiModelProperty(name = "goodsIdPrice", notes = "商品单价")
	private Double goodsIdPrice;
	/**
	 * @Fields goods_id_divideprofit_price : 单件商品结算价
	 */
	@ApiModelProperty(name = "goodsIdDivideprofitPrice", notes = "单件商品结算价")
	private Double goodsIdDivideprofitPrice;
	/**
	 * @Fields goods_id_discount : 商品结算比例
	 */
	@ApiModelProperty(name = "goodsIdDiscount", notes = "商品结算比例")
	private Double goodsIdDiscount;
	/**
	 * @Fields goods_id_name : 商品名称
	 */
	@ApiModelProperty(name = "goodsIdName", notes = "商品名称")
	private String goodsIdName;
	/**
	 * @Fields goods_id_pic : 商品图片
	 */
	@ApiModelProperty(name = "goodsIdPic", notes = "商品图片")
	private String goodsIdPic;
	/**
	 * @Fields goods_spec_detail_id : 商品规格ID
	 */
	@ApiModelProperty(name = "goodsSpecDetailId", notes = "商品规格ID")
	private Long goodsSpecDetailId;
	/**
	 * @Fields goods_spec : 商品规格
	 */
	@ApiModelProperty(name = "goodsSpec", notes = "商品规格")
	private String goodsSpec;
	/**
	 * @Fields supplier_id : 供应商ID
	 */
	@ApiModelProperty(name = "supplierId", notes = "供应商ID")
	private Long supplierId;
	/**
	 * @Fields supplier_id_name : 供应商名称
	 */
	@ApiModelProperty(name = "supplierIdName", notes = "供应商名称")
	private String supplierIdName;
	/**
	 * @Fields supplier_id_tel : 供应商联系方式(多个使用空格分隔)
	 */
	@ApiModelProperty(name = "supplierIdTel", notes = "供应商联系方式(多个使用空格分隔)")
	private String supplierIdTel;
	/**
	 * @Fields is_wholesale : 是否集采(1是, 2否)
	 */
	@ApiModelProperty(name = "isWholesale", notes = "是否集采(1是, 2否)")
	private Integer isWholesale;
	/**
	 * @Fields wholesale_price : 集采价格
	 */
	@ApiModelProperty(name = "wholesalePrice", notes = "集采价格")
	private Double wholesalePrice;
	/**
	 * @Fields order_user_ip : 用户下单IP
	 */
	@ApiModelProperty(name = "orderUserIp", notes = "用户下单IP")
	private String orderUserIp;
	/**
	 * @Fields evaluate_status : 评价状态(0未评价, 1会员已评价, 2双方已评价)
	 */
	@ApiModelProperty(name = "evaluateStatus", notes = "评价状态(0未评价, 1会员已评价, 2双方已评价)")
	private Integer evaluateStatus;
	/**
	 * @Fields last_order_status : 上一次订单状态
	 */
	@ApiModelProperty(name = "lastOrderStatus", notes = "上一次订单状态")
	private Integer lastOrderStatus;
	/**
	 * @Fields order_source : 订单来源(1PC, 2APP, 3IOS, 4微商城)
	 */
	@ApiModelProperty(name = "orderSource", notes = "订单来源(1PC, 2APP, 3IOS, 4微商城)")
	private Integer orderSource;
	
	/**
	 * @Fields goods_id_deal_point : 交易扣点
	 */
	@ApiModelProperty(name = "goodsIdDealPoint", notes = "交易扣点")
	private Double goodsIdDealPoint;
	/**
	 * @Fields profit_ratio : 分润比例
	 */
	@ApiModelProperty(name = "profitRatio", notes = "分润比例")
	private Double profitRatio;
	/**
	 * @Fields local_flag : 是否本地商品
	 */
	@ApiModelProperty(name = "localFlag", notes = "分润比例")
	private Integer localFlag;
	
	/**
	 * @Fields vip_goods_order_flag : 是否vip商品
	 */
	@ApiModelProperty(name = "vipGoodsOrderFlag", notes = "是否vip商品")
	private Integer vipGoodsOrderFlag;
	
	/**
	 * @Fields discount_rate : vip折扣率
	 */
	@ApiModelProperty(name = "discountRate", notes = "vip折扣率")
	private BigDecimal discountRate;
	/**
	 * @Fields discount_price :vip折扣后价格
	 */
	@ApiModelProperty(name = "discountPrice", notes = "vip折扣后价格")
	private BigDecimal discountPrice;
	/**
	 * @Fields goods_id_pic : 商品图片路径
	 */
	@ApiModelProperty(name = "goodsIdPicWholeFilePath", notes = "商品图片路径")
	private String goodsIdPicWholeFilePath;
	
	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Integer getVipGoodsOrderFlag() {
		return vipGoodsOrderFlag;
	}

	public void setVipGoodsOrderFlag(Integer vipGoodsOrderFlag) {
		this.vipGoodsOrderFlag = vipGoodsOrderFlag;
	}

	public Integer getLocalFlag() {
		return localFlag;
	}

	public void setLocalFlag(Integer localFlag) {
		this.localFlag = localFlag;
	}

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
	 * @Title: getConfirmTime
	 * @Description: 获取确认收货时间
	 * @return 确认收货时间
	 */
	public Date getConfirmTime() {
		return this.confirmTime;
	}

	/**
	 * @Title: setConfirmTime
	 * @Description: 设置确认收货时间
	 * @param confirmTime 确认收货时间
	 */
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}
	
	/**
	 * @Title: getOrderExpressId
	 * @Description: 获取订单物流ID
	 * @return 订单物流ID
	 */
	public Long getOrderExpressId() {
		return this.orderExpressId;
	}

	/**
	 * @Title: setOrderExpressId
	 * @Description: 设置订单物流ID
	 * @param orderExpressId 订单物流ID
	 */
	public void setOrderExpressId(Long orderExpressId) {
		this.orderExpressId = orderExpressId;
	}
	
	/**
	 * @Title: getOrderSupplierId
	 * @Description: 获取订单-供应商ID
	 * @return 订单-供应商ID
	 */
	public Long getOrderSupplierId() {
		return this.orderSupplierId;
	}

	/**
	 * @Title: setOrderSupplierId
	 * @Description: 设置订单-供应商ID
	 * @param orderSupplierId 订单-供应商ID
	 */
	public void setOrderSupplierId(Long orderSupplierId) {
		this.orderSupplierId = orderSupplierId;
	}
	
	/**
	 * @Title: getOrderVirtualId
	 * @Description: 获取虚拟订单ID
	 * @return 虚拟订单ID
	 */
	public Long getOrderVirtualId() {
		return this.orderVirtualId;
	}

	/**
	 * @Title: setOrderVirtualId
	 * @Description: 设置虚拟订单ID
	 * @param orderVirtualId 虚拟订单ID
	 */
	public void setOrderVirtualId(Long orderVirtualId) {
		this.orderVirtualId = orderVirtualId;
	}
	
	/**
	 * @Title: getOrderNo
	 * @Description: 获取订单编号
	 * @return 订单编号
	 */
	public String getOrderNo() {
		return this.orderNo;
	}

	/**
	 * @Title: setOrderNo
	 * @Description: 设置订单编号
	 * @param orderNo 订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	/**
	 * @Title: getOrderStatus
	 * @Description: 获取订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 13已发货, 14已收货, 15会员已评价, 16双方已评价, 31会员申请退款(等待供应商审核), 32供应商同意退款(等待平台审核), 41会员申请退货退款(等待供应商审核), 42供应商同意退货退款(等待买家发货), 43买家已发货(等待供应商收货), 44供应商已收货(等待平台审核), 60订单已完成, 61退款完成, 62退货退款完成, 63赠送金额转激活金额结束, 64激活金额转可使用金额结束, 66集采奖励结束, 80未付款已失效)
	 * @return 订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 13已发货, 14已收货, 15会员已评价, 16双方已评价, 31会员申请退款(等待供应商审核), 32供应商同意退款(等待平台审核), 41会员申请退货退款(等待供应商审核), 42供应商同意退货退款(等待买家发货), 43买家已发货(等待供应商收货), 44供应商已收货(等待平台审核), 60订单已完成, 61退款完成, 62退货退款完成, 63赠送金额转激活金额结束, 64激活金额转可使用金额结束, 66集采奖励结束, 80未付款已失效)
	 */
	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	/**
	 * @Title: setOrderStatus
	 * @Description: 设置订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 13已发货, 14已收货, 15会员已评价, 16双方已评价, 31会员申请退款(等待供应商审核), 32供应商同意退款(等待平台审核), 41会员申请退货退款(等待供应商审核), 42供应商同意退货退款(等待买家发货), 43买家已发货(等待供应商收货), 44供应商已收货(等待平台审核), 60订单已完成, 61退款完成, 62退货退款完成, 63赠送金额转激活金额结束, 64激活金额转可使用金额结束, 66集采奖励结束, 80未付款已失效)
	 * @param orderStatus 订单状态(99订单取消, 98系统审核失败订单取消, 11待付款, 12已付款, 20已审核, 13已发货, 14已收货, 15会员已评价, 16双方已评价, 31会员申请退款(等待供应商审核), 32供应商同意退款(等待平台审核), 41会员申请退货退款(等待供应商审核), 42供应商同意退货退款(等待买家发货), 43买家已发货(等待供应商收货), 44供应商已收货(等待平台审核), 60订单已完成, 61退款完成, 62退货退款完成, 63赠送金额转激活金额结束, 64激活金额转可使用金额结束, 66集采奖励结束, 80未付款已失效)
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
	 * @Description: 获取商品总价
	 * @return 商品总价
	 */
	public Double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * @Title: setTotalPrice
	 * @Description: 设置商品总价
	 * @param totalPrice 商品总价
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
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
	 * @Title: getFreightTemplateId
	 * @Description: 获取运费模版ID
	 * @return 运费模版ID
	 */
	public Long getFreightTemplateId() {
		return this.freightTemplateId;
	}

	/**
	 * @Title: setFreightTemplateId
	 * @Description: 设置运费模版ID
	 * @param freightTemplateId 运费模版ID
	 */
	public void setFreightTemplateId(Long freightTemplateId) {
		this.freightTemplateId = freightTemplateId;
	}
	
	/**
	 * @Title: getExpressWay
	 * @Description: 获取快递方式(1平邮, 2快递, 3EMS)
	 * @return 快递方式(1平邮, 2快递, 3EMS)
	 */
	public Integer getExpressWay() {
		return this.expressWay;
	}

	/**
	 * @Title: setExpressWay
	 * @Description: 设置快递方式(1平邮, 2快递, 3EMS)
	 * @param expressWay 快递方式(1平邮, 2快递, 3EMS)
	 */
	public void setExpressWay(Integer expressWay) {
		this.expressWay = expressWay;
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
	 * @Title: getGoodsCount
	 * @Description: 获取商品数量
	 * @return 商品数量
	 */
	public Integer getGoodsCount() {
		return this.goodsCount;
	}

	/**
	 * @Title: setGoodsCount
	 * @Description: 设置商品数量
	 * @param goodsCount 商品数量
	 */
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	
	/**
	 * @Title: getGoodsId
	 * @Description: 获取商品ID
	 * @return 商品ID
	 */
	public Long getGoodsId() {
		return this.goodsId;
	}

	/**
	 * @Title: setGoodsId
	 * @Description: 设置商品ID
	 * @param goodsId 商品ID
	 */
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	
	/**
	 * @Title: getGoodsIdPrice
	 * @Description: 获取商品单价
	 * @return 商品单价
	 */
	public Double getGoodsIdPrice() {
		return this.goodsIdPrice;
	}

	/**
	 * @Title: setGoodsIdPrice
	 * @Description: 设置商品单价
	 * @param goodsIdPrice 商品单价
	 */
	public void setGoodsIdPrice(Double goodsIdPrice) {
		this.goodsIdPrice = goodsIdPrice;
	}
	
	/**
	 * @Title: getGoodsIdDivideprofitPrice
	 * @Description: 获取单件商品结算价
	 * @return 单件商品结算价
	 */
	public Double getGoodsIdDivideprofitPrice() {
		return this.goodsIdDivideprofitPrice;
	}

	/**
	 * @Title: setGoodsIdDivideprofitPrice
	 * @Description: 设置单件商品结算价
	 * @param goodsIdDivideprofitPrice 单件商品结算价
	 */
	public void setGoodsIdDivideprofitPrice(Double goodsIdDivideprofitPrice) {
		this.goodsIdDivideprofitPrice = goodsIdDivideprofitPrice;
	}
	
	/**
	 * @Title: getGoodsIdDiscount
	 * @Description: 获取商品结算比例
	 * @return 商品结算比例
	 */
	public Double getGoodsIdDiscount() {
		return this.goodsIdDiscount;
	}

	/**
	 * @Title: setGoodsIdDiscount
	 * @Description: 设置商品结算比例
	 * @param goodsIdDiscount 商品结算比例
	 */
	public void setGoodsIdDiscount(Double goodsIdDiscount) {
		this.goodsIdDiscount = goodsIdDiscount;
	}
	
	/**
	 * @Title: getGoodsIdName
	 * @Description: 获取商品名称
	 * @return 商品名称
	 */
	public String getGoodsIdName() {
		return this.goodsIdName;
	}

	/**
	 * @Title: setGoodsIdName
	 * @Description: 设置商品名称
	 * @param goodsIdName 商品名称
	 */
	public void setGoodsIdName(String goodsIdName) {
		this.goodsIdName = goodsIdName;
	}
	
	/**
	 * @Title: getGoodsIdPic
	 * @Description: 获取商品图片
	 * @return 商品图片
	 */
	public String getGoodsIdPic() {
		return this.goodsIdPic;
	}

	/**
	 * @Title: setGoodsIdPic
	 * @Description: 设置商品图片
	 * @param goodsIdPic 商品图片
	 */
	public void setGoodsIdPic(String goodsIdPic) {
		this.goodsIdPic = goodsIdPic;
	}
	
	/**
	 * @Title: getGoodsSpecDetailId
	 * @Description: 获取商品规格ID
	 * @return 商品规格ID
	 */
	public Long getGoodsSpecDetailId() {
		return this.goodsSpecDetailId;
	}

	/**
	 * @Title: setGoodsSpecDetailId
	 * @Description: 设置商品规格ID
	 * @param goodsSpecDetailId 商品规格ID
	 */
	public void setGoodsSpecDetailId(Long goodsSpecDetailId) {
		this.goodsSpecDetailId = goodsSpecDetailId;
	}
	
	/**
	 * @Title: getGoodsSpec
	 * @Description: 获取商品规格
	 * @return 商品规格
	 */
	public String getGoodsSpec() {
		return this.goodsSpec;
	}

	/**
	 * @Title: setGoodsSpec
	 * @Description: 设置商品规格
	 * @param goodsSpec 商品规格
	 */
	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}
	
	/**
	 * @Title: getSupplierId
	 * @Description: 获取供应商ID
	 * @return 供应商ID
	 */
	public Long getSupplierId() {
		return this.supplierId;
	}

	/**
	 * @Title: setSupplierId
	 * @Description: 设置供应商ID
	 * @param supplierId 供应商ID
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	
	/**
	 * @Title: getSupplierIdName
	 * @Description: 获取供应商名称
	 * @return 供应商名称
	 */
	public String getSupplierIdName() {
		return this.supplierIdName;
	}

	/**
	 * @Title: setSupplierIdName
	 * @Description: 设置供应商名称
	 * @param supplierIdName 供应商名称
	 */
	public void setSupplierIdName(String supplierIdName) {
		this.supplierIdName = supplierIdName;
	}
	
	/**
	 * @Title: getSupplierIdTel
	 * @Description: 获取供应商联系方式(多个使用空格分隔)
	 * @return 供应商联系方式(多个使用空格分隔)
	 */
	public String getSupplierIdTel() {
		return this.supplierIdTel;
	}

	/**
	 * @Title: setSupplierIdTel
	 * @Description: 设置供应商联系方式(多个使用空格分隔)
	 * @param supplierIdTel 供应商联系方式(多个使用空格分隔)
	 */
	public void setSupplierIdTel(String supplierIdTel) {
		this.supplierIdTel = supplierIdTel;
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
	
	/**
	 * @Title: getWholesalePrice
	 * @Description: 获取集采价格
	 * @return 集采价格
	 */
	public Double getWholesalePrice() {
		return this.wholesalePrice;
	}

	/**
	 * @Title: setWholesalePrice
	 * @Description: 设置集采价格
	 * @param wholesalePrice 集采价格
	 */
	public void setWholesalePrice(Double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	
	/**
	 * @Title: getOrderUserIp
	 * @Description: 获取用户下单IP
	 * @return 用户下单IP
	 */
	public String getOrderUserIp() {
		return this.orderUserIp;
	}

	/**
	 * @Title: setOrderUserIp
	 * @Description: 设置用户下单IP
	 * @param orderUserIp 用户下单IP
	 */
	public void setOrderUserIp(String orderUserIp) {
		this.orderUserIp = orderUserIp;
	}
	
	/**
	 * @Title: getEvaluateStatus
	 * @Description: 获取评价状态(0未评价, 1会员已评价, 2双方已评价)
	 * @return 评价状态(0未评价, 1会员已评价, 2双方已评价)
	 */
	public Integer getEvaluateStatus() {
		return this.evaluateStatus;
	}

	/**
	 * @Title: setEvaluateStatus
	 * @Description: 设置评价状态(0未评价, 1会员已评价, 2双方已评价)
	 * @param evaluateStatus 评价状态(0未评价, 1会员已评价, 2双方已评价)
	 */
	public void setEvaluateStatus(Integer evaluateStatus) {
		this.evaluateStatus = evaluateStatus;
	}
	
	/**
	 * @Title: getLastOrderStatus
	 * @Description: 获取上一次订单状态
	 * @return 上一次订单状态
	 */
	public Integer getLastOrderStatus() {
		return this.lastOrderStatus;
	}

	/**
	 * @Title: setLastOrderStatus
	 * @Description: 设置上一次订单状态
	 * @param lastOrderStatus 上一次订单状态
	 */
	public void setLastOrderStatus(Integer lastOrderStatus) {
		this.lastOrderStatus = lastOrderStatus;
	}
	
	/**
	 * @Title: getOrderSource
	 * @Description: 获取订单来源(1PC, 2APP, 3IOS, 4微商城)
	 * @return 订单来源(1PC, 2APP, 3IOS, 4微商城)
	 */
	public Integer getOrderSource() {
		return this.orderSource;
	}

	/**
	 * @Title: setOrderSource
	 * @Description: 设置订单来源(1PC, 2APP, 3IOS, 4微商城)
	 * @param orderSource 订单来源(1PC, 2APP, 3IOS, 4微商城)
	 */
	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}

	public Double getGoodsIdDealPoint() {
		return goodsIdDealPoint;
	}

	public void setGoodsIdDealPoint(Double goodsIdDealPoint) {
		this.goodsIdDealPoint = goodsIdDealPoint;
	}

	public Double getProfitRatio() {
		return profitRatio;
	}

	public void setProfitRatio(Double profitRatio) {
		this.profitRatio = profitRatio;
	}

	public String getGoodsIdPicWholeFilePath() {
		return goodsIdPicWholeFilePath;
	}

	public void setGoodsIdPicWholeFilePath(String goodsIdPicWholeFilePath) {
		this.goodsIdPicWholeFilePath = goodsIdPicWholeFilePath;
	}
	
}

