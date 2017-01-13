package de.uniulm.in.ki.mbrenner.owlapiaddons.misc;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

/**
 * Created by spellmaker on 31.08.2016.
 */
@Deprecated
public class FastFactory {
    public static String prefix = "";

    private static OWLDataFactory data = OWLManager.getOWLDataFactory();
    public static OWLClass getOWLClass(String iri) {
        return data.getOWLClass(IRI.create(prefix + iri));
    }
    public static OWLNamedIndividual getOWLIndividual(String iri){
        return data.getOWLNamedIndividual(IRI.create(prefix + iri));
    }

    public static OWLClassExpression and(OWLClassExpression...classes){
        return data.getOWLObjectIntersectionOf(classes);
    }

    public static OWLClassExpression some(OWLObjectProperty property, OWLClassExpression oce){
        return data.getOWLObjectSomeValuesFrom(property, oce);
    }
}
