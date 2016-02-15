package start;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

import javax.swing.ImageIcon;
public class Start extends Applet implements Runnable, KeyListener, MouseMotionListener, MouseListener, MouseWheelListener{
	
	int numbercoin = 18;
	private Image i;
	private Image pic;
	private Graphics doubleG;
	coin[] bcoin  = new coin[numbercoin]; 
	coin striker;
	gameplay gp = new gameplay();
	int lowershooty = 441;
	int uppershooty = 162;
	double pf = 0.23;
	int position;
	int coverplay=0;
	int repeatplayer = 0;
	int coverstroke = 0;
	int coverindex = -1;
	coin queen ;
	board b;
	Point mouse = new Point();
	
	
	public void init() {//1
		setSize(1000, 1000); 
		
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
		
	}
	
	public Start() {
		b = new board();
		striker = new coin();
		queen = new coin();
		gp = new gameplay();
		
		for(int j=0; j < numbercoin; j++){
			bcoin[j] = new coin();
		}
		setposition();
		Thread thread = new Thread(this);
		thread.start();//to call run 
	}
	
	public void run() {
		while(true){
			setSize(800, 600);
			//collision checking for black coins
			for(int j =0; j < numbercoin ;j++){
				int vals = 0;
				if(bcoin[j].getvisibility())
				{
				for(int k=0; k < numbercoin; k++){
					int value =0;
					
					if(j!=k && bcoin[j].bflag[k]!=1)
						value = bcoin[j].checkcollision(bcoin[k]);
					if(value == 1){
						bcoin[k].bflag[j]=1;
						bcoin[j].bflag[k]=1;
						bcoin[j].collide(bcoin[k]);
					}
					
				}
		         
				if(bcoin[j].sflag!=1){
					
					vals = bcoin[j].checkcollision(striker);
				}
				if(vals == 1){
					bcoin[j].sflag=1;
					striker.bflag[j]=1;
					bcoin[j].collide(striker);
					
				}
				if(queen.getvisibility())
				{
                 if(bcoin[j].qflag!=1){
					
					vals = bcoin[j].checkcollision(queen);
				}
				if(vals == 1){
					bcoin[j].qflag=1;
					queen.bflag[j]=1;
					bcoin[j].collide(queen);					
				}}
				if(striker.qflag != 1)
				{
					vals = striker.checkcollision(queen);
				}
				if(vals ==1)
				{
					striker.qflag = 1;
					queen.sflag = 1;
					striker.collide(queen);
				}
				}
				bcoin[j].update(this);
				if(bcoin[j].getvisibility()){
					if(coverplay==1){
						int xyz = bcoin[j].check();
						if(xyz == 1){							
								gp.changescore(j);
								gp.changescore();
								coverplay=0;
								coverstroke=0;
								repeatplayer = 1;
						}
						
						
							
					}
					else{
						int xyz = bcoin[j].check();
						if(xyz == 1){							
								gp.changescore(j);								
								repeatplayer = 1;
						}
					}
						
				}
			}
			striker.update(this);
			queen.update(this);
			if(queen.getvisibility()){
				int xyz = queen.check();
				if(xyz == 1){
					coverplay=1;
					
					//gp.changescore();
				}
				
			}
			//striker.checkcollision(bcoin[1]);
			
			//System.out.println(striker.getx()+"," +striker.gety()+","+striker.getdx()+","+striker.getdy());
			
			if(gp.shotplayed == 1)
			checkifstopped();
			
			//put flags back to 0
			
		     initialise();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
	private void initialise()
	{
		for(int j =0; j < numbercoin ;j++){
			for(int k=0; k < numbercoin; k++){
				bcoin[j].bflag[k]=0;
			}
			bcoin[j].sflag = 0;
			bcoin[j].qflag = 0;
		}
		striker.qflag = 0;
		queen.sflag =0;
		
	}
	private void checkifstopped() {
		// TODO Auto-generated method stub
		
		for(int j =0; j < numbercoin; j++){
			if(bcoin[j].getdx() != 0 || bcoin[j].getdy() != 0)
				return;
		}
		
		if(striker.getdx() != 0 && striker.getdy() != 0)
			return;
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gp.shotplayed = 0;
		if(coverstroke==1){
			coverplay=0;
			coverstroke=0;			
			queen.setvisibility(true);
			queen.setx(300);
			queen.sety(300);
			
		}
			
		if(coverplay==1){
			coverstroke=1;
			//gp.changeplayer();
		}
		if(repeatplayer==0)
			gp.changeplayer();
		else
			repeatplayer=0;
		striker.setvisibility(true);
		
		if(gp.player == 1)
			position = lowershooty;
		else
			position = uppershooty;
		striker.setx(295);
		striker.sety(position);
		
	}
 public boolean checkstrikercollision()
  {
	  for(int i =0;i<18;i++)
	  {
		  if(bcoin[i].checkcollision(striker)==1)
		  {
			  return true;
		  }
	  }
	  if(queen.checkcollision(striker)==1)
	  {
		  return true;
	  }
	   return false;
  }

   public void stop() {
	
	}
	
	public void destroy() {
		
	}
	
	public void update(Graphics g) {
		if(i == null){
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
			
		}
		
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		doubleG.setColor(getForeground());
		paint(doubleG);
		
		g.drawImage(i, 0, 0, this);
	}
	public void paint(Graphics g) {
	
		pic = new ImageIcon("D:\\carromf\\src\\board.jpg").getImage();
	//	E:\sem5\carrom_7\src
		g.drawImage(pic, 50, 50, null);
		int i;
		for(int j=0;j<numbercoin;j++)
		{
			if(j%2==0)
				i=2;
			else
				i=1;
			if(bcoin[j].getvisibility())
			 {
				bcoin[j].paint(g,i);	
			 }
		}
		//b.paint(g);
		/*for(int j =0; j < numbercoin/2 ;j++){
			bcoin[j].paint(g,1);
		}
		for(int j = numbercoin/2; j < numbercoin ;j++){
			bcoin[j].paint(g,2);
		}*/
		if(queen.getvisibility())
		{
		queen.paint(g, 3);
		}
		if(striker.getvisibility())
		{
		striker.paint(g,4);
		}
		if(gp.setstroke == 1){
			g.setColor(Color.RED);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(3));
			g.drawLine(striker.getx(), striker.gety(), mouse.x, mouse.y);
		}
	}
	public void setposition()
	{
		queen.setx(300);
		queen.sety(300);
		int r = 2*10+1;
		int x1 = queen.getx();
		int y1 = queen.gety();
		int theta = 0;
		int i,x2,y2;
		for(i=0;i<18;i++)
		{
			if(i==6)
			{
				theta =0;
				r = 40;
			}
				 x2 = (int)(x1 + r* Math.sin(Math.toRadians(theta)));
				 y2 = (int)(y1 - r* Math.cos(Math.toRadians(theta)));
				 bcoin[i].setx(x2);
	             bcoin[i].sety(y2);
	             bcoin[i].setdx(0);
                 bcoin[i].setdy(0);
		    if(i<6)
			    theta += 60;
		    else 
		    	theta += 30;
		}
		// bcoin[16].setx(410);
        // bcoin[16].sety(lowershooty);
        // bcoin[17].setx(380);
        // bcoin[17].sety(lowershooty);
		striker.setx(295);
		striker.sety(lowershooty);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int r = striker.getradius();
		switch(e.getKeyCode()){
		
		case KeyEvent.VK_LEFT:
			striker.moveleft();
			
			//striker.sety(position);
			if(checkstrikercollision())
			{
				if(striker.getx()-(4*r-3)>184)
				{
			    	//striker.setx(striker.getx()-37);
				 boolean val = checkstrikercollision();
				 while(striker.getx()>184 && val)
				 {
					 if(striker.getx()-37<184 && val)
					 {
						 striker.setx(striker.getx()+43);
					 }
					 else if(striker.getx()-37>184 && val)
					 {
						 striker.setx(striker.getx()-37);
						 System.out.println("aaaaaa");
					 }
					 val = checkstrikercollision();
                 }
				}
				else 
					{
					striker.setx(striker.getx()+3);
					}	
				}
			//striker.sety(position);
			break;
			
		case KeyEvent.VK_RIGHT:
			
			striker.moveright();
			
			if(checkstrikercollision())
			{
				if(striker.getx()+37<418)
				{
				//striker.setx(striker.getx()+37);
				boolean val = checkstrikercollision();
				while(striker.getx()<418 && val)
				 {
					if(striker.getx()+37<418 && val)
					 {
						striker.setx(striker.getx()+37);
						System.out.println("SDFSDFSDF");
					 }
					 else if(striker.getx()+37>418 && val)
					 {
						 striker.setx(striker.getx()-43);
					 }
					 val = checkstrikercollision();
					 
                  }
				}
				else {
					striker.setx(striker.getx()-3);
				}
			}
			//striker.sety(position);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		/*mouse.x = e.getX();
		mouse.y = e.getY();*/
		System.out.println( e.getX() +","+ e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		/*mouse.x = e.getX();
		mouse.y = e.getY();
		int strikerx = striker.getx();
		int strikery = striker.gety();*/
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(gp.player ==1 &&  gp.shotplayed != 1 && e.getX() > b.x  && e.getX() < b.x + b.width &&
				e.getY() < b.y + b.height && e.getY() > lowershooty){
			gp.setstroke = 0;
			gp.shotplayed = 1;
			striker.setdx(pf * (striker.getx() - e.getX()));
			striker.setdy(pf * (striker.gety() - e.getY()));
		}
		
		//for player 2
		if(gp.player == 2 &&  gp.shotplayed != 1 && e.getX() > b.x  && e.getX() < b.x + b.width &&
				e.getY() < uppershooty && e.getY() > b.y){
			gp.setstroke = 0;
			gp.shotplayed = 1;
			striker.setdx(pf * (striker.getx() - e.getX()));
			striker.setdy(pf * (striker.gety() - e.getY()));
		}
		
	
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(gp.player ==1 && gp.shotplayed != 1){
			if(e.getX() > b.x  && e.getX() < b.x + b.width &&
					e.getY() < b.y + b.height && e.getY() > lowershooty){
				gp.setstroke = 1;
				mouse.x = e.getX();
				mouse.y = e.getY();
			}
			else 
				gp.setstroke = 0;
		}
		//for player 2
		if(gp.player == 2 && gp.shotplayed != 1){
			if(gp.player == 2 && e.getX() > b.x  && e.getX() < b.x + b.width &&
					e.getY() < uppershooty && e.getY() > b.y){
				gp.setstroke = 1;
				mouse.x = e.getX();
				mouse.y = e.getY();
			}
			else 
				gp.setstroke = 0;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		/*mouse.x = e.getX();
		mouse.y = e.getY();
		System.out.println("x = "+ mouse.x +"y = " + mouse.y);*/
	}
}
