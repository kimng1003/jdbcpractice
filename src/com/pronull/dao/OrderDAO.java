package com.pronull.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import static com.pronull.common.JDBCTemplate.*;
import com.pronull.dto.CategoryDTO;

public class OrderDAO {

	private Properties prop = new Properties();

	public OrderDAO() {

		try {
			prop.loadFromXML(new FileInputStream("mapper/order-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public List<CategoryDTO> selectAllCategory(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<CategoryDTO> categoryList = null;
		
		String query = prop.getProperty("selectAllCategory");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				
				CategoryDTO category = new CategoryDTO();
				category.setCode(rset.getInt("CATEGORY_CODE"));
				category.setName(rset.getString("CATEGORY_NAME"));

				categoryList.add(category);
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
			
		}
		
		return categoryList;
	}
	

	
	
	
	
	
}
