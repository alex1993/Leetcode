package solution200_299.solution226

import structure.TreeNode
import java.util.*

/**
 * Script Created by daidai on 2017/7/14.
 */
fun invertTree(treeNode: TreeNode?): TreeNode? {
    if (treeNode == null) {
        return null
    }
    val tmp = treeNode.left
    treeNode.left = treeNode.right
    treeNode.right = tmp;
    invertTree(treeNode.left)
    invertTree(treeNode.right)
    return treeNode
}

fun bfs(treeNode: TreeNode?): TreeNode? {
    if (treeNode == null) {
        return null
    }
    val queue = LinkedList<TreeNode>()
    queue.offer(treeNode)
    while (!queue.isEmpty()) {
        val first = queue.poll()
        val tmp = first.left
        first.left = first.right
        first.right = tmp
        if (first.left != null) {
            queue.offer(first.left)
        }
        if (first.right != null) {
            queue.offer(first.right)
        }
    }
    return treeNode
}

fun main(args: Array<String>) {
    val node = TreeNode.parse(intArrayOf(4, 2, 7, 1, 3, 6, 9).toTypedArray())
    bfs(node)
    TreeNode.levelPrint(node)
}