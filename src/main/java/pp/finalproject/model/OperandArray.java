package pp.finalproject.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OperandArray<E extends Operand> {
    private final E[] values;

    public OperandArray(Class<E> clazz, int size) {
        this.values = (E[]) Array.newInstance(clazz, size);
        try {
            Arrays.fill(values, clazz.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return values.length;
    }

    public E[] getValues() {
        return values;
    }

    public Operand getValue(int index) {
        return values[index];
    }

    public void setValue(E operand, int index) {
        values[index] = operand;
    }

    /*(@Override
    public String toString() {
        return Integer.toString((value) ? 1 : 0);
    }*/
}
