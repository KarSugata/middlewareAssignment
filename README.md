# middlewareAssignment

Compile the CalculatorServer.java program using: javac CalculatorServer.java. It will produce the .class file in the same directory.

Compile the CalculatorClient.java program using: javac CalculatorClient.java. It will produce the .class file in the same directory.

Start orbd. (start orbd -ORBInitialPort 1050)

Start the CalculatorServer using: start java CalculatorServer -ORBInitialPort 1050 -ORBInitialHost localhost

Start the CalculatorServer using: java CalculatorClient -ORBInitialPort 1050 -ORBInitialHost localhost
