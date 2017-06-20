import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class frame extends JFrame {	
JPanel panel;	
	
frame() {
	setTitle("N O T A T N I K  L E K C Y J N Y");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setDefaultScreenSize();
	main();
}
public void setFrameSize(int width, int height) {
	
}
public void setDefaultScreenSize() {
	Dimension dimension = getScreenDimension();
	int height = dimension.height/2;
	int width = dimension.width/2;
	setSize(width, height);
}
public Dimension getScreenDimension() {
	Toolkit tolkit = Toolkit.getDefaultToolkit();
	Dimension dimension = tolkit.getScreenSize();
	return dimension;
}

public void main() {
	panel = new lessonsPanel().getPanel();
	add(panel);
}


}
