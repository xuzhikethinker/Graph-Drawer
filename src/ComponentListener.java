import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ComponentListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
		String input = GUI.getInputText();
		GraphDrawer.gui.paintDot(Integer.parseInt(input), 200);
		
		System.out.println("Action Event Fired!");
	}

}
