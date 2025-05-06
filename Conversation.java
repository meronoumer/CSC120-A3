import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// References: https://www.w3schools.com/java/ref_string_replaceall.asp


/**
 * Represents a conversation with a chatbot.
 * Implements the Chatbot interface to handle user input and generate responses.
 */
class Conversation implements Chatbot {  

  /**
 * An array of canned responses used by the chatbot.
 */
   static final String[] cannedResponses = {
    "Mh-mmm.", "Oh that's interesting!","Tell me more.", "I see.","I'm so glad", "Go on."
  };
  /**
 * Stores the transcript of the conversation.
 */
ArrayList<String> transcript;
  /**
   * Constructor 
   * Constructs a new Conversation object.
   */

  public Conversation() {
    this.transcript = new ArrayList<String>();
    
  }
  /**
   * Starts and runs the conversation with the user
   * Asks user for input,generates specified number of responses and records the conversation
   */
  public void chat() {

    Scanner input = new Scanner(System.in);
    System.out.println("Hello. I'm a Chatbot. Nice to meet you !");
    System.out.println("How many rounds?");
    int roundsNum  = input.nextInt();  
    input.nextLine();
    
    System.out.println("Hi there!  What's on your mind?");

    for(int i = 0;i<roundsNum ;i++){
      String userInput = input.nextLine();
      String botResponse = respond(userInput);  
      System.out.println(botResponse);
      // System.out.println("Uh huh");
      transcript.add(userInput);
      transcript.add(botResponse);
    }
    System.out.println("Nice talking to you. See ya!");


    input.close();
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
  
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("TRANSCRIPT:");
    for(String line : transcript){
    System.out.println(line);}
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");}
  /**
 * Generates a response based on the user's input.
 *
 * @param inputString The user's input string.
 * @return A response string, either randomly selected or modified based on the input.
 */ 
  public String respond(String inputString) {
    String response;
    String lowerInput = inputString.toLowerCase();
    Random random = new Random(); // Create a Random object
    int randomIndex = random.nextInt(cannedResponses.length); // Generate a random index
    response = cannedResponses[randomIndex];

    String[] words = inputString.split("\\s+"); //new changes


   
    if (lowerInput.contains("i ") || 
    lowerInput.contains("me")||
    lowerInput.contains("am ")||
    lowerInput.contains("you ")||
    lowerInput.contains("your ")||
    lowerInput.contains("my ")||
    lowerInput.contains("are ")||
    lowerInput.contains("is ")){
      response = inputString;


    response = response.replaceAll("\\b[Ii]\\b", "You");
    response = response.replaceAll("\\byou\\b", "I");
        response = response.replaceAll("\\bme\\b", "you");
        response = response.replaceAll("\\bYour\\b", "My");
        // response = response.replaceAll("\\bmy\\b", "your");
        response = response.replaceAll("\\bmy\\b", "_TEMP_MY_");
        response = response.replaceAll("\\byour\\b", "my");
        response = response.replaceAll("\\bMy\\b", "Your");


        response = response.replaceAll("\\bam\\b", "are");
        response = response.replaceAll("\\bis\\b", "are");

        response = response.replaceAll("_TEMP_MY_", "your");


        
      
      
      
      }

        return response;
    }


  
      
  
  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
