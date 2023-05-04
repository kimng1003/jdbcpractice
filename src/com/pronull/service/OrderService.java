package com.pronull.service;

import static com.pronull.common.JDBCTemplate.close;
import static com.pronull.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.pronull.dao.OrderDAO;
import com.pronull.dto.CategoryDTO;
import com.pronull.dto.MenuDTO;

public class OrderService {

	private OrderDAO orderDAO = new OrderDAO();

	public List<CategoryDTO> selectAllCategory() {
		
		Connection con = getConnection();
		
		List<CategoryDTO> categoryList = orderDAO.selectAllCategory(con);
		
		close(con);
		
		return categoryList;
	}

	public List<MenuDTO> selectMenuBy(int categoryCode) {
		
		Connection con = getConnection();
		
		List<MenuDTO> menuList = orderDAO.selectMenuBy(con, categoryCode);
		close(con);
		
		return menuList;
	}
	
	
}
