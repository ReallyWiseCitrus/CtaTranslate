package Project;

import java.io.Console;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static PrintStream printStream;

    static {

        try {

            printStream = new PrintStream(System.out, true, "cp866");

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "cp866");

        String input = scanner.nextLine();

        cta(input);

        main(args);

    }

    private static void cta(String Translate) {

       String[] Split = Translate.split(" ");

       StringBuilder Cta = new StringBuilder();

       for(String SplitPart : Split) {

           if(SplitPart.length() <= 3) {

               Cta.append(SplitPart).append(" ");

               continue;

           }

           if(SplitPart.length() <= 6) {

               int RandomCharAt = new Random().nextInt(SplitPart.length() - 1) + 1;

               char CharAt = SplitPart.charAt(RandomCharAt);

               char LastChar = SplitPart.charAt(SplitPart.length() - 1);

               char[] Chars = SplitPart.toCharArray();

               Chars[Chars.length-1] = CharAt;

               Chars[RandomCharAt] = LastChar;

               SplitPart = String.valueOf(Chars);

           } else {

               long Replaces = SplitPart.length() / 4;

               for(int i = 0; i < Replaces; i++) {

                   int RandomCharAt = new Random().nextInt(SplitPart.length() - 1) + 1;

                   int SecondRandomCharAt = new Random().nextInt(SplitPart.length() - 1) + 1;

                   while(SecondRandomCharAt == RandomCharAt) {

                       SecondRandomCharAt = new Random().nextInt(SplitPart.length() - 1) + 1;

                   }

                   char CharAt = SplitPart.charAt(RandomCharAt);

                   char SecondCharAt = SplitPart.charAt(SecondRandomCharAt);

                   char[] Chars = SplitPart.toCharArray();

                   Chars[RandomCharAt] = SecondCharAt;

                   Chars[SecondRandomCharAt] = CharAt;

                   SplitPart = String.valueOf(Chars);

               }

           }

           Cta.append(SplitPart).append(" ");

       }

       String Translated = Cta.toString();

       Translated = Translated.substring(0, Cta.length() - 1);

       printStream.println(Translated);

    }

}
