/*
 * MIT License
 * 
 * Copyright (c) 2018-2019 Fabio Lima
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.f4b6a3.uuid.strategy.nodeid;

import com.github.f4b6a3.commons.util.ByteUtil;
import com.github.f4b6a3.uuid.strategy.NodeIdentifierStrategy;

/**
 * Strategy that always provides the same node identifier.
 * 
 * The node identifier passed to the constructor is converted to multicast.
 */
public class FixedNodeIdentifierStrategy implements NodeIdentifierStrategy {

	protected long nodeIdentifier;

	public FixedNodeIdentifierStrategy(long nodeIdentifier) {
		this.nodeIdentifier = NodeIdentifierStrategy.setMulticastNodeIdentifier(nodeIdentifier);
	}

	public FixedNodeIdentifierStrategy(byte[] nodeIdentifier) {
		long nodeid = ByteUtil.toNumber(nodeIdentifier);
		this.nodeIdentifier = NodeIdentifierStrategy.setMulticastNodeIdentifier(nodeid);
	}

	@Override
	public long getNodeIdentifier() {
		return this.nodeIdentifier;
	}
}