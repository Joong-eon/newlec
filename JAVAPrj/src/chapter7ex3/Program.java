package chapter7ex3;

public class Program {

	public static void main(String[] args) {
	
		GameFrame frame = new GameFrame();
		frame.setVisible(true);
		frame.setSize(500,700);
		
		
		Fighter fighter = new Fighter();
		Enemy enemy = new Enemy();
		Missile missile =new Missile();
		
		fighter.moveUp();
		fighter.moveDown();
		fighter.moveRight();
		fighter.moveLeft();
		
		enemy.moveRandom();

	}
}