package net.neilgoodman.loader;

/**
*/
public class RESTResponse
{
    private String mData;
    private int    mCode;

    public RESTResponse() {
    }

    public RESTResponse( String data, int code ) {
        mData = data;
        mCode = code;
    }

    public String getData() {
        return mData;
    }

    public int getCode() {
        return mCode;
    }
}
