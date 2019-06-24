package com.mall.study.designPattern.decorate;

/**
 * @Description TODO
 * @Author HuangJiang
 * @Date 2018/8/31 16:10
 * @Version 1.0
 */
public abstract class Decrator extends Component{
	protected Component component;

	public void setComponent(Component component) {
		this.component = component;
	}

	@Override
	public void operation() {
		if (component != null) {
			component.operation();
		}
	}
}
