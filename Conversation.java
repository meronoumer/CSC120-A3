import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


/**
 * Represents a conversation with a chatbot.
 * Implements the Chatbot interface to handle user input and generate responses.
 */
class Conversation implements Chatbot {

  // Attributes 
  /**
 * An array of canned responses used by the chatbot.
 */
   static final String[] cannedResponses = {
    "Mh-mmm.", "Oh that's interesting!","Tell me more.", "I see.","I'm so glad", "Go on."
  };
  /**
 * Stores the transcript of the conversation.
 */
  static ArrayList<String> transcript = new ArrayList<>();

  /**
   * Constructor 
   * Constructs a new Conversation object.
   */
  Conversation() {
    
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
    
    System.out.println("Hi there!  What's on your mind?");
    String firstInput = input.nextLine();

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
    String lowerInput = inputString.toLowerCase();
    Random random = new Random(); // Create a Random object
    int randomIndex = random.nextInt(cannedResponses.length); // Generate a random index
    String response = cannedResponses[randomIndex];
   
    if (lowerInput.contains("i ") || 
    lowerInput.contains("me ")||
    lowerInput.contains("am ")||
    lowerInput.contains("you ")||
    lowerInput.contains("your ")||
    lowerInput.contains("my ")||
    lowerInput.contains("are ")||
    lowerInput.contains("is ")){
      response = inputString;

      if (lowerInput.contains("i ")) {
        response = lowerInput.replace("i ", "You "); }
        
        
    
      if  (lowerInput.contains("me ")) {
        response = response.replace("me", "you"); }
      if (lowerInput.contains("am ")) {
        response = response.replace("am", "are"); }
      if (lowerInput.contains("you ")) {
        response = response.replace("you", "I"); }
      if (lowerInput.toLowerCase().contains("your ")) {
        response = response.replace("your", "my"); }
      if (lowerInput.toLowerCase().contains("my ")) {
        response = response.replace("my", "your"); }
      if (lowerInput.toLowerCase().contains("are ")){
        response = response.replace("are","am");

      }
      if (lowerInput.toLowerCase().contains("is ")){
        response = response.replace("is", "are");
      }
      return response;
      }
    else{
      return response;

      }    

    


    }
  
      
  
  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
