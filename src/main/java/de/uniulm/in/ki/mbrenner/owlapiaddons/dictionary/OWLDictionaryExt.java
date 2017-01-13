package de.uniulm.in.ki.mbrenner.owlapiaddons.dictionary;

import org.semanticweb.owlapi.model.OWLObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Implementation of the OWLDictionary interface
 * Previously unknown objects will be assigned a new id.
 * Optionally an action can be provided, which decides
 * if the object is added to the internal storage
 * Created by spellmaker on 02.09.2016.
 */
public class OWLDictionaryExt implements OWLDictionary {
    private Map<OWLObject, Integer> map;
    private List<OWLObject> invMap;
    private Predicate<OWLObject> newObjectAction;

    public OWLDictionaryExt(){
        map = new HashMap<>();
        invMap = new ArrayList<>();
        newObjectAction = x -> true;
    }

    public OWLDictionaryExt(Predicate<OWLObject> newObjectAction){
        map = new HashMap<>();
        invMap = new ArrayList<>();
        this.newObjectAction = newObjectAction;
    }

    @Override
    public Integer getId(OWLObject o) {
        Integer i = map.get(o);
        if(i == null){
            if(newObjectAction.test(o)){
                i = invMap.size();
                invMap.add(o);
                map.put(o, i);
            }
            else throw new UnsupportedOperationException("Previously unknown object " + o + " was rejected");
        }
        return i;
    }

    @Override
    public OWLObject getObject(Integer id) {
        return invMap.get(id);
    }

    @Override
    public int dictionarySize() {
        return invMap.size();
    }

    /**
     * Creates an unmodifiable version of this dictionary
     * @return An unmodifiable version of this dictionary
     */
    public OWLDictionary makeStatic(){
        return new OWLDictionaryStatic(invMap);
    }
}
