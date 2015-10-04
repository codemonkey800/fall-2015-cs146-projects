Jeremy Asuncion
Phyllis Lau


Our group consists of Jeremy Asuncion and Phyllis Lau. This project took us about 15 hours to complete. Before starting, we expected the hash table to be the fastest due to its runtime ability of O(1) to get and modify information [on average]  whereas the other data structures - AVLTree and BST - are slower in doing the same functions.

As it turns out, the BST is the fastest. We were wrong because we didn’t consider the extra time for the hash table when it needed to insert more elements than it could hold. Therefore, rehashing contributes to additional time, making the hash table actually slower than the BST. 


This is because the AVLTree takes time to rebalance after inserting, as does the HashTable with rehashing as it needs to grow and insert the elements again.

In general, hash tables is the better implementation. In terms of coding and debugging, hash tables are relatively simpler than trees. There is no need to consider options of placing an element into the hash table after using a hash function, whereas we must recursively go through multiple nodes to find the correct place.  


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
