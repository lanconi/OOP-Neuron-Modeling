package rsd.math;

import java.io.Serializable;

/**
 * This final nonextendable class will execute
 * the appropriate activation function, depending
 * on the selection
 * 
 * 	GAUSSIAN
 * 	LINEAR
 * 	PIECEWISE_LINEAR
 * 	SIGMOIDAL
 * 	UNIT_STEP
 * 
 * @author Lance Dooley, Robotic Systems Design (rsd)
 *
 */
public final class ActivationFunction implements Serializable 
{
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	
	private ActivationFunctionEnum afe;
	
	private double threshold = 0.0d;
	
	private double pieceWiseLinearLower = -0.5d;
	private double pieceWiseLinearUpper =  0.5d;

	
	/**
	 * Default constructor creates an instance of ActivationFunction set
	 * to use ActivationFunctionEnum.SIGMOIDAL
	 * 
	 */
	public ActivationFunction()
	{
		this.afe = ActivationFunctionEnum.UNIT_STEP;
	}
	
	/**
	 * 
	 * @param afe ActivationFunctionEnum
	 */
	public ActivationFunction(ActivationFunctionEnum afe)
	{
		this.afe = afe;
	}
	
	/**
	 * 
	 * @param afe
	 */
	public void setSelection(ActivationFunctionEnum afe)
	{
		this.afe = afe;
	}
	
	/**
	 * 
	 * @return ActivationFunctionEnum
	 */
	public ActivationFunctionEnum getSelection()
	{
		return afe;
	}
	
	/**
	 * 
	 * @param threshold
	 */
	public void setThreshold(double threshold)
	{
		this.threshold = threshold;
	}
	
	/**
	 * 
	 * @param threshold
	 */
	public double getThreshold()
	{
		return threshold;
	}
	
	/**
	 * 
	 * @param d  double
	 * @return
	 */
	public double compute(double d)
	{				
		double output = 0.0;
		
		// use a switch statement to determine which
		// activation function to use
		switch(afe)
		{
			case GAUSSIAN:
				output = gaussian(d);
				break;
			case LINEAR:
				output = linear(d);
				break;
			case PIECEWISE_LINEAR:
				output = pieceWiseLinear(d);
				break;
			case SIGMOIDAL:
				output = sigmoidal(d);
				break;
			case UNIT_STEP:
				output = unitStep(d);
				break;
			default:
				output = sigmoidal(d);
				break;
		}
		
		return output; // dendrites.computeNetInput();
	}

	/**
	 * returns the Gaussian pdf (probability density function)
	 * @param x
	 * @return
	 */
	public double gaussian(double x)
	{
		return 	java.lang.Math.exp(-x*x / 2);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	public double linear(double x)
	{
		return x;
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	public double pieceWiseLinear(double x)
	{
		if( x < pieceWiseLinearLower )
			return 0.0d;
		else if( x > pieceWiseLinearLower &&
				 x < pieceWiseLinearUpper )
		{
			return x + 0.5d;
		} else {
			return 1;
		}
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	public double sigmoidal(double x)
	{
		//System.out.println("sigmoidal parameter ..." + x );
		return 1d / (1 + java.lang.Math.exp(-x));
	}
	
	/**
	 * Unit Step with a threshold. If input x is
	 * equal or greater than threshold, then method returns
	 * a 1. Otherwise, method returns a 0.
	 * 
	 * @param x double
	 * @return
	 */
	public double unitStep(double x)
	{
		//System.out.println("unitStep: " + x);
		if( x < threshold)
		{		
			//System.out.println("unitStep: " + 
			//					x  + " < " + threshold);
			return 0d;
		}
		else		
		{
			//System.out.println("unitStep: " + 
			//		x  + " >= " + threshold);
			return 1d;
		}
	}

} // ActivationFunction
