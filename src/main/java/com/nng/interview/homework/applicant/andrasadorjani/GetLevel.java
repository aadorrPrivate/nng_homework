package com.nng.interview.homework.applicant.andrasadorjani;

import com.nng.interview.homework.exercise.DoGetLevel;
import com.nng.interview.homework.exercise.ListItem;
import com.nng.interview.homework.exercise.TreeNode;

/**
 * Created by u95425 on 2016.03.08.
 */
public class GetLevel<T extends Comparable<T>> extends DoGetLevel<T> {

    @Override
    public ListItem<T> getLevel(TreeNode<T> treeNode, int i) {
        System.out.println("Ez az implementáció");
        return null;
    }

}
