package com.bms;

import java.io.Serializable;

public class BatchID implements Serializable {

	public static int idGenerator() {
		return (int) (Math.random()*1000000);
	}
	
	public static int idGeneratorf() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*100000);
	}
}
