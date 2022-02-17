package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//한 명의 클라이언트와 통신하게 해주는 클래스 입니다.
public class Handler {
   Socket socket;
   String id;

   // 생성자 생성
   public Handler(Socket socket) {
      this.socket = socket;
      //send("입장" + Main.name);
      receive();
   }

   // 클라이언트로부터 메시지를 전달받는 메소드.
   int cnt=0;
   public void receive() {
      Thread thread = new Thread() {
         @Override
         public void run() {
            try {
               // 서버가 메시지를 계속 전달받을 수 있도록
               while (true) {
                  InputStream in = socket.getInputStream();
                  // 버퍼를 사용해서 한번에 512byte까지 받을 수 있도록 설정
                  byte[] buffer = new byte[512];
                  // 메시지의 크기
                  int length = in.read(buffer);
                  while (length == -1)
                     throw new IOException();
                  // 서버에 접속을 한 클라이언트의 주소정보 출력, 스레드의 이름값을 출력,
                  System.out.println("[메시지 수신 성공]" + socket.getRemoteSocketAddress() + " : "
                        + Thread.currentThread().getName());
                  // 전달받은 값을 한글도 포함 할 수 있도록 UTF-8 설정
                  String message = new String(buffer, 0, length, "UTF-8");
                  if(cnt==0) {
                     id = message;
                     System.out.println(id);
                     cnt++;
                     continue;
                  } 

                  // /to 닉네임 "메시지"
                  String[] temp = message.split(" ");
                  for (int i = 0; i < temp.length; i++) {
                  }
                  String[] I = temp[0].split(":"); // 자기자신
                  
                  
                  
               

                  String mes ="";
                  for (int i = 2; i < temp.length; i++) {
                     mes+=temp[i]+" ";
                  }

                  if(temp[1].equals("/to")) {
                     for (Handler client : Main.clients) {
                        System.out.println(client.id);
                        if(client.id.equals(temp[2]) || client.id.equals(I[0])) {
                           client.send(I[0] + mes);
                        }
                        
                     }
                  } else {
                     // 전달받은 메시지를 다른 클라이언트들에게 보낼 수 있도록 만들어 줍니다.
                     for (Handler client : Main.clients) {
                        client.send(message);
                        
                     }
      
                  }

               }
            } catch (Exception e) {
               try {
                  System.out.println(" [메시지 수신 오류]" + socket.getRemoteSocketAddress() + " : "
                        + Thread.currentThread().getName());
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }
         }

      };
      // 메인함수에 있는 스레드풀에 submit
      Main.threadPool.submit(thread);
   }

   // 클라이언트에게 메시지를 전송하는 메소드.
   public void send(String message) {
      Thread thread = new Thread() {
         @Override
         public void run() {
            try {
               OutputStream out = socket.getOutputStream();
               byte[] buffer = message.getBytes("UTF-8");
               // 버퍼에 담긴 내용을 서버에서 클라이언트에게 전송
               out.write(buffer);
               out.flush();
            } catch (Exception e) {
               try {
                  System.out.println("[메시지 송수신 오류]" + socket.getRemoteSocketAddress() + " :"
                        + Thread.currentThread().getName());
                  Main.clients.remove(Handler.this);
                  socket.close();

               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }

         }

      };
      Main.threadPool.submit(thread);
   }
}