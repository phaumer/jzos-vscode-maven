/*
 * %Z%%W% %I%
 *
 * =========================================================================
 * Licensed Materials - Property of IBM
 * "Restricted Materials of IBM"
 * (C) Copyright IBM Corp. 2025. All Rights Reserved
 * 
 * DISCLAIMER: 
 * The following [enclosed] code is sample code created by IBM 
 * Corporation.  This sample code is not part of any standard IBM product 
 * and is provided to you solely for the purpose of assisting you in the 
 * development of your applications.  The code is provided 'AS IS', 
 * without warranty of any kind.  IBM shall not be liable for any damages 
 * arising out of your use of the sample code, even if they have been 
 * advised of the possibility of such damages.
 * =========================================================================
 */
package com.ibm.jzos.sample;

import java.util.*;
import com.ibm.jzos.AccessMethodServices;

/**
 * LISTCAT gives you the information without recalling LISTCAT
 * ENT('your.dataset.name') VOLUME LISTCAT will tell the VOLSER of the data set,
 * On the system when we migrate a data set it says VOLSER------------MIGRAT1
 * MIGRAT1 and MIGRAT2 is the standard for terms of HSM to notify that the
 * dataset is migrated.
 * @since 4.1.0
 */
public class ListCat {

    public static void main(String[] args) throws Exception {
        String dsname = args[0];
        System.out.println("dsname = " + dsname);
        String in = "LISTCAT ENT ('" + dsname.toUpperCase() + "') VOLUME";
        System.out.println("in = " + in);
        // String def1 = String.format("LISTCAT ENT ('jazzsv1.private.jzos.jcl')
        // VOLUME");
        String def1 = String.format(in);
        AccessMethodServices ams = new AccessMethodServices();
        ams.addInputLine(def1);
        int rc = ams.execute();

        String out = ams.getOutputLines();
        System.out.println("IDCAMS return code: " + rc);
        System.out.println("IDCAMS return text: " + out);

        String regex = "[\n]";
        String[] myArray = out.split(regex);
        for (String s : myArray) {
            if (s.contains("VOLSER------------")) {
                String[] b = s.split("\\s+");
                String[] c = b[1].split("------------");
                System.out.println(dsname + " is on volume " + c[1]);
            }
        }
    }
}