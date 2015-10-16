package pt.novaims.computation.websocket;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import pt.novaims.computation.model.SocketHandler;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Bean
    public WebSocketHandler myHandler() {
        return new SocketHandler();
    }
	
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SocketHandler(), "/socketHandler").withSockJS();
           // .addInterceptors(new HttpSessionHandshakeInterceptor());
    }    
    

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/portfolio").withSockJS();
    }

    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/topic", "/queue");
    }
    
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }

	public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
		// TODO Auto-generated method stub
		
	}

	public void configureClientInboundChannel(ChannelRegistration registration) {
		// TODO Auto-generated method stub
		
	}

	public void configureClientOutboundChannel(ChannelRegistration registration) {
		// TODO Auto-generated method stub
		
	}

	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
		
	}

	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		
	}

	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
		// TODO Auto-generated method stub
		return false;
	}
}