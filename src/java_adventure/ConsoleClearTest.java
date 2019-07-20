package java_adventure;
import java.io.IOException;
//*******************************************************************************
// File Name: ConsoleClearTest.java
// Author: Mac Orchard
//
// Purpose: 
//*******************************************************************************
public class ConsoleClearTest {
    public static void main (String[] args)throws IOException, InterruptedException{
        System.out.println("This a test of console clearing.");
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}