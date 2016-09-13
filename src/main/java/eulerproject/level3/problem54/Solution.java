package eulerproject.level3.problem54;

import java.io.*;

/**
 * Created by grzesikl on 13/09/2016.
 */
public class Solution {

    public static void main(String[] args) {
        int counter=0;
        File file = new File("C:\\Users\\Lukasz\\IdeaProjects\\projecteuler\\src\\main\\java\\eulerproject\\level3\\problem54\\p054_poker.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                Hand handOne  = new Hand(line.substring(0,15));
                Hand handTwo  = new Hand(line.substring(15));
                System.out.println(handOne.toString() + handTwo.toString());

                if (handOne.compareTo(handTwo)>=0)
                    counter++;
            }

            br.close();
            fr.close();
            System.out.println(counter);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
