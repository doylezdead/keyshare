package server;

import java.awt.*;
import java.awt.event.InputEvent;

public class WorkerRobot {
	private Robot walle;
	
	//constructor
	public WorkerRobot(){
		try {
			walle = new Robot();
		} catch (AWTException e) {
			System.out.println("Wall-e has died");
		}
	}
	
	/**
	 * recieves an array of integers
	 * [0]: (0,1,2,3)
	 *     0: mouse click
	 *         [1]: (0,1)
	 *             0: mouse press
	 *             1: mouse release
	 *         [2]: (0,1,2)
	 *             0: left button
	 *             1: middle button
	 *             2: right button
	 *     1: mouse wheel
	 *         [1]: number of notches
	 *     2: mouse motion
	 *         [1]: x coordinates
	 *         [2]: y coordinates
	 *     3: keyboard
	 *         [1]: (0,1)
	 *             0: key press
	 *             1: key release
	 *         [2]: key number
	 */
	public void work(int[] task){
		//mouse click
		if(task[0]==0){
			//mouse press
			if(task[1]==0){
				//left
				if(task[2]==0){
					walle.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				}
				//middle
				else if(task[2]==1){
					walle.mousePress(InputEvent.BUTTON2_DOWN_MASK);
				}
				//right
				else if(task[2]==2){
					walle.mousePress(InputEvent.BUTTON3_DOWN_MASK);
				}
			}
			//mouse release
			else if(task[1]==1){
				if(task[2]==0){
					walle.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				}
				//middle
				else if(task[2]==1){
					walle.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
				}
				//right
				else if(task[2]==2){
					walle.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
				}
			}
		}
		//mouse wheel
		else if(task[0]==1){
			walle.mouseWheel(task[1]);
		}
		//mouse motion
		else if(task[0]==2){
			walle.mouseMove(task[1], task[2]);
		}
		//keyboard
		else if(task[0]==3){
			//key press
			if(task[1]==0){
				walle.keyPress(task[2]);
			}
			//key release
			else if(task[1]==1){
				walle.keyRelease(task[2]);
			}
		}
	}
}




