Instructions for running the programs:

To run the program that will output the price of the American Put Options:
- put file with inputs in the same directory as AmericanPutOp.java
- each line of input should be tab separated with the following arguments:
    - r (risk free interest rate), T (time to maturity), n (how often to split the tree), v (, S0 (initial stock price at time 0), K (strike price) 
- navigate to the directory where AmericanPutOp.java is
- javac AmericanPutOp.java
- java AmericanPutOp [inputFileName]

To run the program that will output the price of the Asian Call Options:
- put file with inputs in the same directory as AsianCallOp.java
- each line of input should be tab separated with the following arguments:
    - r (risk free interest rate), T (time to maturity), n (how often to split the tree), v (, S0 (initial stock price at time 0), K (strike price)
- navigate to the directory where AsianCallOp.java is
- javac AsianCallOp.java
- java AsianCallOp [inputFileName]


