package com.github.ponymaggie.jpa.controller;

import java.io.IOException;
import java.util.List;

import com.github.ponymaggie.jpa.entity.Student;
import com.github.ponymaggie.jpa.repository.StudentRepository;
import com.github.ponymaggie.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class JPAController {
	
	@Autowired
	private StudentRepository userJPA;

	@Autowired
	private StudentService studentService;

	//预先在数据库中插入一些数据，源码目录中有数据库脚本文件

	//自定义SQL测试
	@RequestMapping(value = "/byAge", method = RequestMethod.GET)
	public List<Student> byAge(int age) {
		return userJPA.findByMyAge(age);
	}

	@RequestMapping(value = "/modifyNameById", method = RequestMethod.GET)
	public int modifyNameById(String name, Long id) {

		return userJPA.modifyNameById(name, id);
	}

	//复杂查询测试
	@RequestMapping(value = "/findBySpec", method = RequestMethod.GET)
	public Page<Student> findBySpec(int page, int pageSize) {
		return studentService.findByMySpec(page, pageSize);
	}

	//事务异常演示
	@RequestMapping(value = "/twt", method = RequestMethod.GET)
	public void twt() {
		try {
			studentService.testWithTransactional();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/twot", method = RequestMethod.GET)
	public void twot() {
		try {
			studentService.testWithoutTransactional();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//查询列表
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Student> list() {
		return userJPA.findAll();
	}

}
