package com.bryant.game.snake;

import java.util.TimerTask;

/**
 * ��ʱ������, ����������̨�ϵ�̰�Գ��Զ����� 
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
