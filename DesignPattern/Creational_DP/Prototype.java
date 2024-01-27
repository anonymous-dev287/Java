package DesignPattern;

import java.util.HashMap;
import java.util.Map;

// Prototype interface
interface PlayerPrototype {
    PlayerPrototype clone();

    void equipWeapon(String weapon);
    void displayLoadout();
}

// Concrete prototypes for different player types
class Sniper implements PlayerPrototype {
    private String weapon;

    public Sniper() {
        this.weapon = "Sniper Rifle";
    }

    @Override
    public PlayerPrototype clone() {
        return new Sniper();
    }

    @Override
    public void equipWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void displayLoadout() {
        System.out.println("Sniper Loadout: " + weapon);
    }
}

class Assault implements PlayerPrototype {
    private String weapon;

    public Assault() {
        this.weapon = "Assault Rifle";
    }

    @Override
    public PlayerPrototype clone() {
        return new Assault();
    }

    @Override
    public void equipWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void displayLoadout() {
        System.out.println("Assault Loadout: " + weapon);
    }
}

// Player manager
class PlayerManager {
    private Map<String, PlayerPrototype> prototypes;

    public PlayerManager() {
        prototypes = new HashMap<>();
    }

    public void addPrototype(String key, PlayerPrototype prototype) {
        prototypes.put(key, prototype);
    }

    public PlayerPrototype createPlayer(String key) {
        return prototypes.get(key).clone();
    }
}

public class Prototype {
    public static void main(String[] args) {
        // Creating and registering player prototypes in the manager
        Sniper sniperPrototype = new Sniper();
        Assault assaultPrototype = new Assault();

        PlayerManager playerManager = new PlayerManager();
        playerManager.addPrototype("Sniper", sniperPrototype);
        playerManager.addPrototype("Assault", assaultPrototype);

        // Creating new players by cloning prototypes
        PlayerPrototype sniperPlayer = playerManager.createPlayer("Sniper");
        PlayerPrototype assaultPlayer = playerManager.createPlayer("Assault");

        // Displaying initial loadouts of cloned players
        sniperPlayer.displayLoadout();  // Output: Sniper Loadout: Sniper Rifle
        assaultPlayer.displayLoadout(); // Output: Assault Loadout: Assault Rifle

        // Customizing loadouts of cloned players
        sniperPlayer.equipWeapon("AWM Sniper Rifle");
        assaultPlayer.equipWeapon("AKM Assault Rifle");

        // Displaying modified loadouts of cloned players
        sniperPlayer.displayLoadout();  // Output: Sniper Loadout: AWM Sniper Rifle
        assaultPlayer.displayLoadout(); // Output: Assault Loadout: AKM Assault Rifle
    }
}
/* The PlayerPrototype interface defines the clone(), equipWeapon(), and displayLoadout() methods.
The Sniper and Assault classes are concrete prototypes implementing the PlayerPrototype interface.
The PlayerManager manages player prototypes and provides a method to create cloned players.
The main method demonstrates creating, registering, and cloning player prototypes with an emphasis on weapon loadouts.

This example allows players to have different initial loadouts and customize their weapons. The Prototype pattern helps in creating
 new player instances by copying existing ones, making it easy to customize individual attributes while reusing the common structure.

*/