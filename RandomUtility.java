package com.bryant.game.snake;

import java.util.Random;

public class RandomUtility{
   static Random random;
	
   //Singleton
   public static Random getRandom() {
	   if(random==null){
		   random=new Random();
		   return random;
	   }
	return random;
}
	public static int nextInt(int num) {
		 random=getRandom();
		 
		return random.nextInt(num);
		// TODO Auto-generated method stub
		
	}
}
