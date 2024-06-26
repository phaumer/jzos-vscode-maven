/*
 * %Z%%W% %I%
 * ===========================================================================
 * IBM Confidential
 * OCO Source Materials
 * Licensed Materials - Property of IBM
 * IBM Semeru Runtime Certified Edition for z/OS
 *
 * (C) Copyright IBM Corp. 2007, 2023
 *
 * The source code for this program is not published or otherwise divested of
 * its trade secrets, irrespective of what has been deposited with the U.S.
 * Copyright Office.
 * 
 * DISCLAIMER: 
 * The following [enclosed] code is sample code created by IBM 
 * Corporation.  This sample code is not part of any standard IBM product 
 * and is provided to you solely for the purpose of assisting you in the 
 * development of your applications.  The code is provided 'AS IS', 
 * without warranty of any kind.  IBM shall not be liable for any damages 
 * arising out of your use of the sample code, even if they have been 
 * advised of the possibility of such damages.
 * ===========================================================================
 */
package com.ibm.jzos.sample.fields;
import com.ibm.jzos.fields.*;

// Generated by com.ibm.jzos.recordgen.asm.RecordClassGenerator on: Tue Jul 17 12:10:53 EDT 2007

/** 
 * Base class to map the fixed portion of SMF record 83 (RACF Security information).
 * This code (excluding these notes) was generated using 
 * <code>com.ibm.jzos.recordgen.asm.RecordClassGenerator</code> using the following JCL:
 * 
 * <pre><code>
//ASSEMBLE EXEC ASMAC,PARM='ADATA,LIST,NOTERM,NODECK,NOOBJECT' 
//C.SYSIN DD * 
      IFASMFR 83 
      END 
//C.SYSADATA DD DSN=&&ADATA,DISP=(NEW,PASS), 
//           SPACE=(CYL,(3,1)) 
//* 
//JAVA EXEC PROC=EXJZOSVM,VERSION='50' 
//MAINARGS DD * 
com.ibm.jzos.recordgen.asm.RecordClassGenerator 
  section=SMFRCD83 
  bufoffset=false 
  package=com.ibm.jzos.sample.fields 
  class=Smf83BaseRecord 
//SYSADATA DD DSN=&&ADATA,DISP=(OLD,DELETE) 
//STDOUT DD PATH='/home/user/Smf83BaseRecord.java', 
//          PATHOPTS=(OWRONLY,OCREAT), 
//          PATHMODE=SIRWXU 
//STDENV DD *
...
   </code></pre>
 * @see Smf83Record Smf83Record for a hand-coded subclass of this class that glues together the components
 * of a SMF 83 record
 * @since 2.1.0
 */
public class Smf83BaseRecord {

	protected static AssemblerDatatypeFactory factory = new AssemblerDatatypeFactory();

	/**          IFASMFR 83 <br/>
	    *%IFABGN1: ; <br/>
	    *        SMF RECORD FIXED HEADER SECTION                           @D6A <br/>
	    *                                                                  @D6A <br/>
	    SMFRCD83 DSECT          FIXED HEADER SECTION                       @M5A  */
	public static int SMFRCD83 = factory.getOffset();

	/**          DS    0F       ALIGN TO FULL WORD BOUNDARY                @M5A  */
	static { factory.pushOffset(); }
	static { factory.getBinaryAsIntField(4, true); }
	static { factory.popOffset(); }

	/** SMF83LEN DS    BL2      RECORD LENGTH                              @M5A  */
	protected static BinaryAsIntField SMF83LEN = factory.getBinaryAsIntField(2, false);

	/** SMF83SEG DS    BL2      SEGMENT DESCRIPTOR                         @M5A  */
	protected static BinaryAsIntField SMF83SEG = factory.getBinaryAsIntField(2, false);

	/** SMF83FLG DS    BL1      SYSTEM INDICATOR                           @M5A  */
	protected static BinaryAsIntField SMF83FLG = factory.getBinaryAsIntField(1, false);

