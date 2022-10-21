package projeto.campoMinadoSwing.src.model;

@FunctionalInterface
public interface FieldObserver {

    public void eventOccurred(Field field, FieldEvent event);
    
}
