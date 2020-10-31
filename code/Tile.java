
public class Tile
{
	private int x;//grammes
	private int y;//sthles
	private char symb;//symbolo
	public Tile(int x,int y,char symb)
	{
		this.x=x;
		this.y=y;
		this.symb=symb;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public char getSymb() {return symb;}
	public void setX(int x) {this.x=x;}
	public void setY(int y) {this.y=y;}
	public void setSymb(char symb) {this.symb=symb;}
	public void draw()
	{
		System.out.print(symb+" ");
	}
	
}
