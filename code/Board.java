import java.util.*;
import javax.swing.*;
public class Board {
private Tile[][] array=new Tile[Arraysize.arraysize][Arraysize.arraysize];
public Board() 
{
	for(int i=0;i<Arraysize.arraysize;i++)
	{
		for(int j=0;j<Arraysize.arraysize;j++)
		{
			Tile t=new Tile(i,j,'~');//dhmioyrgia antikimenwn typoy tile
			array[i][j]=t;//inserting objects
			
		}
	}
}

public  void drawboards(Board a)//ektypwsh kai twn duo pinakwn
{
	//String [][] boards;
	System.out.println("-----------------------------------------");
    System.out.println("- - -  YOU  - - - -\t - -OPPONENT- -");
    System.out.print("  ");
    for(int k=0;k<Arraysize.arraysize;k++)
    System.out.print(k+" ");
    System.out.print("\t");
    System.out.print("  ");
    for(int k=0;k<Arraysize.arraysize;k++)
    System.out.print(k+" ");
    System.out.print("\n");
    for(int i=0;i<Arraysize.arraysize;i++)
    {
        System.out.print(i+" ");
        for(int j=0;j<Arraysize.arraysize;j++)
        {
            array[i][j].draw();
        }
        System.out.print("\t");
        System.out.print(i+" ");
        for(int g=0;g<Arraysize.arraysize;g++)
        {
        	if(a.array[i][g].getSymb()=='s')
        	{
        		a.array[i][g].setSymb('~');
        		a.array[i][g].draw();
        		a.array[i][g].setSymb('s');
        	}
        	else
        	a.array[i][g].draw();
        }
        System.out.print("\n");
    }
    System.out.println("-----------------------------------------");
}
public boolean getAdjacentTiles(int x,int y)//elengxos an yparxoyn ploia perimetrika enos keliou
{
	
    int i,j;
    int counter=0;
    
    if(x==0 && y==0)
    {
        if(array[0][1].getSymb()=='s' || array[1][0].getSymb()=='s')
        {
            counter++;
        }
     }
    else if(x==Arraysize.arraysize-1 && y==0)
    {
        if(array[Arraysize.arraysize-2][0].getSymb()=='s'||array[Arraysize.arraysize-1][1].getSymb()=='s')
        {
            counter ++;
        }
    }
    else if(x==0 && y==Arraysize.arraysize-1)
    {
        if(array[1][Arraysize.arraysize-1].getSymb()=='s'||array[0][Arraysize.arraysize-2].getSymb()=='s')
        {
            counter++;
        }
    }
    else if(x==Arraysize.arraysize-1 && y==Arraysize.arraysize-1)
    {
        for( i=x-1;i<=x;i++)
        {
            for( j=y-1;j<=y;j++)
            {
                if(array[i][j].getSymb()=='s')counter++;
            }
        }
    }
    else if(x==0)
    {
        for( i=y-1;i<=y+1;i=i+2)
        {
            if(array[x][i].getSymb()=='s')
            counter++;
        }
        if(array[x+1][y].getSymb()=='s')
        counter++;
    }
    else if(x==Arraysize.arraysize-1)
    {
        for( i=y-1;i<=y+1;i=i+2)
        {
            if(array[x][i].getSymb()=='s')
            counter++;
        }
        if(array[x-1][y].getSymb()=='s')
        counter++;
    }
    else if(y==0)
    {
        for( i=x-1;i<=x+1;i=i+2)
        {
            if(array[i][y].getSymb()=='s')
            counter++;
        }
        if(array[x][y+1].getSymb()=='s')
        counter++;
    }
    else if(y==Arraysize.arraysize-1)
    {
        for( i=x-1;i<=x+1;i=i+2)
        {
            if(array[i][y].getSymb()=='s')
            counter++;
        }
        if(array[x][y-1].getSymb()=='s')
        counter++;
    }
    else 
    {
        for( i=y-1; i<=y+1; i=i+2)
        {
            if(array[x][i].getSymb()=='s')
            counter++;
        }
        for( i=x-1; i<=x+1; i=i+2)
        {
            if(array[i][y].getSymb()=='s')
            counter++;
        }
    }
    

    
    if(counter==0)
    {return true;}//no ship symbol
    else
    {return false;}
   
}
public 	Tile[][] getArray()//epistrofh pinaka
{
	return array;
}
public boolean AllShipsSunk()//ola ta ploia einai vithismena
{
	int counter=0;
    for(int i=0;i<Arraysize.arraysize;i++)
    {
        for(int j=0;j<Arraysize.arraysize;j++)
        {
            if(array[i][j].getSymb()=='s')counter++;
        }
    }
    if(counter==0)return true;
    else  
    	return false;
}
public void placeAllShips() // tyxaia topothethsh
{
	Random r=new Random();
	Carrier car=new Carrier();
	Battleship bat=new Battleship();
	Cruiser cru=new Cruiser();
	Submarine sub=new Submarine();
	Destroyer des=new Destroyer();
	Ship[] ships=new Ship[5];//pinakas typou ship
	ships[0]=car;
	ships[1]=bat;
	ships[2]=cru;
	ships[3]=sub;
	ships[4]=des;
	
	for(int i=0;i<5;i++)
	{
		ships[i].placeShip(r.nextInt(Arraysize.arraysize),r.nextInt(Arraysize.arraysize),r.nextBoolean()?'V':'H', this, array, 'y');
		
	}
	
}
}
	
	
	
	
	
	





