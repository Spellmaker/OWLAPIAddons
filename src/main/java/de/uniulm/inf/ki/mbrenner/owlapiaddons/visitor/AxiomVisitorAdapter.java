package de.uniulm.inf.ki.mbrenner.owlapiaddons.visitor;

import org.semanticweb.owlapi.model.*;

import java.util.function.Consumer;

/**
 * Created by spellmaker on 01.06.2016.
 */
public class AxiomVisitorAdapter implements OWLAxiomVisitor {
    private final Consumer<Object> defaultAction;

    public AxiomVisitorAdapter(){
        defaultAction = c -> {throw new IllegalArgumentException("No handler for " + c.getClass() + " implemented in class " + this.getClass());};
    }

    public AxiomVisitorAdapter(Consumer<Object> action){
        this.defaultAction = action;
    }


    @Override
    public void visit( OWLDeclarationAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLDatatypeDefinitionAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLAnnotationAssertionAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLSubAnnotationPropertyOfAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLAnnotationPropertyDomainAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLAnnotationPropertyRangeAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLSubClassOfAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLNegativeObjectPropertyAssertionAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLAsymmetricObjectPropertyAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLReflexiveObjectPropertyAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLDisjointClassesAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLDataPropertyDomainAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLObjectPropertyDomainAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLEquivalentObjectPropertiesAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLNegativeDataPropertyAssertionAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLDifferentIndividualsAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLDisjointDataPropertiesAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLDisjointObjectPropertiesAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLObjectPropertyRangeAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLObjectPropertyAssertionAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLFunctionalObjectPropertyAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLSubObjectPropertyOfAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLDisjointUnionAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLSymmetricObjectPropertyAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLDataPropertyRangeAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLFunctionalDataPropertyAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLEquivalentDataPropertiesAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLClassAssertionAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLEquivalentClassesAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLDataPropertyAssertionAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLTransitiveObjectPropertyAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLIrreflexiveObjectPropertyAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLSubDataPropertyOfAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLInverseFunctionalObjectPropertyAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLSameIndividualAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLSubPropertyChainOfAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLInverseObjectPropertiesAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( OWLHasKeyAxiom axiom) {
        defaultAction.accept(axiom);
    }

    @Override
    public void visit( SWRLRule axiom) {
        defaultAction.accept(axiom);
    }
}
