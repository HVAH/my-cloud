package com.mall.base.jpaplugin;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.io.Serializable;

/**
 * @Description 简单排序表达式
 * @Author HuangJiang
 * @Date 2018/8/21 16:04
 * @Version 1.0
 */
public class OrderBy implements Serializable {

	private static final long serialVersionUID = -3078342809727773232L;

	/** 排序方向 */
	public enum Direction {
		asc, desc
	}

	/** 默认方向 */
	private static final OrderBy.Direction DEFAULT_DIRECTION = OrderBy.Direction.desc;

	/** 属性 */
	private String fieldName;

	/** 方向 */
	private OrderBy.Direction direction = DEFAULT_DIRECTION;

	public OrderBy() {
	}

	public OrderBy(String fieldName, Direction direction) {
		this.fieldName = fieldName;
		this.direction = direction;
	}


	public Order toOrder(Root<?> root, CriteriaBuilder criteriaBuilder) {
		Path expression = root.get(fieldName);
		switch (direction) {
			case asc:
				return criteriaBuilder.asc(expression);
			case desc:
				return criteriaBuilder.desc(expression);
			default:
				return criteriaBuilder.desc(expression);
		}
	}
}
