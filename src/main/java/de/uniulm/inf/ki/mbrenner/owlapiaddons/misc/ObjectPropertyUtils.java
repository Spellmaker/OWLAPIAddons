package de.uniulm.inf.ki.mbrenner.owlapiaddons.misc;

import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;

/**
 * Created by Markus Brenner on 03.05.2017.
 */
public class ObjectPropertyUtils {
    public static OWLObjectPropertyExpression inverseOf(OWLObjectPropertyExpression p) {
        if (p instanceof OWLObjectProperty) {
            return p.getInverseProperty();
        } else if (p instanceof OWLObjectInverseOf) {
            return ((OWLObjectInverseOf) p).getInverse();
        } else throw new IllegalArgumentException("not sure what to do with " + p.getClass().getSimpleName());
    }

    public static boolean areInverses(OWLObjectPropertyExpression p1, OWLObjectPropertyExpression p2) {
        if (p1 instanceof OWLObjectInverseOf) {
            return ((OWLObjectInverseOf) p1).getInverse().equals(p2);
        } else if (p2 instanceof OWLObjectInverseOf) {
            return ((OWLObjectInverseOf) p2).getInverse().equals(p1);
        }
        return false;
    }
}
