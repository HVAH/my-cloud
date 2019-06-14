package com.vah.jpa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Eescription 复杂条件表达式
 * @Author HuangJiang
 * @Date 2018/8/17 16:11
 * @Version 1.0
 */
public class ComplexExpression implements Criterion{

	// 表达式
	private Criterion[] criterions;
	// 计算符
	private Operator operator;

	public ComplexExpression() {
	}

	public ComplexExpression(Criterion[] criterions, Operator operator) {
		this.criterions = criterions;
		this.operator = operator;
	}

	@Override
	public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		List<Predicate> predicates = new ArrayList<>();
		for (int i = 0; i < this.criterions.length; i++) {
			predicates.add(this.criterions[i].toPredicate(root, query, builder));
		}
		switch (operator) {
			case OR:
				return builder.or(predicates.toArray(new Predicate[predicates.size()]));
			case AND:
				return builder.and(predicates.toArray(new Predicate[predicates.size()]));
			default:
				return null;
		}
	}
}
