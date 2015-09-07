SecretaryProblemSimulator
=========================

structure:

                   view
                    |
                controller
                    |
Oracle Factory-- Mediator --matroid factory
       |            |          |
(Oracle)        algorithm    (matroid)
                 builder
                    |
        parser, tokeniser, algorithms


Entry point is via GUI.Main
The text fields at the top must contain numbers (doubles), while the bottom one should refer to an algorithm by name.
Currently these are Traditional and test.
All fields are compulsory.
When modelling integer candidate sets, the values correspond to ax^3 + bx^2 +cx + d.

The list of oracles and matroid types can be found in the mediator. An example algorithm can be found at test.txt

> To add a new algorithm:
Implement the Algorithm Interface
Write the code for the algorithm itself. Candidates will be in the form of a ComparableObject.
To include additional methods for these, add them there, or to the specific type of candidate.

Add Algorithm by name to the AlgorithmBuilder.


> To add a new candidate type:
Implement the ComparableObject abstract class.
Add to the ComparableObjectBuilder a new case for which to use it.
You must also include a new Randomiser for it

Note that to include it within pseudocode algorithms you will need to add it to the grammar as well.


> To add a new Oracle
Implement the Oracle Interface.
Add to the OracleFactory a reference for your Oracle
Add it to the Mediator.getOracles()


> To Implement a new Randomiser
Implement the Randomiser Interface.
Add a reference to it into RandomiserFactory, within the switch statement.
Add the same reference to Mediator.getMatroids()

To modify the appearance, use the .CSS file.