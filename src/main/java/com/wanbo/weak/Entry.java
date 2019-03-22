package com.wanbo.weak;

import java.lang.ref.WeakReference;

public class Entry<T> extends WeakReference<T>{

    public Entry(T referent) {
        super(referent);
    }

}
