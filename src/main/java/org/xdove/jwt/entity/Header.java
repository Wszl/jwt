package main.java.org.xdove.jwt.entity;

import main.java.org.xdove.jwt.IHeader;

public class Header implements IHeader {
    protected String typ;
    protected String alg;

    public Header(String typ, String alg) {
        this.typ = typ;
        this.alg = alg;
    }

    public Header() {}

    @Override
    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public void setAlg(String alg) {
        this.alg = alg;
    }

    @Override
    public String getTyp() {
        return typ;
    }

    @Override
    public String getAlg() {
        return alg;
    }
}
