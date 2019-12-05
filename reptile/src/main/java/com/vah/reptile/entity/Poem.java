package com.vah.reptile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 诗词结构
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "poem")
@Entity
public class Poem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    /**
     * 朝代
     */
    private String dynasty;
    /**
     * 作者
     */
    @Column(name = "author")
    private String literatureAuthor;
    /**
     * 名称
     */
    @Column(name = "title")
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
