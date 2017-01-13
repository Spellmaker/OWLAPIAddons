package de.uniulm.in.ki.mbrenner.owlapiaddons.construction;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Provides convenience functions for intuitive ontology building in code
 * Basic usage example:
 * <pre>
 *     {@code
 *     import static de.uniulm.in.ki.mbrenner.owlapiaddons.construction.OWLConstructor.*;
 *     import org.semanticweb.owlapi.model.*;
 *
 *     public class Main{
 *         public static void main(String[] args){
 *             setPrefix("http://example.org/onto#");
 *
 *             OWLOntology o = ontology(subClassOf("A", "B"));
 *         }
 *     }
 *     }
 *
 * </pre>
 *
 *
 * Created by Markus Brenner on 07.10.2016.
 */
public class OWLConstructor {
    private static OWLDataFactory data = OWLManager.getOWLDataFactory();
    private static String prefix = "http://dummy.org/";

    /**
     * Sets the prefix string for all generated IRIs
     * @param p A string, which will prefix all subsequently created IRIs
     */
    public static void setPrefix(String p){
        prefix = p;
    }

    /**
     * Creates a new OWLClass
     * @param name The name of the OWLClass
     * @return An OWLClass
     */
    public static OWLClass concept(String name){
        return data.getOWLClass(IRI.create(prefix + name));
    }

    /**
     * Creates a new OWLObjectProperty
     * @param name The name of the OWLObjectProperty
     * @return An OWLObjectProperty
     */
    public static OWLObjectProperty property(String name){
        return data.getOWLObjectProperty(IRI.create(prefix + name));
    }

    /**
     * Creates a new OWLIndividual
     * @param name The name of the OWLIndividual
     * @return A named OWLIndividual
     */
    public static OWLIndividual individual(String name){
        return data.getOWLNamedIndividual(IRI.create(prefix + name));
    }

    /**
     * Creates a subClass axiom
     * @param sub The sub class
     * @param sup The super class
     * @return A OWLSubClassOfAxiom
     */
    public static OWLSubClassOfAxiom subClassOf(OWLClassExpression sub, OWLClassExpression sup){
        return data.getOWLSubClassOfAxiom(sub, sup);
    }

    /**
     * Creates a subClass axiom
     * @param sub The sub class, will be used to generate an OWLClass
     * @param sup The super class, will be used to generate an OWLClass
     * @return A OWLSubClassOfAxiom
     */
    public static OWLSubClassOfAxiom subClassOf(String sub, String sup){return subClassOf(concept(sub), concept(sup));}

    /**
     * Creates a subClass axiom
     * @param sub The sub class
     * @param sup The super class, will be used to generate an OWLClass
     * @return A OWLSubClassOfAxiom
     */
    public static OWLSubClassOfAxiom subClassOf(OWLClassExpression sub, String sup){return subClassOf((sub), concept(sup));}

    /**
     * Creates a subClass axiom
     * @param sub The sub class, will be used to generate an OWLClass
     * @param sup The super class
     * @return A OWLSubClassOfAxiom
     */
    public static OWLSubClassOfAxiom subClassOf(String sub, OWLClassExpression sup){return subClassOf(concept(sub), (sup));}

    /**
     * Creates a some values from axiom
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectSomeValuesFromAxiom
     */
    public static OWLObjectSomeValuesFrom some(OWLObjectPropertyExpression prop, OWLClassExpression filler){
        return data.getOWLObjectSomeValuesFrom(prop, filler);
    }

    /**
     * Creates a some values from axiom
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectSomeValuesFromAxiom
     */
    public static OWLObjectSomeValuesFrom some(String prop, String filler){return some(property(prop), concept(filler));}
    /**
     * Creates a some values from axiom
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectSomeValuesFromAxiom
     */
    public static OWLObjectSomeValuesFrom some(OWLObjectPropertyExpression prop, String filler){return some((prop), concept(filler));}
    /**
     * Creates a some values from axiom
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectSomeValuesFromAxiom
     */
    public static OWLObjectSomeValuesFrom some(String prop, OWLClassExpression filler){return some(property(prop), (filler));}

    /**
     * Creates a concept intersection
     * @param classes A set of class expressions
     * @return An OWLObjectIntersectionOfAxiom
     */
    public static OWLClassExpression and(OWLClassExpression...classes){
        return data.getOWLObjectIntersectionOf(classes);
    }

    /**
     * Creates a concept intersection
     * @param classes A set of class expressions
     * @return An OWLObjectIntersectionOfAxiom
     */
    public static OWLClassExpression and(String...classes){
        OWLClassExpression[] classes2 = new OWLClassExpression[classes.length];
        for(int i = 0; i < classes.length; i++) classes2[i] = concept(classes[i]);
        return and(classes2);
    }

    public static OWLClassAssertionAxiom isA(OWLClassExpression oce, OWLIndividual ind){
        return data.getOWLClassAssertionAxiom(oce, ind);
    }

    public static OWLClassAssertionAxiom isA(String oce, String ind){return isA(concept(oce), individual(ind));}
    public static OWLClassAssertionAxiom isA(OWLClassExpression oce, String ind){return isA((oce), individual(ind));}
    public static OWLClassAssertionAxiom isA(String oce, OWLIndividual ind){return isA(concept(oce), (ind));}

    public static OWLObjectPropertyAssertionAxiom hasA(OWLObjectProperty prop, OWLIndividual subject, OWLIndividual object){
        return data.getOWLObjectPropertyAssertionAxiom(prop, subject, object);
    }

    public static OWLObjectPropertyAssertionAxiom hasA(String prop, String subject, String object){return hasA(property(prop), individual(subject), individual(object));}
    public static OWLObjectPropertyAssertionAxiom hasA(String prop, String subject, OWLIndividual object){return hasA((prop), individual(subject), (object));}
    public static OWLObjectPropertyAssertionAxiom hasA(String prop, OWLIndividual subject, String object){return hasA((prop), (subject), individual(object));}
    public static OWLObjectPropertyAssertionAxiom hasA(String prop, OWLIndividual subject, OWLIndividual object){return hasA(property(prop), (subject), (object));}
    public static OWLObjectPropertyAssertionAxiom hasA(OWLObjectProperty prop, String subject, String object){return hasA((prop), individual(subject), individual(object));}
    public static OWLObjectPropertyAssertionAxiom hasA(OWLObjectProperty prop, String subject, OWLIndividual object){return hasA((prop), individual(subject), (object));}
    public static OWLObjectPropertyAssertionAxiom hasA(OWLObjectProperty prop, OWLIndividual subject, String object){return hasA((prop), (subject), individual(object));}

    public static OWLOntology ontology(OWLAxiom...axioms){
        Set<OWLAxiom> ax = new HashSet<>();
        Arrays.stream(axioms).forEach(x -> ax.add(x));
        OWLOntologyManager m = OWLManager.createOWLOntologyManager();
        try {
            return m.createOntology(ax);
        }
        catch(OWLOntologyCreationException e){
            return null;
        }
    }
}
