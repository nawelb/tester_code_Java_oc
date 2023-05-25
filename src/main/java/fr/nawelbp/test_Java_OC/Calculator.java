package fr.nawelbp.test_Java_OC;

public class Calculator {

	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	public void longCalculation() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
