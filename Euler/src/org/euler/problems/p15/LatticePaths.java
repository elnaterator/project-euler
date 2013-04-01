package org.euler.problems.p15;

public class LatticePaths {
	
	private long[][] pathMap;

	public LatticePaths(int x, int y) {
		this.pathMap = new long[x][y];
	}

	public static void main(String... args) {

		long start = System.currentTimeMillis();
		
		int x = 30;
		int y = 30;
		LatticePaths lp = new LatticePaths(x,y);
		long paths = lp.numPaths(x, y);
		
		long end = System.currentTimeMillis();
		
		System.out.println("There are " + paths + " paths for a " + x + "x" + y
				+ " grid.  " + (end - start) + "ms");

	}

	public long numPaths(int x, int y) {
		// Its the sum of the paths to get to the 2 adjacent points.
		if(x==0 || y==0)
			return 1;
		else {
			long num = pathMap[x-1][y-1] > 0 ? pathMap[x-1][y-1] : numPaths(x-1,y) + numPaths(y-1,x);
			this.pathMap[x-1][y-1] = num;
			return num;
		}
	}
}
