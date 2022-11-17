public interface Contract {

    void grab(String item); //complete
    String drop(String item); //complete
    void examine(String item); //complete
    void use(String item); //complete
    boolean walk(String direction); //complete
    boolean fly(int x, int y); //complete
    Number shrink(); //complete
    Number grow(); //complete
    void rest(); //complete
    void undo(); //complete

}