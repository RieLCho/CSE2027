// 2019112130 조양진
// SimpleChatClient.java

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*
 * TODO LIST
 * 1. 채팅방 입장시 ID 생성하고 채팅 입력시 그사람 ID 가 옆에 뜨게하기 .
 * (ID 생성시 GUI 를 통해 생성해야 합니다 . Console 창에 입력 X)
 * 2. 채팅방 입장 , 퇴장시 채팅창에 뜨게하기
 * 3. 채팅옆에 현재 시간 출력하기
 * 4. 그 외 기능 구현시 난이도에 따라 +0~2 점을 부여
 */

public class SimpleChatClient
{
    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;
    static String userID;
    
    SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    Date time1 = new Date();
    String nowTime1 = format1.format(time1);
    
    SimpleDateFormat format2 = new SimpleDateFormat ( "HH:mm");
    Date time2 = new Date();
    String nowTime2 = format2.format(time2);
    
    public void go() {
    	System.out.println("Logged in to " + userID);
    	// 4. 그 외 기능 구현시 난이도에 따라 +0~2 점을 부여
        JFrame frame = new JFrame("Simple Chat Client - " + userID);
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        // 4. 그 외 기능 구현시 난이도에 따라 +0~2 점을 부여
        JButton eraseButton = new JButton("Erase");	// outgoing JTextField 지우기
        JButton clearButton = new JButton("Clear");	// incoming JTextArea 비우기
        sendButton.addActionListener(new SendButtonListener());
        eraseButton.addActionListener(new EraseButtonListener());
        clearButton.addActionListener(new ClearButtonListener());
        
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        mainPanel.add(eraseButton);
        mainPanel.add(clearButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setUpNetworking();
        
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
        
        frame.setSize(650, 500);
        frame.setVisible(true);
        // 2. 채팅방 입장시 채팅창에 뜨게하기
        writer.append(userID + " joined chat. (" + nowTime1 + ")"+ "\n");
    	writer.flush();
    	
    	// 2. 채팅방 퇴장시 채팅창에 뜨게하기
    	frame.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    			writer.append(userID + " left chat. (" + nowTime1 + ")"+ "\n");
    	    	writer.flush();
    		}
    	});
    	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
    
    private void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            try {
            	// 1. 채팅 입력시 그사람 ID 가 옆에 뜨게하기
            	// 3. 채팅옆에 현재 시간 출력하기
                writer.println(userID + ": " + outgoing.getText() + " (" + nowTime2 + ")");
                writer.flush();
                
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
    
    // 4. 그 외 기능 구현시 난이도에 따라 +0~2 점을 부여
    // outgoing JTextField 지우기
    public class EraseButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent ev) {
    		SimpleChatClient.this.outgoing.setText(null);
    	}
    }
    // incoming JTextArea 비우기
    public class ClearButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent ev) {
    		SimpleChatClient.this.incoming.setText(null);
    	}
    }
    
    public static void main(String[] args) {
    	new CreateNewAccount().go();
    }
    
    class IncomingReader implements Runnable {
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("LOG: " + message);
                    incoming.append(message + "\n");
                }
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}