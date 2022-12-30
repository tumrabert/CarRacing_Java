package logic;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

import Entity.OtherCar;
import Entity.Coin;
import Entity.PlayerCar;
import EntityBase.Entity;
import input.InputUtility;
import sharedObject.RenderableHolder;

public class GameLogic {
	private PlayerCar player;
	private static ArrayList<Entity> entityformove;
	private static ArrayList<Entity> entityforadd;
	private static boolean lose;
	private static int coincount;
	private static int entitycount;
	public GameLogic() {
		// TODO Auto-generated constructor stub
		player = new PlayerCar(290,800);
		entityformove = new ArrayList<Entity>() ;
		entityforadd = new ArrayList<Entity>() ;
		entitycount = 0 ;
		addNewObject(player);
		coincount = 0 ;
		lose = false ;
	}
	
	private void addNewObject(Entity entity){ //(Entity entity)
		RenderableHolder.getInstance().add(entity);
		entityforadd.add(entity) ;
	}
	
	public void WaveUpdate() {
		Thread updateCar = new Thread(new Runnable() {  

			@Override
			public void run() {

				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000) ;
					while (!isLose() ) {
						OtherCar m = new OtherCar();
						Coin c = new Coin();
						ArrayList<Entity> L= new ArrayList<Entity>();
						L.add(m);
						L.add(c);
						
						Random randomizer = new Random();
						Entity E = L.get(randomizer.nextInt(L.size()));
						
						if(E instanceof OtherCar) {
							addNewObject((OtherCar)E) ;
							entitycount +=1;
						}
						else if(E instanceof Coin) {
							addNewObject((Coin)E) ;
							
						}
						
						if(entitycount<10) {
							Thread.sleep(1000-entitycount*100);
						}
						else {
							Thread.sleep(1000);
						}

					}
				} catch (InterruptedException e) {
				}
			}
		});

		Thread updateMove = new Thread(new Runnable() {

			@Override
			public void run() {

				// TODO Auto-generated method stub
				try {
					while (!isLose()) {
						entityformove = entityforadd ;
						Thread.sleep(5);
						try {
							for (Entity e : entityformove) {
								if(e instanceof OtherCar) {
									if(entitycount < 10)((OtherCar) e).movement(1.5) ;
									else ((OtherCar) e).movement(1) ;
								}
								else if(e instanceof Coin) {((Coin) e).movement() ;}
							}
						} catch(ConcurrentModificationException e) {}

					}
				} catch (InterruptedException e) {
				}
			}
		});

		updateCar.start();
		updateMove.start();
	}
	
	public void logicUpdate(){
		player.update();
		ArrayList<Entity> remove = new ArrayList<Entity>() ;
		try {
			for (Entity e : entityformove) {
				if(e.getY1()  > 960  &!(e instanceof PlayerCar)) {
					remove.add(e) ;
					if((e instanceof OtherCar)) entitycount-=1;
					e.setDestroyed(true);
				}
				if(!e.isDestroyed() ){
					if(player.collideWith(e)) {//check player collision
					if(e instanceof OtherCar) {

							((OtherCar) e).damage(player);
							setLose(true);
							InputUtility.resetInput();
						
					}else if(e instanceof Coin) {
						((Coin) e).addcoin(player);
					} 
					}		
				}
			}
		} catch(ConcurrentModificationException e) {}
		entityforadd.removeAll(remove) ;

	}
	
	
	
	public PlayerCar getPlayer() {
		return player;
	}
	public void setPlayer(PlayerCar player) {
		this.player = player;
	}
	public static ArrayList<Entity> getEntityformove() {
		return entityformove;
	}
	public static void setEntityformove(ArrayList<Entity> entityformove) {
		GameLogic.entityformove = entityformove;
	}
	public static ArrayList<Entity> getEntityforadd() {
		return entityforadd;
	}
	public static void setEntityforadd(ArrayList<Entity> entityforadd) {
		GameLogic.entityforadd = entityforadd;
	}
	public boolean isLose() {
		return lose;
	}
	public static void setLose(boolean lose) {
		GameLogic.lose = lose;
	}
	public static int getCoincount() {
		return coincount;
	}
	public static void addCoincount(int coincount) {
		GameLogic.coincount += coincount;
	}
	public static int getentitycount() {
		return entitycount;
	}
	public static void setentitycount(int entitycount) {
		GameLogic.entitycount = entitycount;
	}
	
	

}
