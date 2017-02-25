package eulerproject.level4.problem99;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by grzesikl on 22/02/2017.
 */
public class Solution {
    public static final String FILE = "C:\\Users\\grzesikl\\IdeaProjects\\projecteuler-master\\src\\main\\java\\eulerproject\\level3\\problem99\\base_exp.txt";

    public static void main(String[] args) {

        Path path = Paths.get(FILE);

        try(Stream<String> lines = Files.lines(path)){
            final String regex= ",";
            List<Number> list;

            list = lines.map(s-> new Number(new Integer(s.split(regex)[0]),new Integer(s.split(regex)[1]))).collect(Collectors.toList());

            int lineNo = 1;
            Number tempNumber = list.get(0);

            for(int i=1;i<list.size();i++) {
                Number otherNumber = list.get(i);
                if(otherNumber.compareTo(tempNumber) > 0) {
                    tempNumber = otherNumber;
                    lineNo = i+1;
                }

            }

            System.out.println(lineNo);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}

class Number implements Comparable{
    private int base;
    private int exp;

    Number(int base, int exp) {
        this.base = base;
        this.exp = exp;
    }


    @Override
    public int compareTo(Object o) {

        if(o instanceof Number) {
            Number other = (Number)o;

            if (other.base == base && other.exp == exp)
                return 0;
            else {
                double thisLog = logaritmValue();
                double otherLog = other.logaritmValue();

                if (thisLog > otherLog)
                    return 1;
                else if(thisLog < otherLog)
                    return -1;
                else
                    return 0;

            }

        }
        else
            return -1;
    }

    public double logaritmValue() {
        return exp*Math.log(base);
    }
}