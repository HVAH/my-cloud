package com.mall.base.jpaplugin;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description 自定义查询容器
 * @Author HuangJiang
 * @Date 2018/8/17 15:18
 * @Version 1.0
 */
public class Criteria<T> implements Specification<T> {

	// 条件表达式
	private List<Criterion> criterions = new ArrayList<>();
	// 排序表达式
	private List<OrderBy> orderByList = new ArrayList<>();

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate predicate = null;
		if (!criterions.isEmpty()) {
			List<Predicate> predicates = new ArrayList<>();
			for (Criterion criterion : criterions) {
				predicates.add(criterion.toPredicate(root, query, criteriaBuilder));
			}
			if (predicates.size() > 0) {
				predicate = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			} else {
				predicate = criteriaBuilder.conjunction();
			}
		}
		List<Order> orders = new ArrayList<>();
		for (OrderBy orderBy : orderByList) {
			orders.add(orderBy.toOrder(root, criteriaBuilder));
		}
		if (orders.size() > 0) {
			query.orderBy(orders);
		}
		return predicate;
	}

	/**
	 * 添加条件表达式
	 * @param criterion
	 */
	private Criteria add(Criterion criterion) {
		if (criterion != null) {
			criterions.add(criterion);
		}
		return this;
	}


	/**
	 * 添加排序表达式
	 * @param orderBy
	 * @return
	 */
	private Criteria order(OrderBy orderBy) {
		if (orderBy != null) {
			orderByList.add(orderBy);
		}
		return this;
	}

	/**
	 * 降序
	 * @param name
	 * @return
	 */
	public Criteria desc(String name) {
		return this.order(new OrderBy(name, OrderBy.Direction.desc));
	}

	/**
	 * 降序
	 * @param name
	 * @return
	 */
	public Criteria asc(String name) {
		return this.order(new OrderBy(name, OrderBy.Direction.asc));
	}
	/**
	 * 排序
	 * @param name
	 * @return
	 */
	public Criteria order(String order, String name) {
		if ("esc".equals(order)) {
			return this.asc(name);
		} else if ("desc".equals(order)) {
			return this.desc(name);
		} else {
			return this;
		}
	}

	/**
	 * 等于
	 */
	public Criteria eq(String fieldName, Object value, boolean ignoreNull) {
		if (!ignoreNull || !StringUtils.isEmpty(value)) {
			return this.add(new SimpleExpression(fieldName, value, Criterion.Operator.EQ));
		}
		return this;
	}

	/**
	 * 集合包含某个元素
	 */
	public Criteria hasMember(String fieldName, Object value, boolean ignoreNull) {
		if (!ignoreNull || !StringUtils.isEmpty(value)) {
			return this.add(new SimpleExpression(fieldName, value, Criterion.Operator.IS_MEMBER));
		}
		return this;
	}

	/**
	 * 不等于
	 */
	public Criteria ne(String fieldName, Object value, boolean ignoreNull) {
		if (!ignoreNull || !StringUtils.isEmpty(value)) {
			return this.add(new SimpleExpression(fieldName, value, Criterion.Operator.NE));
		}
		return this;
	}

	/**
	 * 模糊匹配
	 */
	public Criteria like(String fieldName, String value, boolean ignoreNull) {
		if (!ignoreNull || !StringUtils.isEmpty(value)) {
			return this.add(new SimpleExpression(fieldName, value, Criterion.Operator.LIKE));
		}
		return this;
	}


	/**
	 * 大于
	 */
	public Criteria gt(String fieldName, Object value, boolean ignoreNull) {
		if (!ignoreNull || !StringUtils.isEmpty(value)) {
			return this.add(new SimpleExpression(fieldName, value, Criterion.Operator.GT));
		}
		return this;
	}

	/**
	 * 小于
	 */
	public Criteria lt(String fieldName, Object value, boolean ignoreNull) {
		if (!ignoreNull || !StringUtils.isEmpty(value)) {
			return this.add(new SimpleExpression(fieldName, value, Criterion.Operator.LT));
		}
		return this;
	}

	/**
	 * 小于等于
	 */
	public Criteria lte(String fieldName, Object value, boolean ignoreNull) {
		if (!ignoreNull || !StringUtils.isEmpty(value)) {
			return this.add(new SimpleExpression(fieldName, value, Criterion.Operator.GTE));
		}
		return this;
	}

	/**
	 * 大于等于
	 */
	public Criteria gte(String fieldName, Object value, boolean ignoreNull) {
		if (!ignoreNull || !StringUtils.isEmpty(value)) {
			return this.add(new SimpleExpression(fieldName, value, Criterion.Operator.LTE));
		}
		return this;
	}

	/**
	 * 并且
	 */
	public Criteria and(Criterion... criterions) {
		return this.add(new ComplexExpression(criterions, Criterion.Operator.AND));
	}

	/**
	 * 或者
	 */
	public Criteria or(Criterion... criterions) {
		return this.add(new ComplexExpression(criterions, Criterion.Operator.OR));
	}

	/**
	 * 包含于
	 */
	public Criteria in(String fieldName, Collection value, boolean ignoreNull) {
		if (ignoreNull && (value == null || value.isEmpty())) {
			return this;
		}
		return this.add(new SimpleExpression(fieldName, value, Criterion.Operator.IN));
	}
	/**
	 * 不包含于
	 */
	public Criteria notIn(String fieldName, Collection value, boolean ignoreNull) {
		if (ignoreNull && (value == null || value.isEmpty())) {
			return this;
		}
		return this.add(new SimpleExpression(fieldName, value, Criterion.Operator.NOT_IN));
	}

	/**
	 * 连接查询
	 * @param criteria 被连接表的条件
	 * @param joinType 连接类型
	 * @param name 关联实体的字段名
	 * @return
	 */
	public Criteria join(String name, Criteria<T> criteria, JoinType joinType) {
		return null;
	}

	/**
	 * 集合包含某几个元素，譬如可以查询User类中Set<String> set包含"ABC","bcd"的User集合，
	 * 或者查询User中Set<Address>的Address的name为"北京"的所有User集合
	 * 集合可以为基本类型或者JavaBean，可以是one to many或者是@ElementCollection
	 * @param fieldName
	 * 列名
	 * @param value
	 * 集合
	 * @return
	 * expresssion
	 */
	public Criteria hasMembers(String fieldName, Object... value) {
		SimpleExpression[] ses = new SimpleExpression[value.length];
		int i = 0;
		//集合中对象是基本类型，如Set<Long>，List<String>
		Criterion.Operator operator = Criterion.Operator.IS_MEMBER;
		//集合中对象是JavaBean
		if (fieldName.contains(".")) {
			operator = Criterion.Operator.EQ;
		}
		for (Object obj : value) {
			ses[i] = new SimpleExpression(fieldName, obj, operator);
			i++;
		}
		return this.add(new ComplexExpression(ses, Criterion.Operator.OR));
	}
}
