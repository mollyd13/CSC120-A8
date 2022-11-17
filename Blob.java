public class Blob {
    
    /* blob's attributes */
    public int energy;
    public int fun;
    public int posx;
    public int posy;
    public int size;

    /* blob constructor */
    public Blob(){
        this.energy = 10;
        this.fun = 5;
        this.posx = 0;
        this.posy = 0;
        this.size = 100;
    }

    /* prints blob in an easy to read way
     * @return string indicating you have created a new blob
     */
    public String toString(){
        return "new blob created";
    }

    /* tells whether or not blob is still alive, and if blob is dead print a message saying so
     * @return true if blob is alive, false if blob is dead
     */
    public Boolean isAlive(){
        if (this.energy <= 0){
            System.out.println("Blob's energy has reached zero, say your goodbyes to blob or use undo() to reset");
            return false;
        }
        else if (this.fun<= 0){
            System.out.println("Blob's fun has reached zero, say your goodbyes to blob or use undo() to reset");
            return false;
        }
        else {
            return true;
        }
    }


}
