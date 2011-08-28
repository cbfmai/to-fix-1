package org.tomac.protocol.fix.messaging.fix50sp2.component;

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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrumentLeg;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixLegStipulations;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixLegPreAllocGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixNestedParties3;

public class FixInstrmtLegExecGrp
{

	public int noLegs;
	public InstrmtLegExecGrp[] group;

	public void getAll(int noLegs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noLegs = noLegs;

		if (noLegs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noLegs ).getBytes(), FixTags.NOLEGS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noLegs) {
			group = new InstrmtLegExecGrp[noLegs];

			for ( int i = 0; i < noLegs; i++ ) group[i] = new InstrmtLegExecGrp();
	}

		for ( int i = 0; i < noLegs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noLegs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noLegs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noLegs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrmtLegExecGrp)) return false;

		FixInstrmtLegExecGrp msg = (FixInstrmtLegExecGrp) o;

		for (int i = 0; i<noLegs; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noLegs; i++)
			s += group[i].toString();
		return s;
	}

public class InstrmtLegExecGrp implements FixComponent
{

	public FixInstrumentLeg instrumentLeg;
	public long legQty = 0;
	public long legOrderQty = 0;
	public long legSwapType = 0;
	public byte[] legAllocID;
	public FixLegStipulations legStipulations;
	public FixLegPreAllocGrp legPreAllocGrp;
	public byte legPositionEffect = (byte)' ';
	public long legCoveredOrUncovered = 0;
	public FixNestedParties3 nestedParties3;
	public byte[] legRefID;
	public byte legSettlType = (byte)' ';
	public byte[] legSettlDate;
	public long legLastPx = 0;
	public byte[] legSettlCurrency;
	public long legLastForwardPoints = 0;
	public long legCalculatedCcyLastQty = 0;
	public long legGrossTradeAmt = 0;
	public long legVolatility = 0;
	public long legDividendYield = 0;
	public long legCurrencyRatio = 0;
	public byte[] legExecInst;
	public long legLastQty = 0;

