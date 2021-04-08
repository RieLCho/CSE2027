// 2019112130 조양진
// VerySimpleChatServer.java
// original code: https://github.com/bethrobson/Head-First-Java/blob/master/chap15/VerySimpleChatServer.java

package week9_02;

import java.io.*;
import java.net.*;
import java.util.*;

// 채팅 서버 클래스
public class VerySimpleChatServer
{
	// output 스트림용 arraylist
    ArrayList clientOutputStreams;
    
    // 클라이언트 핸들링 
    public class ClientHandler implements Runnable {
    	// 버퍼 리더와 소켓 생성
        BufferedReader reader;
        Socket sock;
        
        public ClientHandler(Socket clientSOcket) {
            try {
            	// 소켓 받고
                sock = clientSOcket;
                // 인풋 스트림 저장
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
                
            } catch (Exception ex) { ex.printStackTrace(); }
        }
        
        public void run() {
            String message;
            try {
            	// 메세지 받은거 출력
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    // 출력 함수 호출
                    tellEveryone(message);
                }
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }
    // 메인 함수
    public static void main(String[] args) {
        new VerySimpleChatServer().go();
    }
    // 서버 시작하면 실행되는 함수
    public void go() {
    	// 아웃풋 스트림용 어레이리스트
        clientOutputStreams = new ArrayList();
        try {
        	// 클라이언트가 로컬호스트 5000번 포트 쓰니깐 소켓 5000번으로 열었음
            ServerSocket serverSock = new ServerSocket(5000);
            while(true) {
            	// 소켓 연결받고 
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);
                // 새로운 스레드 생성
                Thread t = new Thread(new ClientHandler(clientSocket));
                // 스레드 시작
                t.start();
                System.out.println("got a connection");
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    // 반복해서 입력값이 있으면 출력함
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
