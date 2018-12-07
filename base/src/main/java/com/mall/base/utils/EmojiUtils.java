package com.mall.base.utils;

import org.apache.commons.lang3.StringUtils;

import com.github.binarywang.java.emoji.EmojiConverter;
import com.vdurmont.emoji.EmojiParser;

/**
 * @description: emoji表情处理工具类
 * @author: huangjiang  2018年5月14日 下午4:31:11
 */
public class EmojiUtils {
	private static EmojiConverter emojiConverter = EmojiConverter.getInstance();
	
	/**
	 * @description: 将字符串中的emoji转换成表情字符串
	 * @author: huangjiang  2018年5月14日 下午4:56:45
	 *
	 * @param input
	 * @return
	 */
	public static String toAlias(String input) {
		if (StringUtils.isBlank(input)) {
			return input;
		}
		return emojiConverter.toAlias(input);
	}
	
	/**
	 * @description:  将字符串中的emoji表情字符串转换成Unicode
	 * @author: huangjiang  2018年5月14日 下午4:57:56
	 *
	 * @param input
	 * @return
	 */
	public static String toUnicode(String input) {
		if (StringUtils.isBlank(input)) {
			return input;
		}
		return emojiConverter.toUnicode(input);
	}
	
	/**
	 * @description: 判断内容中是否含有emoji表情 
	 * @author: huangjiang  2018年5月14日 下午5:25:20
	 *
	 * @param input
	 * @return
	 */
	public static boolean containsEmoji(String input) {
		if (StringUtils.isBlank(input)) {
			return false;
		}
		return com.github.binarywang.java.emoji.EmojiUtils.containsSbEmoji(input);
	}
	
	/**
	 * @description: 移除所有emoji表情 
	 * @author: huangjiang  2018年5月23日 上午9:21:24
	 *
	 * @param input
	 * @return
	 */
	public static String removeAllEmojis(String input) {
		return EmojiParser.removeAllEmojis(input);
	}
}
