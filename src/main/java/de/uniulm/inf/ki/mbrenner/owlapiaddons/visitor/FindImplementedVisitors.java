package de.uniulm.inf.ki.mbrenner.owlapiaddons.visitor;

import de.uniulm.inf.ki.mbrenner.owlapiaddons.misc.ClassCounter;
import de.uniulm.inf.ki.mbrenner.owlapiaddons.misc.ConstructorCounter;
import org.semanticweb.owlapi.model.OWLOntology;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by spellmaker on 01.06.2016.
 */
public class FindImplementedVisitors {
    public static List<Class<?>> getImplemented(Class<?> c){
        List<Class<?>> result = new LinkedList<>();

        Method[] methods = c.getMethods();
        for(Method m : methods){
            if(m.getName().equals("visit") && m.getDeclaringClass().equals(c)){
                result.add(m.getParameterTypes()[0]);
            }
        }

        Field[] fields = c.getDeclaredFields();
        for(Field f : fields){
            if(ClassVisitorAdapter.class.isAssignableFrom(f.getType()) ||
                    ClassVisitorAdapterEx.class.isAssignableFrom(f.getType()) ||
                    PropertyVisitorAdapter.class.isAssignableFrom(f.getType()) ||
                    PropertyVisitorAdapterEx.class.isAssignableFrom(f.getType()) ||
                    AxiomVisitorAdapter.class.isAssignableFrom(f.getType()) ||
                    AxiomVisitorAdapterEx.class.isAssignableFrom(f.getType())) {
                result.addAll(getImplemented(f.getType()));
            }
        }

        return result;
    }

    public static List<Class<?>> getMissing(Class<?> visitor, OWLOntology ontology, Class<?> ...exclude){
        ClassCounter c = ConstructorCounter.count(ontology);

        return getMissing(visitor, c, exclude);
    }

    public static List<Class<?>> getMissing(Class<?> visitor, ClassCounter c, Class<?> ...exclude){
        List<Class<?>> implemented = getImplemented(visitor);
        return c.getCount().keySet().stream().
                filter(x -> Arrays.stream(exclude).filter(y -> y.isAssignableFrom(x)).count() <= 0).
                filter(x -> implemented.stream().filter(y -> y.isAssignableFrom(x)).count() <= 0).
                collect(Collectors.toList());
    }
}
