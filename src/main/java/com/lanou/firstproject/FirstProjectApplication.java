package com.lanou.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Controller
@RequestMapping("/")
public class FirstProjectApplication {
	public static List<Map<String,Object>> l=new ArrayList();
	public static void main(String[] args) {

		SpringApplication.run(FirstProjectApplication.class, args);
	}
	@RequestMapping("helloWorld")
	@ResponseBody
	public String helloWorld(String name){
		return "屌丝" + name + "你好!";
	}
	@RequestMapping("hello")
	public ModelAndView helloSpringBoot(String name,String pwd){
		ModelAndView mv=new ModelAndView("hello");
		//mv.setViewName("hello");
		List<Map<String,Object>> l=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String,Object> person=new HashMap<>();
			person.put("name","张三"+(i+1));
			person.put("age",10+i+1);
			l.add(person);
		}
		mv.addObject("name",name);
		mv.addObject("pwd",pwd);
		mv.addObject("list",l);
		for(Object o:l){
			System.out.println(o);
		}

		return mv;
	}
	@RequestMapping("re")

	public ModelAndView hello(String name,String pwd){
		ModelAndView mv=new ModelAndView("regist");
		return mv;
	}
	@RequestMapping("regist")

	public ModelAndView regist(HttpServletRequest request, String acc, String pwd){
		ModelAndView mv=new ModelAndView("login");
		Map<String,Object> person=new HashMap<>();
		person.put("acc",acc);
		person.put("pwd",pwd);
		l.add(person);
		return mv;
	}
	@RequestMapping("lo")

	public ModelAndView login(String name,String pwd){
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request, String acc, String pwd){
		Map<String,Object> person=new HashMap<>();
		person.put("acc",acc);
		person.put("pwd",pwd);

		boolean t=l.contains(person);

		if(t){
			return "登陆成功!!";
		}else{
			return "账号或密码输入错误";
		}

	}
	@RequestMapping("info")
	public ModelAndView info(String acc){
		ModelAndView mv=new ModelAndView("UserInfo");

		if(acc==null){
			mv.addObject("list",l);
		}else{
			List<Map<String,Object>> ll=new ArrayList<Map<String,Object>>();
			for(Map<String,Object> o:l){
				if(o.get("acc").equals(acc)){
					ll.add(o);
					mv.addObject("list",ll);
				}
			}
		}

		return mv;
	}

}
