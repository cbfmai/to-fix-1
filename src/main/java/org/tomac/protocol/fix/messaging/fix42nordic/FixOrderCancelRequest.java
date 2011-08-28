package org.tomac.protocol.fix.messaging.fix42nordic;

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



public class FixOrderCancelRequest extends FixMessage
{

	public byte[] clOrdID;
	public byte[] currency;
	public byte[] orderID;
	public long orderQty = 0;
	public byte[] origClOrdID;
	public byte[] securityID;
	public byte side = (byte)' ';
	public byte[] symbol;
	public byte[] transactTime;
	public byte[] subMktID;

	public FixOrderCancelRequest() {
		super();

		clOrdID = new byte[20];
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		orderID = new byte[32];
		origClOrdID = new byte[20];
		securityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		symbol = new byte[8];
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		subMktID = new byte[3];
		this.clear();

		msgType = MsgTypes.ORDERCANCELREQUEST_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( clOrdID, (byte)0 );
		Utils.fill( currency, (byte)0 );
		Utils.fill( orderID, (byte)0 );
		orderQty = Long.MAX_VALUE;		
		Utils.fill( origClOrdID, (byte)0 );
		Utils.fill( securityID, (byte)0 );
		side = Byte.MAX_VALUE;		
		Utils.fill( symbol, (byte)0 );
		Utils.fill( transactTime, (byte)0 );
		Utils.fill( subMktID, (byte)0 );
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

			case FixTags.CLORDID_INT:
				clOrdID = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREQUEST ,id ,value, clOrdID);
				break;

