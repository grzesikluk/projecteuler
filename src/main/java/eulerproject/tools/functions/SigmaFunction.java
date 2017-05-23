package eulerproject.tools.functions;

public interface SigmaFunction {

    long getValue(long k, long n);
    long getValueModular(long k, long n, long modulo);

}
