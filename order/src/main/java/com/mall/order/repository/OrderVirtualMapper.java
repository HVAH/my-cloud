package com.mall.order.repository;

import com.mall.order.domain.OrderVirtual;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: OrderVirtualMapper
 * @Description: 表操作映射
 * @date 2016年4月13日 下午1:26:51
 * 
 */
public interface OrderVirtualMapper {
	
	/**
	 * 插入数据
	 * 
	 * @param orderVirtual
	 * @return
	 */
	Integer insert(@Param("orderVirtual") OrderVirtual orderVirtual);
	
	/**
	 * 更新数据
	 * 
	 * @param orderVirtual
	 * @param where
	 * @return
	 */
	Integer update(@Param("orderVirtual") OrderVirtual orderVirtual, @Param("where") OrderVirtual where);

	/**
	 * 根据主键更新
	 * 
	 * @param orderVirtual
	 * @param orderVirtualId
	 * @return
	 */
	Integer updateById(@Param("orderVirtual") OrderVirtual orderVirtual, @Param("orderVirtualId") Long orderVirtualId);
	
	/**
	 * 更新有值数据
	 * 
	 * @param orderVirtual
	 * @param where
	 * @return
	 */
	Integer updateActive(@Param("orderVirtual") OrderVirtual orderVirtual, @Param("where") OrderVirtual where);

	/**
	 * 根据主键更新有值数据
	 * 
	 * @param orderVirtual
	 * @param orderVirtualId
	 * @return
	 */
	Integer updateActiveById(@Param("orderVirtual") OrderVirtual orderVirtual, @Param("orderVirtualId") Long orderVirtualId);

	/**
	 * 查询列表
	 * 
	 * @param orderVirtual
	 * @return
	 */
	List<OrderVirtual> select(@Param("orderVirtual") OrderVirtual orderVirtual);

	/**
	 * 根据主键查询
	 * 
	 * @param orderVirtualId
	 * @return
	 */
	OrderVirtual selectById(@Param("orderVirtualId") Long orderVirtualId);

	/**
	 * 按条件删除
	 * 
	 * @param where
	 * @return
	 */
	Integer delete(@Param("where") OrderVirtual where);

	/**
	 * 按主键删除
	 * 
	 * @param orderVirtualId
	 * @return
	 */
	Integer deleteById(@Param("orderVirtualId") Long orderVirtualId);
}
