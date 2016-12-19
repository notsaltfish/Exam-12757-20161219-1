package com.chen.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chen.dao.CustomerDao;
import com.chen.entity.Customer;
import com.chen.util.DbUtil;
	
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer getCustomerByName(String firstName) {
		Customer userInfo = null;
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(firstName!=null){
			sql = "select * from customer where first_name=?";
			params.add(firstName);
		}
		
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try {
			while(rs.next()){
				userInfo = getCustomerInfo(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbUtil.CloseAll();
		}
		return userInfo;
		
	}
	
	public Customer getCustomerInfo(ResultSet rs){
		
		Customer userInfo = null;
		
		userInfo = new Customer();
		try {
			userInfo.setId(rs.getInt(1));
			userInfo.setStoreId(rs.getInt(2));
			userInfo.setFirstName(rs.getString(3));
			userInfo.setLastName(rs.getString(4));
			userInfo.setEmail(rs.getString(5));
			userInfo.setAddressId(rs.getString(6));
			userInfo.setActive(rs.getInt(7));
			userInfo.setCreateDate(rs.getDate(8));
			userInfo.setLastUpdate(rs.getDate(9));

			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userInfo;
		
		
		
	}

}
