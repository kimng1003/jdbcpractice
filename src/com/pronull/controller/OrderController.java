package com.pronull.controller;
import java.util.List;

import com.pronull.dto.CategoryDTO;
import com.pronull.service.OrderService;

public class OrderController {

	private OrderService orderService = new OrderService();
	
	public List<CategoryDTO> selectAllCategory() {
		
		List<CategoryDTO> categoryList = orderService.selectAllCategory();
		 
		return categoryList;
	}

}
