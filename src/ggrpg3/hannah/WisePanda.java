/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ggrpg3.hannah;

import ggrpg3.GetEverything;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fifa
 */
public class WisePanda extends InteractNPC {
    Random random = new Random();
    Scanner input = new Scanner(System.in);
   
   
public WisePanda() {
    name= "Wise Panda";
    id="Wise Panda";
    desc="He's a panda, but hey look, he's wise!";
    hp=75;
}

public static void display() throws InterruptedException{
    System.out.println(name);
    System.out.println(desc);
    System.out.println("HP:"+hp);
    Thread.sleep(1000);



}

public void dialogue1(){
    int selection = random.nextInt(3);
    
    if (selection == 0)
    System.out.println("Young man, you seem in trouble.");
    
    
    if (selection == 1) {
        System.out.println("Do you need some recovery? Y/N");
        char ans = input.next().charAt(0);
        if (ans == 'Y' || ans == 'y')
            hp = hp + heal();
        if (ans == 'N' || ans == 'n')
            System.out.println("Okay.");
        
    }
    
    
    if (selection == 2)
    System.out.println("I know fighting with the Slime is no easy.");
    
    
    if (selection == 3)
    System.out.println("But of course...you need justice. I won't let you down.");
}
    
    
    
    public int heal (){
       Random r = new Random();
        System.out.println("By the power I have, I shall return you to the great health");
        int maxheal=25;
        int healpoint=r.nextInt(maxheal)+10;
        System.out.println("You gained "+healpoint+" Health!");
        System.out.println("Ok now? Go young man!  ");
        return healpoint;
    
    }

    
   



}


