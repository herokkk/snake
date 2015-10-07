package com.bryant.game.snake;

import java.util.Vector;

public interface MoreCells {
   public static final int easy=5;
   
   public static final int intermediate=10;
   
   public static final int advance=15;
   
   public void MoreBugs(Vector<Cell> vector);//根据容器里的数量，来分配随机地址
   
}