	/** *                       BIT MEANING WHEN SET                       @M5A <br/>
	    *                       BIT 1  SUBTYPE UTILIZED INDICATOR          @M5A <br/>
	    SMF83RTY DS    BL1      RECORD TYPE(83)                            @M5A  */
	protected static BinaryAsIntField SMF83RTY = factory.getBinaryAsIntField(1, false);

	/** SMF83TME DS    BL4      TOD FROM TIME MACRO - BINARY               @M5A  */
	protected static BinaryAsLongField SMF83TME = factory.getBinaryAsLongField(4, false);

	/** SMF83DTE DS    PL4      DATE FROM TIME MACRO                       @M5A  */
	protected static PackedDecimalAsIntField SMF83DTE = factory.getPackedDecimalAsIntField(4, true);

	/** SMF83SID DS    CL4      SYSTEM IDENTIFICATION                      @M5A  */
	protected static StringField SMF83SID = factory.getStringField(4, true);

	/** SMF83DF1 DS    BL34     THE FOLLOWING FIELDS ARE DIFFERENT FROM    @D6C  */
	protected static ByteArrayField SMF83DF1 = factory.getByteArrayField(34);

	/** *                         SMF TYPE 80 RECORD:                      @M5A <br/>
	             ORG   SMF83DF1                                            @D6C  <br/>
	    SMF83SSI DS    CL4      SUBSYSTEM IDENTIFICATION - RACF            @D6A  */
	static { factory.incrementOffset(-34); }
	protected static StringField SMF83SSI = factory.getStringField(4, true);

	/** SMF83TYP DS    BL2      RECORD SUBTYPE =1                          @M5A  */
	protected static BinaryAsIntField SMF83TYP = factory.getBinaryAsIntField(2, false);

	/** *                                                                  @D6A <br/>
	    *        SELF DEFINING SECTION                                     @D6A <br/>
	    *                                                                  @D6A <br/>
	    SMF83SDS DS    BL28     SELF DEFINING SECTION                      @D6A  */
	protected static ByteArrayField SMF83SDS = factory.getByteArrayField(28);

	/**          ORG   SMF83SDS                                            @D6A  <br/>
	    SMF83TRP DS    BL2      NUMBER OF TRIPLETS                         @D6A  */
	static { factory.incrementOffset(-28); }
	protected static BinaryAsIntField SMF83TRP = factory.getBinaryAsIntField(2, false);

	/** SMF83XXX DS    BL2      RESERVED                                   @D6A  */
	protected static BinaryAsIntField SMF83XXX = factory.getBinaryAsIntField(2, false);

	/** SMF83OPD DS    BL4      OFFSET TO PRODUCT SECTION                  @D6A  */
	protected static BinaryAsLongField SMF83OPD = factory.getBinaryAsLongField(4, false);

	/** SMF83LPD DS    BL2      LENGTH OF PRODUCT SECTION                  @D6A  */
	protected static BinaryAsIntField SMF83LPD = factory.getBinaryAsIntField(2, false);

	/** SMF83NPD DS    BL2      NUMBER OF PRODUCT SECTIONS                 @D6A  */
	protected static BinaryAsIntField SMF83NPD = factory.getBinaryAsIntField(2, false);

	/** SMF83OD1 DS    BL4      OFFSET TO SECURITY SECTION                 @D6A  */
	protected static BinaryAsLongField SMF83OD1 = factory.getBinaryAsLongField(4, false);

	/** SMF83LD1 DS    BL2      LENGTH OF SECURITY SECTION                 @D6A  */
	protected static BinaryAsIntField SMF83LD1 = factory.getBinaryAsIntField(2, false);

	/** SMF83ND1 DS    BL2      NUMBER OF SECURITY SECTIONS                @D6A  */
	protected static BinaryAsIntField SMF83ND1 = factory.getBinaryAsIntField(2, false);

