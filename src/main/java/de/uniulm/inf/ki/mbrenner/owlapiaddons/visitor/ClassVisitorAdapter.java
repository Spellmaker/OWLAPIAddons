package de.uniulm.inf.ki.mbrenner.owlapiaddons.visitor;

import org.semanticweb.owlapi.model.*;

import java.util.function.Consumer;

/**
 * Created by spellmaker on 01.06.2016.
 */
public class ClassVisitorAdapter implements OWLClassExpressionVisitor {
    private final Consumer<Object> defaultAction;

    public ClassVisitorAdapter(){
        defaultAction = c -> {throw new IllegalArgumentException("No handler for " + c.getClass() + " implemented");};
    }

    public ClassVisitorAdapter(Consumer<Object> action){
        this.defaultAction = action;
    }

    @Override
    public void visit( OWLClass oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectIntersectionOf oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectUnionOf oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectComplementOf oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectSomeValuesFrom oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectAllValuesFrom oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectHasValue oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectMinCardinality oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectExactCardinality oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectMaxCardinality oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectHasSelf oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLObjectOneOf oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLDataSomeValuesFrom oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLDataAllValuesFrom oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLDataHasValue oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLDataMinCardinality oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLDataExactCardinality oce) {
        defaultAction.accept(oce);
    }

    @Override
    public void visit( OWLDataMaxCardinality oce) {
        defaultAction.accept(oce);
    }
}
