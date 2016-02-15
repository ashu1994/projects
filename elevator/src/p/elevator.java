package p;
import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
//public class elevtor extends Applet 
public class elevator{
	int [] a;
	int current;
	char dir;
	int og=0;
	int cg=0;
	int pn=0;
	int c=0,l=0,t=0,power;
	PriorityQueue<Integer> heapmin;
	Iterator minheap_it;
	PriorityQueue<Integer> heapmax;
	Iterator maxheap_it ;	
	 int current_y=(9-current)*50+45;
	// public elevator()
	//.public void init() 
	 public  elevator(){
	    a=new int[10];
	    dir='s';
	    a[0]=5;
	    current=0;
		heapmin = new PriorityQueue<>(10);
		minheap_it = heapmin.iterator();
		heapmax = new PriorityQueue<>(10, new Comparator<Integer>() {

			public int compare(Integer x, Integer y) {
				return y - x;
			}

		});
		maxheap_it = heapmax.iterator();
	 }

	 int d=0;
	 public void update(main sp)
	 {// movelift();
		 
		 //System.out.println( heapmin.peek());
			if(c==0&&pn<=6&&power==1)
			{
				//System.out.println(c);
			    if(dir=='u'&& heapmin.peek()!=null)
			   {
				 if(current<heapmin.peek())//heapmin.peek() is next floor
				{
					current_y -= 1;
					d++;
					if(d==50)//on moving d =50 times elevator reaches to next floor 
					{
						current++;
						d=0;
					}
					
				}
			   }
			    if(dir=='s'&& heapmin.peek()!=null)
				   {
			    	//System.out.println(heapmin.peek());
					 if(current<heapmin.peek())//heapmin.peek() is next floor
					{
						current_y -= 1;
						d++;
						if(d==50)//on moving d =50 times elevator reaches to next floor 
						{
							current++;
							d=0;
						}
						
					}
				   }
			}
			if(heapmin.peek()!=null&&current==heapmin.peek()&&c<172)// on reaching current floor it stops for 170*17 ms
			{
			c++;
			}
			
			if(c==172&&heapmin.peek()!=null) //update current floor to top of min heap element 
			{
				current= heapmin.poll();
				c=0;
				sp.uprequest[current]=0;
				//System.out.println(current + "  "+heapmin.peek());
			}
			
		if(heapmin.peek()==null&&heapmax.peek()==null)//if lift halt at current floor 
			{   c=0;
				dir='s';
				//System.out.println(dir);
			}
		if(l==0&&pn<=6&&power==1)
		{
			//System.out.println(c);
		    if(dir=='d'&& heapmax.peek()!=null)
		   {
			 if(current>heapmax.peek())//heapmin.peek() is next floor
			{
				// System.out.println("a");
				current_y += 1;
				d++;
				if(d==50)//on moving d =50 times elevator reaches to next floor 
				{
					current--;
					d=0;
				}
				
			}
		   }
		    if(dir=='s'&& heapmax.peek()!=null)
			   {
				 if(current>heapmax.peek())//heapmin.peek() is next floor
				{
					 //System.out.println("a");
					current_y += 1;
					d++;
					if(d==50)//on moving d =50 times elevator reaches to next floor 
					{
						current--;
						d=0;
					}
					
				}
			   }
		}
		if(heapmax.peek()!=null&&current==heapmax.peek()&&l<172)// on reaching current floor it stops for 170*17 ms
		{
		l++;
		}
		if(l==172&&heapmax.peek()!=null) //update current floor to top of min heap element 
		{
			current= heapmax.poll();
			l=0;
			sp.uprequest[current]=0;
			//System.out.println(current + "  "+heapmin.peek());
		}
	if(heapmax.peek()==null&&heapmin.peek()==null)//if lift halt at current floor 
		{   l=0;
			dir='s';
			//System.out.println(dir);
		}
 }
	 public void movelift()
	 {
		 int d=0;
		 System.out.println("b");
			if(c==0)
			{
			if(dir=='u'&& heapmin.peek()!=null)
			   {
				if(current<heapmin.peek())//heapmin.peek() is next floor
				{
					current_y -= 1;
					d++;
					if(d==50)
					{
						current++;
						d=0;
					}
					
				}
			   }
			}
			if(heapmin.peek()!=null&&current==heapmin.peek()&&c<172)
			{
			c++;
			}
			if(c==172)
			{
				current= heapmin.poll();
				c=0;
			}
	 }
   public void paint(Graphics e,int i)
   {   if(dir=='d'){
	   if(l<147){ e.setColor(Color.black);
	   e.fillRect(200+(i-1)*180, current_y, 50, 40);
	   e.drawRect(200+(i-1)*180, current_y, 50, 40);
	  }
	   if(l>=4&&l<=29)
	   {
		   e.setColor(Color.white);
		   e.fillRect(200+(i-1)*180+24-l, current_y, l-3, 40);
		   e.fillRect(200+(i-1)*180+24, current_y, l-3, 40);
		   //e.drawRect(200+(i-1)*180, current_y, c-2, 40);
	   }
	   if(l>29&&l<147)
	   {
		   e.setColor(Color.white);
		   e.fillRect(200+(i-1)*180, current_y, 50, 40);
		   e.fillRect(200+(i-1)*180, current_y, 50, 40);
	   }
	   if(l>147)
	   { e.setColor(Color.white);
	   e.fillRect(200+(i-1)*180, current_y, 50, 40);
	   e.drawRect(200+(i-1)*180, current_y, 50, 40);
	  }
	   if(l>=147&&l<172)
	   {
		   e.setColor(Color.black);
		   e.fillRect(200+(i-1)*180, current_y,l-1-146, 40);
		   e.fillRect(200+(i-1)*180+50+145-l, current_y, l-1-146, 40);
	   }  }
   else{ 
	  if(c<147){ e.setColor(Color.black);
	   e.fillRect(200+(i-1)*180, current_y, 50, 40);
	   e.drawRect(200+(i-1)*180, current_y, 50, 40);
	  }
	   if(c>=4&&c<=29)
	   {
		   e.setColor(Color.white);
		   e.fillRect(200+(i-1)*180+24-c, current_y, c-3, 40);
		   e.fillRect(200+(i-1)*180+24, current_y, c-3, 40);
		   //e.drawRect(200+(i-1)*180, current_y, c-2, 40);
	   }
	   if(c>29&&c<147)
	   {
		   e.setColor(Color.white);
		   e.fillRect(200+(i-1)*180, current_y, 50, 40);
		   e.fillRect(200+(i-1)*180, current_y, 50, 40);
	   }
	   if(c>147){ e.setColor(Color.white);
	   e.fillRect(200+(i-1)*180, current_y, 50, 40);
	   e.drawRect(200+(i-1)*180, current_y, 50, 40);
	  }
	   if(c>=147&&c<172)
	   {
		   e.setColor(Color.black);
		   e.fillRect(200+(i-1)*180, current_y,c-1-146, 40);
		   e.fillRect(200+(i-1)*180+50+145-c, current_y, c-1-146, 40);
		  
	   }  
	   
   }
   e.setFont(new Font("TimesRoman", Font.PLAIN, 20));
   e.setColor(Color.black);
   e.drawString("Current Floor:", 90, 570);
   e.drawString("No.of persons:", 90, 600);
   e.drawString("Direction:", 90, 630);
   e.drawString("Indicator:", 90, 660);
   String s1=Integer.toString(current);
   String s2=Integer.toString(pn);
   String s3=Character.toString(dir);
   e.setColor(Color.red);
   e.drawString(s1, 220+(i-1)*180, 570);
   e.drawString(s2, 220+(i-1)*180, 600);
   e.drawString(s3, 220+(i-1)*180, 630);
   if(pn>6)
   e.fillOval(210+(i-1)*180,640,20,20);
   else
   {
	   e.setColor(Color.green);
	   e.fillOval(210+(i-1)*180,640,20,20);
   }
   //e.drawString(s,);
   for(int j=0;j<10;j++)
      
   { String s=Integer.toString(current);
	   e.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		e.setColor(Color.red);
		e.drawString(s, 145+(i-1)*180,520-j*50 );
    if(dir=='u')
	   {
    	//System.out.println("u");
	   paintup(e,i,j);
	   }
    else  if(dir=='d')
	   {
		   paintdown(e,i,j); 
}
   }	
	   
   
   }
   public void paintup(Graphics r,int i,int j)
   {
	   Graphics2D g2 = (Graphics2D) r;
		g2.setStroke(new BasicStroke(4));
	   r.setColor(Color.red);
	   r.drawLine(170+(i-1)*180,520-(j)*50, 170+(i-1)*180,510-j*50);
	   r.drawLine(170+(i-1)*180,510-j*50, 170+(i-1)*180-5,513-j*50);
	   r.drawLine(170+(i-1)*180,510-j*50, 170+(i-1)*180+5,513-j*50);
   }
   public void paintdown(Graphics r,int i,int j)
   {
	   Graphics2D g2 = (Graphics2D) r;
		g2.setStroke(new BasicStroke(4));
	   r.setColor(Color.red);
	   r.drawLine(170+(i-1)*180,520-(j)*50, 170+(i-1)*180,510-j*50);
	   r.drawLine(170+(i-1)*180,520-j*50, 170+(i-1)*180-5,517-j*50);
	   r.drawLine(170+(i-1)*180,520-j*50, 170+(i-1)*180+5,517-j*50);
   }
	public void addtominheap(int x) {
		heapmin.add(x);
	}

	public int retrivefromminheap() {
		return heapmin.peek();
	}

	public void removefromminheap() {
		heapmin.poll();
	}

	public void addtomaxheap(int x) {
		heapmax.add(x);
	}

	public int retrivefrommaxheap() {
		return heapmax.peek();
	}

	public void removefrommaxheap() {
		heapmax.poll();
	}
	public int findinminheap(int x)
	{
	   // Integer x1=x;
		while (minheap_it.hasNext()){
	          if((int)minheap_it.next()==x)return (1);
	      }
		return (0);
	}
	public int findinmaxheap(int x)
	{
	   // Integer x1;
		while (maxheap_it.hasNext()){
			//  x1=(int)maxheap_it.next();
	          if(x==(int)maxheap_it.next())return (1);
	      }
		return (0);
	}
    public void printmax()
    {
    	
			if(heapmax.peek()!=null)
				{ int in = heapmax.poll();
			System.out.println("Processing Integer:" + in);
				}
		
    }
    public void printmin()
    {  
      int in;
    
    	
			if(heapmin.peek()!=null)
				{in = heapmin.peek();
			System.out.println("Processing Integer:" + in);
				}
		
    }
    
}
