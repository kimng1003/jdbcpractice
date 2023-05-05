package com.pronull.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pronull.controller.OrderController;
import com.pronull.dto.CategoryDTO;
import com.pronull.dto.MenuDTO;
import com.pronull.dto.OrderMenuDTO;

public class OrderMenu {

	private OrderController orderController = new OrderController();
	
	Scanner sc = new Scanner(System.in);
	
	public void displayMainMenu() {
	
		List<OrderMenuDTO> orderMenuList = new ArrayList<>();
		int totalOrderPrice = 0;
	
		// 카테고리 선택
	do {	
		System.out.println("===== PIZZA STORE =====");
		List<CategoryDTO> categoryList = orderController.selectAllCategory();
		
		for(CategoryDTO category : categoryList) {
			System.out.println(category.getName());
		}
		
		System.out.println("=========================");
		System.out.println("주문하실 종류 입력 : ");
		String intputCategory = sc.nextLine();
		
		
		// 선택된 카테고리 메뉴 조회
		
		int categoryCode = 0;
		for(int i = 0; i < categoryList.size(); i++) {
			CategoryDTO category = categoryList.get(i);
			
			if(category.getName().equals(intputCategory)){
				categoryCode = category.getCode();
			}
		}
		
		System.out.println("===== 주문 가능 메뉴 =====");

		List<MenuDTO> menuList = orderController.selectMenuBy(categoryCode);
		
		for(MenuDTO menu : menuList) {
			System.out.println(menu.getName() + ": " + menu.getPrice() + "원");
		}

		System.out.println("주문 메뉴 선택 : ");
		String inputmenu = sc.nextLine();
		
		int menuCode = 0;
		int menuPrice = 0;
		for(int i = 0; i < menuList.size(); i++) {
			
			MenuDTO menu = menuList.get(i);
			
			if(menu.getName().equals(inputmenu)) {
				menuCode = menu.getCode();
				menuPrice = menu.getPrice();
			}
		}
		
		System.out.println("주문 수량 : ");
		int orderAmount = sc.nextInt();
		
		
		OrderMenuDTO orderMenu = new OrderMenuDTO();
		
		orderMenu.setMenuCode(menuCode);
		orderMenu.setOrderAmount(orderAmount);
		
		orderMenuList.add(orderMenu);
		
		totalOrderPrice += (menuPrice * orderAmount);
		
		sc.nextLine();
		System.out.println("계속 주문? (예/아니오)");
		boolean isContinue = sc.nextLine().equals("예")? true : false;
		
		if(!isContinue) {
		 System.out.println("주문 종료함");	break;
		}
		
		
	}while(true);
		
	}
	
	
	
	

}
