package com.jay.ml.ai.learnings;

public class LinearRegressionFunctionMain {
  
  public static void main(String[] args) {
    double[] thetaVector = new double[] { 1.004579, 5.286822 };
    LinearRegressionFunction targetFunction = new LinearRegressionFunction(thetaVector);

    // create the feature vector function with x0=1 (for computational reasons) and x1=house-size
    // constant value being 1.0 and second being the size of the house.
    Double[] featureVector = new Double[] { 1.0, 1330.0 };

    // make the prediction
    double predictedPrice = targetFunction.apply(featureVector);
    System.out.println(predictedPrice);
  }
}