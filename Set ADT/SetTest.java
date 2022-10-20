// 
//  Name:   Hung, Kayden 
//  Project:  #2 
//  Due:        10/7/2022 
//  Course:  cs-2400-02
// 
//  Description: 
//    Tester for LinkSet class and all of the features it holds
//     

import java.util.Arrays;

public class SetTest
{

	public static void main(String[] args)
	{

		System.out.println("Set ADT by K. Hung\n");
		System.out.println("Case 1 ---------------------------------------------------------------------------------\n");

		SetInterface<Integer> Aset1 = new LinkedSet<>();
		SetInterface<Integer> Bset1 = new LinkedSet<>();

		Aset1.add(2);
		Aset1.add(1);
		Aset1.add(940); 
		Aset1.add(3);
		Aset1.add(8);
		System.out.println(Arrays.toString(Aset1.toArray()));

		Bset1.add(940);
		Bset1.add(8);
		Bset1.add(3);
		Bset1.add(2);
		Bset1.add(1);
		System.out.println(Arrays.toString(Bset1.toArray()));
		System.out.println();

		System.out.println(Aset1.subset(Bset1));
		System.out.println(Bset1.subset(Aset1));
		System.out.println(Aset1.equals(Bset1));
		System.out.println();
		
		// SetInterface<Integer> Cset1 = Aset1.union(Bset1);
		System.out.println(Arrays.toString(Cset1.toArray()));
		System.out.println(Cset1.toString());
		System.out.println();

		System.out.println(Aset1.getCurrentSize());
		System.out.println(Aset1.isEmpty());
		System.out.println(Aset1.remove());
		System.out.println(Aset1.remove(1));
		System.out.println(Aset1.remove(5));
		System.out.println(Aset1.toString());
		System.out.println(Aset1.getCurrentSize());
		System.out.println();

		System.out.println(Bset1.add(2));
		System.out.println(Bset1.getFrequencyOf(2));
		System.out.println(Bset1.contains(2));
		System.out.println(Bset1.contains(5));
		Bset1.clear();
		System.out.println(Bset1.isEmpty());


		System.out.println("\n\nCase 2 ---------------------------------------------------------------------------------\n");

		SetInterface<Integer> Aset2 = new LinkedSet<>();
		SetInterface<Integer> Bset2 = new LinkedSet<>();
		Aset2.add(1);

		Bset2.add(1);
		Bset2.add(2);

		System.out.println(Aset2.subset(Bset2));
		System.out.println(Bset2.subset(Aset2));
		System.out.println(Aset2.equals(Bset2));
		System.out.println();
		
		// SetInterface<Integer> Cset2 = Aset2.union(Bset2);
		System.out.println(Cset2.toString());


		System.out.println("\n\nCase 3 ---------------------------------------------------------------------------------\n");

		SetInterface<Integer> Aset3 = new LinkedSet<>();
		SetInterface<Integer> Bset3 = new LinkedSet<>();
		Aset3.add(1);
		Aset3.add(2);
		Aset3.add(3);

		Bset3.add(2);
		Bset3.add(3);
		Bset3.add(4);
		Bset3.add(5);

		System.out.println(Aset3.subset(Bset3));
		System.out.println(Bset3.subset(Aset3));
		System.out.println(Aset3.equals(Bset3));
		System.out.println();
		
		// SetInterface<Integer> Cset3 = Aset3.union(Bset3);
		System.out.println(Cset3.toString());


		System.out.println("\n\nCase 4 ---------------------------------------------------------------------------------\n");

		SetInterface<Integer> Aset4 = new LinkedSet<>();
		SetInterface<Integer> Bset4 = new LinkedSet<>();
		Aset4.add(1);

		Bset4.add(2);
		Bset4.add(3);

		System.out.println(Aset4.subset(Bset4));
		System.out.println(Bset4.subset(Aset4));
		System.out.println(Aset4.equals(Bset4));
		System.out.println();
		
		// SetInterface<Integer> Cset4 = Aset4.union(Bset4);
		System.out.println(Cset4.toString());


		System.out.println("\n\nCase 5 ---------------------------------------------------------------------------------\n");

		SetInterface<Integer> Aset5 = new LinkedSet<>();
		SetInterface<Integer> Bset5 = new LinkedSet<>();

		Bset5.add(2);
		Bset5.add(3);

		System.out.println(Aset5.subset(Bset5));
		System.out.println(Bset5.subset(Aset5));
		System.out.println(Aset5.equals(Bset5));
		System.out.println();
		
		// SetInterface<Integer> Cset5 = Aset5.union(Bset5);
		System.out.println(Cset5.toString());

	}
}