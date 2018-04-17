package top.spanky.wos.web.socket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import net.sf.json.JSONObject;

public class WebsocketEndPoint extends TextWebSocketHandler {

    private Set<WebSocketSession> sessionList;

    public Set<WebSocketSession> getSessionList() {
        return sessionList;
    }

    private void addSession(WebSocketSession session) {
        if (sessionList == null) {
            sessionList = new HashSet<WebSocketSession>();
        }
        sessionList.add(session);
    }

    public void sendBroadMessage(Object... messageObj) {
        if ((sessionList == null) || (messageObj == null) || (messageObj.length < 3))
            return;
        try {
            for (WebSocketSession session : sessionList) {
                if ((session != null) && session.isOpen()) {
                    JSONObject message = new JSONObject();
                    message.put("data", messageObj[0]);
                    message.put("channel", messageObj[1]);
                    message.put("topic", messageObj[2]);
                    session.sendMessage(new TextMessage(JSONObject.fromObject(message).toString()));
                } else {
                    sessionList.remove(session);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        TextMessage returnMessage = new TextMessage(message.getPayload());
        System.out.println("Send:\t" + session.getRemoteAddress() + "\t" + message.getPayload());
        session.sendMessage(returnMessage);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(session.getRemoteAddress() + "\t Connection Established");
        addSession(session);
        super.afterConnectionEstablished(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println(session.getRemoteAddress() + "\t Closed");
        sessionList.remove(session);
        super.afterConnectionClosed(session, status);
    }


}