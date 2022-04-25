package chatbot.main.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatbotServer {

    final int PORT;
    private static final Logger logger = LogManager.getLogger(ChatbotServer.class);

    public ChatbotServer(int PORT) {
        this.PORT = PORT;
    }

    void start() {

        try {
            ServerSocket serverSocket = new ServerSocket(this.PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                InetAddress inetAddress = socket.getInetAddress();
                logger.info("Connect {}", inetAddress.getHostAddress());

                ChatbotServerThread chatbotServerThread = new ChatbotServerThread(socket);
                chatbotServerThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
