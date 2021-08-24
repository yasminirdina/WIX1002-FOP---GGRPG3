/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ggrpg3.hannah;

import java.util.Random;

public class Combat {

    private int health;
    private int strength;
    private int level;
    private String name;
    private Combat Chicken;
    private Combat player;
    
    public Combat(int health, int strength, int level, String name) {

        this.health = health;
        //this.strength = strength;
        this.level = level;
        this.name = name;
    }
    

    public static void battle(Combat player, Combat Chicken) throws InterruptedException {
        System.out.println("-----BATTLE START!-----\n");
        do {
            Random rand = new Random();
            //player attack chicken
            //generate player strength
            player.strength = rand.nextInt(50) + 1; //1 -> 50
            //calc enemy's health left
            Chicken.health = Chicken.health - player.strength;
            //display the battle
            System.out.printf("-- %s ATTACKS! --\n", player.name);
            System.out.println(player.name + "'s attack strength: " + player.strength);
            System.out.println(Chicken.name + "'s health left: " + Chicken.health);

            if (Chicken.health < 1 || player.health < 1) {
                break;
            }
            
            Thread.sleep(1000); // delay
            //chicken counterattack player
            //generate chicken's strength
            Chicken.strength = rand.nextInt(25) + 1; //1 -> 25
            //calc player's health left
            player.health = player.health - Chicken.strength;
            //display the battle
            System.out.printf("-- %s ATTACKS! --\n", Chicken.name);
            System.out.println(Chicken.name + "'s attack strength: " + Chicken.strength);
            System.out.println(player.name + "'s health left: " + player.health);

            if (Chicken.health < 1 || player.health < 1) {
                break;
            }

            System.out.println("");
        } while (player.health >= 1 && Chicken.health >= 1);

        if (player.health < 1) {
            //Chicken.level++;
            //System.out.println("\nCurrent enemy level:"+ Chicken.level);
            System.out.println("\nYou lost! Enemy has won the fight."); //lost the fight
        } else if (Chicken.health < 1) {
            player.level++;
            System.out.println("\nYou won! Levelling up...");
            System.out.println("Current player level: " + player.level);
            System.out.println("-- GAME OVER --");
        }
    }
    
    public static void main(String[] args) throws InterruptedException {

        Combat player = new Combat(100, 50, 1, "ali");
        Combat Chicken = new Combat(150, 25, 1, "jahat");
        Combat.battle(player, Chicken);
    }
}