	/** SMF83OD2 DS    BL4      OFFSET TO RELOCATE SECTION                 @D6A  */
	protected static BinaryAsLongField SMF83OD2 = factory.getBinaryAsLongField(4, false);

	/** SMF83LD2 DS    BL2      LENGTH OF RELOCATE SECTION                 @D6A  */
	protected static BinaryAsIntField SMF83LD2 = factory.getBinaryAsIntField(2, false);

	/** SMF83ND2 DS    BL2      NUMBER OF RELOCATE SECTIONS                @D6A  */
	protected static BinaryAsIntField SMF83ND2 = factory.getBinaryAsIntField(2, false);

	protected byte[] bytes;

	// Instance variables used to cache field values 
	private Integer smf83len;
	private Integer smf83seg;
	private Integer smf83flg;
	private Integer smf83rty;
	private Long smf83tme;
	private Integer smf83dte;
	private String smf83sid;
	private byte[] smf83df1;
	private String smf83ssi;
	private Integer smf83typ;
	private byte[] smf83sds;
	private Integer smf83trp;
	private Integer smf83xxx;
	private Long smf83opd;
	private Integer smf83lpd;
	private Integer smf83npd;
	private Long smf83od1;
	private Integer smf83ld1;
	private Integer smf83nd1;
	private Long smf83od2;
	private Integer smf83ld2;
	private Integer smf83nd2;


	public Smf83BaseRecord(byte[] buffer) {
		this.bytes = buffer;
	}


	public int getSmf83len() {
		if (smf83len == null) {
			smf83len = Integer.valueOf(SMF83LEN.getInt(bytes));
		}
		return smf83len.intValue();
	}

	public void setSmf83len(int smf83len) {
		if (SMF83LEN.equals(this.smf83len, smf83len))
			return;
		SMF83LEN.putInt(smf83len, bytes);
		this.smf83len = Integer.valueOf(smf83len);
	}

	public int getSmf83seg() {
		if (smf83seg == null) {
			smf83seg = Integer.valueOf(SMF83SEG.getInt(bytes));
		}
		return smf83seg.intValue();
	}

	public void setSmf83seg(int smf83seg) {
		if (SMF83SEG.equals(this.smf83seg, smf83seg))
			return;
		SMF83SEG.putInt(smf83seg, bytes);
		this.smf83seg = Integer.valueOf(smf83seg);
	}

	public int getSmf83flg() {
		if (smf83flg == null) {
			smf83flg = Integer.valueOf(SMF83FLG.getInt(bytes));
		}
		return smf83flg.intValue();
	}

	public void setSmf83flg(int smf83flg) {
		if (SMF83FLG.equals(this.smf83flg, smf83flg))
			return;
		SMF83FLG.putInt(smf83flg, bytes);
		this.smf83flg = Integer.valueOf(smf83flg);
	}

	public int getSmf83rty() {
		if (smf83rty == null) {
			smf83rty = Integer.valueOf(SMF83RTY.getInt(bytes));
		}
		return smf83rty.intValue();
	}

	public void setSmf83rty(int smf83rty) {
		if (SMF83RTY.equals(this.smf83rty, smf83rty))
			return;
		SMF83RTY.putInt(smf83rty, bytes);
		this.smf83rty = Integer.valueOf(smf83rty);
	}

	public long getSmf83tme() {
		if (smf83tme == null) {
			smf83tme = Long.valueOf(SMF83TME.getLong(bytes));
		}
		return smf83tme.longValue();
	}

	public void setSmf83tme(long smf83tme) {
		if (SMF83TME.equals(this.smf83tme, smf83tme))
			return;
		SMF83TME.putLong(smf83tme, bytes);
		this.smf83tme = Long.valueOf(smf83tme);
	}

	public int getSmf83dte() {
		if (smf83dte == null) {
			smf83dte = Integer.valueOf(SMF83DTE.getInt(bytes));
		}
		return smf83dte.intValue();
	}

