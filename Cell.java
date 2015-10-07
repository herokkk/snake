package com.bryant.game.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 创建类Cell表示单元格类型
 * @author Siyi_Kong
 *
 */
public class Cell {
  public int x;
  public int y;
  
  public Cell() {
	// TODO Auto-generated constructor stub
}
  /** 复制构造器 */
  public Cell(Cell cell){
	  this(cell.x,cell.y);
  }
  
public Cell(int x,int y){
	  this.x=x;
	  this.y=y;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
  
 @Override
public String toString() {
// TODO Auto-generated method stub
return  x + "," + y;
}
 
 /**
  * 封装节点的绘制过程
  * @param g
  * @param g
  * @param r
  */
public void paint(Graphics g, Color b,Color r){
	g.setColor(b);
    g.fillRect(x * WormStage.CELL_SIZE, y * WormStage.CELL_SIZE,
            WormStage.CELL_SIZE, WormStage.CELL_SIZE);
    g.setColor(r);
    //描边
    g.drawRect(x * WormStage.CELL_SIZE, y * WormStage.CELL_SIZE,
            WormStage.CELL_SIZE, WormStage.CELL_SIZE);
}
}
