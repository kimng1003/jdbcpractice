package com.pronull.view;

import java.util.List;

import com.pronull.controller.OrderController;
import com.pronull.dto.CategoryDTO;

public class OrderMenu {

	private OrderController orderController = new OrderController();
	
	public void displayMainMenu() {
	
	
		// 카테고리 선택
		
		System.out.println("=== PIZZA STORE ===");
		List<CategoryDTO> categoryList = orderController.selectAllcategory();
		
	
	}
	

}
