package org.supsys.common.collection;

import org.supsys.common.functional.tuple.Tuple;

import java.util.HashMap;
import java.util.Iterator;

public class FHashMap<K, V> extends HashMap<K, V> implements FMap<K, V> {
    @Override
    public Iterator<Tuple<K, V>> iterator() {
        return _tuples().iterator();
    }
}
