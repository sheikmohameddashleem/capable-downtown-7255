package com.bms;

public class InvalidDataException extends Exception {

	InvalidDataException(){
		
	}
	InvalidDataException(String msg){
		super(msg);
	}
}