package fit.fraction;

import fit.ColumnFixture;
import fraction.Fraction;

public class FractionNumDenom extends ColumnFixture{

	public int numerator;
	public int denominator;
	
	public int numerator2;
	public int denominator2;
	
	public int whole;
	public int power;
	
	public double floatingPoint;
	
	public String str;
	
	// Tests below this line need numerator and denominator
	public int getNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		return f.getNumerator();
	}
	
	public int getDenominator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		return f.getDenominator();
	}
	
	public int getReducedNumerator() {
		Fraction f = Fraction.getReducedFraction(numerator, denominator);
		return f.getNumerator();
	}
	
	public int getReducedDenominator() {
		Fraction f = Fraction.getReducedFraction(numerator, denominator);
		return f.getDenominator();
	}
	
	public int getProperNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		return f.getProperNumerator();
	}
	
	public int getProperWhole() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		return f.getProperWhole();
	}
	
	public int getIntValue() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		return f.intValue();
	}
	
	public long getLongValue() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		return f.longValue();
	}
	
	public float getFloatValue() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		return f.floatValue();
	}
	
	public double getDoubleValue() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		return f.doubleValue();
	}
	
	public int getReduceNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator).reduce();
		return f.getNumerator();
	}
	
	public int getReduceDenominator() {
		Fraction f = Fraction.getFraction(numerator, denominator).reduce();
		return f.getDenominator();
	}
	
	public int getInvertNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator).invert();
		return f.getNumerator();
	}
	
	public int getInvertDenominator() {
		Fraction f = Fraction.getFraction(numerator, denominator).invert();
		return f.getDenominator();
	}
	
	public int getNegateNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator).negate();
		return f.getNumerator();
	}
	
	public int getNegateDenominator() {
		Fraction f = Fraction.getFraction(numerator, denominator).negate();
		return f.getDenominator();
	}
	
	public int getAbsNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator).abs();
		return f.getNumerator();
	}
	
	public int getAbsDenominator() {
		Fraction f = Fraction.getFraction(numerator, denominator).abs();
		return f.getDenominator();
	}
	
	public String getString() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		return f.toString();
	}
	
	public String getProperString() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		return f.toProperString();
	}
	
	// Tests below this line need whole, numerator and denominator
	public int getNumeratorFromWhole() {
		Fraction f = Fraction.getFraction(whole, numerator, denominator);
		return f.getNumerator();
	}
	
	public int getDenominatorFromWhole() {
		Fraction f = Fraction.getFraction(whole, numerator, denominator);
		return f.getDenominator();
	}
	
	// Tests below this line need floatingPoint
	public int getNumeratorFromDouble() {
		Fraction f = Fraction.getFraction(floatingPoint);
		return f.getNumerator();
	}
	
	public int getDenominatorFromDouble() {
		Fraction f = Fraction.getFraction(floatingPoint);
		return f.getDenominator();
	}
	
	// Tests below this line need str
	public int getNumeratorFromString() {
		Fraction f = Fraction.getFraction(str);
		return f.getNumerator();
	}
	
	public int getDenominatorFromString() {
		Fraction f = Fraction.getFraction(str);
		return f.getDenominator();
	}
	
	// Tests below this line need power, numerator and denominator
	public int getPowerNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator).pow(power);
		return f.getNumerator();
	}
	
	public int getPowerDenominator() {
		Fraction f = Fraction.getFraction(numerator, denominator).pow(power);
		return f.getDenominator();
	}
	
	// Tests below this line need numerator, denominator, numerator2 and denominator2
	public int getSumNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		Fraction g = Fraction.getFraction(numerator2, denominator2);
		return f.add(g).getNumerator();
	}
	
	public int getSumDenominator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		Fraction g = Fraction.getFraction(numerator2, denominator2);
		return f.add(g).getDenominator();
	}
	
	public int getDifferenceNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		Fraction g = Fraction.getFraction(numerator2, denominator2);
		return f.subtract(g).getNumerator();
	}
	
	public int getDifferenceDenominator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		Fraction g = Fraction.getFraction(numerator2, denominator2);
		return f.subtract(g).getDenominator();
	}
	
	public int getProductNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		Fraction g = Fraction.getFraction(numerator2, denominator2);
		return f.multiplyBy(g).getNumerator();
	}
	
	public int getProductDenominator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		Fraction g = Fraction.getFraction(numerator2, denominator2);
		return f.multiplyBy(g).getDenominator();
	}
	
	public int getQuotientNumerator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		Fraction g = Fraction.getFraction(numerator2, denominator2);
		return f.divideBy(g).getNumerator();
	}
	
	public int getQuotientDenominator() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		Fraction g = Fraction.getFraction(numerator2, denominator2);
		return f.divideBy(g).getDenominator();
	}
	
	public boolean equalsTo() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		Fraction g = Fraction.getFraction(numerator2, denominator2);
		return f.equals(g);
	}
	
	public int compareTo() {
		Fraction f = Fraction.getFraction(numerator, denominator);
		Fraction g = Fraction.getFraction(numerator2, denominator2);
		return f.compareTo(g);
	}
}
