package com.bit2015.emaillist3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.emaillist3.vo.EmailListVo;

@Repository
public class EmailListDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<EmailListVo> getList() {
		List<EmailListVo> list = 
				(List<EmailListVo>)sqlMapClientTemplate.queryForList("emaillist.list");
		return list;
	}

	public void insert(EmailListVo vo) {
		sqlMapClientTemplate.insert("emaillist.insert", vo);
	}
	
	/*public void insert(EmailListVo vo) {
		long no = (Long)sqlMapClientTemplate.insert("emaillist.insert2", vo);
		System.out.println("--->" + no);
	}*/
	
	public void delete(long no){
		/*EmailListVo vo = new EmailListVo();
		vo.setNo(no);*/
		sqlMapClientTemplate.delete("emaillist.delete", no);
	}
	
	/* 두개 이상을 넘길때 Map를 사용해라
	 public void delete(String firstName, String lastName){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("fn", firstName);
		map.put("ln", lastName);
		
		sqlMapClientTemplate.delete(
				"emaillist.deletebyname", map);
	}*/
	
	
}
