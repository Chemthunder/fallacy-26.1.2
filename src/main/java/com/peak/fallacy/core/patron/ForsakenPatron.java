package com.peak.fallacy.core.patron;

import com.peak.fallacy.api.Patron;

import static com.peak.fallacy.core.Fallacy.id;

/**
 * @author Chemthunder
 */
public class ForsakenPatron extends Patron {
    public ForsakenPatron() {
        super(id("forsaken"), true, 0xFFbcbbbb);
    }
}
