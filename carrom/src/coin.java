
import java.awt.Color;
import java.awt.Graphics;
//import java.util.function.ToIntFunction;


public class coin {
	public coin() {
		// TODO Auto-generated constructor stub
	}
	board b = new board();
	private int x = 0;
	private int y = 0;
	private int radius = 10;
	private double dx = 0;
	private double dy = 0;
	private double friction = 0.10;
	private double fricx = 0;
	private double fricy = 0;
	private boolean visible = true;
	int[] bflag = new int[18];
	
	int qflag;
	int sflag;
	
	
	public coin(int i, int j) {
		x = i;
		y = j;
	}

	public void update(Start sp){
	/*	  if(this.getx()<107 && this.gety()<107
		   ||this.getx()>490 && this.gety()<107
		   ||this.getx()>490 && this.gety()>490
		   ||this.getx()<107 && this.gety()>490){
			  this.setx(-99 );
			  this.setdx(0);
			  this.setdy(0);	
		  }
		  
		  
	*/	  
		 
		 
		changespeed();
		
		
	}
	
	public int  checkcollision(coin c) {
		// TODO Auto-generated method stub
		if(Math.pow(this.x - c.x, 2) + Math.pow(this.y - c.y, 2)  < 4*radius*radius){
			//System.out.println("collision at " + this.x + "and" + c.x);
			return(1);
		}
		return(0);
	}

	private void changespeed() {
		// TODO Auto-generated method stub
		double tan = Math.abs(Math.atan(dy/dx));
		fricx = friction * Math.cos(tan);
		fricy = friction * Math.sin(tan);
		
		if(x + dx > b.x + b.width -  radius){
			x = b.x + b.width - radius ;
			dx = -dx;
		}
		else if(x + dx < b.x + radius){
			x = b.x + radius ;
			dx = -dx;
		}
		else {
				/*if(Math.abs(dx) < 0.25){
					dx=0;
					//dy=0;
					}*/
				x += dx ;
		}
			if(dx > 0){
				dx -= fricx;
				if(dx < 0){
					dx = 0 ;
					dy = 0 ;
				}
			}
			if(dx < 0){
				dx += fricx;
				if(dx > 0 ){
					dx = 0;
					dy = 0 ;
				}
			}
		
		

		
		if(y + dy > b.y+ b.height - radius){
			y = b.y+ b.height - radius ;
			dy = -dy;
		}
		else if(y + dy < b.y + radius){
			y = b.y + radius ;
			dy = -dy;
		}
		else {
		/*	if(Math.abs(dy) < 0.25  ){
				//dx=0;
				dy=0;}*/
				y += dy ;
		}
			if(dy > 0){
				dy -= fricy;
				if(dy < 0){
					dy = 0 ;
					dx=0;
					}
			}
			if(dy < 0){
				dy += fricy;
				if(dy > 0 ){
					dy = 0;
					dx = 0;
					}
			}
	}
    public int check()
    {
    	if(this.getx()<=105 && this.gety() <=105)
    	{
    		visible = false;
    		this.setx(-100);
    		this.dx = 0;
    		this.dy = 0;
    		return(1);
    	}
    	else if(this.getx()>=500 && this.gety() <=105)
    	{
    		visible = false;
    		this.setx(-100);
    		this.dx = 0;
    		this.dy = 0;
    		return(1);
    	}
    	else if(this.getx()<=100 && this.gety() >=500)
    	{
    		visible = false;
    		this.setx(-100);
    		this.dx = 0;
    		this.dy = 0;
    		return(1);
    	}
    	else if(this.getx()>=500 && this.gety() >=500)
    	{
    		visible = false;
    		this.setx(-100);
    		this.dx = 0;
    		this.dy = 0;
    		return(1);
    	}
    	return(0);
    }
	
	
	public void paint(Graphics g){
		g.setColor(Color.blue);
		g.fillOval(x-radius, y-radius , radius*2, radius*2);
	}
	
	public void paint(Graphics g, int i){
		if(i==1)
			g.setColor(Color.BLACK);
		if(i==2)
			g.setColor(Color.BLUE);
		if(i==3)
			g.setColor(Color.RED);
		if(i==4)
			g.setColor(Color.YELLOW);
        g.fillOval(x-radius, y-radius , radius*2, radius*2);
	}
	
	public int  getx(){
		return(this.x);
	}
	
	public int  gety(){
		return(this.y);
	}
	public int getradius()
	{
		return radius;
	}
	
	public void setx(int x){
		this.x = x;
	}
	
	public void sety(int y){
		this.y = y;
	}
	public double  getdx(){
		return(this.dx);
	}
	public double  getdy(){
		return(this.dy);
	}
	public void setdx(double dx){
		this.dx = dx;
	}
	public void setdy(double dy){
		this.dy = dy;
	}
	public boolean getvisibility()
	{
		return(visible);
	}
	public void setvisibility(boolean visible)
	{
		this.visible = visible;
	}

//  later we have to disable this listener
	public void moveleft() {
		// TODO Auto-generated method stub
		if(x > 184)
			x-=3;
	}

	public void moveright() {

		// TODO Auto-generated method stub
		if(x < 418)
				x+=3; 
	}

	public void collide(coin c) {
		// TODO Auto-generated method stub
		//System.out.println("collide method");
		if(c.getvisibility())
		{
		int nx = c.getx() - this.getx();
		int ny = c.gety() - this.gety();
		double nmag =  Math.sqrt((nx*nx)+(ny*ny));
		double unx = nx/nmag;
		double uny = ny/nmag;
		double utx = -1*uny;
		double uty = unx;
		double u1y = this.getdy();
		double u1x = this.getdx();
		double u2y = c.getdy();
		double u2x = c.getdx();
		
		double v1n = u2y*uny + u2x*unx;
		double v2n = u1y*uny + u1x*unx;
		double v1t = u1y*uty + u1x*utx;
		double v2t = u2y*uty + u2x*utx;
		
		double v1x = unx*v1n + utx*v1t;
		double v1y = uny*v1n + uty*v1t;
		double v2x = unx*v2n + utx*v2t;
		double v2y = uny*v2n + uty*v2t;
		
		
		c.setx(this.getx() + (int)(2*(radius+2)* unx));
		c.sety(this.gety() + (int)(2*(radius+2)* uny));
		
		this.setdx(v1x);
		this.setdy(v1y);
	
		
		c.setdx(v2x);
		c.setdy(v2y);
		}
		//System.out.println("collide ");
		
	}

}
