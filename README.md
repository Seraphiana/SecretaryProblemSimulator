SecretaryProblemSimulator
=========================

MSc project stuff

structure:

    view
      |
    controller --matroid factory
      |             |
    algorithm    (matroid)

so, regarding what this whole thing is going to do:
the view is going to be written last, because its the least important(?) and yeah, keeps things easiest that way

the controller starts running, and is given an algorithm (does it need an algorithm to run? or given one at run time?)

algorithm specifies what sort of matroid it needs
it also provides a method to evaluate a value,
    considering its matroid and its answer set, and tells the controller if it should be added
        I think this is the most lightweight I can reasonably make it, and it makes the interface/API for it very lightweight.

the matroid factory gives the controller a generated matroid when asked.
    It doesn't do anything else, but is going to need to either be given random values, or make them itself

some sort of random number generator object needs to be there somewhere. Need to look into it more.
    mersenne twister? seems like it'll be much safer to use than a linear congruential generator
    not sure a LCG would be good enough, and I don't really have the time/resources to get into higher rng theory.
    or use a WELL? like, I really don't know what I'm looking at here nor how much it matters
        
        ok, with further thought I get to the issue of actually making the thing. 
        I mean, making a matroid isn't just randomising numbers and throwing them in.
        as I see it, the way to do it would be to specify a range of values, and for each flip a coin for if to include it
        and then iterate over this set for each possible combination. But that would be hopelessly slow and inefficient
            (I think it would be?)
        and whats more, while a matroid doesn't include duplicates, the candidate list may well?
            (is that true? I really don't know. I can hypothetically imagine it, but not for say, graphic matroids)
        in which case I'd need to create the string of candidates, store them as a list, then create sets from them
        but I'm stuck. I have no idea how to create a set from a set randomly.
        

the matroid class is going to specify a matroid.
    kind of need to make it myself, since I can't find something acceptable in the java API
    use just integers to begin with, I suppose? and if there's time maybe add vectors.
    might be worth leaving that sort of stuff as generic everywhere to make it easier to add to
        rather than specifying that its an int, that is.
    has to provide all the elements in list/array form, or some sort of iterator, obviously

so, the algorithm goes into the monstrous bloated controller and the controller asks the factory for a relevant matroid
then we can run some sort of loop over the list of elements, as provided by the matroid, and check each one
assemble a solution set item by item until we're done then return

the view will need to provide some methods for the controller, insert this into the loop at the end, I guess.



Bluh Bluh Bluh get rid of all of that. Start over (kind of)

        main.GUI
         |
        Display
         |
        main.Controller - main.Algorithm
         |        \    |?
        Oracle    main.Randomiser
        
so, the Gui is a thing, using javafx. The Display sends it stuff to use and look pretty
    I need to work out how this works.

the controller is an actual controller (Woo!)

the algorithm says what to do each time (like, the algorithm itself)

the oracle tells you whether a given value is allowable.

the randomiser gets told what size set you want to use, and randomises the order, gives all that list to the algorithm.

now add a factory: will let me add different kinds of matroid (eg vectors)