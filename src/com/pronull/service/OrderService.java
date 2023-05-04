package com.pronull.service;

import static com.pronull.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.pronull.dao.OrderDAO;
import com.pronull.dto.CategoryDTO;

public class OrderService {

	private OrderDAO orderDAO = new OrderDAO();

	public List<CategoryDTO> selectAllCategory() {
		
		Connection con = getConnection();
		
		List<CategoryDTO> categoryList = orderDAO.selectAllCategory(con);
		
		return categoryList;
	}
	
	
}
