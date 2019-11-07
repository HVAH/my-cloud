package com.mall.base.jpaplugin;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @Description 自定义条件表达式接口
 * @Author HuangJiang
 * @Date 2018/8/17 14:59
 * @Version 1.0
 */
public interface Criterion {
	enum Operator {
		EQ, NE, LIKE, GT, LT, GTE, LTE, AND, OR, IS_MEMBER, IS_NOT_MEMBER, IN, NOT_IN
	}

	Predicate toPredicate(Root<?> root, CriteriaQuery<?> query,
                          CriteriaBuilder builder);

}
