// 2019112130 ������
// CreateNewAccount.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CreateNewAccount {
	static boolean isAccountCreated = false;
	public void go() {
		
		JFrame frame = new JFrame("New Account");
		Dimension dim = new Dimension(250,100);
        frame.setResizable(false);
		frame.setPreferredSize(dim);
        frame.setLocation(960, 540);
		
		JTextField textfield = new JTextField();
		textfield.setToolTipText("ID�� �Է����ּ���.");
		
		JLabel label = new JLabel("LOGIN");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			    // textfield�� �ִ� ID�� SimpleChatClient Ŭ���� ����
				SimpleChatClient.userID = textfield.getText();
				// ���� â �ݱ�
				frame.dispose();
		    	new SimpleChatClient().go();
			}
		});
		
		frame.add(label, BorderLayout.NORTH);
		frame.add(textfield, BorderLayout.CENTER);
		frame.add(button, BorderLayout.SOUTH);
		
		frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

	}
	
}
