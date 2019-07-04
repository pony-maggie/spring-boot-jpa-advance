package com.github.ponymaggie.jpa.repository;


import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import com.github.ponymaggie.jpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<Student,Long>,JpaSpecificationExecutor<Student>,Serializable {
	
	/**
	 * 规范方法名查询:意思是如果在接口中定义的查询方法符合它的命名规则，就可以不用写实现
	 * 语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称：
	 */

	List<Student> findByName(String name);
	Long countByName(String name);
	
	//分页查询，spring data jpa已经帮我们实现了分页的功能，在查询的方法中，需要传入参数Pageable ,当查询中有多个参数的时候Pageable建议做为最后一个参数传入
	Page<Student> findAll(Pageable pageable);

	//复杂查询



		
	@Transactional
	@Modifying
	@Query("delete from Student where id = ?1")
	void deleteByUserId(Long id);

	//自定义SQL查询
	@Transactional
	@Modifying
	@Query("update Student u set u.name = ?1 where u.id = ?2")
	int modifyNameById(String  name, Long id);
	 
	@Query("select u from Student u where u.age = ?1")
	List<Student> findByMyAge(int age);
	
}
