import java.util.ArrayList;
public class Player implements Contract{
    
    /* player attributes */
    ArrayList<String> inventory;
    public String name;
    public Blob myBlob;

    /* player constructor */
    public Player(String name){
        this.name = name;
        this.inventory = new ArrayList<String>();
        this.myBlob = new Blob();
        System.out.println();
        System.out.println("Hi " + name + "! You have just adopted a new virtual blob. Make sure to take care of blob by: ");
        System.out.println("- using grab() and use() with food or toy as the item to feed and play with blob");
        System.out.println("- using walk() and fly() to take blob on adventures. Depending on where you take blob, blob will tell you if blob enjoyed the adventure or not");
        System.out.println("- using rest() to put blob to sleep");
        System.out.println("- using undo() to set blob's stats back to their initial state");
        System.out.println("Make sure to keep an eye on blob's energy and fun as if either one reaches zero blob will die :(");
        System.out.println();
    }

    /* adds item to inventory
     * @param item thing you want to grab
     */
    public void grab(String item){
        if (item.equals("food") || item.equals("toy")){
            inventory.add(item);
            System.out.println("You have grabbed " + item + ", use examine() to learn what it does");
        }
        else{
            System.out.println("Cannot grab " + item + ". Please call grab() with either food or toy as the item");
        }
    }

    /* removes item from inventory
     * @param item thing you want to drop
     * @return thing that has been dropped
     */
    public String drop(String item){
        if (inventory.contains(item)){
            inventory.remove(item);
            System.out.println("You have dropped " + item + ", it is no longer in your inventory");
            return item;
        }
        else{
            System.out.println("Cannot drop " + item + " because it is not in your inventory. Please call grab() and try again");
            return null;
        }
    }

    /* prints the function of an item
     * @param item thing you want to examine
     */
    public void examine(String item){
        if (!inventory.contains(item)){
            System.out.println("Cannot examine " + item + " because it is not in your inventory. Please call grab() and try again");
        }

        else if (item.equals("food")){
            System.out.println("Food will increase blob's energy and size while decreasing blob's fun, call use() to feed blob");
        }

        else{
            System.out.println("Toy will increase blob's fun while reducing blob's size and energy, call use() to play with blob");
        }
    }

    /* adjusts blob's stats based on the item being used
     * @param item the thing you want to use
     */
    public void use(String item){
        if (inventory.contains(item)){
            if (item.equals("food")){
                if (myBlob.energy < 10){
                    myBlob.energy += 1;
                    myBlob.fun -= 1;
                    if (myBlob.isAlive()){
                        System.out.println("Blob thanks you for feeding blob. Updated blob stats are: ");
                        System.out.println("Energy: " + myBlob.energy + "/10" + "\nFun: " + myBlob.fun + "/25" + "\nSize: " + grow() + " inches in diameter");
                        inventory.remove(item);
                        System.out.println(item + " has been removed from your inventory");
                    }
                }
                else{
                    System.out.println("Blob is at full energy already, please reduce energy before attempting to feed blob again");
                }
            }
            
            else{
                    myBlob.energy -= 1;
                    myBlob.fun += 1;
                    if (myBlob.isAlive()){
                        System.out.println("Blob thanks you for playing with blob. Updated blob stats are: ");
                        System.out.println("Energy: " + myBlob.energy + "/10" + "\nFun: " + myBlob.fun + "/25" + "\nSize: " + shrink() + " inches in diameter");
                        inventory.remove(item);
                        System.out.println(item + " has been removed from your inventory");
                    }
            }
        }
        else{
            System.out.println("Cannot use " + item + " because it is not in your inventory. Please use grab() and try again");
        }
    }

    /* reduces blob's size by ten
     * @return blob's new size
     */
    public Number shrink(){
        myBlob.size -= 10;
        return myBlob.size;
    }

    /* increases blob's size by ten
     * @return blob's new size
     */
    public Number grow(){
        myBlob.size += 10;
        return myBlob.size;
    }

    /* depending on the direction, adjusts blob's stats accordingly and tells whether blob enjoyed the adventure or not
     * @param direction the way you want to walk blob
     * @return true if blob liked the direction, false if blob did not
     */
    public boolean walk(String direction){
        if (direction.equals("north") || direction.equals("east")){
            System.out.println("Blob did enjoy this adventure!");
            myBlob.energy -= 2;
            myBlob.fun += 5;
            if (myBlob.isAlive()){
                System.out.println("Energy: " + myBlob.energy + "/10" + "\nFun: " + myBlob.fun + "/25" + "\nSize: " + myBlob.size + " inches in diameter");
            }
            return true;
        }
        else{
            System.out.println("Blob did not enjoy this adventure, try a new direction next time");
            myBlob.energy -= 4;
            myBlob.fun -= 2;
            if (myBlob.isAlive()){
                System.out.println("Energy: " + myBlob.energy + "/10" + "\nFun: " + myBlob.fun + "/25" + "\nSize: " + myBlob.size + " inches in diameter");
            }
            return false;
        }
    }

    /* depending on the coordinates, adjusts blob's stats accordingly and tells whether blob enjoyed the adventure or not
     * @param x the x coordinate of where you want to fly blob
     * @param y the y coordinate of where you want to fly blob
     * @return true if blob liked the coordinates, false if blob did not
     */
    public boolean fly(int x, int y){
        if (x > 25 && y < 25){
            System.out.println("Blob did enjoy this adventure!");
            myBlob.energy -= 2;
            myBlob.fun += 5;
            myBlob.posx = x;
            myBlob.posy = y;
            if (myBlob.isAlive()){
                System.out.println("Energy: " + myBlob.energy + "/10" + "\nFun: " + myBlob.fun + "/25" + "\nSize: " + myBlob.size + " inches in diameter");
            }
            return true;
        }
        else{
            System.out.println("Blob did not enjoy this adventure, try new coordinates next time");
            myBlob.energy -= 4;
            myBlob.fun -= 2;
            myBlob.posx = x;
            myBlob.posy = y;
            if (myBlob.isAlive()){
                System.out.println("Energy: " + myBlob.energy + "/10" + "\nFun: " + myBlob.fun + "/25" + "\nSize: " + myBlob.size + " inches in diameter");
            }
            return false;
        }
    }
    
    /* increases blob's energy and prints updated stats */
    public void rest(){
        if (myBlob.energy < 10){
            myBlob.energy += 1;
            System.out.println("Blob enjoyed the rest, 1 energy restored");
            System.out.println("Energy: " + myBlob.energy + "/10" + "\nFun: " + myBlob.fun + "/25" + "\nSize: " + myBlob.size + " inches in diameter");
        }
    }

    /* resets blob to initial stats */
    public void undo(){
        myBlob.energy = 10;
        myBlob.fun = 5;
        myBlob.size = 100;

        System.out.println("You're actions have been undone and blob's stats have been reset");
        System.out.println("Energy: " + myBlob.energy + "/10" + "\nFun: " + myBlob.fun + "/25" + "\nSize: " + myBlob.size + " inches in diameter");
    }

    /* main method for testing */
    public static void main(String[] args){
        Player myPlayer = new Player("Molly");
        myPlayer.grab("toy");
        myPlayer.examine("toy");
        myPlayer.use("toy");
        myPlayer.walk("north");
        myPlayer.undo();
    }
}
