/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.imgt.ForkJoinSequenceAnalysis3;
import java.util.concurrent.*;
/**
 *
 * @author karthik
 */
class sequenceReadingForkJoin extends RecursiveTask <String>
{
    String sequence;
    sequenceReadingForkJoin(String sequence)
    {
        this.sequence = sequence;
    }

    @Override
    protected String compute() {
        System.out.println(sequence);
        return sequence;
    }
}
