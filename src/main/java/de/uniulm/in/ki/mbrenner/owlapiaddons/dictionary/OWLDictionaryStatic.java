package de.uniulm.in.ki.mbrenner.owlapiaddons.dictionary;

import org.semanticweb.owlapi.model.OWLObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides an implementation of the OWLDictionary interface
 * The contents of this dictionary are not modifiable
 * Creation of this class can be quite expensive, as the whole dictionary
 * needs to be recreated
 *
 * Created by spellmaker on 02.09.2016.
 */
public class OWLDictionaryStatic implements OWLDictionary {
    private Map<OWLObject, Integer> map;
    private OWLObject[] invMap;

    public OWLDictionaryStatic(List<OWLObject> objects){
        map = new HashMap<>();
        invMap = new OWLObject[objects.size()];
        for(int i = 0; i < objects.size(); i++){
            invMap[i] = objects.get(i);
            map.put(objects.get(i), i);
        }
    }

    @Override
    public Integer getId(OWLObject o) {
        return map.get(o);
    }

    @Override
    public OWLObject getObject(Integer id) {
        return invMap[id];
    }

    @Override
    public int dictionarySize() {
        return invMap.length;
    }
}
