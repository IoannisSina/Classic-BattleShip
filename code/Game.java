import java.util.*;
import java.io.*;
import javax.swing.*;
public class Game {
public static void main(String args[])
{
	Player me=new Player("me");
	Player pc=new Player("pc");
		
	pc.placeAllShips();
	char orien;
	int coords[];
	int randcoords[];
	
	
	Random j=new Random();
	
	
	//pc.placeAllShips();
	System.out.println("Random placement of  ships or place them your self?(for random press y else press n)");
	boolean random=randomPlace();
	if(random)
	{
		me.placeAllShips();
		me.drawboards(pc);
	}
	else
	{
		Ship[] ships=new Ship[5];
		Carrier car=new Carrier();
		Battleship bat=new Battleship();
		Cruiser cru=new Cruiser();
		Submarine sub=new Submarine();
		Destroyer des=new Destroyer();
		ships[0]=car;
		ships[1]=bat;
		ships[2]=cru;
		ships[3]=sub;
		ships[4]=des;
		for(int i=0;i<5;i++)
		{
			
			
			System.out.println("Give coords and orientation(H/V) for "+ships[i].getShipname()+"(size="+ships[i].getSize()+"):");
			coords=getInput();
			orien=getOrientation();
			me.placeShip(coords[0],coords[1] ,orien , ships[i]);
			me.drawboards(pc);
			
		}
	}
	
	
	boolean aj=false;
	boolean enemy=false;
	
	System.out.println("Lets start playing.Give coords to fire:");
	while(!aj&&!enemy&&Arraysize.voles>0)
	{
		coords=getInput();
		randcoords=getRandInput();
		me.SytsemClear();
		me.fire(coords[0],coords[1], pc);
		pc.fire(randcoords[0], randcoords[1], me);
		me.drawboards(pc);
		me.getStats();
	        Arraysize.voles--;
		System.out.println("You have more "+Arraysize.voles+" voles.");
		//System.out.println(me.Check());
		aj=me.getBoard().AllShipsSunk();
		enemy=pc.getBoard().AllShipsSunk();
		
		
		
		
	}
	if(aj)
	{
		System.out.println("YOU LOST.");
	}
	else
	{
		System.out.println("YOU WON.");
	}
	
	
}
public static int[] getInput()
{
	Scanner read=new Scanner(System.in);
	int[] coords=new int[2];
	boolean ok=true;
	coords[0]=read.nextInt();
	coords[1]=read.nextInt();
	while((coords[0]>Arraysize.arraysize-1 ||coords[0]<0)||(coords[1]>Arraysize.arraysize-1 ||coords[1]<0))
	{
		System.out.println("Coords must be from 0 to "+Arraysize.arraysize+" :");
		
				coords[0]=read.nextInt();
				coords[1]=read.nextInt();
				
			
	}
		
	
	
	return coords;
}
	public static int[] getRandInput()
	{
		Random e=new Random();
		int [] randcoords=new int[2];
		randcoords[0]=e.nextInt(Arraysize.arraysize);
		randcoords[1]=e.nextInt(Arraysize.arraysize);
		return randcoords;
	}
	public static char getOrientation()
	{
		char orien;
		Scanner g=new Scanner(System.in);
		orien=g.next().charAt(0);
		while((orien!='H')&&(orien!='V'))
		{
			System.out.println("orientation must be H(horizontal) or V(verticl).");
			orien=g.next().charAt(0);
		}
		
		return orien;
	}

	public static boolean randomPlace()
	{
		Scanner a=new Scanner(System.in);
		char random;
		random=a.next().charAt(0);
		if(random=='y' || random=='Y')
		{
			return true;
		}
		else 
		{
			return false;
		}
			
		
	}
	
}


