package assignment4;


import java.awt.Color;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import edu.princeton.cs.introcs.StdDraw;

public class ZombieData {

	public static void main(String[] args) throws Exception {
		// NOTE: The lines below will prompt the user with a file open dialog box.
		//       The contents of the selected file will be made available via the ArgsProcessor ap.
		JFileChooser chooser = new JFileChooser("zombieSims");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
		// TODO: 1. Read in the number of entities from Scanner
		int numEntities = in.nextInt();

		// TODO: 2. Create the arrays that will hold entity data
		boolean[] areZombies = new boolean[numEntities];
		double[][] xs=new double[numEntities][2];

		// TODO: 3. Read in all the Entity data
		for (int j=0;j<numEntities;j++){
			areZombies[j]=(in.next().equals("Zombie"));
			xs[j][0]=in.nextDouble();
			xs[j][1]=in.nextDouble();
		}

		// TODO: 4. Iterate through all the data and display it using StdDraw
		StdDraw.setPenRadius(0.01);
		int non_Zombie=0;
		for (int j=0;j<numEntities;j++){
			if (areZombies[j]){
				StdDraw.setPenColor(StdDraw.RED);
			}
			else{
				StdDraw.setPenColor(StdDraw.BLUE);
				non_Zombie+=1;
			}
			StdDraw.point(xs[j][0],xs[j][1]);
		}
		StdDraw.text(0.9,0.1,non_Zombie+"/"+numEntities);
		//StdDraw.show();

	}
}
