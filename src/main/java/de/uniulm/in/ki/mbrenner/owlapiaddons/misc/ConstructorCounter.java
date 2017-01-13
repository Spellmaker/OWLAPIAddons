package de.uniulm.in.ki.mbrenner.owlapiaddons.misc;

import org.semanticweb.owlapi.model.*;

/**
 * Counts constructors used in OWLAPI objects
 * Created by spellmaker on 31.05.2016.
 */
public class ConstructorCounter implements OWLClassExpressionVisitor, OWLPropertyExpressionVisitor, OWLAxiomVisitor, OWLEntityVisitor, OWLIndividualVisitor {
    private final ClassCounter counter;

    private ConstructorCounter(){
        counter = new ClassCounter();
    }

    public static ClassCounter count(OWLOntology ontology){
        ConstructorCounter c = new ConstructorCounter();
        ontology.getAxioms().forEach(x -> x.accept(c));
        return c.counter;
    }

    public static ClassCounter count(OWLAxiom axiom){
        ConstructorCounter c = new ConstructorCounter();
        axiom.accept(c);
        return c.counter;
    }

    @Override
    public void visit( OWLDeclarationAxiom owlDeclarationAxiom) {
        counter.add(owlDeclarationAxiom);
        owlDeclarationAxiom.getEntity().accept(this);
    }

    @Override
    public void visit( OWLDatatypeDefinitionAxiom owlDatatypeDefinitionAxiom) {
        counter.add(owlDatatypeDefinitionAxiom);
        counter.add(owlDatatypeDefinitionAxiom.getDataRange());
        counter.add(owlDatatypeDefinitionAxiom.getDatatype());
    }

    @Override
    public void visit( OWLAnnotationAssertionAxiom owlAnnotationAssertionAxiom) {
        counter.add(owlAnnotationAssertionAxiom);
    }

    @Override
    public void visit( OWLSubAnnotationPropertyOfAxiom owlSubAnnotationPropertyOfAxiom) {
        counter.add(owlSubAnnotationPropertyOfAxiom);
    }

    @Override
    public void visit( OWLAnnotationPropertyDomainAxiom owlAnnotationPropertyDomainAxiom) {
        counter.add(owlAnnotationPropertyDomainAxiom);
    }

    @Override
    public void visit( OWLAnnotationPropertyRangeAxiom owlAnnotationPropertyRangeAxiom) {
        counter.add(owlAnnotationPropertyRangeAxiom);
    }

    @Override
    public void visit( OWLClass owlClass) {
        counter.add(owlClass);
    }

    @Override
    public void visit( OWLObjectIntersectionOf owlObjectIntersectionOf) {
        counter.add(owlObjectIntersectionOf);
        owlObjectIntersectionOf.getOperands().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLObjectUnionOf owlObjectUnionOf) {
        counter.add(owlObjectUnionOf);
        owlObjectUnionOf.getOperands().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLObjectComplementOf owlObjectComplementOf) {
        counter.add(owlObjectComplementOf);
        owlObjectComplementOf.getOperand().accept(this);
    }

    @Override
    public void visit( OWLObjectSomeValuesFrom owlObjectSomeValuesFrom) {
        counter.add(owlObjectSomeValuesFrom);
        owlObjectSomeValuesFrom.getFiller().accept(this);
        owlObjectSomeValuesFrom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLObjectAllValuesFrom owlObjectAllValuesFrom) {
        counter.add(owlObjectAllValuesFrom);
        owlObjectAllValuesFrom.getFiller().accept(this);
        owlObjectAllValuesFrom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLObjectHasValue owlObjectHasValue) {
        counter.add(owlObjectHasValue);
        owlObjectHasValue.getProperty().accept(this);
        owlObjectHasValue.getProperty().accept(this);
    }

    @Override
    public void visit( OWLObjectMinCardinality owlObjectMinCardinality) {
        counter.add(owlObjectMinCardinality);
        owlObjectMinCardinality.getFiller().accept(this);
        owlObjectMinCardinality.getProperty().accept(this);
    }

