package ar.edu.unq.po2.prueba;

public class Point {

	private int x;
	private int y;
	
	public Point() {
		super();
		this.setX(0);
		this.setY(0);
	}
	
	public Point(int x, int y) {
		super();
		this.setX(x);
		this.setY(y);
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

	public Point restarCon(Point punto) {
		
		int nuevoEjeX = Math.abs(this.getX() - punto.getX());
		int nuevoEjeY = Math.abs(this.getY() - punto.getY());
		
		return new Point(nuevoEjeX, nuevoEjeY);
	}	
	
}
