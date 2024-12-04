public class AwesomestClassEver<T>{
    final T mostAwesomeElement;

    /**
     * Construct an object, made just for the most awesome element ever!
     * @param mostAwesomeElement The most awesome element ever!
     */
    AwesomestClassEver(T mostAwesomeElement){
        this.mostAwesomeElement = mostAwesomeElement;
    }

    /**
     * You want to see the most awesome element ever!
     * @return The most awesome element ever!
     */
    T getMostAwesomeElement(){
        return mostAwesomeElement;
    }

    /**
     * Set a new most awesome element ever!
     * @param newMostAwesomeElement The new most awesome element ever!
     * @throws IllegalAccessError Sike! This is a space for just the most awesome element ever, and not some cheap copy!
     */
    void setMostAwesomeElement(T newMostAwesomeElement) throws IllegalAccessError{
        throw new IllegalAccessError("Sike! The most Awesome Element can't be changed!");
    }
}