	public void setSmf83dte(int smf83dte) {
		if (SMF83DTE.equals(this.smf83dte, smf83dte))
			return;
		SMF83DTE.putInt(smf83dte, bytes);
		this.smf83dte = Integer.valueOf(smf83dte);
	}

	public String getSmf83sid() {
		if (smf83sid == null) {
			smf83sid = SMF83SID.getString(bytes);
		}
		return smf83sid;
	}

	public void setSmf83sid(String smf83sid) {
		if (SMF83SID.equals(this.smf83sid, smf83sid))
			return;
		SMF83SID.putString(smf83sid, bytes);
		this.smf83sid = smf83sid;
	}

	public byte[] getSmf83df1() {
		if (smf83df1 == null) {
			smf83df1 = SMF83DF1.getByteArray(bytes);
		}
		return smf83df1;
	}

	public void setSmf83df1(byte[] smf83df1) {
		if (SMF83DF1.equals(this.smf83df1, smf83df1))
			return;
		SMF83DF1.putByteArray(smf83df1, bytes);
		this.smf83df1 = smf83df1;
	}

	public String getSmf83ssi() {
		if (smf83ssi == null) {
			smf83ssi = SMF83SSI.getString(bytes);
		}
		return smf83ssi;
	}

	public void setSmf83ssi(String smf83ssi) {
		if (SMF83SSI.equals(this.smf83ssi, smf83ssi))
			return;
		SMF83SSI.putString(smf83ssi, bytes);
		this.smf83ssi = smf83ssi;
	}

	public int getSmf83typ() {
		if (smf83typ == null) {
			smf83typ = Integer.valueOf(SMF83TYP.getInt(bytes));
		}
		return smf83typ.intValue();
	}

	public void setSmf83typ(int smf83typ) {
		if (SMF83TYP.equals(this.smf83typ, smf83typ))
			return;
		SMF83TYP.putInt(smf83typ, bytes);
		this.smf83typ = Integer.valueOf(smf83typ);
	}

	public byte[] getSmf83sds() {
		if (smf83sds == null) {
			smf83sds = SMF83SDS.getByteArray(bytes);
		}
		return smf83sds;
	}

	public void setSmf83sds(byte[] smf83sds) {
		if (SMF83SDS.equals(this.smf83sds, smf83sds))
			return;
		SMF83SDS.putByteArray(smf83sds, bytes);
		this.smf83sds = smf83sds;
	}

	public int getSmf83trp() {
		if (smf83trp == null) {
			smf83trp = Integer.valueOf(SMF83TRP.getInt(bytes));
		}
		return smf83trp.intValue();
	}

	public void setSmf83trp(int smf83trp) {
		if (SMF83TRP.equals(this.smf83trp, smf83trp))
			return;
		SMF83TRP.putInt(smf83trp, bytes);
		this.smf83trp = Integer.valueOf(smf83trp);
	}

	public int getSmf83xxx() {
		if (smf83xxx == null) {
			smf83xxx = Integer.valueOf(SMF83XXX.getInt(bytes));
		}
		return smf83xxx.intValue();
	}

	public void setSmf83xxx(int smf83xxx) {
		if (SMF83XXX.equals(this.smf83xxx, smf83xxx))
			return;
		SMF83XXX.putInt(smf83xxx, bytes);
		this.smf83xxx = Integer.valueOf(smf83xxx);
	}

	public long getSmf83opd() {
		if (smf83opd == null) {
			smf83opd = Long.valueOf(SMF83OPD.getLong(bytes));
		}
		return smf83opd.longValue();
	}

	public void setSmf83opd(long smf83opd) {
		if (SMF83OPD.equals(this.smf83opd, smf83opd))
			return;
		SMF83OPD.putLong(smf83opd, bytes);
		this.smf83opd = Long.valueOf(smf83opd);
	}

