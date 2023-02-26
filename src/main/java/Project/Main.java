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

    public static void main(String[] agrs){

        Scanner scanern = new Scanner(System.in, "cp866");

        String ipunt = scanern.nextLine();

        cta(ipunt);

        main(agrs);

    }

    private static void cta(String transatel) {

        String[] sptil = transatel.split(" ");

        StringBuilder cta = new StringBuilder();

        for(String sptil_prat : sptil) {

            for(int rnadom = 0; rnadom < new Random().nextInt(3) + 3; rnadom++) {

                int lnegth = sptil_prat.length();

                int rnadom_chra_oen_ = new Random().nextInt(lnegth);

                int rnadom_chra_otw_ = new Random().nextInt(lnegth);

                char rnadom_chra_oen = sptil_prat.charAt(rnadom_chra_oen_);

                char rnadom_chra_otw = sptil_prat.charAt(rnadom_chra_otw_);

                char[] chras = sptil_prat.toCharArray();

                chras[rnadom_chra_oen_] = rnadom_chra_otw;

                chras[rnadom_chra_otw_] = rnadom_chra_oen;

                sptil_prat = String.valueOf(chras);

            }

            cta.append(sptil_prat).append(" ");

        }

        String cta_transatel = cta.toString();

        cta_transatel = cta_transatel.substring(0, cta_transatel.length()-1);

        printStream.println(cta_transatel);

    }

}