	public InstrmtLegExecGrp() {
		super();

		instrumentLeg = new FixInstrumentLeg();
		legAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		legStipulations = new FixLegStipulations();
		legPreAllocGrp = new FixLegPreAllocGrp();
		nestedParties3 = new FixNestedParties3();
		legRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		legSettlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		legSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		legExecInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		legQty = Long.MAX_VALUE;		
		legOrderQty = Long.MAX_VALUE;		
		legSwapType = Long.MAX_VALUE;		
		Utils.fill( legAllocID, (byte)0 );
		legPositionEffect = Byte.MAX_VALUE;		
		legCoveredOrUncovered = Long.MAX_VALUE;		
		Utils.fill( legRefID, (byte)0 );
		legSettlType = Byte.MAX_VALUE;		
		Utils.fill( legSettlDate, (byte)0 );
		legLastPx = Long.MAX_VALUE;		
		Utils.fill( legSettlCurrency, (byte)0 );
		legLastForwardPoints = Long.MAX_VALUE;		
		legCalculatedCcyLastQty = Long.MAX_VALUE;		
		legGrossTradeAmt = Long.MAX_VALUE;		
		legVolatility = Long.MAX_VALUE;		
		legDividendYield = Long.MAX_VALUE;		
		legCurrencyRatio = Long.MAX_VALUE;		
		Utils.fill( legExecInst, (byte)0 );
		legLastQty = Long.MAX_VALUE;		
		instrumentLeg.clear();
		legStipulations.clear();
		legPreAllocGrp.clear();
		nestedParties3.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.LEGSYMBOL_INT) {
				instrumentLeg.getAll(FixTags.LEGSYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGQTY_INT) {
				legQty = FixUtils.getTagFloatValue(null ,id ,value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGORDERQTY_INT) {
				legOrderQty = FixUtils.getTagFloatValue(null ,id ,value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGSWAPTYPE_INT) {
				legSwapType = FixUtils.getTagIntValue(null ,id ,value );
				if (!FixMessageInfo.LegSwapType.isValid(legSwapType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + legSwapType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGALLOCID_INT) {
				legAllocID = FixUtils.getTagStringValue(null ,id ,value, legAllocID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOLEGSTIPULATIONS_INT) {
				int noLegStipulations;
				noLegStipulations = FixUtils.getTagIntValue(null ,id ,value );
				legStipulations.getAll(noLegStipulations, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOLEGALLOCS_INT) {
				int noLegAllocs;
				noLegAllocs = FixUtils.getTagIntValue(null ,id ,value );
				legPreAllocGrp.getAll(noLegAllocs, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGPOSITIONEFFECT_INT) {
				legPositionEffect = FixUtils.getTagCharValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGCOVEREDORUNCOVERED_INT) {
				legCoveredOrUncovered = FixUtils.getTagIntValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NONESTED3PARTYIDS_INT) {
				int noNested3PartyIDs;
				noNested3PartyIDs = FixUtils.getTagIntValue(null ,id ,value );
				nestedParties3.getAll(noNested3PartyIDs, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGREFID_INT) {
				legRefID = FixUtils.getTagStringValue(null ,id ,value, legRefID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGSETTLTYPE_INT) {
				legSettlType = FixUtils.getTagCharValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGSETTLDATE_INT) {
				legSettlDate = FixUtils.getTagStringValue(null ,id ,value, legSettlDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGLASTPX_INT) {
				legLastPx = FixUtils.getTagFloatValue(null ,id ,value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGSETTLCURRENCY_INT) {
				legSettlCurrency = FixUtils.getTagStringValue(null ,id ,value, legSettlCurrency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGLASTFORWARDPOINTS_INT) {
				legLastForwardPoints = FixUtils.getTagFloatValue(null ,id ,value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGCALCULATEDCCYLASTQTY_INT) {
				legCalculatedCcyLastQty = FixUtils.getTagFloatValue(null ,id ,value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGGROSSTRADEAMT_INT) {
				legGrossTradeAmt = FixUtils.getTagFloatValue(null ,id ,value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGVOLATILITY_INT) {
				legVolatility = FixUtils.getTagFloatValue(null ,id ,value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGDIVIDENDYIELD_INT) {
				legDividendYield = FixUtils.getTagFloatValue(null ,id ,value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGCURRENCYRATIO_INT) {
				legCurrencyRatio = FixUtils.getTagFloatValue(null ,id ,value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGEXECINST_INT) {
				legExecInst = FixUtils.getTagStringValue(null ,id ,value, legExecInst);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGLASTQTY_INT) {
				legLastQty = FixUtils.getTagFloatValue(null ,id ,value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(instrumentLeg.legSymbol)) return true;
		if (FixUtils.isSet(legQty)) return true;
		if (FixUtils.isSet(legOrderQty)) return true;
		if (FixUtils.isSet(legSwapType)) return true;
		if (FixUtils.isSet(legAllocID)) return true;
		if (FixUtils.isSet(legStipulations.noLegStipulations)) return true;
		if (FixUtils.isSet(legPreAllocGrp.noLegAllocs)) return true;
		if (FixUtils.isSet(legPositionEffect)) return true;
		if (FixUtils.isSet(legCoveredOrUncovered)) return true;
		if (FixUtils.isSet(nestedParties3.noNested3PartyIDs)) return true;
		if (FixUtils.isSet(legRefID)) return true;
		if (FixUtils.isSet(legSettlType)) return true;
		if (FixUtils.isSet(legSettlDate)) return true;
		if (FixUtils.isSet(legLastPx)) return true;
		if (FixUtils.isSet(legSettlCurrency)) return true;
		if (FixUtils.isSet(legLastForwardPoints)) return true;
		if (FixUtils.isSet(legCalculatedCcyLastQty)) return true;
		if (FixUtils.isSet(legGrossTradeAmt)) return true;
		if (FixUtils.isSet(legVolatility)) return true;
		if (FixUtils.isSet(legDividendYield)) return true;
		if (FixUtils.isSet(legCurrencyRatio)) return true;
		if (FixUtils.isSet(legExecInst)) return true;
		if (FixUtils.isSet(legLastQty)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrumentLeg.legSymbol)) instrumentLeg.encode( out );
		if (FixUtils.isSet(legQty)) FixUtils.putFixFloatTag( out, FixTags.LEGQTY_INT, legQty);
		if (FixUtils.isSet(legOrderQty)) FixUtils.putFixFloatTag( out, FixTags.LEGORDERQTY_INT, legOrderQty);
		if (FixUtils.isSet(legSwapType)) FixUtils.putFixTag( out, FixTags.LEGSWAPTYPE_INT, legSwapType);
		if (FixUtils.isSet(legAllocID)) FixUtils.putFixTag( out, FixTags.LEGALLOCID_INT, legAllocID, 0, Utils.lastIndexTrim(legAllocID, (byte)0) );
		if (FixUtils.isSet(legStipulations.noLegStipulations)) legStipulations.encode( out );
		if (FixUtils.isSet(legPreAllocGrp.noLegAllocs)) legPreAllocGrp.encode( out );
		if (FixUtils.isSet(legPositionEffect)) FixUtils.putFixTag( out, FixTags.LEGPOSITIONEFFECT_INT, legPositionEffect );
		if (FixUtils.isSet(legCoveredOrUncovered)) FixUtils.putFixTag( out, FixTags.LEGCOVEREDORUNCOVERED_INT, legCoveredOrUncovered);
		if (FixUtils.isSet(nestedParties3.noNested3PartyIDs)) nestedParties3.encode( out );
		if (FixUtils.isSet(legRefID)) FixUtils.putFixTag( out, FixTags.LEGREFID_INT, legRefID, 0, Utils.lastIndexTrim(legRefID, (byte)0) );
		if (FixUtils.isSet(legSettlType)) FixUtils.putFixTag( out, FixTags.LEGSETTLTYPE_INT, legSettlType );
		if (FixUtils.isSet(legSettlDate)) FixUtils.putFixTag( out, FixTags.LEGSETTLDATE_INT, legSettlDate);
		if (FixUtils.isSet(legLastPx)) FixUtils.putFixFloatTag( out, FixTags.LEGLASTPX_INT, legLastPx);
		if (FixUtils.isSet(legSettlCurrency)) FixUtils.putFixTag( out, FixTags.LEGSETTLCURRENCY_INT, legSettlCurrency, 0, Utils.lastIndexTrim(legSettlCurrency, (byte)0) );
		if (FixUtils.isSet(legLastForwardPoints)) FixUtils.putFixFloatTag( out, FixTags.LEGLASTFORWARDPOINTS_INT, legLastForwardPoints);
		if (FixUtils.isSet(legCalculatedCcyLastQty)) FixUtils.putFixFloatTag( out, FixTags.LEGCALCULATEDCCYLASTQTY_INT, legCalculatedCcyLastQty);
		if (FixUtils.isSet(legGrossTradeAmt)) FixUtils.putFixTag( out, FixTags.LEGGROSSTRADEAMT_INT, legGrossTradeAmt);
		if (FixUtils.isSet(legVolatility)) FixUtils.putFixFloatTag( out, FixTags.LEGVOLATILITY_INT, legVolatility);
		if (FixUtils.isSet(legDividendYield)) FixUtils.putFixFloatTag( out, FixTags.LEGDIVIDENDYIELD_INT, legDividendYield);
		if (FixUtils.isSet(legCurrencyRatio)) FixUtils.putFixFloatTag( out, FixTags.LEGCURRENCYRATIO_INT, legCurrencyRatio);
		if (FixUtils.isSet(legExecInst)) FixUtils.putFixTag( out, FixTags.LEGEXECINST_INT, legExecInst, 0, Utils.lastIndexTrim(legExecInst, (byte)0) );
		if (FixUtils.isSet(legLastQty)) FixUtils.putFixFloatTag( out, FixTags.LEGLASTQTY_INT, legLastQty);
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(instrumentLeg.legSymbol)) s += instrumentLeg.toString();
			if (FixUtils.isSet(legQty)) s += "LegQty(687)=" + String.valueOf(legQty) + sep;
			if (FixUtils.isSet(legOrderQty)) s += "LegOrderQty(685)=" + String.valueOf(legOrderQty) + sep;
			if (FixUtils.isSet(legSwapType)) s += "LegSwapType(690)=" + String.valueOf(legSwapType) + sep;
			if (FixUtils.isSet(legAllocID)) s += "LegAllocID(1366)=" + new String(legAllocID) + sep;
			if (FixUtils.isSet(legStipulations.noLegStipulations)) s += legStipulations.toString();
			if (FixUtils.isSet(legPreAllocGrp.noLegAllocs)) s += legPreAllocGrp.toString();
			if (FixUtils.isSet(legPositionEffect)) s += "LegPositionEffect(564)=" + String.valueOf(legPositionEffect) + sep;
			if (FixUtils.isSet(legCoveredOrUncovered)) s += "LegCoveredOrUncovered(565)=" + String.valueOf(legCoveredOrUncovered) + sep;
			if (FixUtils.isSet(nestedParties3.noNested3PartyIDs)) s += nestedParties3.toString();
			if (FixUtils.isSet(legRefID)) s += "LegRefID(654)=" + new String(legRefID) + sep;
			if (FixUtils.isSet(legSettlType)) s += "LegSettlType(587)=" + String.valueOf(legSettlType) + sep;
			if (FixUtils.isSet(legSettlDate)) s += "LegSettlDate(588)=" + new String(legSettlDate) + sep;
			if (FixUtils.isSet(legLastPx)) s += "LegLastPx(637)=" + String.valueOf(legLastPx) + sep;
			if (FixUtils.isSet(legSettlCurrency)) s += "LegSettlCurrency(675)=" + new String(legSettlCurrency) + sep;
			if (FixUtils.isSet(legLastForwardPoints)) s += "LegLastForwardPoints(1073)=" + String.valueOf(legLastForwardPoints) + sep;
			if (FixUtils.isSet(legCalculatedCcyLastQty)) s += "LegCalculatedCcyLastQty(1074)=" + String.valueOf(legCalculatedCcyLastQty) + sep;
			if (FixUtils.isSet(legGrossTradeAmt)) s += "LegGrossTradeAmt(1075)=" + String.valueOf(legGrossTradeAmt) + sep;
			if (FixUtils.isSet(legVolatility)) s += "LegVolatility(1379)=" + String.valueOf(legVolatility) + sep;
			if (FixUtils.isSet(legDividendYield)) s += "LegDividendYield(1381)=" + String.valueOf(legDividendYield) + sep;
			if (FixUtils.isSet(legCurrencyRatio)) s += "LegCurrencyRatio(1383)=" + String.valueOf(legCurrencyRatio) + sep;
			if (FixUtils.isSet(legExecInst)) s += "LegExecInst(1384)=" + new String(legExecInst) + sep;
			if (FixUtils.isSet(legLastQty)) s += "LegLastQty(1418)=" + String.valueOf(legLastQty) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof InstrmtLegExecGrp)) return false;

			InstrmtLegExecGrp msg = (InstrmtLegExecGrp) o;

		if (!instrumentLeg.equals(msg.instrumentLeg)) return false;

		if (!( legQty==msg.legQty)) return false;

		if (!( legOrderQty==msg.legOrderQty)) return false;

		if (!( legSwapType==msg.legSwapType)) return false;

		if (!Utils.equals( legAllocID, msg.legAllocID)) return false;

		if (!legStipulations.equals(msg.legStipulations)) return false;

		if (!legPreAllocGrp.equals(msg.legPreAllocGrp)) return false;

		if (!( legPositionEffect==msg.legPositionEffect)) return false;

		if (!( legCoveredOrUncovered==msg.legCoveredOrUncovered)) return false;

		if (!nestedParties3.equals(msg.nestedParties3)) return false;

		if (!Utils.equals( legRefID, msg.legRefID)) return false;

		if (!( legSettlType==msg.legSettlType)) return false;

		if (!( legLastPx==msg.legLastPx)) return false;

		if (!Utils.equals( legSettlCurrency, msg.legSettlCurrency)) return false;

		if (!( legLastForwardPoints==msg.legLastForwardPoints)) return false;

		if (!( legCalculatedCcyLastQty==msg.legCalculatedCcyLastQty)) return false;

		if (!( legGrossTradeAmt==msg.legGrossTradeAmt)) return false;

		if (!( legVolatility==msg.legVolatility)) return false;

		if (!( legDividendYield==msg.legDividendYield)) return false;

		if (!( legCurrencyRatio==msg.legCurrencyRatio)) return false;

		if (!Utils.equals( legExecInst, msg.legExecInst)) return false;

		if (!( legLastQty==msg.legLastQty)) return false;

		return true;
	}
}
}
