package org.xdove.jwt.entity.common;

import org.xdove.jwt.entity.AbstractContains;
import org.xdove.jwt.entity.IHeader;

public class Header extends AbstractContains implements IHeader {

    public static final String TYP = "JWT";
    public static final String ALG = "Hmacsha256";

    public Header() {
        this.setTyp(TYP);
        this.setAlg(ALG);
    }

    @Override
    public String getTyp() {
        return (String) this.get(IHeader.TYP);
    }

    @Override
    public void setTyp(String typ) {
        this.put(IHeader.TYP, typ);
    }

    @Override
    public String getAlg() {
        return (String) this.get(IHeader.ALG);
    }

    @Override
    public void setAlg(String alg) {
        this.put(IHeader.ALG, alg);
    }
}
