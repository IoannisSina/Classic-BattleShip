import java.util.*;
public class Player
{
	private String name;
	private int sv=0;//sinolo volwn
	private int sa=0;//sinolo astoxiwn
	private int ev=0;//epitiximenes voles
	private int ep=0;//keli idi xtipimeno,skepsh
	private int periptosi;
	private int ypoper;
	private static int giros=1;
	private int[] skepsh=new int[4];//0 grammh,1 sthlh
	private char orient;
	private boolean ok;
	private Board board=new Board();
	public Player(String name)
	{
		this.name=name;
	}
	
	public void placeAllShips()//random placement
	{
		board.placeAllShips();
	}
	public void placeShip(int x,int y,char p,Ship k)//player places ships
	{
		k.placeShip(x, y, p, this.getBoard(), this.getBoard().getArray(), 'n');
	}
	public void drawboards(Player b)//draw boards
	{
		this.board.drawboards(b.board);
	}
	public Board getBoard()//returns the board of the player
	{
		return board;
	}
	public int Check()//ektypwnei posa ~ yparxoyn
	{
		int counter=0;
		for(int i=0;i<Arraysize.arraysize;i++)
		{
			for(int j=0;j<Arraysize.arraysize;j++)
			{
				if(board.getArray()[i][j].getSymb()=='~')
					counter++;
			}
				
		}
		return counter;
	}
	public void fire(int x,int y,Player c)
	{
		
		if(giros%2!=0) {
			giros++;
		if(c.board.getArray()[x][y].getSymb()=='s')
		{
			c.board.getArray()[x][y].setSymb('x');
			sv++;
			ev++;
			System.out.println(" You hit a ship.");
		}
		else if(c.board.getArray()[x][y].getSymb()=='~')
		{
			c.board.getArray()[x][y].setSymb('o');
			sv++;
			sa++;
			System.out.println(" You missed");
		}
		else if(c.board.getArray()[x][y].getSymb()=='x')
		{
			sv++;
			ep++;
			System.out.println(" Alread hit");
		}
		else if(c.board.getArray()[x][y].getSymb()=='o')
		{
			sv++;
			ep++;
			
			System.out.println(" Already missed");
		}
		}
		else 
		{
			int a;//random
			int b;//random
			Random temp=new Random();
			giros++;//poios paizei
			while(c.getBoard().getArray()[x][y].getSymb()!='s')
			{
				x=temp.nextInt(Arraysize.arraysize-1);
				y=temp.nextInt(Arraysize.arraysize-1);
			}
			/*if(c.getBoard().getArray()[x][y].getSymb()=='~') //kodikas xwris to mponous
			{
			    c.getBoard().getArray()[x][y].setSymb('o');
			 }
			 else
			 {
			     c.getBoard().getArray()[x][y].setSymb('x');
			 }*/
			
			if(ep==0)
			{
				if(c.getBoard().getArray()[x][y].getSymb()=='s')
				{
					c.getBoard().getArray()[x][y].setSymb('x');
					skepsh[0]=x;
					skepsh[1]=y;
					skepsh[2]=x;
					skepsh[3]=y;
					ep++;
				}
				else if(c.getBoard().getArray()[x][y].getSymb()=='~')
				{
					c.getBoard().getArray()[x][y].setSymb('o');
				}
			}
			else if(ep==1)
			{
				if((skepsh[0]==0 ||skepsh[0]==Arraysize.arraysize-1)&& skepsh[1]==0)//aristera gonies
				{
					periptosi=0;
					ep++;
					if(c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].getSymb()=='s')
					{
						c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].setSymb('x');
						orient='h';
						skepsh[1]++;
					}
					else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].getSymb()=='~')
					{
						c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].setSymb('o');
						orient='v';
					}
					else
					{
						orient='v';
						if(skepsh[0]==0)
						{
							c.getBoard().getArray()[skepsh[0]+1][skepsh[1]].setSymb('x');
							skepsh[0]++;
						}
						else
						{
							c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].setSymb('x');
							skepsh[0]--;
						}				
							
					}
					
				}
				else if((skepsh[0]==0 ||skepsh[0]==Arraysize.arraysize-1)&& skepsh[1]==Arraysize.arraysize-1)//deksia gonies
				{
					periptosi=1;
					ep++;
					if(c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].getSymb()=='s')
					{
						c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].setSymb('x');
						orient='h';
						skepsh[1]--;
					}
					else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].getSymb()=='~')
					{
						c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].setSymb('o');
						orient='v';
					}
					else
					{
						orient='v';
						if(skepsh[0]==0)
						{
							c.getBoard().getArray()[skepsh[0]+1][skepsh[1]].setSymb('x');
							skepsh[0]++;
						}
						else
						{
							c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].setSymb('x');
							skepsh[0]--;
						}				
							
					}
				}
				else if(skepsh[0]==0||skepsh[0]==Arraysize.arraysize-1)//panw katw grammh
				{
					periptosi=2;
					if(c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].getSymb()=='s')
					{
						c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].setSymb('x');
						orient='h';
						skepsh[1]++;
						ep++;
					}
					else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].getSymb()=='~')
					{
						c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].setSymb('o');
					}
					else
					{
						if(c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].getSymb()=='s')
						{
							
							c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].setSymb('x');
							orient='h';
							skepsh[1]--;
							ep++;
						}
						else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].getSymb()=='~')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].setSymb('o');
							orient='v';
							
						}
						else
						{
							orient='v';
							ep++;
							if(skepsh[0]==0)
							{
								c.getBoard().getArray()[skepsh[0]+1][skepsh[1]].setSymb('x');
								skepsh[0]++;
							}						
							else
							{
								c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].setSymb('x');
								skepsh[0]--;
							}
						}
					}
					
				}
				else if(skepsh[1]==0||skepsh[1]==Arraysize.arraysize-1)//dexia kai aristeri stili
				{
					periptosi=3;
					if(c.getBoard().getArray()[skepsh[0]+1][skepsh[1]].getSymb()=='s')
					{
						c.getBoard().getArray()[skepsh[0]+1][skepsh[1]].setSymb('x');
						orient='v';
						skepsh[0]++;
						ep++;
					}
					else if(c.getBoard().getArray()[skepsh[0]+1][skepsh[1]].getSymb()=='~')
					{
						c.getBoard().getArray()[skepsh[0]+1][skepsh[1]].setSymb('o');
					}
					else
					{
						if(c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].getSymb()=='s')
						{
							c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].setSymb('x');
							orient='v';
							skepsh[0]--;
							ep++;
						}
						else if(c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].getSymb()=='~')
						{
							c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].setSymb('o');
							orient='h';
						}
						else
						{
							orient='h';
							ep++;
							if(skepsh[3]==0)//arxiko
							{
								c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].setSymb('x');
								skepsh[1]++;
							}						
							else
							{
								c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].setSymb('x');
								skepsh[1]--;
							}
						}
					}
				}
				else//oxi sta akra tou pinaka
				{
					periptosi=4;
					if(c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].getSymb()=='s')
					{
						c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].setSymb('x');
						orient='h';
						skepsh[1]++;
						ep++;
					}
					else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].getSymb()=='~')
					{
						c.getBoard().getArray()[skepsh[0]][skepsh[1]+1].setSymb('o');
					}
					else
					{
						if(c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].getSymb()=='s')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].setSymb('x');
							orient='h';
							skepsh[1]--;
							ep++;
						}
						else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].getSymb()=='~')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]-1].setSymb('o');
							orient='v';
							
						}
						else
						{
							orient='v';
							if(c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].getSymb()=='s')
							{
								c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].setSymb('x');
								skepsh[0]--;
								ep++;
							}
							else if(c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].getSymb()=='~')
							{
								c.getBoard().getArray()[skepsh[0]-1][skepsh[1]].setSymb('o');
							}
							else
							{
								c.getBoard().getArray()[skepsh[0]+1][skepsh[1]].setSymb('x');
								skepsh[2]++;
								ep++;
							}
						}
					}
				}
			}
			else if(ep==2)
			{
				if(periptosi==0)
				{
					if(orient=='h')
					{
						skepsh[1]++;
						if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
						}
						else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
							ep=0;
						}
						else 
						{
							ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
							
						}
					}
					else
					{
						if(skepsh[2]==0)
							skepsh[0]++;
						else skepsh[0]--;
						if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
						}
						else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
							ep=0;
						}
						else
						{
							
							ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
						}
					}
				}
				else if(periptosi==1)
				{
					if(orient=='h')
					{
						skepsh[1]--;
						if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
						}
						else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
							ep=0;
						}
						else 
						{
							ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
						}
					}
					else
					{
						if(skepsh[2]==0)
						skepsh[0]++;
						else skepsh[0]--;
						if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
						}
						else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
							ep=0;
						}
						else
						{
							
							ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
						}
					}
				}
				else if(periptosi==2)
				{
					if(orient=='h')
					{
						if(skepsh[3]>skepsh[1])
						{
							
							if(skepsh[1]>0)
							skepsh[1]--;
							
								if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
								{
									c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
								}
								else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
								{
									c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
									ep=0;
									skepsh[1]++;
								}
								else
								{
									
									ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
								}
							
							
							
						}
						else if(skepsh[3]<skepsh[1])
						{
							
							if(skepsh[1]<Arraysize.arraysize-1)
							{
								skepsh[1]++;
							}
								if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
								{
									c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
								}
								else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
								{
									c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
									skepsh[1]--;
								}
								else
								{
									if(skepsh[3]>0)
									{
										skepsh[3]--;
									}
									if(c.getBoard().getArray()[skepsh[0]][skepsh[3]].getSymb()=='s')
									{
										c.getBoard().getArray()[skepsh[0]][skepsh[3]].setSymb('x');
									}
									else if(c.getBoard().getArray()[skepsh[0]][skepsh[3]].getSymb()=='~')
									{
										c.getBoard().getArray()[skepsh[0]][skepsh[3]].setSymb('o');
										skepsh[3]++;
									}
									else
									{
										
										ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
									}
									
									
								}
							
							
						}
					}
					else
					{
						if(skepsh[2]==0)
						{
							skepsh[0]++;
						}
						else
						{
							skepsh[0]--;
						}
						if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
						}
						else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
							ep=0;
						}
						else
						{
							
							ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
						}
					}
				}
				else if(periptosi==3)
				{
					if(orient=='v')
					{
						if(skepsh[2]>skepsh[0])
						{
							
							if(skepsh[0]>0)
							skepsh[0]--;
							
								if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
								{
									c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
								}
								else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
								{
									c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
									ep=0;
								}
								else
								{
									
									ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
								}
							
							
						}
						else if(skepsh[2]<skepsh[0])
						{
							
							if(skepsh[0]<Arraysize.arraysize-1)
							{
								skepsh[0]++;
							}
								if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
								{
									c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
								}
								else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
								{
									c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
									skepsh[0]--;
								}
								else
								{
									if(skepsh[2]>0)
									{
										skepsh[2]--;
									}
									if(c.getBoard().getArray()[skepsh[2]][skepsh[1]].getSymb()=='s')
									{
										c.getBoard().getArray()[skepsh[2]][skepsh[1]].setSymb('x');
									}
									else if(c.getBoard().getArray()[skepsh[2]][skepsh[1]].getSymb()=='~')
									{
										c.getBoard().getArray()[skepsh[2]][skepsh[1]].setSymb('o');
										skepsh[2]++;
										ep=0;
									}
									else
									{
										
										ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
									}
									
									
								}
							
							
						}
					}
					else
					{
						if(skepsh[1]==0)
						{
							skepsh[1]++;
						}
						else
						{
							skepsh[1]--;
						}
						if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
						}
						else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
						{
							c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
							ep=0;
						}
						else
						{
							
							ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
						}
					}
				}
				else if(periptosi==4)
				{
					if(orient=='h')
					{
						if(skepsh[1]<Arraysize.arraysize-1)
						{
							skepsh[1]++;
						}
						if(skepsh[3]<skepsh[1])
						{
							if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
							{
								c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
							}
							else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
							{
								c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
								skepsh[1]--;
							}
							else
							{
								if(skepsh[3]>0)
								{
									skepsh[3]--;
								}

								if(c.getBoard().getArray()[skepsh[0]][skepsh[3]].getSymb()=='s')
								{
									c.getBoard().getArray()[skepsh[0]][skepsh[3]].setSymb('x');
								}
								else if(c.getBoard().getArray()[skepsh[0]][skepsh[3]].getSymb()=='~')
								{
									c.getBoard().getArray()[skepsh[0]][skepsh[3]].setSymb('o');
									skepsh[3]++;
									ep=0;
								}
								else
								{
									
									ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
								}
								
							}
						}
					}
					else
					{
						if(skepsh[0]>0)
						{
							skepsh[0]--;
						}
						if(skepsh[2]>skepsh[0])
						{
							if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='s')
							{
								c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('x');
							}
							else if(c.getBoard().getArray()[skepsh[0]][skepsh[1]].getSymb()=='~')
							{
								c.getBoard().getArray()[skepsh[0]][skepsh[1]].setSymb('o');
								skepsh[0]++;
							}
							else
							{
								if(skepsh[2]<Arraysize.arraysize-1)
								{
									skepsh[2]++;
								}
								if(c.getBoard().getArray()[skepsh[2]][skepsh[1]].getSymb()=='s')
								{
									c.getBoard().getArray()[skepsh[2]][skepsh[1]].setSymb('x');
								}
								else if(c.getBoard().getArray()[skepsh[2]][skepsh[1]].getSymb()=='~')
								{
									c.getBoard().getArray()[skepsh[2]][skepsh[1]].setSymb('o');
									skepsh[2]--;
									ep=0;
								}
								else
								{
									
									ep=0;
							a=temp.nextInt(Arraysize.arraysize-1);
							b=temp.nextInt(Arraysize.arraysize-1);
							while(c.getBoard().getArray()[a][b].getSymb()!='~'&&c.Check()!=0)
							{
								a=temp.nextInt(Arraysize.arraysize-1);
								b=temp.nextInt(Arraysize.arraysize-1);
							}
							if(c.getBoard().getArray()[a][b].getSymb()=='~')
							c.getBoard().getArray()[a][b].setSymb('o');
							else if(c.getBoard().getArray()[a][b].getSymb()=='s')
							c.getBoard().getArray()[a][b].setSymb('x');
								}
							}
						}
					}
				}
			}
			
			}
		}
			
		
		
		
		
	
		
            		
            		
			
			
			
         
	
	public void getStats()
	{
		System.out.println("Synolo volwn: "+sv);
		System.out.println("Epitiximenes voles: "+ev);
		System.out.println("Apotiximenes voles: "+sa);
		System.out.println("Epanalipseis: "+ep);
	}
	public void SytsemClear()
	{
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	
}