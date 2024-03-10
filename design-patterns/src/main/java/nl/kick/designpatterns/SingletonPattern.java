package nl.kick.designpatterns;

/**
 * Singleton Pattern
 *
 * By making the constructor private we ensure the class is created once, making it a singleton
 * @implNote When to use:
 * Resources like db connections, loggers that are expensive to create or help performance
 * Configuration sources for the application
 * Resources that need to be shared
 */
public class SingletonPattern {

    /**
     * Used in both
     */
    private SingletonPattern () {};

    /**
     * Multithread safe approach with an inner class. The instance is lazy loaded when the {@link SingletonPattern#getInstance()} is called.
     */
    private static class SingletonHolder {
        public static final SingletonPattern instance = new SingletonPattern();
    }

    public static SingletonPattern getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * Original implementation
     */
    private static final SingletonPattern originalInstance = new SingletonPattern();

    public static SingletonPattern getOriginalInstance() {
        return originalInstance;
    }

}
