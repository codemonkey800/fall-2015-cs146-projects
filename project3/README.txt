Jeremy Asuncion
Phyllis Lau

Our group consists of Jeremy Asuncion and Phyllis Lau. This project took us about 15 hours to complete. 
Before starting, we expected the hash table to be the fastest due to its average running time of O(1), 
and expected BSTs and AVL trees to be slower.

As it turns out, the BST is the fastest. We were wrong because we didn’t consider the extra time for the hash table 
when it needed to insert more elements than it could hold. Therefore, rehashing contributes to additional time, 
making the hash table actually slower than the BST. 

In our benchmarks, BSTs turned out to be faster. From this, we were wrong in our expectations. 
But there's a lot of things to take into account with these results. 
One thing to consider is that the hashtable has to do rehashing when the load factor goes over 0.75, 
so that may have slowed down the true running time of the hashtable.

Despite the results, we believe that hashtables are still better. 
Implementing a hashtable is not that difficult (In comparison to BSTs and especially AVL trees). 
Debugging is also simpler for hashtables because the data is structured in a simpler fashion, 
in comparsion to a BST, and especially an AVL tree which can be difficult to visualize. 
Memory usage wise, hashtables may not be the best since hashtables require allocation of an array that 
may not have all of its buckets filled. On average, hashtables outperform BSTs 
and AVL trees due to its O(1) running time. In the worst case, hashtables and BSTs are the same: O(n), 
whereas AVL trees run much slower due to its rigid balance factor.

In comparison to BSTs and hashtables, AVL trees performed really badly, 
with an average measured time of 1.750s for execution. BSTs and hashtables are very close, 
but in BSTs somehow outperform hashtables. So in order of speed: BSTs, hashtables, AVL trees. 
Again, we still think hashtables can be potentially faster. Perhaps more needed optimizations are required.

Based on the data returned from the Correlator program, we conclude that Bacon did write Shakespeare's plays. 
The Correlator program returned a difference metric of 5.799e-4, 
which is a significantly small value for the difference metric. To further confide our conclusion, 
we ran Correlator against The New Atlantis and this README.txt. 
The Correlator program returned a difference metric of 9.707e-4. 
Of course, this is expected since Bacon did not write this README.txt (That would be funny, however). 
Given the much larger difference, it's reasonable to assume that Bacon did write Shakespare's plays, 
but still, our conclusion should be taken with a grain of salt since 5.799e-4 is small, it's not terribly small.

The tables for our benchmarks are in the benchmarks.pdf file. 
For our benchmarks, we used the time command and we measured user time as per suggested. 
Using this as measurement, we attributed "better" to be executions that resulted in smaller times. 
This measurement is interesting because it's a test for raw speed, rather than using a 
typical conceptual model like the RAM model used in running time analysis. 
For benchmarking, we ran 10 speed tests for a single command and logged those tests. 
To get an idea of the overal speed, we then averaged the speed. 

There are many potential sources of error in our benchmarks. For example, the amount of test cases
may have been too small. But considering the difference between run times are small, we don't have
to worry that much about it. Other sources of error could include the time required by the JVM to
bootstrap an application. count.sh is ran using the cat command, which is written in C. 
Although the JVM is getting much faster these days, we must deny that for a program such as this,
the C implementaion is significantly faster. Also, the WordCount program has the job of printing the
resulting frequencies in two different orders. That means we have to sort it into both orders using
a comparator. This could have also made the running time of WordCount longer in comparison
to the count.sh script.

The results of the benchmarks allowed us to interpret the speed of certain data structures.
In general, it seemd that BSTs performed the BST, hash tables second, and AVL trees last.
We used both WordCount and Correlator programs for our benchmarks, and both concede to the same
results. 

Although BSTs exceeded our expectations, we still concluded hashtables to be the better data structure.
Admittedly, BSTs performed much better, but there is much to consider. For one, maybe our implementation
of hashtable was bad. Or perhaps the rehasing took a toll on the running time of hashtables. But overall,
we conclude that hashtables are still the better data structure for such an application, with BSTs second
and AVL trees third.

For future study, an interesting perspective to take on is to guess the amount of unique words
in a document, and then constructing a hashtable with just enough space for those words. That way,
rehasing is done at a minimum (Or not at all), and thus rehashing doesn't have to occur. Rehasing
is often a O(n^2) time algorithm, and allocating an array large enough to hold all data would elimnate
that, possibly resulting in a faster execution time for the Correlator and WordCount programs.

Overal, both Phyllis and I enjoyed this project. Phyllis enjoyed writing the Correlator class and tester class
for HashTable, but she disliked implementing the hashtable itself. I enjoyed the majority of this project
except for writing the tester for AVL (Nooooo) and doing the actual benchmarking process. But overall, the
project was fun and should be given again next year!
