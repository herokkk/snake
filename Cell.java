package com.bryant.game.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 * ������Cell��ʾ��Ԫ������
 * @author Siyi_Kong
 *
 */
public class Cell {
  public int x;
  public int y;
  
  public Cell() {
	// TODO Auto-generated constructor stub
}
  /** ���ƹ����� */
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
  * ��װ�ڵ�Ļ��ƹ���
  * @param g
  * @param g
  * @param r
  */
public void paint(Graphics g, Color b,Color r){
	g.setColor(b);
    g.fillRect(x * WormStage.CELL_SIZE, y * WormStage.CELL_SIZE,
            WormStage.CELL_SIZE, WormStage.CELL_SIZE);
    g.setColor(r);
    //���
    g.drawRect(x * WormStage.CELL_SIZE, y * WormStage.CELL_SIZE,
            WormStage.CELL_SIZE, WormStage.CELL_SIZE);
}
}
