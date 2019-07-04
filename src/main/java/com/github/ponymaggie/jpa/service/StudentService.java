package com.github.ponymaggie.jpa.service;

import com.github.ponymaggie.jpa.entity.Student;
import com.github.ponymaggie.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //指定条件分页查询，参数分别是页数和每页的大小
    public Page<Student> findByMySpec(int page, int pageSize) {

        Sort sort = new Sort(Sort.Direction.DESC, "id");

        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Student> students = studentRepository.findAll(new MyTestSpec(), pageable);
        return students;
    }

    private PageRequest buildPageRequest(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        return new PageRequest(page, size, sort);
    }

    //带事务注解的两步操作
    @Transactional
    public void testWithTransactional() throws Exception {

        studentRepository.deleteById(4L);

        Student student = new Student();
        student.setName("test2");
        student.setAge(31);
        student.setSchool("test2 school");
        studentRepository.save(student);

        if (1 == 1) {
            throw new RuntimeException("事务测试抛出一个运行时异常");
        }


    }

    //不带事务注解的两步操作
    public void testWithoutTransactional() throws Exception {

        studentRepository.deleteById(4L);

        Student student = new Student();
        student.setName("test3");
        student.setAge(33);
        student.setSchool("test3 school");
        studentRepository.save(student);

        if (1 == 1) {
            throw new RuntimeException("非事务测试抛出一个运行时异常");
        }
    }


}
