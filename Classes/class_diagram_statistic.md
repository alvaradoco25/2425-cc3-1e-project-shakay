```mermaid

classDiagram
    class Statistic {
        - int health
        - int attackPower
        - int defense
        - int experience
        - int level
        + increaseExperience(int amount)
        + takeDamage(int damage)
        + heal(int amount)
        + levelUp()
        + displayStats()
    }