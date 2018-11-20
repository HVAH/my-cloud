package com.mall.order.repository;


import com.mall.order.domain.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: OrderDetailMapper
 * @Description: 表操作映射
 * @date 2016年4月13日 下午1:26:51
 * 
 */
public interface OrderDetailMapper {
	
	/**
	 * 插入数据
	 * 
	 * @param orderDetail
	 * @return
	 */
	Integer insert(@Param("orderDetail") OrderDetail orderDetail);
	
	/**
	 * 更新数据
	 * 
	 * @param orderDetail
	 * @param where
	 * @return
	 */
	Integer update(@Param("orderDetail") OrderDetail orderDetail, @Param("where") OrderDetail where);

	/**
	 * 根据主键更新
	 * 
	 * @param orderDetail
	 * @param orderDetailId
	 * @return
	 */
	Integer updateById(@Param("orderDetail") OrderDetail orderDetail, @Param("orderDetailId") Long orderDetailId);
	
	/**
	 * 更新有值数据
	 * 
	 * @param orderDetail
	 * @param where
	 * @return
	 */
	Integer updateActive(@Param("orderDetail") OrderDetail orderDetail, @Param("where") OrderDetail where);

	/**
	 * 根据主键更新有值数据
	 * 
	 * @param orderDetail
	 * @param orderDetailId
	 * @return
	 */
	Integer updateActiveById(@Param("orderDetail") OrderDetail orderDetail, @Param("orderDetailId") Long orderDetailId);

	/**
	 * 查询列表
	 * 
	 * @param orderDetail
	 * @return
	 */
	List<OrderDetail> select(@Param("orderDetail") OrderDetail orderDetail);
	/**
	 * 根据虚拟订单id查询订单
	 * @param
	 * 
	 * @param
	 * @return
	 */
	List<OrderDetail> selectByOrderVirtualId(@Param("orderVirtualId") Long orderVirtualId, @Param("vipGoodsOrderFlag") Integer vipGoodsOrderFlag);

	/**
	 * 根据主键查询
	 * 
	 * @param orderDetailId
	 * @return
	 */
	OrderDetail selectById(@Param("orderDetailId") Long orderDetailId);

	/**
	 * 按条件删除
	 * 
	 * @param where
	 * @return
	 */
	Integer delete(@Param("where") OrderDetail where);

	/**
	 * 按主键删除
	 * 
	 * @param orderDetailId
	 * @return
	 */
	Integer deleteById(@Param("orderDetailId") Long orderDetailId);

}
