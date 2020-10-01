//@author Mike Gawronski
package intro;

public class OrderedPair <T> implements OrderedPairInterface <T> {
    private T first;
    private T second;

    public OrderedPair (T f, T s) {
        first = f; second = s;
    }

    public OrderedPair() { this (null, null);}

    public T getFirst () {
        return first;
    }

    public T getSecond () {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public void swap () {
        T temp = first;
        first = second;
        second = temp;
    }

   public boolean equals(Object obj) {
    OrderedPair o = (OrderedPair) obj;
    return ((this.first.equals(o.first))&&(this.second.equals(o.second)));
    }

    public OrderedPair <T> copy (){
       OrderedPair t = new OrderedPair<>(getFirst(),getSecond());
    return t;
    }


    @Override
    public String toString() {
        return "(" + first + " , " + second + ")";
    }


}