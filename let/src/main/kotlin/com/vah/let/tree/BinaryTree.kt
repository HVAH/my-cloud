package com.vah.let.tree

/**
 * 普通二叉树 链式结构
 */
class BinaryTree(
    var root: Node? = null
) {

    fun beforeErgodic() {
        root?.beforeErgodic()
    }

    fun middleErgodic() {
        root?.middleErgodic()
    }

    fun afterErgodic() {
        root?.afterErgodic()
    }

    fun beforeFind(target: Int): Node? {
        return root?.beforeFind(target)
    }
}

class Node(
    val value: Int,
    var l: Node? = null,
    var r: Node? = null
) {
    fun beforeErgodic() {
        println(value)
        l?.beforeErgodic()
        r?.beforeErgodic()
    }

    fun middleErgodic() {
        l?.middleErgodic()
        println(value)
        r?.middleErgodic()
    }

    fun afterErgodic() {
        l?.afterErgodic()
        r?.afterErgodic()
        println(value)
    }

    fun beforeFind(target: Int): Node? {
        var node: Node?
        if (value == target)
            return this

        node = l?.beforeFind(target)
        node ?: let {
            node = r?.beforeFind(target)
        }
        return node
    }
}

/**
 * 顺序存储结构的二叉树  只针对完全二叉树
 * 第n个节点的左节点  2n+1
 * 第n个节点的右节点  2n+2
 * 第n个节点的父节点 (n-1)/2
 */
class ArrayBinaryTree(
    val data: IntArray
) {
    private fun beforeErgodic(index: Int) {
        if (data[index] == null || index >= data.size)
            return
        println(data[index])
        if (2 * index + 1 < data.size) {
            beforeErgodic(2 * index + 1)
        }
        if (2 * index + 2 < data.size) {
            beforeErgodic(2 * index + 2)
        }
    }
    fun beforeErgodic() {
        beforeErgodic(0)
    }
}

fun main() {
    val tree = BinaryTree()
    val node = Node(1)
    node.l = Node(2, Node(4), Node(5))
    node.r = Node(3, Node(6), Node(7))
    tree.root = node
    tree.beforeErgodic()
    println("==========================")
    tree.middleErgodic()
    println("==========================")
    tree.afterErgodic()
    println("==========================")
    println(tree.beforeFind(6)?.value)
    println("==========================")
    ArrayBinaryTree(intArrayOf(1,2,3,4,5,6,7)).beforeErgodic()
}