    @Override
    public void visit( OWLObjectExactCardinality owlObjectExactCardinality) {
        counter.add(owlObjectExactCardinality);
        owlObjectExactCardinality.getFiller().accept(this);
        owlObjectExactCardinality.getProperty().accept(this);
    }

    @Override
    public void visit( OWLObjectMaxCardinality owlObjectMaxCardinality) {
        counter.add(owlObjectMaxCardinality);
        owlObjectMaxCardinality.getFiller().accept(this);
        owlObjectMaxCardinality.getProperty().accept(this);
    }

    @Override
    public void visit( OWLObjectHasSelf owlObjectHasSelf) {
        counter.add(owlObjectHasSelf);
        owlObjectHasSelf.getProperty().accept(this);
    }

    @Override
    public void visit( OWLObjectOneOf owlObjectOneOf) {
        counter.add(owlObjectOneOf);
        owlObjectOneOf.getIndividuals().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLDataSomeValuesFrom owlDataSomeValuesFrom) {
        counter.add(owlDataSomeValuesFrom);
        counter.add(owlDataSomeValuesFrom.getFiller());
        owlDataSomeValuesFrom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLDataAllValuesFrom owlDataAllValuesFrom) {
        counter.add(owlDataAllValuesFrom);
        counter.add(owlDataAllValuesFrom.getFiller());
        owlDataAllValuesFrom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLDataHasValue owlDataHasValue) {
        counter.add(owlDataHasValue);
        counter.add(owlDataHasValue.getProperty());
        owlDataHasValue.getProperty().accept(this);
    }

    @Override
    public void visit( OWLDataMinCardinality owlDataMinCardinality) {
        counter.add(owlDataMinCardinality);
        counter.add(owlDataMinCardinality.getFiller());
        owlDataMinCardinality.getProperty().accept(this);
    }

    @Override
    public void visit( OWLDataExactCardinality owlDataExactCardinality) {
        counter.add(owlDataExactCardinality);
        counter.add(owlDataExactCardinality.getFiller());
        owlDataExactCardinality.getProperty().accept(this);
    }

    @Override
    public void visit( OWLDataMaxCardinality owlDataMaxCardinality) {
        counter.add(owlDataMaxCardinality);
        counter.add(owlDataMaxCardinality.getFiller());
        owlDataMaxCardinality.getProperty().accept(this);
    }

    @Override
    public void visit( OWLSubClassOfAxiom owlSubClassOfAxiom) {
        counter.add(owlSubClassOfAxiom);
        owlSubClassOfAxiom.getSuperClass().accept(this);
        owlSubClassOfAxiom.getSubClass().accept(this);
    }

    @Override
    public void visit( OWLNegativeObjectPropertyAssertionAxiom owlNegativeObjectPropertyAssertionAxiom) {
        counter.add(owlNegativeObjectPropertyAssertionAxiom);
        owlNegativeObjectPropertyAssertionAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLAsymmetricObjectPropertyAxiom owlAsymmetricObjectPropertyAxiom) {
        counter.add(owlAsymmetricObjectPropertyAxiom);
        owlAsymmetricObjectPropertyAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLReflexiveObjectPropertyAxiom owlReflexiveObjectPropertyAxiom) {
        counter.add(owlReflexiveObjectPropertyAxiom);
        owlReflexiveObjectPropertyAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLDisjointClassesAxiom owlDisjointClassesAxiom) {
        counter.add(owlDisjointClassesAxiom);
        owlDisjointClassesAxiom.getClassExpressions().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLDataPropertyDomainAxiom owlDataPropertyDomainAxiom) {
        counter.add(owlDataPropertyDomainAxiom);
        owlDataPropertyDomainAxiom.getDomain().accept(this);
        owlDataPropertyDomainAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLObjectPropertyDomainAxiom owlObjectPropertyDomainAxiom) {
        counter.add(owlObjectPropertyDomainAxiom);
        owlObjectPropertyDomainAxiom.getDomain().accept(this);
        owlObjectPropertyDomainAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLEquivalentObjectPropertiesAxiom owlEquivalentObjectPropertiesAxiom) {
        counter.add(owlEquivalentObjectPropertiesAxiom);
        owlEquivalentObjectPropertiesAxiom.getProperties().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLNegativeDataPropertyAssertionAxiom owlNegativeDataPropertyAssertionAxiom) {
        counter.add(owlNegativeDataPropertyAssertionAxiom);
        owlNegativeDataPropertyAssertionAxiom.getProperty().accept(this);
        counter.add(owlNegativeDataPropertyAssertionAxiom.getObject());
    }

