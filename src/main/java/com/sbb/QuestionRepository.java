package com.sbb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

 @Query("select q "
         + "from Question q "
         + "join SiteUser u on q.author=u "
         + "where u.username = :username "
         + "order by q.createDate desc ")
 List<Question> findCurrentQuestion(@Param("username") String username,
                                    Pageable pageable);

}