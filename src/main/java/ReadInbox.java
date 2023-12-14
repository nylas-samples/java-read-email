// Import Nylas packages
import com.nylas.NylasClient;
import com.nylas.models.*;

// Import DotEnv to handle .env files
import io.github.cdimascio.dotenv.Dotenv;

import java.text.SimpleDateFormat;
import java.util.List;

public class ReadEmailParameters {
    public static void main(String[] args) throws NylasSdkTimeoutError, NylasApiError {
        // Load the .env file
        Dotenv dotenv = Dotenv.load();
        // Initialize the Nylas client
        NylasClient nylas = new NylasClient.Builder(dotenv.get("V3_TOKEN_API")).build();

        ListMessagesQueryParams queryParams = new ListMessagesQueryParams.Builder().
                limit(3).
                inFolder(List.of("inbox")).
                build();

        ListResponse<Message> message = nylas.messages().list(dotenv.get("GRANT_ID"), queryParams);
        for(Message email : message.getData()){
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                    format(new java.util.Date((email.getDate() * 1000L)));
            System.out.println("[" + date + "] | " + email.getSubject());
        }
    }
}
