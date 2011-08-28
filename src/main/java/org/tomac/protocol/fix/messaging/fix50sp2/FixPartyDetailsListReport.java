package org.tomac.protocol.fix.messaging.fix50sp2;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.component.FixHopGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixApplicationSequenceControl;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixPartyListGrp;

public class FixPartyDetailsListReport extends FixMessage
{

	public FixApplicationSequenceControl applicationSequenceControl;
	public byte[] partyDetailsListReportID;
	public byte[] partyDetailsListRequestID;
	public long partyDetailsRequestResult = 0;
	public long totNoPartyList = 0;
	public boolean lastFragment = false;
	public FixPartyListGrp partyListGrp;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;

	public FixPartyDetailsListReport() {
		super();

		applicationSequenceControl = new FixApplicationSequenceControl();
		partyDetailsListReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		partyDetailsListRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		partyListGrp = new FixPartyListGrp();
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

		msgType = MsgTypes.PARTYDETAILSLISTREPORT_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( partyDetailsListReportID, (byte)0 );
		Utils.fill( partyDetailsListRequestID, (byte)0 );
		partyDetailsRequestResult = Long.MAX_VALUE;		
		totNoPartyList = Long.MAX_VALUE;		
		lastFragment = false;		
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		applicationSequenceControl.clear();
		partyListGrp.clear();
	}

	@Override
	public void getAll() throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		super.getAll();

