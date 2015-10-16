package pt.novaims.computation.model;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

public class SocketHandler extends BinaryWebSocketHandler {

	@Override
    public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        super.handleBinaryMessage(session, message);
        BinaryMessage binaryMessage = new BinaryMessage(message.getPayload());
        
    }
}
