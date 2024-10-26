/**
 * Represents a parrot in a virtual world, which has several properties that define the state of the parrot.
 * January 26, 2023
 *
 * @author Jesse Atkinson
 */
public class Parrot {
    /**
     * Parrot name
     */
    private String name;
    /**
     * Number of hearts the parrot has
     */
    private int hearts;
    /**
     * Amount of crumbs in the parrot's stomach
     */
    private double crumbs;
    /**
     * Whether the parrot is tamed
     */
    private boolean isTamed;
    /**
     * Whether the parrot is alive
     */
    private boolean isAlive;
    /**
     * Whether the parrot is sitting
     */
    private boolean isSitting;

    /**
     * Default constructor for parrot class
     */
    public Parrot() {
        this.name = "Julius";
        this.hearts = 3;
        this.crumbs = 0.1;
        this.isTamed = false;
        this.isAlive = true;
        this.isSitting = false;
    }

    /**
     * Determines the amount of crumbs in the parrot's stomach as well as configures the feed option
     *
     * @param crumbs the amount of crumbs
     */
    public void feed(double crumbs) {
        // Determines whether the parrot is alive
        if (!isAlive) {
            System.out.println(this.name + " is dead and cannot be fed.");
            return;
        }
        this.crumbs += crumbs;
        // Determine if the parrot loses health based on how many crumbs it is fed
        if (this.crumbs > 2.5) {
            this.hearts -= 2;
            if (this.hearts <= 0) {
                this.isAlive = false;
                this.isTamed = false;
                System.out.println(this.name + " died.");
            }
        } else if (this.hearts < 3) {
            this.hearts++;
        }
        if (Math.random() < 0.2 * crumbs) {
            this.isTamed = true;
        }
    }

    /**
     * Controls the parrot's behavior, whether it is sitting or flying
     *
     * @param command whether it is sitting or flying
     */
    public void command(String command) {
        if (!isAlive) {
            System.out.println(this.name + "is dead and cannot be commanded.");
            return;
        }
        if (this.isTamed) {
            if (command.equals("sit")) {
                this.isSitting = true;
            } else if (command.equals("fly")) {
                this.isSitting = false;
            }
        } else {
            System.out.println(this.name + " is not tamed and cannot be commanded.");
        }
    }

    /**
     * Allows for a parrot to play with another
     *
     * @param playmate to play with
     */
    public void play(Parrot playmate) {
        if (this.isTamed && playmate.isTamed) {
            this.isTamed = false;
            playmate.isTamed = false;
        } else {
            System.out.println("Both parrots must be tamed in order to play together.");
        }
    }

    /**
     * Allows the user to hit the parrot and deal damage to it
     *
     * @param args unused
     */
    public void hit() {
        if (this.isAlive) {
            this.hearts--;
            if (this.hearts <= 0) {
                this.isAlive = false;
                System.out.println(this.name + " died.");
            }
            this.isTamed = false;
        } else {
            System.out.println("This parrot is dead and cannot be hit.");
        }
    }

    /**
     * Displays the information of each parrot
     *
     * @return status
     */
    public String toString() {
        String status = "";
        if (!this.isAlive) {
            status = "DEAD ";
        }
        if (this.isTamed) {
            status += "Tamed ";
        } else {
            status += "Untamed ";
        }
        status += this.name + ": " + this.crumbs + "kg crumbs, " + this.hearts + " hearts";
        if (this.isTamed && this.isSitting) {
            status += ", sitting";
        } else if (!this.isTamed || !this.isSitting) {
            status += ", flying";
        }
        return status;
    }

    /**
     * @return The name of the parrot
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the parrot
     *
     * @param name of the parrot
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Number of hearts of the parrot
     */
    public int getHearts() {
        return hearts;
    }

    /**
     * Set the number of hearts of the parrot
     *
     * @param hearts Number of hearts of the parrot
     */
    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    /**
     * @return Amount of crumbs in the parrot's stomach
     */
    public double getCrumbs() {
        return crumbs;
    }

    /**
     * Set the amount of crumbs in the parrot's stomach
     *
     * @param crumbs Amount of crumbs in the parrot
     */
    public void setCrumbs(double crumbs) {
        this.crumbs = crumbs;
    }

    /**
     * @return Whether the parrot is tamed
     */
    public boolean isTamed() {
        return isTamed;
    }

    /**
     * Set whether the parrot is tamed
     *
     * @param tamed Whether the parrot is tamed
     */
    public void setTamed(boolean tamed) {
        isTamed = tamed;
    }

    /**
     * @return Whether the parrot is alive
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Set whether the parrot is alive
     *
     * @param alive Whether the parrot is alive
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * @return Whether the parrot is sitting
     */
    public boolean isSitting() {
        return isSitting;
    }

    /**
     * Set whether the parrot is sitting
     *
     * @param sitting Whether the parrot is sitting
     */
    public void setSitting(boolean sitting) {
        isSitting = sitting;
    }
}

