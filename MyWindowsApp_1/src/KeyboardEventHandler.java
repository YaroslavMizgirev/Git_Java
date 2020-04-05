import org.eclipse.swt.events.KeyEvent;

public class KeyboardEventHandler implements org.eclipse.swt.events.KeyListener { 

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("keyPressed");
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println("keyReleased");
		//keystrokeHandling(e.keyCode);
	}


}
