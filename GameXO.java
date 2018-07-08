import java.awt.*;
import java.awt.event.*;  
public class GameXO
{
	public static void main(String[] args) 
	{
		Graphic game1 = new Graphic();
	}
}
class Graphic implements ActionListener
{
	static int count=0,x,y;
	Button b[][] = new Button[3][3];
	Frame f1 = new Frame();
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Button reset = new Button("Reset");
	Button exit = new Button("Exit");
	Button undo = new Button("undo");
	public void check(String t)
	{
		if(b[0][0].getLabel()==t&&b[0][1].getLabel()==t&&b[0][2].getLabel()==t)
			{System.out.println(t+" won");System.exit(0);}
		if(b[0][0].getLabel()==t&&b[1][0].getLabel()==t&&b[2][0].getLabel()==t)
			{System.out.println(t+" won");System.exit(0);}
		if(b[0][0].getLabel()==t&&b[1][1].getLabel()==t&&b[2][2].getLabel()==t)
			{System.out.println(t+" won");System.exit(0);}
		if(b[1][0].getLabel()==t&&b[1][1].getLabel()==t&&b[1][2].getLabel()==t)
			{System.out.println(t+" won");System.exit(0);}
		if(b[2][0].getLabel()==t&&b[2][1].getLabel()==t&&b[2][2].getLabel()==t)
			{System.out.println(t+" won");System.exit(0);}
		if(b[0][1].getLabel()==t&&b[1][1].getLabel()==t&&b[2][1].getLabel()==t)
			{System.out.println(t+" won");System.exit(0);}
		if(b[0][2].getLabel()==t&&b[1][2].getLabel()==t&&b[2][2].getLabel()==t)
			{System.out.println(t+" won");System.exit(0);}
		if(b[2][1].getLabel()==t&&b[2][2].getLabel()==t&&b[1][2].getLabel()==t)
			{System.out.println(t+" won");System.exit(0);}
	}
	public Graphic()
	{
		int i,j;

		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				b[i][j]= new Button("");
				p1.add(b[i][j]);
				b[i][j].addActionListener(this);
			}
		}
		exit.addActionListener(this);
		reset.addActionListener(this);
		undo.addActionListener(this);
		p2.add(reset);p2.add(exit);p2.add(undo);
		FlowLayout fw1 = new FlowLayout();
		p2.setLayout(fw1);
		p2.setSize(300,100);
		GridLayout g1 =new GridLayout(3,3);
		p1.setLayout(g1);
		p1.setVisible(true);
		p1.setSize(300,300);	
		f1.add(p1);
		f1.add("South",p2);
		f1.setSize(300,400);
		f1.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exit)
			System.exit(0);
		else if(e.getSource()==reset)
		{
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					b[i][j].setLabel("");
				}
			}
		}
		else if(e.getSource()==undo)
		{
			b[x][y].setLabel("");
			count--;
		}
		else
		   	{
		   		for (int i=0;i<3;i++) 
		   		{
		   			for (int j=0;j<3;j++) 
		   			{
		   				if(e.getSource()==b[i][j]&&b[i][j].getLabel()=="")
						{
							x=i;y=j;
							if(Graphic.count%2==0)	
							{b[i][j].setLabel("X");check("X");}
							else
							{b[i][j].setLabel("O");check("O");}
							Graphic.count++;
							if(Graphic.count==9)
								{System.out.println("Draw");System.exit(0);}
						}
					}	
		   		}
	      	}
		}
	}