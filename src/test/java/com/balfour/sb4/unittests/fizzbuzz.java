package com.balfour.sb4.unittests;

import org.testng.annotations.Test;

public class fizzbuzz {
	private int count = 1;
	
	
	@Test
	public void fizzbuzztest(){
		while(count<101){
			if(count % 15 == 0){
				System.out.println("FizzBuzz");
			}else if(count % 3 == 0){
				System.out.println("Fizz");
			}else if(count % 5 == 0){
				System.out.println("Buzz");
			}else 
				System.out.println(count);
			count ++;
		}
	}

}
