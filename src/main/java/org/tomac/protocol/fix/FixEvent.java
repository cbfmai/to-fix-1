/**
 * Copyright (c) 2011 Sebastian Tomac (tomac.org)
 * Licensed under LGPL licenses.
 * You may obtain a copy of the License at http://www.gnu.org/copyleft/lgpl.html
 **/
package org.tomac.protocol.fix;

import org.tomac.protocol.fix.messaging.FixMessageInfo;

/**
 * @author seto
 *
 */
public class FixEvent extends FixMessageInfo.SessionRejectReason {

	// avoid collition with SessionRejectReasons
	public static final int	DISCONNECT	= 100;
	public static final int	CONNECT	= 101;
	public static final int	MSGSEQNUM_LOGOUT	= 102;
	public static final int	GARBLED	= 103;
	public static final int	MSGSEQNUM_RESENDREQUEST	= 104;
	public static final int	MSGSEQNUM_LOGON_RESENDREQUEST	= 105;
	public static final int	BEGINSTRING_LOGOUT	= 106;

}
