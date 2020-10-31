import java.util.*;
abstract class Ship 
{
	private int a,b;//keli enarkshs
	private char pros;//prosanatolismos
	private int size;//megethos pliou
	private String shipname;
	
	public Ship(int size,String shipname )
	{
		this.size=size;
		this.shipname=shipname;
	}
	public int getSize() {return size;}
	public String getShipname() {return shipname;}
	
	public void placeShip(int z,int w,char pro,Board n,Tile[][] q,char rand)
	{
		Scanner getin=new Scanner(System.in);
		Random random=new Random();
		int counter=0;
		
		if(rand=='n')
		{
			
			a=z;
			b=w;
			pros=pro;		
			while(counter==0)
			{
				try 
				{
					Oversize();
					OverlapTiles(q);
					AdjacentTiles(n);
				}
				catch(Exception ex) {System.out.println(ex.getMessage());counter++;}
				if(counter==0) 
				{
					break;
				}
				else 
				{
					counter=0;
					a=getin.nextInt();
					b=getin.nextInt();
					pros=getin.next().charAt(0);	
				}
				
					
			}
		}
		else if(rand=='y')
		{
			a=z;
			b=w;
			pros=pro;
			
			
			while(counter==0)
			{
				try 
				{
					Oversize();
					OverlapTiles(q);
					AdjacentTiles(n);
					 
				}
				catch(Exception ex) {counter++;}
				
				if(counter==0) 
				{
					break;
				}
				else 
				{
					counter=0;
					a=random.nextInt(Arraysize.arraysize);
					b=random.nextInt(Arraysize.arraysize);
					pros=random.nextBoolean()?'H':'V';
					
				}
				
					
			}
			
		}
		
		
		if(pros=='H') 
		{
			for(int i=b;i<b+size;i++)
			{
				q[a][i].setSymb('s');
			}
				
		}
		else if(pros=='V') 
		{
			for(int j=a;j<a+size;j++) 
			{
				q[j][b].setSymb('s');
			}
		}
	}
	public void Oversize() throws OversizeException
	{
		 if(pros=='H')
	        {
	        
	        if(b+size>Arraysize.arraysize)
	        	throw new OversizeException("Ship cannot be out of the board.");
	        
	    }
	         if(pros=='V')
	        {
	        	 if(a+size>Arraysize.arraysize)
	 	        	throw new OversizeException("Ship cannot be out of the board.");
	 	        
	        }
	}
	public void OverlapTiles(Tile [][] k)throws OverlapTilesException
    {
        int counter=0;
        if(pros=='H')
        {
            for(int i=b;i<b+size;i++)
            {
                if(k[a][i].getSymb()=='s')
                counter++;
            }
        }
        else if(pros=='V')
        {
            for(int i=a;i<a+size;i++)
            {
                if(k[i][b].getSymb()=='s')
                counter++;
            }
        }
        if(counter!=0)
        throw new OverlapTilesException("This ship is crossing another.");
    }
	public void AdjacentTiles(Board g)throws AdjacentTilesException
    {
        int counting=0;
        if(pros=='H')
        {
            for(int i=b;i<size+b;i++)
            {
                if(!g.getAdjacentTiles(a,i))counting++;//There are ship tiles
            }
            if(counting!=0)
            throw new AdjacentTilesException("Ships cant have adjacent ships.");
        }
        else if(pros=='V')
        {
            for(int i=a;i<size+a;i++)
            {
                if(!g.getAdjacentTiles(i,b))counting++;//There are ship tiles
            }
            if(counting!=0)
            throw new AdjacentTilesException("Ships cant have adjacent ships.");
        }
    }
	

}


