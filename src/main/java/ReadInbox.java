//Import Java Utilities
import java.io.IOException;
import java.util.List;

// Import Nylas Packages
import com.nylas.NylasAccount;
import com.nylas.NylasClient;
import com.nylas.RequestFailedException;
import com.nylas.Message;
import com.nylas.Messages;
import com.nylas.RemoteCollection;
import com.nylas.MessageQuery;

// Import DotEnv to handle .env files
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

public class ReadInbox {
    public static void main(String[] args) throws RequestFailedException, IOException{
        Dotenv dotenv = Dotenv.load();
        // Create the client object
        NylasClient client = new NylasClient();
        // Connect it to Nylas using the Access Token from the .env file
        NylasAccount account = client.account(dotenv.get("ACCESS_TOKEN"));

        // Access the messages endpoint
        Messages messages = account.messages();
        // Read 3 messages coming from the Inbox
        RemoteCollection<Message> messageList = messages.list(new MessageQuery().in("inbox").limit(3));

        // Loop through the emails
        for(Message email : messageList){
            // Print the date and subject of the email
            System.out.println(email.getDate() + " " + email.getSubject());
        }
    }
}
