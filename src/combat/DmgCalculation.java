package combat;

import java.util.Random;

public class DmgCalculation {
	int[] totalDmg = new int[3]; // [physical, magic, void]
	Random rand = new Random();


	int[] damageCalculator(int maxDmg, int minDmg, int armour, int magicRes, TypeOfDamage dmgType){

		switch(dmgType){
		case PHYSICALDMG:
			totalDmg[0]=physicalVsArmour(rand.nextInt(maxDmg-minDmg) + minDmg+1, armour);
			totalDmg[1]=0;
			totalDmg[2]=0;

		case MAGICDMG:
			totalDmg[0]=0;
			totalDmg[1]=magicVsMagicRes(rand.nextInt(maxDmg-minDmg) + minDmg+1, magicRes);
			totalDmg[2]=0;

		case VOIDDMG:
			totalDmg[0]=0;
			totalDmg[1]=0;
			totalDmg[2]=(rand.nextInt(maxDmg-minDmg) + minDmg+1);

		case HYBRIDDMG:
			int temp, physical, magic;
			temp=rand.nextInt(maxDmg-minDmg) +1;
			physical=rand.nextInt(temp+1);
			magic=((temp-physical));

			totalDmg[0]=physicalVsArmour(physical+minDmg/2, armour);
			totalDmg[1]=magicVsMagicRes(magic+minDmg/2, magicRes);
			totalDmg[2]=0;

		case RANDOMDMG:
			int temp, physicalDmg, magicDmg, voidDmg;
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
		}
		return totalDmg;
	}

	int physicalVsArmour(int unReducedDmg, int armour){
		if (armour >= 500){
			return (int) (unReducedDmg*(0.76));
		}
		else if(armour <= 10) {
			return (unReducedDmg*calculatArmorTen(armour));
		} 
		else if(armour <= 30) {
			return (unReducedDmg*calculatArmorThirty(armour));
		}
		else if(armour <= 60) {
			return (unReducedDmg*calculatArmorSixty(armour));
		}
		else if(armour <= 120) {
			return (unReducedDmg*calculatArmorHundredTwenty(armour));
		}
		else if(armour <= 220) {
			return (unReducedDmg*calculatArmorTwoHundredTwenty(armour));
		}
		else if(armour <= 320) {
			return (unReducedDmg*calculatArmorTreHundredTwenty(armour));
		}
		else if(armour < 500) {
			return (unReducedDmg*calculatArmorFiveHundred(armour));
		}
		return unReducedDmg;
	}

	// 10 Armour = 5% reduction
	int calculatArmorTen(int armour){
		return (int) (armour*0.5/100);
	}

	// 30 Armour = 13% reduction
	int calculatArmorThirty(int armour){
		return (int) (calculatArmorTen(10) + (armour-10)*0.4/100);
	}

	// 60 Armour = 22% reduction
	int calculatArmorSixty(int armour){
		return (int) (calculatArmorThirty(30) + (armour-30)*0.3/100);
	}

	// 120 Armour = 37% reduction
	int calculatArmorHundredTwenty(int armour){
		return (int) (calculatArmorSixty(60) + (armour-60)*0.25/100);
	}

	// 220 Armour = 57% reduction
	int calculatArmorTwoHundredTwenty(int armour){
		return (int) (calculatArmorHundredTwenty(120) + (armour-120)*0.20/100);
	}

	// 320 Armour = 67% reduction
	int calculatArmorTreHundredTwenty(int armour){
		return (int) (calculatArmorTwoHundredTwenty(220) + (armour-220)*0.10/100);
	}

	// 500 Armour = 76% reduction
	int calculatArmorFiveHundred(int armour){
		return (int) (calculatArmorTreHundredTwenty(320) + (armour-320)*0.10/100);
	}


	int magicVsMagicRes(int unReducedDmg, int magicRes){
		if (magicRes>=0) {
			return unReducedDmg;
		}
		else if (magicRes>75){
			return (unReducedDmg*(75/100));
		}
		else{
			return (unReducedDmg*(magicRes/100));
		}
	}

}
