package de.uniulm.in.ki.mbrenner.owlapiaddons.misc;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created by spellmaker on 31.08.2016.
 */
public class Loader {
    public static OWLOntology load(String resource) throws OWLOntologyCreationException{
        return OWLManager.createOWLOntologyManager().loadOntologyFromOntologyDocument(new File(Loader.class.getClassLoader().getResource(resource).getFile()));
    }
}
