package client;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class InputReader extends Applet implements MouseListener,
MouseWheelListener,
MouseMotionListener,
KeyListener{
/*
	public void init() {
		System.out.println("init");
		this.addMouseListener(this);
		this.addMouseWheelListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
	}
*/
	public Client connectedClient;
	private Applet mParent;
	public InputReader(Applet aParent){
		mParent = aParent;
		init();
	}
	public InputReader(MapGUI map, Client client){
		System.out.println("init");
		map.addMouseListener(this);
		map.addMouseWheelListener(this);
		map.addMouseMotionListener(this);
		map.addKeyListener(this);
		
		
		System.out.println(map.getMouseListeners());
		init();
		connectedClient = client;
		System.out.println("initialized input reader with Client " + connectedClient);
		
		
		int[] arr = {8,0,0,8,5};
		
		
		try {
			connectedClient.oos.writeObject(arr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	//has list of commands for robot to execute for listeners
	public static int commands[] = {-1,-1,-1};

	//MouseListener stuff
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseevent triggered");
		/*
		switch(e.getModifiers()){
			case InputEvent.BUTTON1_MASK: {
				System.out.println("LEFT");
				break;
			}
			case InputEvent.BUTTON2_MASK: {
				System.out.println("MIDDLE");
				break;
			}
			case InputEvent.BUTTON3_MASK: {
				System.out.println("RIGHT");
				break;
			}
		}
		 */
	}
	@Override
	public void mouseEntered(MouseEvent e) {System.out.println("mouseevent triggered");}
	@Override
	public void mouseExited(MouseEvent e) {System.out.println("mouseevent triggered");}
	@Override
	public void mousePressed(MouseEvent e) {
		//sets commands to a default of -1
		//for(int i=0; i<commands.length; i++){
		//	commands[i] = -1;
		//}
		System.out.println("mouseevent triggered");
		commands[0]=0;
		commands[1]=0;
		switch(e.getModifiers()){
		case InputEvent.BUTTON1_MASK: {
			System.out.println("LEFT PRESS");
			commands[2]=0;
			try {
				connectedClient.oos.writeObject(commands);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			commands[0] = -1;
			commands[1] = -1;
			commands[2] = -1;
			break;
		}
		case InputEvent.BUTTON2_MASK: {
			System.out.println("MIDDLE PRESS");
			commands[2]=1;
			break;
		}
		case InputEvent.BUTTON3_MASK: {
			System.out.println("RIGHT PRESS");
			commands[2]=2;
			break;
		}
		}

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		//sets commands to a default of -1
		//for(int i=0; i<commands.length; i++){
		//	commands[i] = -1;
		//}
		commands[0]=0;
		commands[1]=1;
		switch(e.getModifiers()){
		case InputEvent.BUTTON1_MASK: {
			System.out.println("LEFT RELEASE");
			commands[2]=0;
			break;
		}
		case InputEvent.BUTTON2_MASK: {
			System.out.println("MIDDLE RELEASE");
			commands[2]=1;
			break;
		}
		case InputEvent.BUTTON3_MASK: {
			System.out.println("RIGHT RELEASE");
			commands[2]=2;
			break;
		}
		}
	}	


	//MouseWheelListener stuff
	@Override
	public void mouseWheelMoved(MouseWheelEvent e){
		//sets commands to a default of -1
		//for(int i=0; i<commands.length; i++){
		//	commands[i] = -1;
		//}
		commands[0]=1;
		int rotation = e.getWheelRotation();
		commands[1]=rotation;
		System.out.println(rotation);
	}


	//MouseMotionListener stuff
	@Override
	public void mouseDragged(MouseEvent e){
		//sets commands to a default of -1
		//for(int i=0; i<commands.length; i++){
		//	commands[i] = -1;
		//}
		commands[0]=2;
		Point coords = MouseInfo.getPointerInfo().getLocation();
		commands[1]=(int) coords.getX();
		commands[2]=(int) coords.getY();
		System.out.println("x:" + coords.getX() + " y:" + coords.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e){
		//sets commands to a default of -1
		//for(int i=0; i<commands.length; i++){
		//	commands[i] = -1;
		//}
		commands[0]=2;
		Point coords = MouseInfo.getPointerInfo().getLocation();
		commands[1]=(int) coords.getX();
		commands[2]=(int) coords.getY();
		System.out.println("x:" + coords.getX() + " y:" + coords.getY());
	}


	//KeyListener stuff
	@Override
	public void keyPressed(KeyEvent e){
		//sets commands to a default of -1
		//for(int i=0; i<commands.length; i++){
		//	commands[i] = -1;
		//}
		commands[0]=3;
		commands[1]=0;
		int key = e.getKeyCode();
		commands[2]=key;
		System.out.println(key + " PRESS");

	}
	@Override
	public void keyReleased(KeyEvent e){
		//sets commands to a default of -1
		//for(int i=0; i<commands.length; i++){
		//	commands[i] = -1;
		//}
		commands[0]=3;
		commands[1]=1;
		int key = e.getKeyCode();
		commands[2]=key;
		System.out.println(key + " RELEASE");
	}
	@Override
	public void keyTyped(KeyEvent e){}
}
