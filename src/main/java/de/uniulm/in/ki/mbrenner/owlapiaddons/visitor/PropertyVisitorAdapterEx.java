package de.uniulm.in.ki.mbrenner.owlapiaddons.visitor;

import org.semanticweb.owlapi.model.*;

import javax.annotation.Nonnull;
import java.util.function.Consumer;


/**
 * Adapter for easier implementation of OWLAPI visitors
 * Created by spellmaker on 01.06.2016.
 */
public class PropertyVisitorAdapterEx<T> implements OWLPropertyExpressionVisitorEx<T> {
    private final Consumer<Object> defaultAction;

    protected PropertyVisitorAdapterEx(){
        defaultAction = c -> {throw new IllegalArgumentException("No handler for " + c.getClass() + " implemented");};
    }

    public PropertyVisitorAdapterEx(Consumer<Object> action){
        this.defaultAction = action;
    }


    @Override
    public T visit(OWLObjectProperty property) {
        defaultAction.accept(property);
        return null;
    }


    @Override
    public T visit(OWLObjectInverseOf property) {
        defaultAction.accept(property);
        return null;
    }


    @Override
    public T visit(OWLDataProperty property) {
        defaultAction.accept(property);
        return null;
    }

    @Nonnull
    @Override
    public T visit(@Nonnull OWLAnnotationProperty property) {
        defaultAction.accept(property);
        return null;
    }
}
