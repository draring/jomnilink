package com.digitaldan.jomnilinkII.MessageTypes;

/**
*  Copyright (C) 2009  Dan Cunningham
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation, version 2
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/

import com.digitaldan.jomnilinkII.Message;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ConnectedSecurityStatus implements Message {

	@Singular private final List<Partition> partitions;
	/*
	 *CONNECTED SECURITY SYSTEM STATUS
	This message is sent in response to a REQUEST CONNECTED SECURITY SYSTEM STATUS message.
	    Start character             0x21
	    Message length              number of data bytes + 1
	    Message Type                0x2E
	    Data 1                      mode in partition 1
	    Data 2                      status of partition 1
	    Data 3                      mode in partition 2
	    Data 4                      status of partition 2
	    ...
	    Data 15                     mode in partition 8
	    Data 16                     status of partition 8
	    CRC 1                       varies
	    CRC 2                       varies
	 */

	@Override
	public int getMessageType() {
		return MESG_TYPE_SYS_STATUS;
	}

	@Value
	public static class Partition {
		private final int mode;
		private final int status;

		public Partition(int mode, int status) {
			this.mode = mode;
			this.status = status;
		}
	}

}
