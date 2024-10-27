package dev.vabalas.backend;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OpenAiPrompter {

    private final ChatClient chatClient;

    public OpenAiPrompter(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

//    @EventListener(ApplicationStartedEvent.class)
    public void sampleCall() {
        System.out.println("Calling OpenAI API...");

        var result = chatClient.prompt()
                .system("short answer")
                .user("10 car brands")
                .call()
                .entity(new ParameterizedTypeReference<List<String>>() {});

        System.out.println("Result: " + result);
    }
}
