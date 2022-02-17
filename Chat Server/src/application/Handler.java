package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//�� ���� Ŭ���̾�Ʈ�� ����ϰ� ���ִ� Ŭ���� �Դϴ�.
public class Handler {
   Socket socket;
   String id;

   // ������ ����
   public Handler(Socket socket) {
      this.socket = socket;
      //send("����" + Main.name);
      receive();
   }

   // Ŭ���̾�Ʈ�κ��� �޽����� ���޹޴� �޼ҵ�.
   int cnt=0;
   public void receive() {
      Thread thread = new Thread() {
         @Override
         public void run() {
            try {
               // ������ �޽����� ��� ���޹��� �� �ֵ���
               while (true) {
                  InputStream in = socket.getInputStream();
                  // ���۸� ����ؼ� �ѹ��� 512byte���� ���� �� �ֵ��� ����
                  byte[] buffer = new byte[512];
                  // �޽����� ũ��
                  int length = in.read(buffer);
                  while (length == -1)
                     throw new IOException();
                  // ������ ������ �� Ŭ���̾�Ʈ�� �ּ����� ���, �������� �̸����� ���,
                  System.out.println("[�޽��� ���� ����]" + socket.getRemoteSocketAddress() + " : "
                        + Thread.currentThread().getName());
                  // ���޹��� ���� �ѱ۵� ���� �� �� �ֵ��� UTF-8 ����
                  String message = new String(buffer, 0, length, "UTF-8");
                  if(cnt==0) {
                     id = message;
                     System.out.println(id);
                     cnt++;
                     continue;
                  } 

                  // /to �г��� "�޽���"
                  String[] temp = message.split(" ");
                  for (int i = 0; i < temp.length; i++) {
                  }
                  String[] I = temp[0].split(":"); // �ڱ��ڽ�
                  
                  
                  
               

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
                     // ���޹��� �޽����� �ٸ� Ŭ���̾�Ʈ�鿡�� ���� �� �ֵ��� ����� �ݴϴ�.
                     for (Handler client : Main.clients) {
                        client.send(message);
                        
                     }
      
                  }

               }
            } catch (Exception e) {
               try {
                  System.out.println(" [�޽��� ���� ����]" + socket.getRemoteSocketAddress() + " : "
                        + Thread.currentThread().getName());
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }
         }

      };
      // �����Լ��� �ִ� ������Ǯ�� submit
      Main.threadPool.submit(thread);
   }

   // Ŭ���̾�Ʈ���� �޽����� �����ϴ� �޼ҵ�.
   public void send(String message) {
      Thread thread = new Thread() {
         @Override
         public void run() {
            try {
               OutputStream out = socket.getOutputStream();
               byte[] buffer = message.getBytes("UTF-8");
               // ���ۿ� ��� ������ �������� Ŭ���̾�Ʈ���� ����
               out.write(buffer);
               out.flush();
            } catch (Exception e) {
               try {
                  System.out.println("[�޽��� �ۼ��� ����]" + socket.getRemoteSocketAddress() + " :"
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