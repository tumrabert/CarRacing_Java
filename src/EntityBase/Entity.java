package EntityBase;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{
	
	protected double x1,y1;
	protected double x2,y2;
	protected boolean visible,destroyed;
	protected int rndIndexCar;
	
	protected Entity() {
		// TODO Auto-generated constructor stub
		visible = true;
		destroyed = false;
	}
	public boolean collideWith(Entity other){

		boolean a,b,c,d;
		a= ((other.x1<this.x2) & (this.x2<other.x2)||(other.x1<this.x1) & (this.x1<other.x2));
		b= ((this.x1<other.x1) & (other.x1<this.x2)||(this.x1<other.x2) & (other.x2<this.x2));
		c=((other.y1<this.y2) &&(this.y2<other.y2))||((other.y1<this.y1) &&(this.y1<other.y2));
		d=((this.y1<other.y2) &&(other.y2<this.y2))||((this.y1<other.y1) &&(other.y1<this.y2));
		return (a&c)||(b&d);

	}
	



	

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	//setter & getter for(x1,y1),(x2,y2);
	public double getX1() {
		return x1;
	}

	public void setX1(double x) {
		this.x1 = x;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y) {
		this.y1 = y;
	}
	public double getX2() {
		return x2;
	}
	public void setX2(double x2) {
		this.x2 = x2;
	}
	public double getY2() {
		return y2;
	}
	public void setY2(double y2) {
		this.y2 = y2;
	}

	
	

}
