class nihal
{	
	int r,c,s;	
	public void hollow()
	{
		for(r=1; r<=5; r++)
		{
			for(c=1; c<=5; c++)
			{
				if(r==1|| r==5|| c==1|| c==5)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println(" ");
		}
		System.out.println();
	}

	


	public void butterfly()
	{

		//for upper part

		for(r=1; r<=4; r++)
		{			
			for(c=1; c<=r; c++)
			{
				System.out.print("*");
			}
			for(s=1; s<=2*(4-r); s++)
			{
				System.out.print(" ");
			}
			for(c=1; c<=r; c++)
			{
				System.out.print("*");	
			}
		System.out.println();	
		}

		//lower part
	
		for(r=4; r>=1; r--)
		{			
			for(c=1; c<=r; c++)
			{
				System.out.print("*");
			}
				for(s=1; s<=2*(4-r); s++)
				{
					System.out.print(" ");
				}
					for(c=1; c<=r; c++)
						{
							System.out.print("*");	
						}
			System.out.println();	
		}		
		System.out.println();
	}

	
	public void rhombus()
	{
		for(r=1; r<=5; r++)
		{
			for(s=1; s<=5-r; s++)
			{
				System.out.print(" ");
			}
				for(c=1; c<=5; c++)
				{
					System.out.print("*");	
				}
			System.out.println();
		}
		System.out.println();	
	}
	

	
	public void numtriangle()
	{
		int n=1;
		for(r=1; r<=5; r++)
		{
			for(s=1; s<=5-r; s++)
			{
				System.out.print(" ");		
			}
			for(c=1; c<=r; c++)
			{
				System.out.print(r+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	

	public void numpattern()
	{
		int n=1;
		for(r=5; r>=1; r--)
		{
			for(c=1; c<=r; c++)
			{
				System.out.print(c);
			}
				for(s=0; s<=(2*r-1); s++)
				{
					System.out.print(" ");
				}
			System.out.println();
		}
		System.out.println();
	}


	public void palitriangle()
	{
		for(r=1; r<=5; r++)
		{
			for(s=1; s<=5-r; s++)
			{
				System.out.print(" ");
			}
				for(c=r; c>=1; c--)
				{
					System.out.print(c);
					
				}
				for(c=2; c<=r; c++)
				{
					System.out.print(c);
					
				}
			System.out.println();
		}
		System.out.println();
	}

	
	public void quadrhombus()
	{
		//upper part
		for(r=1; r<=4; r++)
		{
			for(s=1; s<=4-r; s++)
			{
				System.out.print(" ");
			}
				for(c=1; c<=r; c++)
				{
					System.out.print("*");
				}
					for(c=2; c<=r; c++)
					{
						System.out.print("*");
					}
		
			System.out.println();
		}
		
		//for lower part
		for(r=4; r>=1; r--)
		{
			for(s=1; s<=4-r; s++)
			{
				System.out.print(" ");
			}
				for(c=1; c<=r; c++)
				{
					System.out.print("*");
				}
					for(c=2; c<=r; c++)
					{
						System.out.print("*");
					}
		
			System.out.println();
		}







		System.out.println();
	}
	
	public void revnumpattern()
	{
		int n=1;
		for(r=5; r>=1; r--)
		{
			for(c=1; c<=r; c++)
			{
				System.out.print(c);
			
			}
		
			System.out.println();
		}
		System.out.println();
	}
	
	public void floydtriangle()
	{
		int n=1;
		for(r=1; r<=5; r++)
		{
			for(c=1; c<=r; c++)
			{
				System.out.print(n++ +" ");
			
			}
		
			System.out.println();
		}
		System.out.println();
	}
	
	public void floydtriangle1()
	{
		int n=1;
		for(r=1; r<=5; r++)
		{
			for(c=1; c<=r; c++)
			{
				if((r+c)%2==0)
					System.out.print("1");
				else
					System.out.print("0");
			}
		
			System.out.println();
		}
		System.out.println();
	}
	

}

class DSA1
{
	public static void main(String args[])
	{
		nihal x = new nihal();
		x.hollow();
		x.butterfly();
		x.rhombus();
		x.numtriangle();
		x.palitriangle();
		x.quadrhombus();
		x.numpattern();
		x.revnumpattern();
		x.floydtriangle();
		x.floydtriangle1();
	}
}