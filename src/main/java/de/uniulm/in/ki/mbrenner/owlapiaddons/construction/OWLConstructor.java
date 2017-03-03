package de.uniulm.in.ki.mbrenner.owlapiaddons.construction;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
     * Creates a some values from object
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectSomeValuesFrom object
     */
    public static OWLObjectSomeValuesFrom some(OWLObjectPropertyExpression prop, OWLClassExpression filler){
        return data.getOWLObjectSomeValuesFrom(prop, filler);
    }

    /**
     * Creates a some values from object
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectSomeValuesFrom object
     */
    public static OWLObjectSomeValuesFrom some(String prop, String filler){return some(property(prop), concept(filler));}
    /**
     * Creates a some values from object
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectSomeValuesFrom object
     */
    public static OWLObjectSomeValuesFrom some(OWLObjectPropertyExpression prop, String filler){return some((prop), concept(filler));}
    /**
     * Creates a some values from object
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectSomeValuesFrom object
     */
    public static OWLObjectSomeValuesFrom some(String prop, OWLClassExpression filler){return some(property(prop), (filler));}

    /**
     * Creates an all values from object
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectAllValuesFrom object
     */
    public static OWLObjectAllValuesFrom all(OWLObjectPropertyExpression prop, OWLClassExpression filler){
        return data.getOWLObjectAllValuesFrom(prop, filler);
    }

    /**
     * Creates an all values from object
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectAllValuesFrom object
     */
    public static OWLObjectAllValuesFrom all(String prop, String filler){return all(property(prop), concept(filler));}
    /**
     * Creates an all values from object
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectAllValuesFrom object
     */
    public static OWLObjectAllValuesFrom all(OWLObjectPropertyExpression prop, String filler){return all((prop), concept(filler));}
    /**
     * Creates an all values from object
     * @param prop The property
     * @param filler The filler
     * @return A OWLObjectAllValuesFrom object
     */
    public static OWLObjectAllValuesFrom all(String prop, OWLClassExpression filler){return all(property(prop), (filler));}


    /**
     * Creates a concept intersection
     * @param classes A set of class expressions
     * @return An OWLObjectIntersectionOf object
     */
    public static OWLClassExpression and(OWLClassExpression...classes){
        return data.getOWLObjectIntersectionOf(classes);
    }

    /**
     * Creates a concept intersection
     * @param classes A set of class expressions
     * @return An OWLObjectIntersectionOf object
     */
    public static OWLClassExpression and(String...classes){
        OWLClassExpression[] classes2 = new OWLClassExpression[classes.length];
        for(int i = 0; i < classes.length; i++) classes2[i] = concept(classes[i]);
        return and(classes2);
    }

    /**
     * Creates a concept union
     * @param classes A set of class expressions
     * @return An OWLObjectUnionOf object
     */
    public static OWLClassExpression or(OWLClassExpression...classes){
        return data.getOWLObjectUnionOf(classes);
    }

    /**
     * Creates a concept union
     * @param classes A set of class expressions
     * @return An OWLObjectUnionOf object
     */
    public static OWLClassExpression or(String...classes){
        OWLClassExpression[] classes2 = new OWLClassExpression[classes.length];
        for(int i = 0; i < classes.length; i++) classes2[i] = concept(classes[i]);
        return or(classes2);
    }

    public static OWLClassAssertionAxiom isA(OWLClassExpression oce, OWLIndividual ind){
        return data.getOWLClassAssertionAxiom(oce, ind);
    }

    public static OWLClassAssertionAxiom isA(String oce, String ind){return isA(concept(oce), individual(ind));}
    public static OWLClassAssertionAxiom isA(OWLClassExpression oce, String ind){return isA((oce), individual(ind));}
    public static OWLClassAssertionAxiom isA(String oce, OWLIndividual ind){return isA(concept(oce), (ind));}

    public static OWLObjectPropertyAssertionAxiom hasA(OWLObjectPropertyExpression prop, OWLIndividual subject, OWLIndividual object){
        return data.getOWLObjectPropertyAssertionAxiom(prop, subject, object);
    }

    public static OWLObjectPropertyAssertionAxiom hasA(String prop, String subject, String object){return hasA(property(prop), individual(subject), individual(object));}
    public static OWLObjectPropertyAssertionAxiom hasA(String prop, String subject, OWLIndividual object){return hasA((prop), individual(subject), (object));}
    public static OWLObjectPropertyAssertionAxiom hasA(String prop, OWLIndividual subject, String object){return hasA((prop), (subject), individual(object));}
    public static OWLObjectPropertyAssertionAxiom hasA(String prop, OWLIndividual subject, OWLIndividual object){return hasA(property(prop), (subject), (object));}
    public static OWLObjectPropertyAssertionAxiom hasA(OWLObjectPropertyExpression prop, String subject, String object){return hasA((prop), individual(subject), individual(object));}
    public static OWLObjectPropertyAssertionAxiom hasA(OWLObjectPropertyExpression prop, String subject, OWLIndividual object){return hasA((prop), individual(subject), (object));}
    public static OWLObjectPropertyAssertionAxiom hasA(OWLObjectPropertyExpression prop, OWLIndividual subject, String object){return hasA((prop), (subject), individual(object));}

    /**
     * Creates the complement of the provided concept
     * @param oce A class expression
     * @return A OWLObjectComplementOf of the class expression
     */
    public static OWLClassExpression not(OWLClassExpression oce){
        return data.getOWLObjectComplementOf(oce);
    }

    /**
     * Creates the complement of the provided concept name
     * @param oce The name for which a OWLClass should be generated
     * @return A OWLObjectComplementOf of the generated OWLClass
     */
    public static OWLClassExpression not(String oce){
        return not(concept(oce));
    }

    public static OWLOntology ontology(OWLAxiom...axioms){
        OWLOntologyManager m = OWLManager.createOWLOntologyManager();
        try {
            return m.createOntology(axioms(axioms));
        }
        catch(OWLOntologyCreationException e){
            return null;
        }
    }

    public static Set<OWLAxiom> axioms(OWLAxiom...axioms){
        Set<OWLAxiom> ax = new HashSet<>();
        Arrays.stream(axioms).forEach(ax::add);
        return ax;
    }

    public static <T> Set<T> axioms(Class<T> clazz, OWLAxiom...axioms){
        return Arrays.stream(axioms).filter(clazz::isInstance).map(clazz::cast).collect(Collectors.toSet());
    }

    public static OWLClassExpression top(){
        return data.getOWLThing();
    }

    public static OWLClassExpression bottom(){
        return data.getOWLNothing();
    }

    public static OWLObjectPropertyExpression inv(OWLObjectPropertyExpression p){
        return data.getOWLObjectInverseOf(p);
    }

    public static OWLObjectPropertyExpression inv(String p){
        return inv(property(p));
    }

    public static OWLSubObjectPropertyOfAxiom subProp(OWLObjectPropertyExpression sub, OWLObjectPropertyExpression sup){
        return data.getOWLSubObjectPropertyOfAxiom(sub, sup);
    }

    public static OWLSubObjectPropertyOfAxiom subProp(String sub, OWLObjectPropertyExpression sup){
        return subProp(property(sub), sup);
    }

    public static OWLSubObjectPropertyOfAxiom subProp(OWLObjectPropertyExpression sub, String sup){
        return subProp(sub, property(sup));
    }

    public static OWLSubObjectPropertyOfAxiom subProp(String sub, String sup){
        return subProp(property(sub), property(sup));
    }

    public static OWLTransitiveObjectPropertyAxiom trans(OWLObjectPropertyExpression p){
        return data.getOWLTransitiveObjectPropertyAxiom(p);
    }

    public static OWLTransitiveObjectPropertyAxiom trans(String s){
        return trans(property(s));
    }

    public static OWLSymmetricObjectPropertyAxiom symmetric(OWLObjectPropertyExpression p){
        return data.getOWLSymmetricObjectPropertyAxiom(p);
    }

    public static OWLSymmetricObjectPropertyAxiom symmetric(String s){
        return symmetric(property(s));
    }

    public static OWLObjectPropertyDomainAxiom domain(OWLObjectPropertyExpression p, OWLClassExpression oce) {
        return data.getOWLObjectPropertyDomainAxiom(p, oce);
    }

    public static OWLObjectPropertyDomainAxiom domain(String p, OWLClassExpression oce) {
        return domain(property(p), oce);
    }

    public static OWLObjectPropertyDomainAxiom domain(OWLObjectPropertyExpression p, String oce) {
        return domain(p, concept(oce));
    }

    public static OWLObjectPropertyDomainAxiom domain(String p, String oce) {
        return domain(property(p), concept(oce));
    }

    public static OWLObjectPropertyRangeAxiom range(OWLObjectPropertyExpression p, OWLClassExpression oce) {
        return data.getOWLObjectPropertyRangeAxiom(p, oce);
    }

    public static OWLObjectPropertyRangeAxiom range(String p, OWLClassExpression oce) {
        return range(property(p), oce);
    }

    public static OWLObjectPropertyRangeAxiom range(OWLObjectPropertyExpression p, String oce) {
        return range(p, concept(oce));
    }

    public static OWLObjectPropertyRangeAxiom range(String p, String oce) {
        return range(property(p), concept(oce));
    }

    public static OWLDataProperty dproperty(String p) {
        return data.getOWLDataProperty(IRI.create(prefix + p));
    }

    public static OWLDataPropertyDomainAxiom dDomain(OWLDataPropertyExpression p, OWLClassExpression oce) {
        return data.getOWLDataPropertyDomainAxiom(p, oce);
    }

    public static OWLDataPropertyDomainAxiom dDomain(String p, OWLClassExpression oce) {
        return dDomain(dproperty(p), oce);
    }

    public static OWLDataPropertyDomainAxiom dDomain(OWLDataPropertyExpression p, String oce) {
        return dDomain(p, concept(oce));
    }

    public static OWLDataPropertyDomainAxiom dDomain(String p, String oce) {
        return dDomain(dproperty(p), concept(oce));
    }

    public static OWLDataPropertyAssertionAxiom hasData(OWLDataPropertyExpression p, OWLIndividual a, OWLLiteral b) {
        return data.getOWLDataPropertyAssertionAxiom(p, a, b);
    }

    public static OWLDataPropertyAssertionAxiom hasData(String p, OWLIndividual a, OWLLiteral b) {
        return hasData(dproperty(p), (a), (b));
    }

    public static OWLDataPropertyAssertionAxiom hasData(OWLDataPropertyExpression p, String a, OWLLiteral b) {
        return hasData((p), individual(a), (b));
    }

    public static OWLDataPropertyAssertionAxiom hasData(String p, String a, OWLLiteral b) {
        return hasData(dproperty(p), individual(a), (b));
    }

    public static OWLDataPropertyAssertionAxiom hasData(OWLDataPropertyExpression p, OWLIndividual a, String b) {
        return hasData((p), (a), data.getOWLLiteral(b));
    }

    public static OWLDataPropertyAssertionAxiom hasData(String p, OWLIndividual a, String b) {
        return hasData(dproperty(p), (a), data.getOWLLiteral(b));
    }

    public static OWLDataPropertyAssertionAxiom hasData(OWLDataPropertyExpression p, String a, String b) {
        return hasData((p), individual(a), data.getOWLLiteral(b));
    }

    public static OWLDataPropertyAssertionAxiom hasData(String p, String a, String b) {
        return hasData(dproperty(p), individual(a), data.getOWLLiteral(b));
    }
}
