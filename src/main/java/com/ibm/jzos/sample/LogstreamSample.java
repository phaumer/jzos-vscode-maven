/*
 * ===========================================================================
 * IBM Confidential
 * OCO Source Materials
 * Licensed Materials - Property of IBM
 * IBM Semeru Runtime Certified Edition for z/OS
 *
 * (C) Copyright IBM Corp. 2017
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

import com.ibm.jzos.ZLogstream;
import com.ibm.jzos.ZLogstreamException;

/**
 * Sample program that uses ZLogstream, supporting IXGCONN (connect) and
 * IXGBRWSE (read),
 * to read data from a z/OS Logstream (aka, the z/OS System Logger).
 * The name of the z/OS logstream is given as arguments to main(). If a Java
 * security
 * manager is active, it is used to check permissions for reading or writing to
 * a resource
 * path name generated from the logstream name. For a logstream named
 * "XXX.YYY.ZZZ",
 * a pathname of "/LOGSTREAM/XXX/YYY/XXX" is used.
 * <p>
 * Note:
 * To avoid memory leaks, a ZLogstream instance must be closed at the end of the
 * execution
 * or when the execution is interrupted by an exception. Refer to the code below
 * for details.
 * </p>
 */

public class LogstreamSample {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Usage: LogstreamSample <logstream name>");
			System.exit(1);
		}

		String logName = args[0];
		int maxRecordLength = 1024;
		byte[] record = new byte[maxRecordLength];

		ZLogstream zls = null;

		// Notes:
		// 1) Use try/catch blocks to handle exceptions.
		// 2) Implement a finally block with a close method to ensure
		// the stream disconnected and the memory released properly.
		try {
			// The ZLogstream constructor allocates a native work area and
			// calls the IXGCONN macro to connect to the named logstream
			zls = new ZLogstream(logName, true);

			// The browse method calls the IXGBROWSE REQUEST=START to
			// start a session
			zls.browseStart(true, true);

			// The read method allocates a native buffer storage and then calls
			// IXGBROWSE REQUEST=READCURSOR macro to read data from the logstream
			zls.readCursor(record, 0, true);

			// Get timestamp from the last block read
			long ots = zls.getTimestamp();

			// Calls IXGROWSE REQUET=END to end the session
			// If this method cannot be reached due to an exception, it will be
			// automatically called by the close method in the finally block.
			zls.browseEnd();

		} catch (Exception e) {
			// handle exception as appropriate here

		} finally {
			try {
				// The close method calls the IXGCONN macro to disconnect from
				// the logstream. It will also release the native work area and
				// buffer storage previously allocated by the constructor and
				// the read method.
				zls.close();
			} catch (Exception e) {
				// handle exception as appropriate here
			}
		}

	}
}
