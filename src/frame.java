import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;

public class frame extends JFrame {	
	
frame() {
	setTitle("N O T A T N I K  L E K C Y J N Y");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setDefaultScreenSize();
}
public void setFrameSize(int width, int height) {
	
}
public void setDefaultScreenSize() {
	Dimension dimension = getScreenDimension();
	int height = dimension.height;
	int width = dimension.width;
	setSize(width/2, height/2);
}
public Dimension getScreenDimension() {
	Toolkit tolkit = Toolkit.getDefaultToolkit();
	Dimension dimension = tolkit.getScreenSize();
	return dimension;
}


}
