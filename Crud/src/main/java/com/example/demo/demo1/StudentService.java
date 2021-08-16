package com.example.demo.demo1;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
	public class StudentService {
		@Autowired
		JdbcTemplate jdbcTemplate;
		@Autowired
		NamedParameterJdbcTemplate npjt;
		
		public String insert(Student s)
		{
			int res=0;
			int id=s.getId();
			String name=s.getName();
			int age=s.getAge();
			int phno=s.getPhno();
			String mail=s.getMail();
			String sql="Insert into itg140 values( ?,?,?,?,?)";
		    res=jdbcTemplate.update(sql,id,name,age,phno,mail);
			if(res>0)
			{
				return "data inserted succesfully";
			}
			else
			{
				return "sorry data insertion failed";
			}
		}
		
		public Map<String, String> insertion(Student s)
		{
			int result=0;
			
			Map<String, String> data1 = new HashMap<String, String>();
			String sql = "insert into itg140 value(:Id,:Name,:Age,:Phno,:Mail)";
			try {

				SqlParameterSource param = new MapSqlParameterSource()

						.addValue("Id", s.getId())
						.addValue("Name",s.getName())
						.addValue("Age",s.getAge())
						.addValue("Phno",s.getPhno())
						.addValue("Mail",s.getMail());
				result = npjt.update(sql, param);
				if (result > 0) {
					data1.put("success", "record updated successfully");
				} else {
					data1.put("sorry", "record updation failed");
				}
			}

			catch (Exception e) {
				System.out.println(e);
				data1.put("error", "Error occured, please try again!");
			}
			return data1;
		}
		
		public Map<String,String> update(Student s)
		{
			int result1=0;
			Map<String,String> data2  = new HashMap<String,String>();
			String sql="update itg140 set name=:Name where id=:Id";
			try
			{
				SqlParameterSource param=new MapSqlParameterSource()
						.addValue("Name",s.getName())
				        .addValue("Id",s.getId());
				result1=npjt.update(sql, param);
				if(result1>0)
				{
					data2.put("success","data updated successfully");
				}
				else
				{
					data2.put("Sorry","data updation failed");
				}
			}
			catch(Exception e)
			{
				data2.put("error occured please try again","try again");
			}
			return data2;
		}

		}
        
		

