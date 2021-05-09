package sbp.runner;

import sbp.exceptions.WorkWithExceptions;
import sbp.io.MyIOExample;

public class Main {
    public static void main(String[] args) {
        //MyIOExample myIOExample = new MyIOExample();
        //myIOExample.workWithFile("pom.xml");
        //myIOExample.copyFile("pom.xml", "pom2.txt");
        //myIOExample.copyBufferedFile("pom.xml", "pom3.txt");
        //myIOExample.copyFileWithReaderAndWriter("pom.xml", "pom4.txt");

        try
        {
            String s = "ErrorString";
            throw new WorkWithExceptions();
        } catch (WorkWithExceptions ex) {
            ex.printStackTrace();
            ex.exceptionProcessing();
        }
    }
}
