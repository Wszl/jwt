package org.xdove.jwt.entity;

public class Header {
    protected String typ;
    protected String alg;

    public Header(String typ, String alg) {
        this.typ = typ;
        this.alg = alg;
    }

    public Header() {}

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getTyp() {
        return typ;
    }

    public String getAlg() {
        return alg;
    }
}
