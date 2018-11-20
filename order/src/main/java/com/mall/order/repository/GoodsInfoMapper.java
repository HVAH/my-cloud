package com.mall.order.repository;

import com.mall.order.domain.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface GoodsInfoMapper {
	
	List<GoodsInfo> listGodosInfoByIds(@Param("ids")Collection ids);

	/**
	 * 插入数据
	 *
	 * @param goodsInfo
	 * @return
	 */
	Integer insert(@Param("goodsInfo") GoodsInfo goodsInfo);

	/**
	 * 查询列表
	 *
	 * @param goodsInfo
	 * @return
	 */
	List<GoodsInfo> select(@Param("goodsInfo") GoodsInfo goodsInfo);
}
