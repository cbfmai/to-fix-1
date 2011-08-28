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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixOrdListStatGrp;

public class FixListStatus extends FixMessage
{

	public byte[] listID;
	public long listStatusType = 0;
	public long noRpts = 0;
	public long listOrderStatus = 0;
	public long contingencyType = 0;
	public long listRejectReason = 0;
	public long rptSeq = 0;
	public byte[] listStatusText;
	public long encodedListStatusTextLen = 0;
	public byte[] encodedListStatusText;
	public byte[] transactTime;
	public long totNoOrders = 0;
	public boolean lastFragment = false;
	public FixOrdListStatGrp ordListStatGrp;

	public FixListStatus() {
		super();

		listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		listStatusText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedListStatusText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		ordListStatGrp = new FixOrdListStatGrp();
		this.clear();

		msgType = MsgTypes.LISTSTATUS_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( listID, (byte)0 );
		listStatusType = Long.MAX_VALUE;		
		noRpts = Long.MAX_VALUE;		
		listOrderStatus = Long.MAX_VALUE;		
		contingencyType = Long.MAX_VALUE;		
		listRejectReason = Long.MAX_VALUE;		
		rptSeq = Long.MAX_VALUE;		
		Utils.fill( listStatusText, (byte)0 );
		encodedListStatusTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedListStatusText, (byte)0 );
		Utils.fill( transactTime, (byte)0 );
		totNoOrders = Long.MAX_VALUE;		
		lastFragment = false;		
		ordListStatGrp.clear();
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

			case FixTags.LISTID_INT:
				listID = FixUtils.getTagStringValue(MsgTypes.LISTSTATUS ,id ,value, listID);
				break;

