import java.util.Iterator;

public class Array3D<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new Array3DIterator<T>();
    }

    private class Array3DIterator<T> implements Iterator<T> {
        int currentDim1 = 0;
        int currentDim2 = 0;
        int currentDim3 = 0;

        @Override
        public boolean hasNext() {
            if (currentDim1 + 1 == array.length) {
                if (currentDim2 + 1 == array[currentDim1].length) {
                    return currentDim3 < array[currentDim1][currentDim2].length;
                }
                return currentDim2 < array[currentDim1].length;
            }
            return currentDim1 < array.length;
        }

        public T next() {
            if (currentDim3 == array[currentDim1][currentDim2].length) {
                currentDim3 = 0;
                currentDim2++;

                if (currentDim2 == array[currentDim1].length) {
                    currentDim2 = 0;
                    currentDim1++;
                }
            }

            return (T) array[currentDim1][currentDim2][currentDim3++];
        }
    }


    public T[][][] array;
}
