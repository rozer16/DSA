https://takeuforward.org/binary-tree/introduction-to-trees/
https://takeuforward.org/binary-tree/binary-tree-representation-in-c/
https://takeuforward.org/binary-tree/binary-tree-representation-in-java/

What is a tree data structure?


There are two major types of data structures:

Linear
Non-Linear
Tree is a Non-linear data structure
where as Arrays,LinkedList are linear data structures.


What makes tree a non-linear data structure is, the information or data is not stored in a sequential fashion,
same is for traversal or retrieval.
Unlike, in arrays, we know that elements are stored at contiguous memory locations,
however, it is not the same with trees. The nodes in a tree can be stored at random memory locations
and can be linked to each other using pointers to define the structure of the tree.


Why is tree data structure important?
To understand why tree? Think about why we created other data structures.
 In order to do that, link every data structure to some real world entity and see where it fit’s well.

Will you use an array to store information of your family’s hierarchy? No right, what do you visualise this hierarchy as? I visualise it as a tree.

That is it, tree is used and important to store hierarchical data.

Tree data structure in C, C++, Java, Python
However, no data-structure is bound by any programming language.
You can choose any of the above popular programming language and implement all possible trees in it.
But, we highly recommend to go with any one of C++, Java or Python. These are object oriented language with a good number of inbuilt library functions.



Terms :
Root
Ancestor
Leaf Node
Children

* Full BT : All nodes have 0 or 2 children
                    1
             2              3
         4      5       6       7

* Complete BT : All levels except the last one are completely filled. The last level may or may not be completely filled.
                Nodes in the last level are as left as possible.
                    1
             2              3
         4      5       6       7


                             1
                      2              3
                                  6
                               7

* Perfect BT : All leaf nodes are at same level
                    1
             2              3
         4      5       6       7


* Balanced BT : Height of tree at max log base 2 (N), N = no of nodes
    For every node : Abs(height(left) - height(right)) <= 1

    N = 8 ==> log base 2 (8) = 3 ==> For 8 nodes, max height of any leaf AANode should not be more than 3.


* Degenerate BT : Every Node has single child


==================

Traversing Technique

DFS :
    Breath First Search :
        Preorder : Root Left Right
        Inorder : Left Root Right
        PostOrder : Left Right Root

BFS :
    Depth First Search
        Traversing all nodes of tree level by level.


======


Here’s a simple breakdown to remember the concepts of Full, Complete, Perfect, and Balanced binary trees:

1. Full Binary Tree

	•	Every node has 0 or 2 children.
	•	No node has only one child.
	•	Tip: Think of it as “all or nothing” for child nodes.

2. Complete Binary Tree

	•	All levels are completely filled except possibly the last.
	•	Nodes in the last level are filled from left to right.
	•	Tip: Visualize a tree filling up like water in a glass, level by level.

3. Perfect Binary Tree

	•	Every level of the tree is completely filled.
	•	Number of nodes = 2^{h+1} - 1, where h is the height.
	•	Tip: Perfect symmetry—no gaps at any level.

4. Balanced Binary Tree

	•	The height difference between the left and right subtrees of any node is at most 1.
	•	Focus is on maintaining efficient operations (like searching).
	•	Tip: Think of balance as keeping the tree from becoming skewed.

Summary Table:

Type	Key Rule	Tip
Full	Every node has 0 or 2 children	All or nothing
Complete	All levels filled except the last (left to right)	Filling a glass
Perfect	All levels fully filled	Perfect symmetry
Balanced	Height difference ≤ 1 at any node	Avoid skewness

Keep this table handy for quick recollection!

