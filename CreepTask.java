package com.bryant.game.snake;

import java.util.TimerTask;

/**
 * 定时器任务, 用于驱动舞台上的贪吃虫自动运行 
 */
public class CreepTask extends TimerTask {
  WormStage wormStage;
  
    
public CreepTask(WormStage wormStage) {
	this.wormStage = wormStage;
}


	@Override
	public void run() {
		// TODO Auto-generated method stub
     wormStage.creepforFood();
	}

}
