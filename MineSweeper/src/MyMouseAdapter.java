import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {

 
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1: 		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3: 
			Component c2 = e.getComponent();
			while (!(c2 instanceof JFrame)) {
				c2 = c2.getParent();
				if (c2 == null) {
					return;
				}
			}
			JFrame myFrame2 = (JFrame) c2;
			MyPanel myPanel2 = (MyPanel) myFrame2.getContentPane().getComponent(0);
			Insets myInsets2 = myFrame2.getInsets();
			int x2 = myInsets2.left;
			int y2 = myInsets2.top;
			e.translatePoint(-x2, -y2);
			int x3 = e.getX();
			int y3 = e.getY();
			myPanel2.x = x3;
			myPanel2.y = y3;
			myPanel2.mouseDownGridX = myPanel2.getGridX(x3, y3);
			myPanel2.mouseDownGridY = myPanel2.getGridY(x3, y3);
			myPanel2.repaint();
			break;
		
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			 System.out.print(gridX + " " + gridY);
		
									
									if( MyPanel.MineArray[gridX][gridY]==0 || MyPanel.MineArray[gridX][gridY]==1  ){
										 MyPanel.colorArray[gridX][gridY] = Color.BLACK;
										 myPanel.repaint();
									}
									else{ MyPanel.colorArray[gridX][gridY] = Color.GRAY;
									myPanel.repaint();
									int flagcounter=0;
									
								for(int i= -1; i <= 1; i++){
										 for(int u = -1; u <= 1; u++){		 
										 	//if( MyPanel.MineArray[gridX-1+i][gridY-1+u]==0 || MyPanel.MineArray[gridX-1+i][gridY-1+u]==1  )
											if(gridX+i>=0 && gridY+u>=0 && gridX+i<=8 && gridY+u<=8) {
											  if( MyPanel.MineArray[gridX+i][gridY+u]==0 || MyPanel.MineArray[gridX+i][gridY+u]==1 )	{
												 flagcounter = flagcounter + 1;
									
												 }
											}
										}
								} 	
								if(flagcounter ==0)
								{
									for(int i= -1; i <= 1; i++){
										 for(int u = -1; u <= 1; u++){		 
										 	//if( MyPanel.MineArray[gridX-1+i][gridY-1+u]==0 || MyPanel.MineArray[gridX-1+i][gridY-1+u]==1  )
											if(gridX+i>=0 && gridY+u>=0 && gridX+i<=8 && gridY+u<=8) {
											  if( !(MyPanel.MineArray[gridX+i][gridY+u]==0 || MyPanel.MineArray[gridX+i][gridY+u]==1 ))	{
												  MyPanel.colorArray[gridX+i][gridY+u] = Color.GRAY; }} }
											  }
								}
								}
							
							
								break;	
			     
			
		case 3:		//Right mouse button
			Component c2 = e.getComponent();
			while (!(c2 instanceof JFrame)) {
				c2 = c2.getParent();
				if (c2 == null) {
					return;
				}
			}
			JFrame myFrame2 = (JFrame)c2;
			MyPanel myPanel2 = (MyPanel) myFrame2.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets2 = myFrame2.getInsets();
			int x2 = myInsets2.left;
			int y2 = myInsets2.top;
			e.translatePoint(-x2, -y2);
			int x3 = e.getX();
			int y3= e.getY();
			myPanel2.x = x3;
			myPanel2.y = y3;
			int grid2X = myPanel2.getGridX(x3, y3);
			int grid2Y = myPanel2.getGridY(x3, y3);
			// System.out.print(grid2X + " " + grid2Y);
             if ((myPanel2.mouseDownGridX == -1) || (myPanel2.mouseDownGridY == -1)) {
	}
		
		else{           
		      
           MyPanel.colorArray[grid2X][grid2Y] = Color.RED;
           myPanel2.repaint();
					
				}
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	
}