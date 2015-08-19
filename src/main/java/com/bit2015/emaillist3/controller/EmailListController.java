package com.bit2015.emaillist3.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.emaillist3.dao.EmailListDao;
import com.bit2015.emaillist3.vo.EmailListVo;

@Controller
public class EmailListController {
	
	@Autowired
	private EmailListDao emailListDao;
	
	@RequestMapping("/list")
	public String list(Model model){
			List<EmailListVo> list = emailListDao.getList();
			model.addAttribute("list", list);
			//model.addAttribute(list); // 이름이 같으면 list만 사용해도 가능하다.
		return "list";
	}
	
	@RequestMapping("/form")
	public String form(){

		return "form_emaillist";
	}
	
	@RequestMapping("/add")
	public String insert(@ModelAttribute EmailListVo emailListVo,
			Model model){
		System.out.println(emailListVo);
			emailListDao.insert(emailListVo);
			
		return "redirect:/list";
	}
	
	@RequestMapping("/delete/{no}")
	@ResponseBody
	public String delete(@PathVariable("no") long no){
		//System.out.println(no);
		emailListDao.delete(no);
		//emailListDao.delete("나","나나");
		return "call delete(" + no + ")";
	}
	
}
