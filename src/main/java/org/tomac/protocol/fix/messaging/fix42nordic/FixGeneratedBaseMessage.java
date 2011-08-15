package org.tomac.protocol.fix.messaging.fix42nordic;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixSessionException;

public abstract class FixGeneratedBaseMessage implements FixMessageInfo
{

	public ByteBuffer buf;

	public int startPos = Integer.MAX_VALUE;

	public int msgType;

	public int msgLen;

	public final StringBuffer status = new StringBuffer();

	public int size()
	{

		return msgLen;
	}

	public abstract void encode( ByteBuffer msg );

	public abstract void getAll() throws FixSessionException, IllegalStateException;

	public abstract void clear();

	public void setBuffer( ByteBuffer buf )
	{

		this.buf = buf;

		startPos = buf.position();
	}

	public void setLen( int len )
	{

		msgLen = len;
	}

	public abstract void printBuffer( ByteBuffer out );

}
