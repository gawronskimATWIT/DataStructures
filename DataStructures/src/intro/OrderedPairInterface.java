//@author Mike Gawronski
package intro;

public interface OrderedPairInterface <T>{
    public T getFirst ();

    public T getSecond ();

    public void setFirst(T first);

    public void setSecond(T second);

    public boolean equals(Object obj);

    public void swap();

    public String toString();

}