			case FixTags.CURRENCY_INT:
				currency = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREQUEST ,id ,value, currency);
				break;

			case FixTags.ORDERID_INT:
				orderID = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREQUEST ,id ,value, orderID);
				break;

			case FixTags.ORDERQTY_INT:
				orderQty = FixUtils.getTagFloatValue(MsgTypes.ORDERCANCELREQUEST ,id ,value);
				break;

			case FixTags.ORIGCLORDID_INT:
				origClOrdID = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREQUEST ,id ,value, origClOrdID);
				break;

			case FixTags.SECURITYID_INT:
				securityID = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREQUEST ,id ,value, securityID);
				break;

			case FixTags.SIDE_INT:
				side = FixUtils.getTagCharValue(MsgTypes.ORDERCANCELREQUEST ,id ,value );
				if (!Side.isValid(side) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + side + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.SYMBOL_INT:
				symbol = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREQUEST ,id ,value, symbol);
				break;

			case FixTags.TRANSACTTIME_INT:
				transactTime = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREQUEST ,id ,value, transactTime);
				break;

			case FixTags.SUBMKTID_INT:
				subMktID = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREQUEST ,id ,value, subMktID);
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( MsgTypes.ORDERCANCELREQUEST ,FixTags.CHECKSUM_INT, value );

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

		if (! FixUtils.isSet(msgSeqNum) ) return FixTags.MSGSEQNUM_INT;
		if (! FixUtils.isSet(senderCompID) ) return FixTags.SENDERCOMPID_INT;
		if (! FixUtils.isSet(sendingTime) ) return FixTags.SENDINGTIME_INT;
		if (! FixUtils.isSet(targetCompID) ) return FixTags.TARGETCOMPID_INT;
		if (! FixUtils.isSet(clOrdID) ) return FixTags.CLORDID_INT;
		if (! FixUtils.isSet(origClOrdID) ) return FixTags.ORIGCLORDID_INT;
		if (! FixUtils.isSet(side) ) return FixTags.SIDE_INT;
		if (! FixUtils.isSet(symbol) ) return FixTags.SYMBOL_INT;
		if (! FixUtils.isSet(transactTime) ) return FixTags.TRANSACTTIME_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.ORDERCANCELREQUEST);

		// encode all fields including the header

		FixUtils.putFixTag( out, FixTags.MSGSEQNUM_INT, msgSeqNum);
		if (FixUtils.isSet(possDupFlag)) FixUtils.putFixTag( out, FixTags.POSSDUPFLAG_INT, possDupFlag?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.SENDERCOMPID_INT, senderCompID, 0, Utils.lastIndexTrim(senderCompID, (byte)0) );
		if (FixUtils.isSet(senderSubID)) FixUtils.putFixTag( out, FixTags.SENDERSUBID_INT, senderSubID, 0, Utils.lastIndexTrim(senderSubID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SENDINGTIME_INT, sendingTime);
		FixUtils.putFixTag( out, FixTags.TARGETCOMPID_INT, targetCompID, 0, Utils.lastIndexTrim(targetCompID, (byte)0) );
		if (FixUtils.isSet(targetSubID)) FixUtils.putFixTag( out, FixTags.TARGETSUBID_INT, targetSubID, 0, Utils.lastIndexTrim(targetSubID, (byte)0) );
		if (FixUtils.isSet(possResend)) FixUtils.putFixTag( out, FixTags.POSSRESEND_INT, possResend?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(onBehalfOfCompID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFCOMPID_INT, onBehalfOfCompID, 0, Utils.lastIndexTrim(onBehalfOfCompID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfSubID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFSUBID_INT, onBehalfOfSubID, 0, Utils.lastIndexTrim(onBehalfOfSubID, (byte)0) );
		if (FixUtils.isSet(origSendingTime)) FixUtils.putFixTag( out, FixTags.ORIGSENDINGTIME_INT, origSendingTime);
		if (FixUtils.isSet(deliverToCompID)) FixUtils.putFixTag( out, FixTags.DELIVERTOCOMPID_INT, deliverToCompID, 0, Utils.lastIndexTrim(deliverToCompID, (byte)0) );
		if (FixUtils.isSet(deliverToSubID)) FixUtils.putFixTag( out, FixTags.DELIVERTOSUBID_INT, deliverToSubID, 0, Utils.lastIndexTrim(deliverToSubID, (byte)0) );

		FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		if (FixUtils.isSet(orderID)) FixUtils.putFixTag( out, FixTags.ORDERID_INT, orderID, 0, Utils.lastIndexTrim(orderID, (byte)0) );
		if (FixUtils.isSet(orderQty)) FixUtils.putFixFloatTag( out, FixTags.ORDERQTY_INT, orderQty);
		FixUtils.putFixTag( out, FixTags.ORIGCLORDID_INT, origClOrdID, 0, Utils.lastIndexTrim(origClOrdID, (byte)0) );
		if (FixUtils.isSet(securityID)) FixUtils.putFixTag( out, FixTags.SECURITYID_INT, securityID, 0, Utils.lastIndexTrim(securityID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		FixUtils.putFixTag( out, FixTags.SYMBOL_INT, symbol, 0, Utils.lastIndexTrim(symbol, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
		if (FixUtils.isSet(subMktID)) FixUtils.putFixTag( out, FixTags.SUBMKTID_INT, subMktID, 0, Utils.lastIndexTrim(subMktID, (byte)0) );
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
		s += "MsgType(35)=" + new String(MsgTypes.ORDERCANCELREQUEST) + sep;

		try {
			// print all fields including the header

			 s += "MsgSeqNum(34)=" + String.valueOf(msgSeqNum) + sep;
			if (FixUtils.isSet(possDupFlag)) s += "PossDupFlag(43)=" + String.valueOf(possDupFlag) + sep;
			 s += "SenderCompID(49)=" + new String(senderCompID) + sep;
			if (FixUtils.isSet(senderSubID)) s += "SenderSubID(50)=" + new String(senderSubID) + sep;
			 s += "SendingTime(52)=" + new String(sendingTime) + sep;
			 s += "TargetCompID(56)=" + new String(targetCompID) + sep;
			if (FixUtils.isSet(targetSubID)) s += "TargetSubID(57)=" + new String(targetSubID) + sep;
			if (FixUtils.isSet(possResend)) s += "PossResend(97)=" + String.valueOf(possResend) + sep;
			if (FixUtils.isSet(onBehalfOfCompID)) s += "OnBehalfOfCompID(115)=" + new String(onBehalfOfCompID) + sep;
			if (FixUtils.isSet(onBehalfOfSubID)) s += "OnBehalfOfSubID(116)=" + new String(onBehalfOfSubID) + sep;
			if (FixUtils.isSet(origSendingTime)) s += "OrigSendingTime(122)=" + new String(origSendingTime) + sep;
			if (FixUtils.isSet(deliverToCompID)) s += "DeliverToCompID(128)=" + new String(deliverToCompID) + sep;
			if (FixUtils.isSet(deliverToSubID)) s += "DeliverToSubID(129)=" + new String(deliverToSubID) + sep;

			 s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			if (FixUtils.isSet(orderID)) s += "OrderID(37)=" + new String(orderID) + sep;
			if (FixUtils.isSet(orderQty)) s += "OrderQty(38)=" + String.valueOf(orderQty) + sep;
			 s += "OrigClOrdID(41)=" + new String(origClOrdID) + sep;
			if (FixUtils.isSet(securityID)) s += "SecurityID(48)=" + new String(securityID) + sep;
			 s += "Side(54)=" + String.valueOf(side) + sep;
			 s += "Symbol(55)=" + new String(symbol) + sep;
			 s += "TransactTime(60)=" + new String(transactTime) + sep;
			if (FixUtils.isSet(subMktID)) s += "SubMktID(5815)=" + new String(subMktID) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixOrderCancelRequest)) return false;

			FixOrderCancelRequest msg = (FixOrderCancelRequest) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!Utils.equals( orderID, msg.orderID)) return false;

		if (!( orderQty==msg.orderQty)) return false;

		if (!Utils.equals( origClOrdID, msg.origClOrdID)) return false;

		if (!Utils.equals( securityID, msg.securityID)) return false;

		if (!( side==msg.side)) return false;

		if (!Utils.equals( symbol, msg.symbol)) return false;

		if (!Utils.equals( subMktID, msg.subMktID)) return false;

		return true;
	}
}
