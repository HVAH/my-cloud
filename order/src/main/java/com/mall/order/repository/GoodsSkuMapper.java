package com.mall.order.repository;

import com.mall.order.domain.GoodsSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface GoodsSkuMapper {

	/**
	 * 查询商品sku详情
	 * @param skus
	 * @return
	 * @throws Exception
	 */
	List<GoodsSku> listGoodsSkuByIds(@Param("skus") Collection<Long> skus) throws Exception;

	/**
	 * 插入数据
	 *
	 * @param goodsSku
	 * @return
	 */
	Integer insert(@Param("goodsSku") GoodsSku goodsSku);
	
}
