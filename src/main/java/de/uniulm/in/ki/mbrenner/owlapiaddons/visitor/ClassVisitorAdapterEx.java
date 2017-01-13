package de.uniulm.in.ki.mbrenner.owlapiaddons.visitor;

import org.semanticweb.owlapi.model.*;

import java.util.function.Consumer;


/**
 * Adapter for easier implementation of OWLAPI visitors
 * Created by spellmaker on 01.06.2016.
 */
public class ClassVisitorAdapterEx<T> implements OWLClassExpressionVisitorEx<T> {
    private final Consumer<Object> defaultAction;

    protected ClassVisitorAdapterEx(){
        defaultAction = c -> {throw new IllegalArgumentException("No handler for " + c.getClass() + " implemented");};
    }

    public ClassVisitorAdapterEx(Consumer<Object> action){
        this.defaultAction = action;
    }

    @Override
    public T visit(OWLClass oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectIntersectionOf oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectUnionOf oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectComplementOf oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectSomeValuesFrom oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectAllValuesFrom oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectHasValue oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectMinCardinality oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectExactCardinality oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectMaxCardinality oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectHasSelf oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLObjectOneOf oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLDataSomeValuesFrom oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLDataAllValuesFrom oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLDataHasValue oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLDataMinCardinality oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLDataExactCardinality oce) {
        defaultAction.accept(oce);
        return null;
    }


    @Override
    public T visit(OWLDataMaxCardinality oce) {
        defaultAction.accept(oce);
        return null;
    }
}