    @Override
    public void visit( OWLDifferentIndividualsAxiom owlDifferentIndividualsAxiom) {
        counter.add(owlDifferentIndividualsAxiom);
        owlDifferentIndividualsAxiom.getIndividuals().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLDisjointDataPropertiesAxiom owlDisjointDataPropertiesAxiom) {
        counter.add(owlDisjointDataPropertiesAxiom);
        owlDisjointDataPropertiesAxiom.getProperties().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLDisjointObjectPropertiesAxiom owlDisjointObjectPropertiesAxiom) {
        counter.add(owlDisjointObjectPropertiesAxiom);
        owlDisjointObjectPropertiesAxiom.getProperties().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLObjectPropertyRangeAxiom owlObjectPropertyRangeAxiom) {
        counter.add(owlObjectPropertyRangeAxiom);
        owlObjectPropertyRangeAxiom.getProperty().accept(this);
        owlObjectPropertyRangeAxiom.getRange().accept(this);
    }

    @Override
    public void visit( OWLObjectPropertyAssertionAxiom owlObjectPropertyAssertionAxiom) {
        counter.add(owlObjectPropertyAssertionAxiom);
        owlObjectPropertyAssertionAxiom.getObject().accept(this);
        owlObjectPropertyAssertionAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLFunctionalObjectPropertyAxiom owlFunctionalObjectPropertyAxiom) {
        counter.add(owlFunctionalObjectPropertyAxiom);
        owlFunctionalObjectPropertyAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLSubObjectPropertyOfAxiom owlSubObjectPropertyOfAxiom) {
        counter.add(owlSubObjectPropertyOfAxiom);
        owlSubObjectPropertyOfAxiom.getSubProperty().accept(this);
        owlSubObjectPropertyOfAxiom.getSuperProperty().accept(this);
    }

    @Override
    public void visit( OWLDisjointUnionAxiom owlDisjointUnionAxiom) {
        counter.add(owlDisjointUnionAxiom);
        owlDisjointUnionAxiom.getClassExpressions().forEach(x -> x.accept(this));
        owlDisjointUnionAxiom.getOWLClass().accept((OWLClassExpressionVisitor) this);
    }

    @Override
    public void visit( OWLSymmetricObjectPropertyAxiom owlSymmetricObjectPropertyAxiom) {
        counter.add(owlSymmetricObjectPropertyAxiom);
        owlSymmetricObjectPropertyAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLDataPropertyRangeAxiom owlDataPropertyRangeAxiom) {
        counter.add(owlDataPropertyRangeAxiom);
        owlDataPropertyRangeAxiom.getProperty().accept(this);
        counter.add(owlDataPropertyRangeAxiom.getRange());
    }

    @Override
    public void visit( OWLFunctionalDataPropertyAxiom owlFunctionalDataPropertyAxiom) {
        counter.add(owlFunctionalDataPropertyAxiom);
        owlFunctionalDataPropertyAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLEquivalentDataPropertiesAxiom owlEquivalentDataPropertiesAxiom) {
        counter.add(owlEquivalentDataPropertiesAxiom);
        owlEquivalentDataPropertiesAxiom.getProperties().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLClassAssertionAxiom owlClassAssertionAxiom) {
        counter.add(owlClassAssertionAxiom);
        owlClassAssertionAxiom.getClassExpression().accept(this);
        owlClassAssertionAxiom.getIndividual().accept(this);
    }

