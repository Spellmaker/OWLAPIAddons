package de.uniulm.in.ki.mbrenner.owlapiaddons.visitor;

import org.semanticweb.owlapi.model.*;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

/**
 * Created by spellmaker on 01.06.2016.
 */
public class PropertyVisitorAdapter implements OWLPropertyExpressionVisitor {
    private Consumer<Object> defaultAction;

    public PropertyVisitorAdapter(){
        defaultAction = c -> {throw new IllegalArgumentException("No handler for " + c.getClass() + " implemented");};
    }

    public PropertyVisitorAdapter(Consumer<Object> action){
        this.defaultAction = action;
    }


    @Override
    public void visit( OWLObjectProperty property) {
        defaultAction.accept(property);
    }

    @Override
    public void visit( OWLObjectInverseOf property) {
        defaultAction.accept(property);
    }

    @Override
    public void visit( OWLDataProperty property) {
        defaultAction.accept(property);
    }

    @Override
    public void visit(@Nonnull OWLAnnotationProperty property) {
        defaultAction.accept(property);
    }
}
