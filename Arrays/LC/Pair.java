
public class Pair<T1, T2> {
    T1 key;
    T2 value;
    public Pair(T1 sum, T2 i) {
        key = sum;
        value = i;
    }

    public T1 getKey() {
        return key;
    }

    public T2 getValue() {
        return value;
    }

}