			case FixTags.LISTSTATUSTYPE_INT:
				listStatusType = FixUtils.getTagIntValue(MsgTypes.LISTSTATUS ,id ,value );
				if (!ListStatusType.isValid(listStatusType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + listStatusType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.NORPTS_INT:
				noRpts = FixUtils.getTagIntValue(MsgTypes.LISTSTATUS ,id ,value );
				break;

			case FixTags.LISTORDERSTATUS_INT:
				listOrderStatus = FixUtils.getTagIntValue(MsgTypes.LISTSTATUS ,id ,value );
				if (!ListOrderStatus.isValid(listOrderStatus) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + listOrderStatus + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.CONTINGENCYTYPE_INT:
				contingencyType = FixUtils.getTagIntValue(MsgTypes.LISTSTATUS ,id ,value );
				if (!ContingencyType.isValid(contingencyType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + contingencyType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.LISTREJECTREASON_INT:
				listRejectReason = FixUtils.getTagIntValue(MsgTypes.LISTSTATUS ,id ,value );
				if (!ListRejectReason.isValid(listRejectReason) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + listRejectReason + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.RPTSEQ_INT:
				rptSeq = FixUtils.getTagIntValue(MsgTypes.LISTSTATUS ,id ,value );
				break;

			case FixTags.LISTSTATUSTEXT_INT:
				listStatusText = FixUtils.getTagStringValue(MsgTypes.LISTSTATUS ,id ,value, listStatusText);
				break;

			case FixTags.ENCODEDLISTSTATUSTEXTLEN_INT:
				encodedListStatusTextLen = FixUtils.getTagIntValue(MsgTypes.LISTSTATUS ,id ,value );
				break;

			case FixTags.ENCODEDLISTSTATUSTEXT_INT:
				encodedListStatusText = FixUtils.getTagStringValue(MsgTypes.LISTSTATUS ,id ,value, encodedListStatusText);
				break;

			case FixTags.TRANSACTTIME_INT:
				transactTime = FixUtils.getTagStringValue(MsgTypes.LISTSTATUS ,id ,value, transactTime);
				break;

			case FixTags.TOTNOORDERS_INT:
				totNoOrders = FixUtils.getTagIntValue(MsgTypes.LISTSTATUS ,id ,value );
				break;

			case FixTags.LASTFRAGMENT_INT:
				lastFragment = FixUtils.getTagBooleanValue(MsgTypes.LISTSTATUS ,id ,value );
				if (!LastFragment.isValid(lastFragment) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + lastFragment + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.NOORDERS_INT:
				ordListStatGrp.noOrders = FixUtils.getTagIntValue( MsgTypes.LISTSTATUS ,FixTags.NOORDERS_INT ,value );
				ordListStatGrp.getAll(ordListStatGrp.noOrders, value );
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( MsgTypes.LISTSTATUS ,FixTags.CHECKSUM_INT, value );

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
		if (! FixUtils.isSet(listID) ) return FixTags.LISTID_INT;
		if (! FixUtils.isSet(listStatusType) ) return FixTags.LISTSTATUSTYPE_INT;
		if (! FixUtils.isSet(noRpts) ) return FixTags.NORPTS_INT;
		if (! FixUtils.isSet(listOrderStatus) ) return FixTags.LISTORDERSTATUS_INT;
		if (! FixUtils.isSet(rptSeq) ) return FixTags.RPTSEQ_INT;
		if (! FixUtils.isSet(totNoOrders) ) return FixTags.TOTNOORDERS_INT;
		if (! ordListStatGrp.isSet() ) return FixTags.NOORDERS_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.LISTSTATUS);

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

		FixUtils.putFixTag( out, FixTags.LISTID_INT, listID, 0, Utils.lastIndexTrim(listID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.LISTSTATUSTYPE_INT, listStatusType);
		FixUtils.putFixTag( out, FixTags.NORPTS_INT, noRpts);
		FixUtils.putFixTag( out, FixTags.LISTORDERSTATUS_INT, listOrderStatus);
		if (FixUtils.isSet(contingencyType)) FixUtils.putFixTag( out, FixTags.CONTINGENCYTYPE_INT, contingencyType);
		if (FixUtils.isSet(listRejectReason)) FixUtils.putFixTag( out, FixTags.LISTREJECTREASON_INT, listRejectReason);
		FixUtils.putFixTag( out, FixTags.RPTSEQ_INT, rptSeq);
		if (FixUtils.isSet(listStatusText)) FixUtils.putFixTag( out, FixTags.LISTSTATUSTEXT_INT, listStatusText, 0, Utils.lastIndexTrim(listStatusText, (byte)0) );
		if (FixUtils.isSet(encodedListStatusTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDLISTSTATUSTEXTLEN_INT, encodedListStatusTextLen);
		if (FixUtils.isSet(encodedListStatusText)) FixUtils.putFixTag( out, FixTags.ENCODEDLISTSTATUSTEXT_INT, encodedListStatusText, 0, Utils.lastIndexTrim(encodedListStatusText, (byte)0) );
		if (FixUtils.isSet(transactTime)) FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
		FixUtils.putFixTag( out, FixTags.TOTNOORDERS_INT, totNoOrders);
		if (FixUtils.isSet(lastFragment)) FixUtils.putFixTag( out, FixTags.LASTFRAGMENT_INT, lastFragment?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(ordListStatGrp.noOrders)) ordListStatGrp.encode( out );
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
		s += "MsgType(35)=" + new String(MsgTypes.LISTSTATUS) + sep;

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

			 s += "ListID(66)=" + new String(listID) + sep;
			 s += "ListStatusType(429)=" + String.valueOf(listStatusType) + sep;
			 s += "NoRpts(82)=" + String.valueOf(noRpts) + sep;
			 s += "ListOrderStatus(431)=" + String.valueOf(listOrderStatus) + sep;
			if (FixUtils.isSet(contingencyType)) s += "ContingencyType(1385)=" + String.valueOf(contingencyType) + sep;
			if (FixUtils.isSet(listRejectReason)) s += "ListRejectReason(1386)=" + String.valueOf(listRejectReason) + sep;
			 s += "RptSeq(83)=" + String.valueOf(rptSeq) + sep;
			if (FixUtils.isSet(listStatusText)) s += "ListStatusText(444)=" + new String(listStatusText) + sep;
			if (FixUtils.isSet(encodedListStatusTextLen)) s += "EncodedListStatusTextLen(445)=" + String.valueOf(encodedListStatusTextLen) + sep;
			if (FixUtils.isSet(encodedListStatusText)) s += "EncodedListStatusText(446)=" + new String(encodedListStatusText) + sep;
			if (FixUtils.isSet(transactTime)) s += "TransactTime(60)=" + new String(transactTime) + sep;
			 s += "TotNoOrders(68)=" + String.valueOf(totNoOrders) + sep;
			if (FixUtils.isSet(lastFragment)) s += "LastFragment(893)=" + String.valueOf(lastFragment) + sep;
			if (FixUtils.isSet(ordListStatGrp.noOrders)) s += ordListStatGrp.toString();

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixListStatus)) return false;

			FixListStatus msg = (FixListStatus) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( listID, msg.listID)) return false;

		if (!( listStatusType==msg.listStatusType)) return false;

		if (!( noRpts==msg.noRpts)) return false;

		if (!( listOrderStatus==msg.listOrderStatus)) return false;

		if (!( contingencyType==msg.contingencyType)) return false;

		if (!( listRejectReason==msg.listRejectReason)) return false;

		if (!( rptSeq==msg.rptSeq)) return false;

		if (!Utils.equals( listStatusText, msg.listStatusText)) return false;

		if (!( encodedListStatusTextLen==msg.encodedListStatusTextLen)) return false;

		if (!Utils.equals( encodedListStatusText, msg.encodedListStatusText)) return false;

		if (!( totNoOrders==msg.totNoOrders)) return false;

		if (!( lastFragment==msg.lastFragment)) return false;

		if (!ordListStatGrp.equals(msg.ordListStatGrp)) return false;

		return true;
	}
}
