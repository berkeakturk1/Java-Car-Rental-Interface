import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.io.FileWriter;
import java.io.IOException;

public class Client {
    private int clientID, totalAmount, times;
    private List<String>  pickL, dropL;

    public Client(){
        Random random = new Random();
        clientID = random.nextInt(1000, 2000);
        totalAmount = 0;
        times = 0;
        this.pickL = new ArrayList<>();
        this.dropL = new ArrayList<>();

    }

    public int getClientID() {return clientID;}

    public void append(String name, String text){
        if (name.equals("p"))
            pickL.add(text);
        else if(name.equals("d"))
            dropL.add(text);
    }
    public void increment(){times++;}

    public void addAmount(int amount){totalAmount+=amount;}
    public void generateList(){
        try {

            FileWriter fWriter = new FileWriter(
                    "C:\\Users\\aktrk\\IdeaProjects\\oophw\\src\\reports\\client_id.txt");

            fWriter.write("Client ID: " + Integer.toString(clientID));
            fWriter.write("\nTotal amount of times a car has been rented: " + Integer.toString(times) + "\n"
                    +"Total amount of money spent by Client: " + Integer.toString(totalAmount) );
            for (int i = 0; i < pickL.size(); i++){
                fWriter.write("\n" + Integer.toString(i + 1) + ". Car locations: \n"
                        + "Pick-up location: " + pickL.get(i)
                        + "\nDrop-off location: " + dropL.get(i));
            }
            fWriter.close();

            System.out.println(
                    "File is created successfully with the content.");
        }

        // Catch block to handle if exception occurs
        catch (IOException e) {

            // Print the exception
            System.out.print(e.getMessage());
        }
    }
}
