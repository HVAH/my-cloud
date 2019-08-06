package com.mall.base.dto.response;

import com.mall.base.constant.Header;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Eescription 查询类接口返回实体
 * @Author HuangJiang
 * @Date 2018/8/20 10:09
 * @Version 1.0
 */
public class RespJson {
	// 数据类型 如(user arLinck 之类的数据名)
	private String type;
	// 数据内容
	private Object data;

	// 分页返回
	public static ResponseEntity<RespJson> newResult(Integer page, Integer size, Long total, String type, Object object) {
		return ResponseEntity.status(HttpStatus.OK)
				.header(Header.X_PAGINATION_PAGE, page.toString())
				.header(Header.X_PAGINATION_PER_PAGE, size.toString())
				.header(Header.X_PAGINATION_COUNT, String.valueOf(total))
				.body(new RespJson(type, object));
	}

	// 单个查询返回
	public static ResponseEntity<RespJson> newResult(String type, Object object) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new RespJson(type, object));
	}

	public RespJson(String type, Object data) {
		this.type = type;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
