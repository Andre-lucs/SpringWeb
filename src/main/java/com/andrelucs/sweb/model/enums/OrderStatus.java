package com.andrelucs.sweb.model.enums;

public enum OrderStatus {
	WAITING_PAYMEMT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int code;
	OrderStatus(int i) {
		code = i;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus v : OrderStatus.values()) {
			if (v.getCode() == code) {
				return v;
			}
		}
		throw new IllegalArgumentException("Invalid Status Code"); 
	}
}
