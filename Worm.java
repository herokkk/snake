package com.bryant.game.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Worm {
	 /** ���� �� */
    public static final int DIRECTION_UP = 1;
    /** ���� �� */
    public static final int DIRECTION_DOWN = -1;
    /** ���� �� */
    public static final int DIRECTION_LEFT = 2;
    /** ���� �� */
    public static final int DIRECTION_RIGHT = -2;
    
    /** ��ĵ�ǰ���з��� */
    private static int currentDirection=DIRECTION_DOWN;
	int x=0;//��¼���µ�λ��
	int y=0;
    /** �ڵ����� */
    private Cell[] cells;//���ýڵ���������
    
//    /**��¼�����ƶ���������*/
//    public static boolean VorH;
    
    /**
     * �������ߵĳ�ʼ��λ��
     */
    public Worm() {
		// TODO Auto-generated constructor stub
    	//WormStage.WORM_LEN Ĭ��̰�Գ�ĳ���
    	cells=new Cell[WormStage.WORM_LEN];
    	for (int i = 0; i < cells.length; i++) {
			cells[i]=new Cell(i, 0);
		}
	}
    
//    public void down(){
//    	currentDirection=DIRECTION_UP;
//    }
//    
//    public void left(){
//    	currentDirection=DIRECTION_LEFT;
//    }
//    
//    public void right(){
//    	currentDirection=DIRECTION_RIGHT;
//    }
//    public void up(){
//    	currentDirection=DIRECTION_UP;
//    }
    /**
     * ����(creep)����, ���з���: �Ƴ�ĩβ�ڵ�, ����ͷ�ڵ�
     * @param direction ���з���
     */
    public boolean creep(int direction,Cell food){
    	boolean eat=false;
    	if(direction+currentDirection!=0){
    		currentDirection=direction;
    		Cell newHead=newhead(direction);
    		//�����ͷ�ڵ��Ƿ���ʳ���غ�, ����غϾ���չ�ڵ��������������1
    		if (newHead.getX()==food.getX()&&newHead.getY()==food.getY()) {
				cells=Arrays.copyOf(cells, cells.length+1);
				eat=true;
			}
    		if(newHead!=null){
    			//�Ƴ�ĩβ�ڵ�
    			for (int i =cells.length-1; i>=1; i--) {
    				
    				//�ڼ��̰��µ�ʱ����ü�¼��cells[0]��λ��
					cells[i]=cells[i-1];
//    				if(WormStage.VorH.equals("hor")){
//					if(cells[i].getY()<y){
//						++cells[i].y;
//					}
//					if(currentDirection==DIRECTION_LEFT){
//						--cells[i].x;
//					}else if(currentDirection==DIRECTION_RIGHT){
//						++cells[i].x;
//					}
    				}
				}
    			//������ͷ�ڵ�
    			cells[0]=newHead;
    		}
    	return eat;
    	}
    

    /**
     * ����
     */
    public boolean creep(Cell food){
    	return creep(currentDirection,food);
    }
    
    public void paint(Graphics g, Color b, Color f){
    	for (int i = 0; i < cells.length; i++) {
			cells[i].paint(g, b, f);
		}
    }

	private Cell newhead(int direction) {
		// TODO Auto-generated method stub
		Cell newhead=null;
		Cell head=cells[0];
		
		switch (direction) {
		case DIRECTION_UP:
			newhead=new Cell(head.getX(), head.getY() - 1);
			break;
		case DIRECTION_DOWN:
	            newhead = new Cell(head.getX(), head.getY() + 1);
	            break;
	    case DIRECTION_LEFT:
	            newhead = new Cell(head.getX() - 1, head.getY());
	            break;
	    case DIRECTION_RIGHT:
	            newhead = new Cell(head.getX() + 1, head.getY());
	            break;
		
		}
		return newhead;
	}
	
	/**
     * ����Ƿ�Ҫײ��ͷ��, ֻ�Ǽ����һ�������, ��ִ�����ж���
     *   ����: ײ����Ե 
     * @param direction ��Ҫ���еķ���
     * @return �������ײ��(ײ����Ե )�ͷ���true, ���򷵻�false
     */
	 public boolean hit(int direction){
		 Cell cell=newhead(direction);//��ʱ��cell
		 //��ʵ�����ж����ϽǺ����½�2��
		 if(cell.getX()<0 || cell.getY()<0 || cell.getX()>=WormStage.CELL_COLS
				 ||cell.getY()>=WormStage.CELL_ROWS){
			 return true;
		 }
		 //��չ����  �ж��Ƿ�Ե��Լ�
	        if(this.contains(cell.getX(), cell.getY())){
	            return true;
	        }
		 return false;
	 }
	 
	 /**
	     * ��鵱ǰ�������Ƿ��ײͷ
	     * @return �������ײ���ͷ���true, ���򷵻�false
	     */
	    public boolean hit(){
	        return hit(currentDirection);
	    }
	    
	    /**
	     * ��鵱ǰ̰�Գ������Ƿ����x,y����ڵ㣬���ػ�������cell[0]
	     * @param x 
	     * @param y
	     * @return ��������ڵ�(x,y)�ͷ���true
	     */
	    public boolean contains(int x, int y) {
	        for (int i = 0; i < cells.length; i++) {
	            if (x == cells[i].getX() && y == cells[i].getY()) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public boolean changeDirection(int direction){

	    	if(direction+currentDirection!=0){
	    		currentDirection=direction;
	    		//x=cells[0].getX();
	    		//y=cells[0].getY();
	    		
	    		return true;
	    	}
	    	return false;
	    }
}
