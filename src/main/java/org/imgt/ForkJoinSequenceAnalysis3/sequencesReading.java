/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.imgt.ForkJoinSequenceAnalysis3;

/**
 *
 * @author karthik
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class sequencesReading {

    String header = ">";
    String file;

    public void fileRead() {
        BufferedReader buff = null;
        StringBuilder wholeStringBlock = new StringBuilder();
        ForkJoinPool pool = new ForkJoinPool();
        String line;
        try {
            buff = new BufferedReader(new FileReader("/home/karthik/NetBeansProjects/mavenThreadsApp/bin/HumanIGSequences_VQuest.fasta"));
            //System.out.println("Reading the file using readLine() method:");
            if(buff.readLine().isEmpty() == true) throw new IOException ("It is an empty file at:" +buff);
            //while(buff.readLine().charAt(0) != header.charAt(0)) throw new IOException ("First line of a FASTA file at" + buff + " should always start with '>' character");
            for (line = buff.readLine(); line != null; line = buff.readLine()) {
                if (line.startsWith(header)) {
                    if (wholeStringBlock.length() != 0) {
                        //System.out.println("Goes on thread on these sequence with VQuest!" +wholeStringBlock.toString());
                        sequenceReadingForkJoin vQuestTask = new sequenceReadingForkJoin(wholeStringBlock.toString());
                        wholeStringBlock.setLength(0);
                        pool.execute(vQuestTask);
                    }
                    System.out.println("new sequence");
                } else {
                    wholeStringBlock.append(line);
                    //System.out.println(line);
                }
            }
            if (wholeStringBlock.length() != 0) {
                //System.out.println("Goes on thread on these sequence with VQuest" +wholeStringBlock.toString());
                sequenceReadingForkJoin vQuestTask = new sequenceReadingForkJoin(wholeStringBlock.toString());
                wholeStringBlock.setLength(0);
                pool.execute(vQuestTask);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (buff != null) {
                    buff.close();
                }
            } catch (IOException e) {
                System.out.println("Error in closing the Buffered Reader");
            }
        }
    }
}
