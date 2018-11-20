package com.mall.study.study.designPattern.decorate;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/31 16:08
 * @Version 1.0
 */
public class ConcretComponent extends Component {
	@Override
	public void operation() {
		System.out.println("具体对象的操作");
	}
}
