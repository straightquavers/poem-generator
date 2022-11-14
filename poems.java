
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; // Import the Scanner class to read text files

//key a=adjective, v=verb, n=noun, av=adverb
// (pr = present, p = past)
// different poem structures
public class poems {

    public static void main(String[] args) {
        Random r2 = new Random();
        String l1, l2, l3;

        l1 = "";
        l2 = "";
        l3 = "";

//        System.out.println("hi");
//        String a = readFile("2a");
//        System.out.println(a);
        int poemType = r2.nextInt(4);

        if (poemType == 0) {
            // A 1a 2a 1n
// A 1n 1v(pr) into the 1n,
// 1n! 2n again.
            l1 = "A " + readFile("1a") + " " + readFile("2a") + " " + readFile("1n");
            l2 = "A " + readFile("1n") + " " + readFile("1v") + " into the " + readFile("1n");
            l3 = readFile("1n") + "! " + readFile("2n") + " again.";
        } else if (poemType == 1) {
// On a 2a 1n
// A 1n has 3v(p):
// 2n in 2n
            l1 = "On a " + readFile("2a") + " " + readFile("1n");
            l2 = "A " + readFile("1n") + " has " + readFile("3v") + ":";
            l3 = readFile("2n") + " in " + readFile("2n");
        } else if (poemType == 2) {
            //The 2n gives 1n.
//2n 2v(pr) their 2n,
//As 1n 1v(pr) 
            l1 = "The " + readFile("2n") + " gives " + readFile("1n");
            l2 = readFile("2n") + " " + readFile("2v") + " their " + readFile("2n");
            l3 = "As " + readFile("1n") + " " + readFile("1v");
        } else if (poemType == 3) {
            // 2v in the 1n,
// The 1n 1v 3av,
// 1n 1v 1n is 1a
            l1 = readFile("2v") + " in the " + readFile("1n");
            l2 = "The " + readFile("1n") + " " + readFile("1v") + " " + readFile("3av");
            l3 = readFile("1n") + " " + readFile("1v") + " " + readFile("1n") + " is " + readFile("1a");
        } else {
            System.out.println("i hate myself\npoetry amirite");
        }
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
    }

    public static String readFile(String wordtype) {
        try {
            Random r1 = new Random();
            String filename = "./wordlists/" + wordtype + ".txt";
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> wordlist = new ArrayList<String>();

            // read into array
            // strip spaces
            // get random number less than number of words
            // find nth word
            // return as string
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim().replaceAll("\\s+", "");
                wordlist.add(data);
            }
            myReader.close();
            int randomNumber = r1.nextInt(wordlist.size());
            String randomWord = wordlist.get(randomNumber);
            return randomWord;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "An error occurred.";
        }

    }
}
