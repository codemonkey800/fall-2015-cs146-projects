Jeremy Asuncion
Phyllis Lau


Our group consists of Jeremy Asuncion and Phyllis Lau. This project took us about 15 hours to complete. Before starting, we expected the hash table to be the fastest due to its average running time of O(1), and expected BSTs and AVL trees to be slower.

As it turns out, the BST is the fastest. We were wrong because we didn’t consider the extra time for the hash table when it needed to insert more elements than it could hold. Therefore, rehashing contributes to additional time, making the hash table actually slower than the BST. 

In our benchmarks, BSTs turned out to be faster. From this, we were wrong in our expectations. But there's a lot of things to take into account with these results. One thing to consider is that the hashtable has to do
rehashing when the load factor goes over 0.75, so that may have slowed down the true running time of the hashtable.

Despite the results, we believe that hashtables are still better. Implementing a hashtable is not that difficult (In comparison to BSTs and especially AVL trees). Debugging is also simpler for hashtables because the data is structured in a simpler fashion, in comparsion to a BST, and especially an AVL tree which can be difficult to visualize. Memory usage wise, hashtables may not be the best since hashtables require allocation of an array that may not have all of its buckets filled. On average, hashtables outperform BSTs and AVL trees due to its O(1) running time. 

special cases where one did well or badly
1.
2.
3.



We think that Bacon did/did not write Shakespeare’s plays based on the data we collected …… 1P

Write up benchmarks -


Results listed in charts attached.
Since we didn’t get consistent times for each run, we took the average of 10 runs. 
After these results, we have concluded that 

time for hash table may actually depend on the initial size of the hash table. 



9.  Personally, I (Phyllis) enjoyed writing the Correlator class. I really didn’t like implementing the HashTable.
Jeremy enjoyed working on _____, but didn't like the benchmarking process. 
