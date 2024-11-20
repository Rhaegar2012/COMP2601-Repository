import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CustomNotifications {
	
	
	
	private final static int DIALOG_WIDTH 	=300;
	private final static int DIALOG_HEIGHT	=150;
	private final static int TOP_BORDER		=20;
	private final static int BOTTOM_BORDER	=20;
	private final static int LEFT_BORDER	=20;
	private final static int RIGHT_BORDER	=20;
	
	public static CustomNotifications notifications  = new CustomNotifications();
	
	public static void invalidEntryNotification(final String message) {
		JDialog notification = new JDialog();
		notification.setLayout(new BorderLayout());
		notification.setSize(DIALOG_WIDTH,DIALOG_HEIGHT);
		JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
		messageLabel.setBorder(BorderFactory.createEmptyBorder(TOP_BORDER,BOTTOM_BORDER,LEFT_BORDER,RIGHT_BORDER));
		notification.add(messageLabel,BorderLayout.CENTER);
		notification.setVisible(true);
		
	}

}
