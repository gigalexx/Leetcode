package problems.medium

import algorithms.TreeNode

fun main() {

}

fun isValidBST(root: TreeNode?): Boolean {

    return isBST(root, Long.MIN_VALUE..Long.MAX_VALUE)
}

fun isBST(node: TreeNode?, range: LongRange): Boolean {
    if (node == null) return true

    if (node.value <= range.first || node.value >= range.last) return false


    return isBST(node.left, range.first..node.value) && isBST(node.right, node.value..range.last)
}