	public int getSmf83lpd() {
		if (smf83lpd == null) {
			smf83lpd = Integer.valueOf(SMF83LPD.getInt(bytes));
		}
		return smf83lpd.intValue();
	}

	public void setSmf83lpd(int smf83lpd) {
		if (SMF83LPD.equals(this.smf83lpd, smf83lpd))
			return;
		SMF83LPD.putInt(smf83lpd, bytes);
		this.smf83lpd = Integer.valueOf(smf83lpd);
	}

	public int getSmf83npd() {
		if (smf83npd == null) {
			smf83npd = Integer.valueOf(SMF83NPD.getInt(bytes));
		}
		return smf83npd.intValue();
	}

	public void setSmf83npd(int smf83npd) {
		if (SMF83NPD.equals(this.smf83npd, smf83npd))
			return;
		SMF83NPD.putInt(smf83npd, bytes);
		this.smf83npd = Integer.valueOf(smf83npd);
	}

	public long getSmf83od1() {
		if (smf83od1 == null) {
			smf83od1 = Long.valueOf(SMF83OD1.getLong(bytes));
		}
		return smf83od1.longValue();
	}

	public void setSmf83od1(long smf83od1) {
		if (SMF83OD1.equals(this.smf83od1, smf83od1))
			return;
		SMF83OD1.putLong(smf83od1, bytes);
		this.smf83od1 = Long.valueOf(smf83od1);
	}

	public int getSmf83ld1() {
		if (smf83ld1 == null) {
			smf83ld1 = Integer.valueOf(SMF83LD1.getInt(bytes));
		}
		return smf83ld1.intValue();
	}

	public void setSmf83ld1(int smf83ld1) {
		if (SMF83LD1.equals(this.smf83ld1, smf83ld1))
			return;
		SMF83LD1.putInt(smf83ld1, bytes);
		this.smf83ld1 = Integer.valueOf(smf83ld1);
	}

	public int getSmf83nd1() {
		if (smf83nd1 == null) {
			smf83nd1 = Integer.valueOf(SMF83ND1.getInt(bytes));
		}
		return smf83nd1.intValue();
	}

	public void setSmf83nd1(int smf83nd1) {
		if (SMF83ND1.equals(this.smf83nd1, smf83nd1))
			return;
		SMF83ND1.putInt(smf83nd1, bytes);
		this.smf83nd1 = Integer.valueOf(smf83nd1);
	}

	public long getSmf83od2() {
		if (smf83od2 == null) {
			smf83od2 = Long.valueOf(SMF83OD2.getLong(bytes));
		}
		return smf83od2.longValue();
	}

	public void setSmf83od2(long smf83od2) {
		if (SMF83OD2.equals(this.smf83od2, smf83od2))
			return;
		SMF83OD2.putLong(smf83od2, bytes);
		this.smf83od2 = Long.valueOf(smf83od2);
	}

	public int getSmf83ld2() {
		if (smf83ld2 == null) {
			smf83ld2 = Integer.valueOf(SMF83LD2.getInt(bytes));
		}
		return smf83ld2.intValue();
	}

	public void setSmf83ld2(int smf83ld2) {
		if (SMF83LD2.equals(this.smf83ld2, smf83ld2))
			return;
		SMF83LD2.putInt(smf83ld2, bytes);
		this.smf83ld2 = Integer.valueOf(smf83ld2);
	}

	public int getSmf83nd2() {
		if (smf83nd2 == null) {
			smf83nd2 = Integer.valueOf(SMF83ND2.getInt(bytes));
		}
		return smf83nd2.intValue();
	}

	public void setSmf83nd2(int smf83nd2) {
		if (SMF83ND2.equals(this.smf83nd2, smf83nd2))
			return;
		SMF83ND2.putInt(smf83nd2, bytes);
		this.smf83nd2 = Integer.valueOf(smf83nd2);
	}

}
