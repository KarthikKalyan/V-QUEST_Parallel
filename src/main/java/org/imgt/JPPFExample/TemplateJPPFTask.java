/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.imgt.JPPFExample;

import org.jppf.node.protocol.AbstractTask;

/**
 *
 * @author karthik
 */
public class TemplateJPPFTask extends AbstractTask<String> {

    public void run() {
        // write your task code here.
        System.out.println("Hello, this is the node executing a template JPPF task");
        System.out.println("In fact, this is more than the standard template");

        // ...
        // eventually set the execution results
        setResult("the execution was performed successfully");
    }

}
