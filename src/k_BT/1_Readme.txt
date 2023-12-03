
Root
Ancestor
Leaf AANode
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

BFS :
    Breath First Search :
        Preorder : Root Left Right
        Inorder : Left Root Right
        PostOrder : Left Right Root

DFS :
    Depth First Search
        Traversing all nodes of tree level by level.
