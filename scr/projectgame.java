import java.util.*;

class Game {
    private Scanner scanner;
    private Player player;
    private Location currentLocation;

    public Game() {
        scanner = new Scanner(System.in);
        player = new Player("Hero", 100);
        currentLocation = new Location("Forest", "A dark, eerie forest.");

        // Add an enemy and item to the location
        currentLocation.addEnemy(new Enemy("Goblin", 30, 5));
        currentLocation.addItem(new Item("Health Potion"));
    }

    public void start() {
        System.out.println("Welcome to the Text RPG!");
        while (true) {
            System.out.println("\nCurrent Location: " + currentLocation.getName());
            System.out.println("1. Look around\n2. Fight enemy\n3. Pick up item\n4. Quit");
            System.out.print("Choose an action: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: lookAround(); break;
                case 2: fightEnemy(); break;
                case 3: pickUpItem(); break;
                case 4: System.out.println("Thanks for playing!"); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void lookAround() {
        System.out.println(currentLocation.getDescription());
        System.out.println("Enemies: " + currentLocation.getEnemyList().size());
        System.out.println("Items: " + currentLocation.getItemList().size());
    }

    private void fightEnemy() {
        if (currentLocation.getEnemyList().isEmpty()) {
            System.out.println("No enemies here.");
            return;
        }
        Enemy enemy = currentLocation.getEnemyList().get(0);
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("You attack the " + enemy.getName());
            enemy.takeDamage(10);
            if (enemy.getHealth() > 0) {
                System.out.println(enemy.getName() + " attacks you!");
                player.takeDamage(enemy.getAttackPower());
            }
        }
        if (player.getHealth() > 0) {
            System.out.println("You defeated the " + enemy.getName());
            currentLocation.getEnemyList().remove(enemy);
        } else {
            System.out.println("You died!");
            System.exit(0);
        }
    }

    private void pickUpItem() {
        if (currentLocation.getItemList().isEmpty()) {
            System.out.println("No items to pick up.");
            return;
        }
        Item item = currentLocation.getItemList().get(0);
        System.out.println("You picked up: " + item.getName());
        currentLocation.getItemList().remove(item);
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
