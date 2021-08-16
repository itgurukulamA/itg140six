package com.example.demo1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class EmployeeupdateService {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Map<String, String> Updateemploy(Employeeupdate eu)

	{

		int result = 0;
		Map<String, String> data1 = new HashMap<String, String>();
		String sql = "update employee set companyname= :Companyname where id= :Id";
		try {

			SqlParameterSource parameters = new MapSqlParameterSource()

					.addValue("Companyname", eu.getCompanyname())
					.addValue("Id", eu.getId());
			result = namedParameterJdbcTemplate.update(sql, parameters);
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

}