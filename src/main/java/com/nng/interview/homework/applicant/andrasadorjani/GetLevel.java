package com.nng.interview.homework.applicant.andrasadorjani;

import com.google.common.base.Preconditions;
import com.nng.interview.homework.exercise.DoGetLevel;
import com.nng.interview.homework.exercise.ListItem;
import com.nng.interview.homework.exercise.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by u95425 on 2016.03.08.
 * The class implements the getLevel service
 */
public class GetLevel<T extends Comparable<T>> extends DoGetLevel<T> {

    /**
     * Query the nodes in a binary tree on a given level
     * @param treeNode The root of the binary tree
     * @param i the sequence number of the level in question. 0 is the level of the root element
     * @return A linked list containing the elements on a given level
     */
    @Override
    public ListItem<T> getLevel(TreeNode<T> treeNode, int i) {

        // check the necessary conditions described in the method documentation
        Preconditions.checkNotNull(treeNode);
        Preconditions.checkArgument(i >= 0);


        // the resultSet linked list will hold the result - the nodes from left to right on the desired level
        ListItem<T> resultSet = null;
        // the nodes queue holds the tree nodes during the traversal
        Queue<TreeNode<T>> nodes = new LinkedList<TreeNode<T>>();
        // the levels queue holds the leveles during the traversal
        Queue<Integer> levels = new LinkedList<Integer>();

        // at first add the root node - we start the traversal at the root node
        nodes.add(treeNode);
        // add the level of the root node
        levels.add(0);

        ListItem<T> result = null;
        // traversing the tree nodes - Breadth First Search
        while(!nodes.isEmpty()) {
            TreeNode<T> current = nodes.poll();
            Integer currentLevel = levels.poll();

            //we traversed all nodes in the tree, finished the Breadth First Search
            if(current == null) {
                break;
            }

            //we found a node on the desired level
            if(currentLevel == i) {
                if(result == null) {
                    result = new ListItem<T>(current.getData());
                    resultSet = result;
                }else {
                    result.setNext(new ListItem<T>(current.getData()));
                    result = result.getNext();
                }
            }else{
                // in this case we are not there, we go on with the traversal
                // add the left and right nodes to the queue - in the desired orde from left to right
                if(current.getLeft() != null){
                    nodes.add(current.getLeft());
                    levels.add(currentLevel + 1);
                }
                if(current.getRight() != null){
                    nodes.add(current.getRight());
                    levels.add(currentLevel + 1);
                }
            }
        }

        //after the traversal we return the resultSet
        return resultSet;
    }
}
