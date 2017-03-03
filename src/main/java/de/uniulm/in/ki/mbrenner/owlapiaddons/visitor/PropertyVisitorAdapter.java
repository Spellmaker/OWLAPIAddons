package de.uniulm.in.ki.mbrenner.owlapiaddons.visitor;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLPropertyExpressionVisitor;

import java.util.function.Consumer;

/**
 * Allows fine grained control for property visitors
 *
 * Created by spellmaker on 01.06.2016.
 */
public class PropertyVisitorAdapter implements OWLPropertyExpressionVisitor {
    private Consumer<Object> defaultAction;

    /**
     * Constructs a new instance
     */
    public PropertyVisitorAdapter(){
        defaultAction = c -> {throw new IllegalArgumentException("No handler for " + c.getClass() + " implemented");};
    }

    /**
     * Constructs a new instance
     * Allows to specify a policy for unimplemented visitor methods
     *
     * @param action The action to execute for unhandled types
     */
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
}
