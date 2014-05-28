package combat;
import characters.Creature.TypeOfDamage;

import java.util.Random;




public class DmgCalculation {
	static private int[] totalDmg = new int[3]; // [physical, magic, void]
	static private Random rand = new Random();

	
	public static void main(String[] args){
	
		DmgCalculation.damageCalculator(101, 100, 499, 10, TypeOfDamage.PHYSICALDMG);
		System.out.println("PHY: " + totalDmg[0] + ", MAG: " + totalDmg[1] + ", VOID: " + totalDmg[2]);
	}
	
	
	

	public static int[] damageCalculator(int maxDmg, int minDmg, int armour, int magicRes, TypeOfDamage dmgType){
		int temp;
		
		switch(dmgType){
		case PHYSICALDMG:
			System.out.println("PSYC");
			totalDmg[0]=physicalVsArmour(rand.nextInt(maxDmg-minDmg+1) + minDmg, armour);
			totalDmg[1]=0;
			totalDmg[2]=0;
			break;

		case MAGICDMG:
			System.out.println("MAGICCCCC");
			totalDmg[0]=0;
			totalDmg[1]=magicVsMagicRes(rand.nextInt(maxDmg-minDmg+1) + minDmg, magicRes);
			totalDmg[2]=0;
			break;

		case VOIDDMG:
			System.out.println("VOIIIIIIID");
			totalDmg[0]=0;
			totalDmg[1]=0;
			totalDmg[2]=(rand.nextInt(maxDmg-minDmg+1) + minDmg);
			break;

		case HYBRIDDMG:
			System.out.println("HYPE!");
			int physical, magic;
			temp=rand.nextInt(maxDmg-minDmg) +1;
			physical=rand.nextInt(temp+1);
			magic=((temp-physical));

			totalDmg[0]=physicalVsArmour(physical+minDmg/2, armour);
			totalDmg[1]=magicVsMagicRes(magic+minDmg/2, magicRes);
			totalDmg[2]=0;
			break;

		case RANDOMDMG:
			System.out.println("RANDOM");
			int physicalDmg, magicDmg, voidDmg;
			temp=rand.nextInt(3);
			if(temp==0){
				temp=rand.nextInt(maxDmg+1-minDmg)+minDmg;
				physicalDmg = rand.nextInt(temp);
				temp=temp-physicalDmg;
				totalDmg[0]=physicalVsArmour(physicalDmg, armour);
				magicDmg = rand.nextInt(temp);
				temp=temp-magicDmg;
				totalDmg[1]=magicVsMagicRes(magicDmg, magicRes);
				totalDmg[2]=temp;
			}
			if(temp==1){
				temp=rand.nextInt(maxDmg+1-minDmg) +minDmg;
				magicDmg = rand.nextInt(temp);
				temp=temp-magicDmg;
				totalDmg[1] = magicVsMagicRes(magicDmg, magicRes);
				physicalDmg = rand.nextInt(temp);
				temp=temp-physicalDmg;
				totalDmg[0]=physicalVsArmour(physicalDmg, armour);
				totalDmg[2]=temp;
			}
			else{
				temp=rand.nextInt(maxDmg+1-minDmg) +minDmg;
				voidDmg = rand.nextInt(temp);
				temp=temp-voidDmg;
				totalDmg[2]=voidDmg;
				physicalDmg = rand.nextInt(temp);
				temp=temp-physicalDmg;
				totalDmg[0]=physicalVsArmour(physicalDmg, armour);
				totalDmg[1]=magicVsMagicRes(temp, magicRes);
			}
			break;
		}
		return totalDmg;
	}

	static int physicalVsArmour(int unReducedDmg, int armour){
		if (armour >= 500){
			return (int) (unReducedDmg*(0.24));
		}
		else if(armour <= 10) {
			return (int) (unReducedDmg*(1-calculatArmorTen(armour)));
		} 
		else if(armour <= 30) {
			return (int) (unReducedDmg*(1-calculatArmorThirty(armour)));
		}
		else if(armour <= 60) {
			return (int) (unReducedDmg*(1-calculatArmorSixty(armour)));
		}
		else if(armour <= 120) {
			return (int) (unReducedDmg*(1-calculatArmorHundredTwenty(armour)));
		}
		else if(armour <= 220) {
			return (int) (unReducedDmg*(1-calculatArmorTwoHundredTwenty(armour)));
		}
		else if(armour <= 320) {
			return (int) (unReducedDmg*(1-calculatArmorTreHundredTwenty(armour)));
		}
		else if(armour < 500) {
			return (int) (unReducedDmg*(1-calculatArmorFiveHundred(armour)));
		}
		return unReducedDmg;
	}

	// 10 Armour = 5% reduction
	static double calculatArmorTen(int armour){
		return (armour*0.5/100);
	}

	// 30 Armour = 13% reduction
	static double calculatArmorThirty(int armour){
		return (calculatArmorTen(10) + (armour-10)*0.4/100);
	}

	// 60 Armour = 22% reduction
	static double calculatArmorSixty(int armour){
		return (calculatArmorThirty(30) + (armour-30)*0.3/100);
	}

	// 120 Armour = 37% reduction
	static double calculatArmorHundredTwenty(int armour){
		return (calculatArmorSixty(60) + (armour-60)*0.25/100);
	}

	// 220 Armour = 57% reduction
	static double calculatArmorTwoHundredTwenty(int armour){
		return (calculatArmorHundredTwenty(120) + (armour-120)*0.20/100);
	}

	// 320 Armour = 67% reduction
	static double calculatArmorTreHundredTwenty(int armour){
		return (calculatArmorTwoHundredTwenty(220) + (armour-220)*0.10/100);
	}

	// 500 Armour = 76% reduction
	static double calculatArmorFiveHundred(int armour){
		return (calculatArmorTreHundredTwenty(320) + (armour-320)*0.05/100);
	}


	static int magicVsMagicRes(int unReducedDmg, int magicRes){
		if (magicRes<=0) {
			return unReducedDmg;
		}
		else if (magicRes>75){
			return (unReducedDmg*(75/100));
		}
		else{
			System.out.println("unReducedDmg: " + unReducedDmg);
			System.out.println("magicres: " + magicRes);
			int temp = ((100-magicRes)*unReducedDmg/100);
			System.out.println("temp: " + temp);
			return temp;
		}
	}

}
