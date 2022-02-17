package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

   Socket socket;
   TextArea textArea;

   // 클라이언트 프로그램 동작
   public void startClient(String IP, int port) {
      Thread thread = new Thread() {
         public void run() {
            try {
               // socket 초기화
               socket = new Socket(IP, port);
               receive();
            } catch (Exception e) {
               // 오류가 생긴다면
               if (!socket.isClosed()) {
                  stopClient();
                  Platform.exit();
               }
            }
         }
      };
      thread.start();
   }

   // 클라이언트 프로그램 종료 메소드
   public void stopClient() {
      try {
         if (socket != null && !socket.isClosed()) {
//            try {
//                 Thread.sleep(300);
//              } catch (InterruptedException e) {
//                 e.printStackTrace();
//              }
//            send("[서버 접속 실패]");
             socket.close();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   // 서버로부터 메시지를 전달받는 메소드
   public void receive() {
      // 서버 프로그램으로부터 메시지를 계속 전달 받을 수 있도록
      while (true) {
         try {
            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[512];
            int length = in.read(buffer);
            if (length == -1)
               throw new IOException();
            String message = new String(buffer, 0, length, "UTF-8");
            Platform.runLater(() -> {
               // 메시지 창에 타 클라이언트의 메세지를 띄움
               textArea.appendText(message);
            });

         } catch (Exception e) {
            stopClient();
            break;
         }
      }
   }

   // 서버로 메시지를 전송하는 메소드
   public void send(String message) {
      Thread thread = new Thread() {
         public void run() {
            try {
               OutputStream out = socket.getOutputStream();
               byte[] buffer = message.getBytes("UTF-8");
               out.write(buffer);
               out.flush();
            } catch (Exception e) {
               stopClient();
            }
         }
      };
      thread.start();
   }
   
   //귓속말
   public void send(String message, String toNickName) {
      Thread thread = new Thread() {
            public void run() {
               try {
                  OutputStream out = socket.getOutputStream();
                  byte[] buffer = message.getBytes("UTF-8");
                  out.write(buffer);
                  out.flush();
               } catch (Exception e) {
                  stopClient();
               }
            }
         };
         thread.start();
   }


   @Override
   public void start(Stage stage) {
      BorderPane root = new BorderPane();
      root.setPadding(new Insets(5));
      root.setStyle("-fx-background-color: pink; -fx-padding: 10;");

      HBox hbox = new HBox();
      hbox.setSpacing(5);
      hbox.setStyle("-fx-background-color: pink;-fx-radius:30;");

      TextField userName = new TextField();
      userName.setPrefWidth(150);
      userName.setPromptText("닉네임을 입력하세요.");
      HBox.setHgrow(userName, Priority.ALWAYS);
      
      
      String IPText = "192.168.1.48"; // 서버 IP
      int portText = 5001;
      textArea = new TextArea(); // 메시지를 보여주는 채팅창
      textArea.setEditable(false);
      textArea.setStyle("-fx-background-color: pink; -fx-padding: 10 0 10 0;");
      root.setCenter(textArea);

      TextField input = new TextField(); // 메시지를 입력하는 창
      input.setPrefWidth(Double.MAX_VALUE);
      input.setDisable(true);

      input.setOnAction(event -> {
            if(input!=null && input.getLength()>0) {               
               
               send(userName.getText() + ": " + input.getText() + "\n");
               input.setText(""); // 보낸 뒤 초기화
            }
            input.requestFocus(); // 커서 깜빡
         });
      
     
      
      
      
      // 보내기 버튼
      Button sendButton = new Button("보내기");
      sendButton.setDisable(true);
      sendButton.setStyle("-fx-cursor: hand; -fx-background-color: #11ffee00;  "
            + "-fx-border-color:white;  -fx-border-width: 1;  -fx-border-radius: 30; ");

      sendButton.setOnAction(event ->{
            if(input!=null && input.getLength()>0) {
               sendButton.setDisable(false);
               send(userName.getText() + " : " + input.getText() + "\n");
               input.setText("");
            }
            input.requestFocus();
         });
      
      // 접속하기 버튼
      Button connectionButton = new Button("접속하기");
      connectionButton.setStyle("-fx-cursor: hand; -fx-background-color: #11ffee00;  "
            + "-fx-border-color:white;  -fx-border-width: 1;  -fx-border-radius: 30; ");
      connectionButton.setOnAction(event -> {
         if (connectionButton.getText().equals("접속하기") 
               && userName.getText()!=null 
               && userName.getText().length()>0) {
            startClient(IPText, portText);
            try {
               Thread.sleep(300);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            send(userName.getText());
            // !!
            try {
            Thread.sleep(1000);
         } catch (Exception e) {
            // TODO: handle exception
         }
            send("                 [ " + userName.getText() + "님이 입장 하셨습니다. ]\n");
            connectionButton.setText("종료하기");
            input.setDisable(false);
            input.requestFocus();
            sendButton.setDisable(false);
            connectionButton.setStyle("-fx-background-color: #FFF; ");

         } else {
            send("                 [ " + userName.getText() + "님이 퇴장 하셨습니다. ]\n");
            try {
               Thread.sleep(300);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            stopClient();
            connectionButton.setText("접속하기");
            input.setDisable(true);
            sendButton.setDisable(true);
         }
      });

      hbox.getChildren().addAll(userName, connectionButton);
      root.setTop(hbox);

      BorderPane pane = new BorderPane();
      pane.setCenter(input);
      pane.setRight(sendButton);

      root.setBottom(pane);
      Scene scene = new Scene(root, 300, 500);
      stage.setTitle(" 🍑이슬톡톡 ");
      stage.setScene(scene);
      stage.setOnCloseRequest(event -> stopClient());
      stage.show();

      connectionButton.requestFocus();

   }

   // 프로그램의 진입점.
   public static void main(String[] args) {
      launch(args);
   }
}