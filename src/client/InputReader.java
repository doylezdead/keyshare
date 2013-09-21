package client;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class InputReader extends Applet implements MouseListener,
										MouseWheelListener,
										MouseMotionListener,
										KeyListener{

	public void init() {
		this.addMouseListener(this);
		this.addMouseWheelListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
	}
	
	//MouseListener stuff
	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		switch(e.getModifiers()){
			case InputEvent.BUTTON1_MASK: {
				System.out.println("LEFT PRESS");
				break;
			}
			case InputEvent.BUTTON2_MASK: {
				System.out.println("MIDDLE PRESS");
				break;
			}
			case InputEvent.BUTTON3_MASK: {
				System.out.println("RIGHT PRESS");
				break;
			}
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		switch(e.getModifiers()){
			case InputEvent.BUTTON1_MASK: {
				System.out.println("LEFT RELEASE");
				break;
			}
			case InputEvent.BUTTON2_MASK: {
				System.out.println("MIDDLE RELEASE");
				break;
			}
			case InputEvent.BUTTON3_MASK: {
				System.out.println("RIGHT RELEASE");
				break;
			}
		}
	}	
	
	
	//MouseWheelListener stuff
	@Override
	public void mouseWheelMoved(MouseWheelEvent e){
		int rotation = e.getWheelRotation();
		System.out.println(rotation);
	}
	
	
	//MouseMotionListener stuff
	@Override
	public void mouseDragged(MouseEvent e){
		Point coords = MouseInfo.getPointerInfo().getLocation();
		System.out.println("x:" + coords.getX() + " y:" + coords.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e){
		Point coords = MouseInfo.getPointerInfo().getLocation();
		System.out.println("x:" + coords.getX() + " y:" + coords.getY());
	}
	
	
	//KeyListener stuff
	@Override
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		System.out.println(key + " PRESS");
		
	}
	@Override
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		System.out.println(key + " RELEASE");
	}
	@Override
	public void keyTyped(KeyEvent e){}
}