    @Override
    public void visit( OWLEquivalentClassesAxiom owlEquivalentClassesAxiom) {
        counter.add(owlEquivalentClassesAxiom);
        owlEquivalentClassesAxiom.getClassExpressions().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLDataPropertyAssertionAxiom owlDataPropertyAssertionAxiom) {
        counter.add(owlDataPropertyAssertionAxiom);
        counter.add(owlDataPropertyAssertionAxiom.getObject());
        owlDataPropertyAssertionAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLTransitiveObjectPropertyAxiom owlTransitiveObjectPropertyAxiom) {
        counter.add(owlTransitiveObjectPropertyAxiom);
        owlTransitiveObjectPropertyAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLIrreflexiveObjectPropertyAxiom owlIrreflexiveObjectPropertyAxiom) {
        counter.add(owlIrreflexiveObjectPropertyAxiom);
        owlIrreflexiveObjectPropertyAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLSubDataPropertyOfAxiom owlSubDataPropertyOfAxiom) {
        counter.add(owlSubDataPropertyOfAxiom);
        owlSubDataPropertyOfAxiom.getSubProperty().accept(this);
        owlSubDataPropertyOfAxiom.getSuperProperty().accept(this);
    }

    @Override
    public void visit( OWLInverseFunctionalObjectPropertyAxiom owlInverseFunctionalObjectPropertyAxiom) {
        counter.add(owlInverseFunctionalObjectPropertyAxiom);
        owlInverseFunctionalObjectPropertyAxiom.getProperty().accept(this);
    }

    @Override
    public void visit( OWLSameIndividualAxiom owlSameIndividualAxiom) {
        counter.add(owlSameIndividualAxiom);
        owlSameIndividualAxiom.getIndividuals().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( OWLSubPropertyChainOfAxiom owlSubPropertyChainOfAxiom) {
        counter.add(owlSubPropertyChainOfAxiom);
        owlSubPropertyChainOfAxiom.getPropertyChain().forEach(x -> x.accept(this));
        owlSubPropertyChainOfAxiom.getSuperProperty().accept(this);
    }

    @Override
    public void visit( OWLInverseObjectPropertiesAxiom owlInverseObjectPropertiesAxiom) {
        counter.add(owlInverseObjectPropertiesAxiom);
        owlInverseObjectPropertiesAxiom.getFirstProperty().accept(this);
        owlInverseObjectPropertiesAxiom.getSecondProperty().accept(this);
    }

    @Override
    public void visit( OWLHasKeyAxiom owlHasKeyAxiom) {
        counter.add(owlHasKeyAxiom);
        owlHasKeyAxiom.getClassExpression().accept(this);
        owlHasKeyAxiom.getPropertyExpressions().forEach(x -> x.accept(this));
    }

    @Override
    public void visit( SWRLRule swrlRule) {
        counter.add(swrlRule);
    }

    @Override
    public void visit( OWLObjectProperty owlObjectProperty) {
        counter.add(owlObjectProperty);
    }

    @Override
    public void visit( OWLObjectInverseOf owlObjectInverseOf) {
        counter.add(owlObjectInverseOf);
        owlObjectInverseOf.getInverse().accept(this);
    }

    @Override
    public void visit( OWLDataProperty owlDataProperty) {
        counter.add(owlDataProperty);
    }

    @Override
    public void visit( OWLNamedIndividual owlNamedIndividual) {
        counter.add(owlNamedIndividual);
    }

    @Override
    public void visit( OWLAnonymousIndividual owlAnonymousIndividual) {
        counter.add(owlAnonymousIndividual);
    }

    @Override
    public void visit( OWLDatatype owlDatatype) {
        counter.add(owlDatatype);
    }

    @Override
    public void visit( OWLAnnotationProperty owlAnnotationProperty) {
        counter.add(owlAnnotationProperty);
    }
}
