// 2019112130 ������
// VerySimpleChatServer.java
// original code: https://github.com/bethrobson/Head-First-Java/blob/master/chap15/VerySimpleChatServer.java

package week9_02;

import java.io.*;
import java.net.*;
import java.util.*;

// ä�� ���� Ŭ����
public class VerySimpleChatServer
{
	// output ��Ʈ���� arraylist
    ArrayList clientOutputStreams;
    
    // Ŭ���̾�Ʈ �ڵ鸵 
    public class ClientHandler implements Runnable {
    	// ���� ������ ���� ����
        BufferedReader reader;
        Socket sock;
        
        public ClientHandler(Socket clientSOcket) {
            try {
            	// ���� �ް�
                sock = clientSOcket;
                // ��ǲ ��Ʈ�� ����
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
                
            } catch (Exception ex) { ex.printStackTrace(); }
        }
        
        public void run() {
            String message;
            try {
            	// �޼��� ������ ���
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    // ��� �Լ� ȣ��
                    tellEveryone(message);
                }
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }
    // ���� �Լ�
    public static void main(String[] args) {
        new VerySimpleChatServer().go();
    }
    // ���� �����ϸ� ����Ǵ� �Լ�
    public void go() {
    	// �ƿ�ǲ ��Ʈ���� ��̸���Ʈ
        clientOutputStreams = new ArrayList();
        try {
        	// Ŭ���̾�Ʈ�� ����ȣ��Ʈ 5000�� ��Ʈ ���ϱ� ���� 5000������ ������
            ServerSocket serverSock = new ServerSocket(5000);
            while(true) {
            	// ���� ����ް� 
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);
                // ���ο� ������ ����
                Thread t = new Thread(new ClientHandler(clientSocket));
                // ������ ����
                t.start();
                System.out.println("got a connection");
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    // �ݺ��ؼ� �Է°��� ������ �����
    public void tellEveryone(String message) {
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }
}
