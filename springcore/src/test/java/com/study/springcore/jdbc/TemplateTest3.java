package com.study.springcore.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.ls.LSOutput;

import com.study.springcore.aop.Calc;
import com.study.springcore.jdbc.entity.Emp;
import com.study.springcore.jdbc.template.EmpDao;
import com.study.springcore.jdbc.template.EmpJobDao;

public class TemplateTest3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpJobDao empJobDao = ctx.getBean("empJobDao", EmpJobDao.class);
		empJobDao.queryEmps().forEach(System.out::println);
		System.out.println();
		empJobDao.queryJobs().forEach(System.out::println);
		System.out.println();
		empJobDao.queryEmps2().forEach(System.out::println);
		System.out.println();
		empJobDao.queryJobs2().forEach(System.out::println);
	}
	
}