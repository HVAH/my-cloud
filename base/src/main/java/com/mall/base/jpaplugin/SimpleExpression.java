package com.mall.base.jpaplugin;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * @Description 简单条件表达式
 * @Author HuangJiang
 * @Date 2018/8/17 15:27
 * @Version 1.0
 */
public class SimpleExpression implements  Criterion{

	// 属性名   连表查询规范： 连表属性.字段名.jointype
	private String fieldName;
	// 属性值
	private Object value;
	// 运算符
	private Operator operator;
	// 集合
	private Collection collection = new ArrayList();

	public SimpleExpression() {
	}

	public SimpleExpression(String fieldName, Object value, Operator operator) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
	}

	public SimpleExpression(String fieldName, Collection collection, Operator operator) {
		this.fieldName = fieldName;
		this.collection = collection;
		this.operator = operator;
	}


	@Override
	public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		Path expression;
		if (fieldName.contains(".")) {
			// 表关联数据,只处理一层 如 user.address
			String[] names = fieldName.trim().split("\\.");
			expression = root.get(names[0]);
			JoinType joinType = JoinType.INNER;
			if ("left".equals(names[2])) {
				joinType = JoinType.LEFT;
			} else if ("right".equals(names[2])) {
				joinType = JoinType.RIGHT;
			}
			// 获取该属性的类型
			Class type = expression.getJavaType();
			if (type.equals(Set.class)) {
				expression = root.joinSet(names[0]).get(names[1]);
			} else if (type.equals(Map.class)) {
				expression = root.joinMap(names[0]).get(names[1]);
			} else if (type.equals(List.class)) {
				expression = root.joinList(names[0]).get(names[1]);
			} else {
				expression = root.join(names[0], joinType).get(names[1]);
			}
		} else {
			// 单表查询
			expression = root.get(fieldName);
		}

		// EQ, NE, LIKE, GT, LT, GTE, LTE, IS_MEMBER, IS_NOT_MEMBER, IN
		switch (operator) {
			case EQ:
				return builder.equal(expression ,value);
			case NE:
				return builder.notEqual(expression, value);
			case LIKE:
				return  builder.like((Expression<String>) expression, "%" + value + "%");
			case GT:
				return  builder.greaterThan(expression, (Comparable) value);
			case LT:
				return  builder.lessThan(expression, (Comparable) value);
			case GTE:
				return  builder.greaterThanOrEqualTo(expression, (Comparable) value);
			case LTE:
				return  builder.lessThanOrEqualTo(expression, (Comparable) value);
			case IS_MEMBER:
				return builder.isMember(value, expression);
			case IS_NOT_MEMBER:
				return builder.isNotMember(value, expression);
			case IN:
				return expression.in(collection);
			case NOT_IN:
				return expression.in(collection).not();
			default:
				return null;
		}

	}


}
