// 2019112130 ������
// SimpleChatClientA.java
// original code: https://github.com/bethrobson/Head-First-Java/blob/master/chap15/SimpleChatClientA.java

package week9_02;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ä�� Ŭ���̾�Ʈ A
public class SimpleChatClientA
{
	// Ŭ���̾�Ʈ ����� GUI�� �Է��ϴ� ��
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    
    public void go() {
    	// GUI �̸� ����
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        // ������ ��ư ����
        JButton sendButton = new JButton("Send");
        // ��ư�� �׼Ǹ����ʷ� SendButtonListener Ŭ���� ����
        sendButton.addActionListener(new SendButtonListener());
        // ���� �ǳڿ� �ؽ�Ʈ�ڽ� �߰�
        mainPanel.add(outgoing);
        // ���� �ǳڿ� ������ �ڽ� �߰�
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        // ��Ʈ��ũ ����
        setUpNetworking();
        // ������ 400*500
        frame.setSize(400, 500);
        frame.setVisible(true);
        
    }
    // ��Ʈ��ũ ����
    private void setUpNetworking() {
        try {
        	// localhost, 5000��Ʈ
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    // ������ ��ư ������ �ʿ��� Ŭ���� 
    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
                
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
    
    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
}