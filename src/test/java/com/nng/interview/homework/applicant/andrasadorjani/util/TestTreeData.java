package com.nng.interview.homework.applicant.andrasadorjani.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nng.interview.homework.exercise.ListItem;
import com.nng.interview.homework.exercise.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by andra on 2016. 03. 10..

 * The class is responsible to create test data
 * the nodesOnLevel map should be initialized according to the preorderList
 */
public class TestTreeData {

    public  static Map<Integer, ArrayList<Integer>> nodesOnLevel = Maps.newHashMap();

    public static TreeNode<Integer> testTree;

    private static int[] preorderList = {10, 5, 2, 7, 15, 12, 20, 30};

    static {
        nodesOnLevel.put(0, Lists.newArrayList(10));
        nodesOnLevel.put(1, Lists.<Integer>newArrayList(5, 15));
        nodesOnLevel.put(2, Lists.<Integer>newArrayList(2, 7, 12, 20));
        nodesOnLevel.put(3, Lists.<Integer>newArrayList(30));

        testTree = constructTree();
    }

    private static TreeNode<Integer> constructTree() {
        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        Stack<Integer> levels = new Stack<Integer>();

        TreeNode<Integer> root = new TreeNode<Integer>(preorderList[0]);
        stack.add(root);
        for (int i = 1; i < preorderList.length; i++) {
            TreeNode<Integer> temp = null;
            while (!stack.isEmpty() && preorderList[i] > stack.peek().getData()) {
                temp = stack.pop();
            }
            if (temp != null) {
                temp.setRight(new TreeNode<Integer>(preorderList[i]));
                stack.push(temp.getRight());
            } else {
                stack.peek().setLeft(new TreeNode<Integer>(preorderList[i]));
                stack.push(stack.peek().getLeft());
            }
        }
        return root;
    }


}
