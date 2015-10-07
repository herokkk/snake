package com.bryant.game.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ������WormStage��Ϊ�ߵ���̨
 * @author Siyi_Kong
 *
 */
public class WormStage extends JPanel implements MoreCells{
	/**  /** ��ʾ��Ԫ���С ���ظ��� */ 
    public static final int CELL_SIZE = 10;
    /** ��̨��Ԫ������� */
    public static final int CELL_COLS = 35;
    /** ��̨��Ԫ������� */
    public static final int CELL_ROWS = 35;
    /**Ĭ��̰���ߵĳ���*/
    public static final int WORM_LEN=12;
    
    int score=0;
    /**̰����*/
    Worm worm;
    //����ʳ��
    private Cell food;
    /** ����̰�Գ��Զ����еĶ�ʱ�� */
    Timer timer=new Timer();
    /**�Ƿ�alive**/
    static boolean isAlive=true;
    Vector<Cell> bugs=new Vector<>();
    
    public WormStage() {
		// TODO Auto-generated constructor stub
    	setSize(CELL_SIZE*CELL_COLS, CELL_SIZE*CELL_ROWS);
	}
    
    public WormStage(int x,int y) {
		// TODO Auto-generated constructor stub
    	setSize(x,y);
    	
	}
    public Cell randomFood(){
    	int x=RandomUtility.nextInt(CELL_COLS);
    	int y=RandomUtility.nextInt(CELL_ROWS);
    	//Cell objCell=new Cell(x, y);
    	//bugs.add(objCell);//ÿ����һ������һ������
    	return new Cell(x, y);
    }
    
    public void action(){
    	//Scanner scanner=new Scanner(System.in);
    	food=randomFood();
    	worm=new Worm();//��ʼ������
    	timer.schedule(new CreepTask(this), 0,200);
    	requestFocus();
    	addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent e) {
    			// TODO Auto-generated method stub
    			int keyCode=e.getKeyCode();
    			switch (keyCode) {
				case KeyEvent.VK_DOWN:
					worm.changeDirection(Worm.DIRECTION_DOWN);
					creepforFood();
					break;
				case KeyEvent.VK_UP:
                    worm.changeDirection(Worm.DIRECTION_UP);
                    creepforFood();
                    break;
                case KeyEvent.VK_LEFT:
                    worm.changeDirection(Worm.DIRECTION_LEFT);
                    creepforFood();
                    break;
                case KeyEvent.VK_RIGHT:
                    worm.changeDirection(Worm.DIRECTION_RIGHT);
                    creepforFood();
                    break;
				}
    		}
		});

    }
    //��д���Ʒ���paint(), ���ʳ��Ļ������:��ͼ
    @Override
    public void paint(Graphics g) {
    	// TODO Auto-generated method stub
    	/***********************/
    	//������
    	g.setColor(Color.red);
    	g.fillRect(0, 0,getWidth(),getHeight());
    	g.setColor(Color.green);
    	g.drawString("���ĵ÷�: "+score,380,20);
    	/**********************/
    	
    	if (food!=null) {
    		 food.paint(g, new Color(255, 192, 0),  new Color(35, 31, 32));
    		 
		}
    	if (worm!=null) {
			worm.paint(g,new Color(0, 176, 240), new Color(35, 31, 32));
		}
    }
    
    /** ���з���, ���ײͷ�����¿�ʼ */
    public void creepforFood(){
    	if (worm.hit()) {
    		worm.changeDirection(Worm.DIRECTION_DOWN);//����ı䷽������
    		score=0;
			worm=new Worm();
			food=randomFood();
			
		}else {
			boolean eat=worm.creep(food);
			if (eat) {
				score++;
				if(score==easy){
					food=randomFood();
					
					timer.schedule(new CreepTask(this),0,150);
				}else if (score==intermediate) {
					food=randomFood();
					//repaint();
					timer.schedule(new CreepTask(this),0,120);
				}else if (score==advance) {
					food=randomFood();
					timer.schedule(new CreepTask(this),0,80);
				}
				food=randomFood();//�������д�ϣ����������3���÷��⣬�޷�����
			}
		}
    	repaint();//����paint
    }
    
   
    
    @SuppressWarnings("static-access")
	public static void main(String[] args) {
		JFrame jFrame=new JFrame();
		Font font=new Font(Font.DIALOG, Font.BOLD, 10);
		jFrame.setTitle("Worm");
		jFrame.setSize(460,470);
		
		//encapsulate the width and height of an object(single)
		Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
		jFrame.setLocation((int)dimension.getWidth()/2, 
				(int)dimension.getHeight()/2);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(false);
		
		jFrame.setLayout(null);
		WormStage wormStage=new WormStage(460,470);
		jFrame.setVisible(true);
		
		int w=jFrame.getContentPane().getWidth();
		int h=jFrame.getContentPane().getHeight();
		
		wormStage.setLocation(0,0);
	    jFrame.getContentPane().add(wormStage);
	    wormStage.action();
    }

	@Override
	public void MoreBugs(Vector<Cell> vector) {
		// TODO Auto-generated method stub
		for (int i = 0; i <vector.size(); i++) {
			
		}
	}

	
}
