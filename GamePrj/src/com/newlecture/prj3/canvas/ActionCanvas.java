package com.newlecture.prj3.canvas;

import java.awt.Canvas;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

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

	private Item[] items;
	private int itemSize = 0;
	/*
	private final int UP = 1004; //final : 절대 변하지 않는 특정한 것을 정하고 싶을 때                               static :  변수를 인스턴스가 아닌 전역변수로 처리
	private final int DOWN = 1005;
	private final int LEFT = 1006;
	private final int RIGHT = 1007;*/

	public ActionCanvas() {
		instance = this;

		enemy = new Enemy();
		enemy.setMoveListener(
				new EnemyMoveListener() {

					@Override
					public void onMove() {
//						System.out.println("오호~!");

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
		
	}

	public void start() {

		Runnable sub = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {

					//					enemy.update();
					//					for(int i=0; i<boys.length; i++)
					//						boys[i].update();

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

		// ? == true 세 소년에게 모두 물었을 때 모두가 선택이 된적이 없다면.
		// 선택된 소년을 이동 currentBoy.move(x, y);
		//else
		// 선택을 변경		

		repaint();
		return super.mouseDown(evt, x, y);
	}

	@Override
	public boolean keyDown(Event evt, int key) {
		//		System.out.println(key);
		//		//내방법 
		//		switch(key) {
		//			case UP:
		////				currentBoy.위로가();
		//				double up= currentBoy.getY();
		//				up-=10;
		//				currentBoy.setY(up);
		//				break;
		//				
		//			case DOWN:
		////				currentBoy.아래로가();
		//				double down= currentBoy.getY();
		//				down+=10;
		//				currentBoy.setY(down);
		//				break;
		//				
		//			case LEFT:
		////				currentBoy.왼쪽으로가();
		//				double left= currentBoy.getX();
		//				left-=10;
		//				currentBoy.setX(left);
		//				break;
		//				
		//			case RIGHT:
		////				currentBoy.오른쪽으로가();
		//				double right= currentBoy.getX();
		//				right+=10;
		//				currentBoy.setX(right);
		//				break;
		//				
		//			default:
		//			
		//		}
		//방법1
		/*
		double x = currentBoy.getX();
		double y = currentBoy.getY();

		switch(key) {
		case UP:
//			currentBoy.위로가();
//			currentBoy.move(x,y-5);
			break;

		case DOWN:
//			currentBoy.아래로가();
//			currentBoy.move(x,y+5);
			break;

		case LEFT:
//			currentBoy.왼쪽으로가();
//			currentBoy.move(x-5,y);
			break;

		case RIGHT:
//			currentBoy.오른쪽으로가();
//			currentBoy.move(x+5,y);
			break;

		default:

	}*/
		//방법2(더 객체지향스러움)
		currentBoy.move(key);
		
		// 1. 보이가 frame 바깥으로 빠져나가지 않게 제한 걸어두기  => 특정 좌표일때 멈추게 하기
			// 보이가 못움직이게 위치 제한 
			// currentBoy.onMove()		// onMove() : boy가 특정 좌표에 위치했따를 누군가에게 알려주는 작업
		// 2. onMove()를 구현하는 쪽에서 -> background를 움직이기
			// canvas에서 구현 - bacground를  +1만 해보기
		// 3. boy의 이동 방향에 따라 background 움직이기
		
		currentBoy.setMoveListener(new BackMoveListener() {

			@Override
			public void onMove() {
				
				double x = background.getX();
				double y = background.getY();
				//System.out.println(1);
				
				if(currentBoy.getY()<=72)
					background.move(x, y + 5);//배경이 아래로
				if(currentBoy.getY()>= 552)
					background.move(x, y - 5);
				if(currentBoy.getX()<= currentBoy.getWidth()/2+5 &&currentBoy.getX()>=currentBoy.getWidth()/2 -5) {
					System.out.println(x);
					double x2 = background.getX();
					x2 += 5;
					background.setX(x2);
//					background.move(x + 5, y);
				}
				if(currentBoy.getX()>=315)
					background.move(x - 5, y);                           //바운더리 필요


			}
		});
		

		return super.keyDown(evt, key);
	}

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

		//		boy1.paint(bg);
		//		boy2.paint(bg);//
		//		boy3.paint(bg);
		//		enemy.paint(bg);

		g.drawImage(buf, 0, 0, this);//
	}
}

// 1. 소년을 생성할 때 위치를 초기화할 수 있게 하라.
// 2. 세 명의 소년을 띄워라
// 3. 사용자 입력처리 : 마우스로 클릭하면 그 위치로 1번째 소년을 이동시키시오.
// 4. (x,y)가 소년의 좌/상단이 이동의 중심좌표가 된다. 
//     이것을 중심/하단이 되도록 Body.paint 메소드를 수정해서 보정하시오.
// 5. Boy 한테 좌표를 주면서 네가 선택되었니? isSelected(x, y):true/false -> true일 경우 
//    isSelected()의 반환 값이 true 일경우 -> currentBoy.move(x, y)
// 6. 나무, 자동차, 깡통, 로봇....이든 새로운 개체 하나를 등장시키시오.

