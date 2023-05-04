package com.pronull.view;

import java.util.List;
import java.util.Scanner;

import com.pronull.controller.OrderController;
import com.pronull.dto.CategoryDTO;

public class OrderMenu {

	private OrderController orderController = new OrderController();
	
	Scanner sc = new Scanner(System.in);
	
	public void displayMainMenu() {
	
	
		// 카테고리 선택
		
		System.out.println("=== PIZZA STORE ===");
		List<CategoryDTO> categoryList = orderController.selectAllCategory();
		
		for(CategoryDTO category : categoryList) {
			System.out.println(category.getName());
		}
		
		System.out.println("=========================");
		System.out.println("주문하실 종류 입력 : ");
		String intputCategory = sc.nextLine();
		
		int categoryCode = 0;
		for(int i = 0; i < categoryList.size(); i++) {
			CategoryDTO catgegory = categoryList.get(i);
		}
	}
	
	

}
