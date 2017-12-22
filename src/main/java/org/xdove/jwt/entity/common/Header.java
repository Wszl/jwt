package org.xdove.jwt.entity.common;

import org.xdove.jwt.entity.AbstractContains;
import org.xdove.jwt.entity.IHeader;

public class Header extends AbstractContains implements IHeader {

    @Override
    public String getTyp() {
        return null;
    }

    @Override
    public void setTyp(String typ) {

    }

    @Override
    public String getAlg() {
        return null;
    }

    @Override
    public void setAlg(String alg) {

    }
}
