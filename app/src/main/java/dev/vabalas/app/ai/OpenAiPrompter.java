package dev.vabalas.app.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class OpenAiPrompter {

    private final ChatClient chatClient;

    public OpenAiPrompter(ChatClient.Builder builder) {
        this.chatClient = builder.defaultSystem("short answer").build();
    }

    public void recommendCarToLoan(int budget, int loanPeriodYears, double interestRate) {
        System.out.println("recommending a car:");
        var carRecommendation = chatClient.prompt()
                .user("I have a budget of %d. Recommend me nice car to loan".formatted(budget))
                .call()
                .entity(CarDetails.class);
        System.out.println(carRecommendation);

        System.out.println("Estimating monthly payment:");
        var loanDetails = chatClient.prompt()
                .user("""
                        I am taking a loan for a car which costs %s.
                        The loan is for %d years with %f percent interest rate.
                        What would be my monthly payment?
                        """.formatted(carRecommendation.price(), loanPeriodYears, interestRate))
                .call()
                .entity(LoanDetails.class);
        System.out.println(loanDetails);

        System.out.println("Generating agreement:");
        var loanAgreementHTML = chatClient.prompt()
                .user("""
                        Generate car loan agreement document in html format.
                        It should include these car details: %s.
                        It should include these loan details: %s.
                        Also generate table with values for each monthly payment, how much of the car value is left to pay, how much of the interest is left to pay.
                        """.formatted(carRecommendation, loanDetails))
                .call()
                .content();
        System.out.println(loanAgreementHTML);
    }
}
