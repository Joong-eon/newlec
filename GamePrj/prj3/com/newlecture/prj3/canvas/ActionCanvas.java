package com.newlecture.prj3.canvas;

import java.awt.Canvas;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.newlecture.prj3.entity.BackMoveListener;
import com.newlecture.prj3.entity.Background;
import com.newlecture.prj3.entity.Boy;
import com.newlecture.prj3.entity.Enemy;
import com.newlecture.prj3.entity.EnemyMoveListener;
import com.newlecture.prj3.entity.Item;
import com.newlecture.prj3.entity.sje;

public class ActionCanvas extends Canvas {

	public static Canvas instance;

	private Enemy enemy; 
	private Boy[] boys;
	private Boy boy1;
	private Boy boy2;
	private Boy boy3;
	private Boy currentBoy;

	private Background background;
//	private Missile[] missiles;
	int missileSize = 0;

	private Item[] items;
	private int itemSize = 0;
	
//	private final int UP = 1004; //final : 절대 변하지 않는 특정한 것을 정하고 싶을 때                               static :  변수를 인스턴스가 아닌 전역변수로 처리
//	private final int DOWN = 1005;
//	private final int LEFT = 1006;
//	private final int RIGHT = 1007;

	public ActionCanvas() {
		instance = this;

		enemy = new Enemy();
		enemy.setMoveListener(
				new EnemyMoveListener() {
					@Override
					public void onMove() {
						//System.out.println("오호~!");
					}
				}
				);

		// Boy를 생성
		boys = new Boy[3];

		boy1 = new Boy(100,200);
		boy2 = new Boy(200,200);
		boy3 = new Boy(300,200);

		boys[0] = boy1;
		boys[1] = boy2;
		boys[2] = boy3;

		background = new Background();

		items = new Item[100];
		items[0] = background;
		items[1] = boy1;
		items[2] = boy2;
		items[3] = boy3;
		items[4] = enemy;
		itemSize = 5;

		currentBoy = boy1;
		
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
						
						switch(code){
						case KeyEvent.VK_LEFT :
						case KeyEvent.VK_UP :
						case KeyEvent.VK_RIGHT :
						case KeyEvent.VK_DOWN :
							currentBoy.move(code);
							break;
						case KeyEvent.VK_SPACE : 
//							Missile.missile = currentBoy.fire();
				}
				currentBoy.move(e.getKeyCode());
				System.out.printf("KeyCode : %d\n", e.getKeyCode());
			}
		}); 
	}


	public void start() {

		Runnable sub = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					for(int i=0; i<itemSize; i++)
						items[i].update();

					repaint();
					// -> Canvas.update() : 지우기 -> Canvas.paint(g) -> 다시 그리기

					//System.out.println("repaint");

					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread th = new Thread(sub);
		th.start();
		
		//억지로 끝내지말고, while문을 사용하여 자연스럽게 끝낼 수 있도록 만들기
		//th.stop();

	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {

		//		boolean ?;
		//		for(3번)
		//			if()
		//				? = ;
		for(int i=0; i<3; i++)
			if(boys[i].isSelected(x, y)) {
				currentBoy = boys[i];
				System.out.printf("boy[%d] selected", i);
				return super.mouseDown(evt, x, y);
			}

		//		if(boy2.isSelected(x, y)) {
		//			currentBoy = boy2;
		//			System.out.println("boy2 selected");
		//			return super.mouseDown(evt, x, y);
		//		}
		//		
		//		if(boy3.isSelected(x, y)) {
		//			currentBoy = boy3;
		//			System.out.println("boy3 selected");
		//			return super.mouseDown(evt, x, y);
		//		}

		currentBoy.move(x, y);
		repaint();
		return super.mouseDown(evt, x, y);
	}

//	@Override
//	public boolean keyDown(Event evt, int key) {
////		//방법1
////		double x = currentBoy.getX();
////		double y = currentBoy.getY();
////
////		switch(key) {
////		case UP:
//////			currentBoy.위로가();
////			currentBoy.move(x,y-5);
////			break;
////
////		case DOWN:
//////			currentBoy.아래로가();
////			currentBoy.move(x,y+5);
////			break;
////
////		case LEFT:
//////			currentBoy.왼쪽으로가();
////			currentBoy.move(x-5,y);
////			break;
////
////		case RIGHT:
//////			currentBoy.오른쪽으로가();
////			currentBoy.move(x+5,y);
////			break;
////
////		default:
////
////	}
//		//방법2(더 객체지향스러움)
//		currentBoy.move(key);
//
//		currentBoy.setMoveListener(new BackMoveListener() {
//
//			@Override
//			public void onMove() {
//			//System.out.println(2);
//				double x = background.getX();
//				double y = background.getY();
//
//				if(key==UP &&
//						currentBoy.getHeight()>=currentBoy.getY()) {
//					//background.move(x, y + 2);//배경이 아래로
//					background.setY(y+2);
//				}
//				if(key==DOWN &&
//						600 - currentBoy.getHeight()<=currentBoy.getY())
//					background.setY(y-2);
//				
//				if(key==LEFT &&
//						currentBoy.getWidth()>=currentBoy.getX()) 
//					background.setX(x+2);
//				
//				if(key==RIGHT &&
//						currentBoy.getHeight()<=currentBoy.getX())
//					background.setX(x-2);                          
//			}
//		});
//
//		return super.keyDown(evt, key);
//	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		//super.update(g);
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = this.createImage(this.getWidth(), getHeight());
		Graphics bg = buf.getGraphics();

		for(int i=0; i<itemSize; i++)
			items[i].paint(bg);

		g.drawImage(buf, 0, 0, this);//
	}
}

