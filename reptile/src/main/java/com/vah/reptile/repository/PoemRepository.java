package com.vah.reptile.repository;

import com.vah.reptile.entity.Poem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/11/7 10:23 上午
 * @Version 1.0
 **/
@Repository
public interface PoemRepository extends JpaRepository<Poem, Long>, JpaSpecificationExecutor<Poem> {
}
