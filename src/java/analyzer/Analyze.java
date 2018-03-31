package java.analyzer;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import java.sorters.*;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Bodriagina
 */
public class Analyze {
    public static Set<Class<? extends Sort>> getAllClasses(){
        Reflections ref = new Reflections("java/sorters");
        Set<Class<? extends Sort>> sorters = ref.getSubTypesOf(Sort.class);
        sorters.remove(BubbleSort.class);
        return sorters;
    }
    public static Set<Method> getAllMethods(Class class1){
        Reflections ref = new Reflections("java/fillers", new MethodAnnotationsScanner());
        Set<Method> fillers = ref.getMethodsAnnotatedWith(class1);
        return fillers;
    }
}
