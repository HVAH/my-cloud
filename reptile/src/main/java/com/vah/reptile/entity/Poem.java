package com.vah.reptile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 诗词结构
 *
 * @author https://github.com/zhdh
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "md_")
@Entity
public class Poem {

    /**
     * 朝代
     */
    private String dynasty;
    /**
     * 作者
     */
    private String literatureAuthor;
    /**
     * 名称
     */
    private String displayName;
    /**
     * 内容
     */
    private String body;

    /**
     * 类型
     */
    private String type;

}
