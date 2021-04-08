// 2019112130 조양진
// SimpleChatClientA.java
// original code: https://github.com/bethrobson/Head-First-Java/blob/master/chap15/SimpleChatClientA.java

package week9_02;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 채팅 클라이언트 A
public class SimpleChatClientA
{
	// 클라이언트 실행시 GUI로 입력하는 곳
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    
    public void go() {
    	// GUI 이름 설정
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        // 보내기 버튼 생성
        JButton sendButton = new JButton("Send");
        // 버튼에 액션리스너로 SendButtonListener 클래스 연결
        sendButton.addActionListener(new SendButtonListener());
        // 메인 판넬에 텍스트박스 추가
        mainPanel.add(outgoing);
        // 메인 판넬에 보내기 박스 추가
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        // 네트워크 연결
        setUpNetworking();
        // 사이즈 400*500
        frame.setSize(400, 500);
        frame.setVisible(true);
        
    }
    // 네트워크 연결
    private void setUpNetworking() {
        try {
        	// localhost, 5000포트
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    // 보내기 버튼 누름에 필요한 클래스 
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