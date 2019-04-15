package com.fmi.laborator08;

import java.util.List;

public class Crate<T> {
    private T contents;
    public T emptyCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }



}
