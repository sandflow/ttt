/*
 * Copyright 2014-15 Skynav, Inc. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY SKYNAV, INC. AND ITS CONTRIBUTORS “AS IS” AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL SKYNAV, INC. OR ITS CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.skynav.ttpe.area;

import org.w3c.dom.Element;

import com.skynav.ttpe.geometry.Dimension;

public class BlockArea extends NonLeafAreaNode {

    private double bpd;
    private double ipd;

    public BlockArea(Element e) {
        this(e, Double.NaN, Double.NaN);
    }

    public BlockArea(Element e, double ipd, double bpd) {
        super(e);
        this.ipd = ipd;
        this.bpd = bpd;
    }

    public void setIPD(double ipd) {
        this.ipd = ipd;
    }

    public void setBPD(double bpd) {
        this.bpd = bpd;
    }

    public void expand(double ipd, double bpd) {
        // expand in Dimension.IPD to fit specified IPD
        if (!Double.isNaN(ipd)) {
            if (Double.isNaN(this.ipd) || (this.ipd < ipd))
                this.ipd = ipd;
        }
        // expand in Dimension.BPD to fit specified BPD plus existing BPD
        if (!Double.isNaN(bpd)) {
            if (Double.isNaN(this.bpd))
                this.bpd = 0;
            this.bpd += bpd;
        }
    }

    @Override
    public double getAvailable(Dimension dimension) {
        return (dimension == Dimension.IPD) ? ipd : bpd;
    }

}