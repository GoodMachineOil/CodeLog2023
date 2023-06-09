BFS（广度优先搜索）是一种通过遍历算法来查找图或树的搜索算法。BFS从根节点开始，逐层遍历，即先遍历完第一层所有节点，再遍历第二层所有节点，以此类推。BFS通常使用队列（Queue）来实现，具体实现方式如下：

新建一个队列，将根节点入队。

当队列不为空时，循环执行以下步骤：

a. 将队头节点出队，并访问该节点。

b. 将队头节点的所有未访问过的子节点入队。

遍历结束。

在实现BFS时，我们需要额外记录节点的层数信息，方便后续对节点按层分类。可以使用一个包含节点和层数的Pair来表示节点，然后将Pair入队。