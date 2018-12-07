/**
 * Copyright 2018 Fabio Lima <br/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); <br/>
 * you may not use this file except in compliance with the License. <br/>
 * You may obtain a copy of the License at <br/>
 *
 * http://www.apache.org/licenses/LICENSE-2.0 <br/>
 *
 * Unless required by applicable law or agreed to in writing, software <br/>
 * distributed under the License is distributed on an "AS IS" BASIS, <br/>
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. <br/>
 * See the License for the specific language governing permissions and <br/>
 * limitations under the License. <br/>
 *
 */

package com.github.f4b6a3.uuid.factory;

import com.github.f4b6a3.uuid.factory.abst.AbstractTimeBasedUuidCreator;
import com.github.f4b6a3.uuid.util.UuidUtil;

/**
 * Factory that creates time-based UUIDs, version 0.
 * 
 * This version is a 'extension' of the RFC-4122. It leaves the timestamp bits
 * in the 'natural' order, instead of rearranging them as the version 1 does.
 *
 */
public class MssqlUuidCreator extends AbstractTimeBasedUuidCreator {

	public MssqlUuidCreator() {
		super(VERSION_0);
	}

	protected MssqlUuidCreator(int version) {
		super(version);
	}

	/**
	 * Generate a MS SQL Server 'friendly' UUID.
	 * 
	 * {@link UuidUtil#formatMssqlMostSignificantBits(long)}
	 * 
	 * @param timestamp
	 */
	@Override
	public long formatMostSignificantBits(long timestamp) {
		return UuidUtil.formatMssqlMostSignificantBits(timestamp);
	}
}