		// assumption message is full otherwise decode would return null
		// so negative id means that we are at the end of the message
		int id;
		int lastTagPosition = buf.position();
		while ( ( id = FixUtils.getTagId( buf ) ) >= 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.APPLID_INT:
				applicationSequenceControl.getAll(FixTags.APPLID_INT, value );
				break;

			case FixTags.PARTYDETAILSLISTREPORTID_INT:
				partyDetailsListReportID = FixUtils.getTagStringValue(MsgTypes.PARTYDETAILSLISTREPORT ,id ,value, partyDetailsListReportID);
				break;

			case FixTags.PARTYDETAILSLISTREQUESTID_INT:
				partyDetailsListRequestID = FixUtils.getTagStringValue(MsgTypes.PARTYDETAILSLISTREPORT ,id ,value, partyDetailsListRequestID);
				break;

			case FixTags.PARTYDETAILSREQUESTRESULT_INT:
				partyDetailsRequestResult = FixUtils.getTagIntValue(MsgTypes.PARTYDETAILSLISTREPORT ,id ,value );
				if (!PartyDetailsRequestResult.isValid(partyDetailsRequestResult) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + partyDetailsRequestResult + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.TOTNOPARTYLIST_INT:
				totNoPartyList = FixUtils.getTagIntValue(MsgTypes.PARTYDETAILSLISTREPORT ,id ,value );
				break;

			case FixTags.LASTFRAGMENT_INT:
				lastFragment = FixUtils.getTagBooleanValue(MsgTypes.PARTYDETAILSLISTREPORT ,id ,value );
				if (!LastFragment.isValid(lastFragment) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + lastFragment + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.NOPARTYLIST_INT:
				partyListGrp.noPartyList = FixUtils.getTagIntValue( MsgTypes.PARTYDETAILSLISTREPORT ,FixTags.NOPARTYLIST_INT ,value );
				partyListGrp.getAll(partyListGrp.noPartyList, value );
				break;

			case FixTags.TEXT_INT:
				text = FixUtils.getTagStringValue(MsgTypes.PARTYDETAILSLISTREPORT ,id ,value, text);
				break;

			case FixTags.ENCODEDTEXTLEN_INT:
				encodedTextLen = FixUtils.getTagIntValue(MsgTypes.PARTYDETAILSLISTREPORT ,id ,value );
				break;

			case FixTags.ENCODEDTEXT_INT:
				encodedText = FixUtils.getTagStringValue(MsgTypes.PARTYDETAILSLISTREPORT ,id ,value, encodedText);
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( MsgTypes.PARTYDETAILSLISTREPORT ,FixTags.CHECKSUM_INT, value );

				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, FixUtils.getMsgType(msgType) );

				return;

			default:
				throw new FixSessionException(SessionRejectReason.UNDEFINED_TAG, "Unknown tag".getBytes(), id, FixUtils.getMsgType(msgType) );

			}

			lastTagPosition = buf.position();

		}

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(senderCompID) ) return FixTags.SENDERCOMPID_INT;
		if (! FixUtils.isSet(targetCompID) ) return FixTags.TARGETCOMPID_INT;
		if (! FixUtils.isSet(msgSeqNum) ) return FixTags.MSGSEQNUM_INT;
		if (! FixUtils.isSet(sendingTime) ) return FixTags.SENDINGTIME_INT;
		if (! FixUtils.isSet(partyDetailsListReportID) ) return FixTags.PARTYDETAILSLISTREPORTID_INT;
		if (! FixUtils.isSet(checkSum) ) return FixTags.CHECKSUM_INT;
		return tag;

	}
	@Override
	public void encode( ByteBuffer out )
	{
		// Encode message. Set msgSeqNum and sendingTime and optional resend flags, before encoding. 

		int msgStart = out.position();

		out.put( BEGINSTRING_VALUE_WITH_TAG );

		int msgLengthValueStart = out.position() + 2 /* 9= */;

		// placeholder
		FixUtils.putFixTag(out, FixTags.BODYLENGTH_INT, FixConstants.MAX_MESSAGE_SIZE );

		int msgTypeStart = out.position();

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.PARTYDETAILSLISTREPORT);

		// encode all fields including the header

		if (FixUtils.isSet(applVerID)) FixUtils.putFixTag( out, FixTags.APPLVERID_INT, applVerID, 0, Utils.lastIndexTrim(applVerID, (byte)0) );
		if (FixUtils.isSet(cstmApplVerID)) FixUtils.putFixTag( out, FixTags.CSTMAPPLVERID_INT, cstmApplVerID, 0, Utils.lastIndexTrim(cstmApplVerID, (byte)0) );
		if (FixUtils.isSet(applExtID)) FixUtils.putFixTag( out, FixTags.APPLEXTID_INT, applExtID);
		FixUtils.putFixTag( out, FixTags.SENDERCOMPID_INT, senderCompID, 0, Utils.lastIndexTrim(senderCompID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TARGETCOMPID_INT, targetCompID, 0, Utils.lastIndexTrim(targetCompID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfCompID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFCOMPID_INT, onBehalfOfCompID, 0, Utils.lastIndexTrim(onBehalfOfCompID, (byte)0) );
		if (FixUtils.isSet(deliverToCompID)) FixUtils.putFixTag( out, FixTags.DELIVERTOCOMPID_INT, deliverToCompID, 0, Utils.lastIndexTrim(deliverToCompID, (byte)0) );
		if (FixUtils.isSet(secureDataLen)) FixUtils.putFixTag( out, FixTags.SECUREDATALEN_INT, secureDataLen);
		if (FixUtils.isSet(secureData)) FixUtils.putFixTag( out, FixTags.SECUREDATA_INT, secureData, 0, Utils.lastIndexTrim(secureData, (byte)0) );
		FixUtils.putFixTag( out, FixTags.MSGSEQNUM_INT, msgSeqNum);
		if (FixUtils.isSet(senderSubID)) FixUtils.putFixTag( out, FixTags.SENDERSUBID_INT, senderSubID, 0, Utils.lastIndexTrim(senderSubID, (byte)0) );
		if (FixUtils.isSet(senderLocationID)) FixUtils.putFixTag( out, FixTags.SENDERLOCATIONID_INT, senderLocationID, 0, Utils.lastIndexTrim(senderLocationID, (byte)0) );
		if (FixUtils.isSet(targetSubID)) FixUtils.putFixTag( out, FixTags.TARGETSUBID_INT, targetSubID, 0, Utils.lastIndexTrim(targetSubID, (byte)0) );
		if (FixUtils.isSet(targetLocationID)) FixUtils.putFixTag( out, FixTags.TARGETLOCATIONID_INT, targetLocationID, 0, Utils.lastIndexTrim(targetLocationID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfSubID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFSUBID_INT, onBehalfOfSubID, 0, Utils.lastIndexTrim(onBehalfOfSubID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfLocationID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFLOCATIONID_INT, onBehalfOfLocationID, 0, Utils.lastIndexTrim(onBehalfOfLocationID, (byte)0) );
		if (FixUtils.isSet(deliverToSubID)) FixUtils.putFixTag( out, FixTags.DELIVERTOSUBID_INT, deliverToSubID, 0, Utils.lastIndexTrim(deliverToSubID, (byte)0) );
		if (FixUtils.isSet(deliverToLocationID)) FixUtils.putFixTag( out, FixTags.DELIVERTOLOCATIONID_INT, deliverToLocationID, 0, Utils.lastIndexTrim(deliverToLocationID, (byte)0) );
		if (FixUtils.isSet(possDupFlag)) FixUtils.putFixTag( out, FixTags.POSSDUPFLAG_INT, possDupFlag?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(possResend)) FixUtils.putFixTag( out, FixTags.POSSRESEND_INT, possResend?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.SENDINGTIME_INT, sendingTime);
		if (FixUtils.isSet(origSendingTime)) FixUtils.putFixTag( out, FixTags.ORIGSENDINGTIME_INT, origSendingTime);
		if (FixUtils.isSet(xmlDataLen)) FixUtils.putFixTag( out, FixTags.XMLDATALEN_INT, xmlDataLen);
		if (FixUtils.isSet(xmlData)) FixUtils.putFixTag( out, FixTags.XMLDATA_INT, xmlData, 0, Utils.lastIndexTrim(xmlData, (byte)0) );
		if (FixUtils.isSet(messageEncoding)) FixUtils.putFixTag( out, FixTags.MESSAGEENCODING_INT, messageEncoding, 0, Utils.lastIndexTrim(messageEncoding, (byte)0) );
		if (FixUtils.isSet(lastMsgSeqNumProcessed)) FixUtils.putFixTag( out, FixTags.LASTMSGSEQNUMPROCESSED_INT, lastMsgSeqNumProcessed);
		if ( FixUtils.isSet(hopGrp.noHops) )hopGrp.encode( out );

		if (FixUtils.isSet(applicationSequenceControl.applID)) applicationSequenceControl.encode( out );
		FixUtils.putFixTag( out, FixTags.PARTYDETAILSLISTREPORTID_INT, partyDetailsListReportID, 0, Utils.lastIndexTrim(partyDetailsListReportID, (byte)0) );
		if (FixUtils.isSet(partyDetailsListRequestID)) FixUtils.putFixTag( out, FixTags.PARTYDETAILSLISTREQUESTID_INT, partyDetailsListRequestID, 0, Utils.lastIndexTrim(partyDetailsListRequestID, (byte)0) );
		if (FixUtils.isSet(partyDetailsRequestResult)) FixUtils.putFixTag( out, FixTags.PARTYDETAILSREQUESTRESULT_INT, partyDetailsRequestResult);
		if (FixUtils.isSet(totNoPartyList)) FixUtils.putFixTag( out, FixTags.TOTNOPARTYLIST_INT, totNoPartyList);
		if (FixUtils.isSet(lastFragment)) FixUtils.putFixTag( out, FixTags.LASTFRAGMENT_INT, lastFragment?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(partyListGrp.noPartyList)) partyListGrp.encode( out );
		if (FixUtils.isSet(text)) FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		if (FixUtils.isSet(encodedTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXTLEN_INT, encodedTextLen);
		if (FixUtils.isSet(encodedText)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXT_INT, encodedText, 0, Utils.lastIndexTrim(encodedText, (byte)0) );
		// the checksum at the end

		int checkSumStart = out.position();
		out.position( msgLengthValueStart );
		bodyLength = checkSumStart - msgTypeStart;
		Utils.longToNumeric( out, bodyLength, Utils.digits(FixConstants.MAX_MESSAGE_SIZE) );

		checkSum = FixUtils.computeChecksum( out, msgStart, checkSumStart );
		out.position( checkSumStart );
		FixUtils.putFixTag( out, FixTags.CHECKSUM_INT, checkSum );

		out.flip();

	}
	@Override		
	public void printBuffer(ByteBuffer out) {

		out.put(buf);

		out.flip();

	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = SOH;

		String s = "BeginString(8)=" + new String(BEGINSTRING_VALUE) + sep;
		s += "BodyLength(9)=" + bodyLength + sep;
		s += "MsgType(35)=" + new String(MsgTypes.PARTYDETAILSLISTREPORT) + sep;

		try {
			// print all fields including the header

			if (FixUtils.isSet(applVerID)) s += "ApplVerID(1128)=" + new String(applVerID) + sep;
			if (FixUtils.isSet(cstmApplVerID)) s += "CstmApplVerID(1129)=" + new String(cstmApplVerID) + sep;
			if (FixUtils.isSet(applExtID)) s += "ApplExtID(1156)=" + String.valueOf(applExtID) + sep;
			 s += "SenderCompID(49)=" + new String(senderCompID) + sep;
			 s += "TargetCompID(56)=" + new String(targetCompID) + sep;
			if (FixUtils.isSet(onBehalfOfCompID)) s += "OnBehalfOfCompID(115)=" + new String(onBehalfOfCompID) + sep;
			if (FixUtils.isSet(deliverToCompID)) s += "DeliverToCompID(128)=" + new String(deliverToCompID) + sep;
			if (FixUtils.isSet(secureDataLen)) s += "SecureDataLen(90)=" + String.valueOf(secureDataLen) + sep;
			if (FixUtils.isSet(secureData)) s += "SecureData(91)=" + new String(secureData) + sep;
			 s += "MsgSeqNum(34)=" + String.valueOf(msgSeqNum) + sep;
			if (FixUtils.isSet(senderSubID)) s += "SenderSubID(50)=" + new String(senderSubID) + sep;
			if (FixUtils.isSet(senderLocationID)) s += "SenderLocationID(142)=" + new String(senderLocationID) + sep;
			if (FixUtils.isSet(targetSubID)) s += "TargetSubID(57)=" + new String(targetSubID) + sep;
			if (FixUtils.isSet(targetLocationID)) s += "TargetLocationID(143)=" + new String(targetLocationID) + sep;
			if (FixUtils.isSet(onBehalfOfSubID)) s += "OnBehalfOfSubID(116)=" + new String(onBehalfOfSubID) + sep;
			if (FixUtils.isSet(onBehalfOfLocationID)) s += "OnBehalfOfLocationID(144)=" + new String(onBehalfOfLocationID) + sep;
			if (FixUtils.isSet(deliverToSubID)) s += "DeliverToSubID(129)=" + new String(deliverToSubID) + sep;
			if (FixUtils.isSet(deliverToLocationID)) s += "DeliverToLocationID(145)=" + new String(deliverToLocationID) + sep;
			if (FixUtils.isSet(possDupFlag)) s += "PossDupFlag(43)=" + String.valueOf(possDupFlag) + sep;
			if (FixUtils.isSet(possResend)) s += "PossResend(97)=" + String.valueOf(possResend) + sep;
			 s += "SendingTime(52)=" + new String(sendingTime) + sep;
			if (FixUtils.isSet(origSendingTime)) s += "OrigSendingTime(122)=" + new String(origSendingTime) + sep;
			if (FixUtils.isSet(xmlDataLen)) s += "XmlDataLen(212)=" + String.valueOf(xmlDataLen) + sep;
			if (FixUtils.isSet(xmlData)) s += "XmlData(213)=" + new String(xmlData) + sep;
			if (FixUtils.isSet(messageEncoding)) s += "MessageEncoding(347)=" + new String(messageEncoding) + sep;
			if (FixUtils.isSet(lastMsgSeqNumProcessed)) s += "LastMsgSeqNumProcessed(369)=" + String.valueOf(lastMsgSeqNumProcessed) + sep;
			if (FixUtils.isSet(hopGrp.noHops)) s += hopGrp.toString();

			if (FixUtils.isSet(applicationSequenceControl.applID)) s += applicationSequenceControl.toString();
			 s += "PartyDetailsListReportID(1510)=" + new String(partyDetailsListReportID) + sep;
			if (FixUtils.isSet(partyDetailsListRequestID)) s += "PartyDetailsListRequestID(1505)=" + new String(partyDetailsListRequestID) + sep;
			if (FixUtils.isSet(partyDetailsRequestResult)) s += "PartyDetailsRequestResult(1511)=" + String.valueOf(partyDetailsRequestResult) + sep;
			if (FixUtils.isSet(totNoPartyList)) s += "TotNoPartyList(1512)=" + String.valueOf(totNoPartyList) + sep;
			if (FixUtils.isSet(lastFragment)) s += "LastFragment(893)=" + String.valueOf(lastFragment) + sep;
			if (FixUtils.isSet(partyListGrp.noPartyList)) s += partyListGrp.toString();
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPartyDetailsListReport)) return false;

			FixPartyDetailsListReport msg = (FixPartyDetailsListReport) o;

		if ( ! super.equals(msg) ) return false;

		if (!applicationSequenceControl.equals(msg.applicationSequenceControl)) return false;

		if (!Utils.equals( partyDetailsListReportID, msg.partyDetailsListReportID)) return false;

		if (!Utils.equals( partyDetailsListRequestID, msg.partyDetailsListRequestID)) return false;

		if (!( partyDetailsRequestResult==msg.partyDetailsRequestResult)) return false;

		if (!( totNoPartyList==msg.totNoPartyList)) return false;

		if (!( lastFragment==msg.lastFragment)) return false;

		if (!partyListGrp.equals(msg.partyListGrp)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		return true;
	}
}
