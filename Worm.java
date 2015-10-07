package com.bryant.game.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Worm {
	 /** 方向 上 */
    public static final int DIRECTION_UP = 1;
    /** 方向 下 */
    public static final int DIRECTION_DOWN = -1;
    /** 方向 左 */
    public static final int DIRECTION_LEFT = 2;
    /** 方向 右 */
    public static final int DIRECTION_RIGHT = -2;
    
    /** 虫的当前运行方向 */
    private static int currentDirection=DIRECTION_DOWN;
	int x=0;//记录按下的位置
	int y=0;
    /** 节点数组 */
    private Cell[] cells;//利用节点来构建蛇
    
//    /**记录横向移动还是纵向*/
//    public static boolean VorH;
    
    /**
     * 控制了蛇的初始化位置
     */
    public Worm() {
		// TODO Auto-generated constructor stub
    	//WormStage.WORM_LEN 默认贪吃虫的长度
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
     * 爬行(creep)方法, 爬行方法: 移除末尾节点, 增加头节点
     * @param direction 爬行方向
     */
    public boolean creep(int direction,Cell food){
    	boolean eat=false;
    	if(direction+currentDirection!=0){
    		currentDirection=direction;
    		Cell newHead=newhead(direction);
    		//检查新头节点是否与食物重合, 如果重合就扩展节点数组的容量增加1
    		if (newHead.getX()==food.getX()&&newHead.getY()==food.getY()) {
				cells=Arrays.copyOf(cells, cells.length+1);
				eat=true;
			}
    		if(newHead!=null){
    			//移除末尾节点
    			for (int i =cells.length-1; i>=1; i--) {
    				
    				//在键盘按下的时候，最好记录下cells[0]的位置
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
    			//插入新头节点
    			cells[0]=newHead;
    		}
    	return eat;
    	}
    

    /**
     * 爬行
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
     * 检查是否将要撞击头部, 只是检查下一步的情况, 不执行爬行动作
     *   包括: 撞击边缘 
     * @param direction 将要运行的方向
     * @return 如果发生撞击(撞击边缘 )就返回true, 否则返回false
     */
	 public boolean hit(int direction){
		 Cell cell=newhead(direction);//临时的cell
		 //其实就是判断左上角和右下角2点
		 if(cell.getX()<0 || cell.getY()<0 || cell.getX()>=WormStage.CELL_COLS
				 ||cell.getY()>=WormStage.CELL_ROWS){
			 return true;
		 }
		 //扩展部分  判断是否吃到自己
	        if(this.contains(cell.getX(), cell.getY())){
	            return true;
	        }
		 return false;
	 }
	 
	 /**
	     * 检查当前方向上是否会撞头
	     * @return 如果发生撞击就返回true, 否则返回false
	     */
	    public boolean hit(){
	        return hit(currentDirection);
	    }
	    
	    /**
	     * 检查当前贪吃虫身上是否包含x,y坐标节点，返回回来的是cell[0]
	     * @param x 
	     * @param y
	     * @return 如果包含节点(x,y)就返回true
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
