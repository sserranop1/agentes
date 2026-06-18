import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

public class OpenAIService {

    private final OpenAIClient client;

    public OpenAIService() {
        this.client = OpenAIOkHttpClient.fromEnv();
    }

    public String ask(String prompt) {
        try {
            ResponseCreateParams params = ResponseCreateParams.builder()
                    .model(ChatModel.GPT_4O)
                    .input(prompt)
                    .build();

            Response response = client.responses().create(params);

            StringBuilder text = new StringBuilder();

            response.output().stream()
                    .flatMap(item -> item.message().stream())
                    .flatMap(message -> message.content().stream())
                    .flatMap(content -> content.outputText().stream())
                    .forEach(outputText -> text.append(outputText.text()));

            if (text.length() == 0) {
                return "El modelo respondió, pero no recibí texto.";
            }

            return text.toString();

        } catch (Exception e) {
            return "Error llamando al modelo de IA: " + e.getMessage();
        }
    }
}