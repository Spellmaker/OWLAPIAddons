package de.uniulm.in.ki.mbrenner.owlapiaddons.visitor;

import org.semanticweb.owlapi.model.*;

import java.util.function.Consumer;


/**
 * Adapter for easier implementation of OWLAPI visitors
 * Created by spellmaker on 01.06.2016.
 */
public class AxiomVisitorAdapterEx<T> implements OWLAxiomVisitorEx<T> {
    private final Consumer<Object> defaultAccept;

    protected AxiomVisitorAdapterEx(){
        defaultAccept = c -> {throw new IllegalArgumentException("No handler for " + c.getClass() + " implemented in class " + this.getClass());};
    }

    public AxiomVisitorAdapterEx(Consumer<Object> accept){
        this.defaultAccept = accept;
    }


    @Override
    public T visit(OWLDeclarationAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLDatatypeDefinitionAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLAnnotationAssertionAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLSubAnnotationPropertyOfAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLAnnotationPropertyDomainAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLAnnotationPropertyRangeAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLSubClassOfAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLAsymmetricObjectPropertyAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLReflexiveObjectPropertyAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLDisjointClassesAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLDataPropertyDomainAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLObjectPropertyDomainAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLEquivalentObjectPropertiesAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLDifferentIndividualsAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLDisjointDataPropertiesAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLDisjointObjectPropertiesAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLObjectPropertyRangeAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLObjectPropertyAssertionAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLFunctionalObjectPropertyAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLSubObjectPropertyOfAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLDisjointUnionAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLSymmetricObjectPropertyAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLDataPropertyRangeAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLFunctionalDataPropertyAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLEquivalentDataPropertiesAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLClassAssertionAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLEquivalentClassesAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLDataPropertyAssertionAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLTransitiveObjectPropertyAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLSubDataPropertyOfAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLSameIndividualAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLSubPropertyChainOfAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLInverseObjectPropertiesAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(OWLHasKeyAxiom axiom) {
        defaultAccept.accept(axiom);
        return null;
    }


    @Override
    public T visit(SWRLRule axiom) {
        defaultAccept.accept(axiom);
        return null;
    }
}
