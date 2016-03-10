package com.nng.interview.homework.applicant.andrasadorjani;

import com.nng.interview.homework.applicant.andrasadorjani.util.TestTreeData;
import com.nng.interview.homework.exercise.DoGetLevel;
import com.nng.interview.homework.exercise.ListItem;
import com.nng.interview.homework.exercise.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by andra on 2016. 03. 10..
 */
public class GetLevelTest {

    /**
     * Tests whether a NullPointerException is thrown in case of a null root node
     */
    @Test(expected = NullPointerException.class)
    public void testPreconditionsNullRoot () {
        DoGetLevel<Integer> instance = GetLevel.newInstance();

        // call the getLevel method with null root node
        instance.getLevel(null, 0);
    }


    /**
     * Tests whether an IllegalArgumentException is thrown in case of an invalid desired level is given
     * eg.: the given level is less than 0
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPreconditionsInvalidLevel () {
        DoGetLevel<Integer> instance = GetLevel.newInstance();

        // call the getLevel method with an invalid level argument
        instance.getLevel(new TreeNode<Integer>(1), -1);
    }

    /**
     * Tests whether the result containing all nodes fulfilling the conditions on a given level
     * The test data should be correctly set in class TestTreeData
     */
    @Test
    public void testWithExistingLevel () {
        DoGetLevel<Integer> instance = GetLevel.newInstance();

        /**
         * test results on level from the test tree
         */

        ListItem<Integer> result;
        for (Integer level : TestTreeData.nodesOnLevel.keySet()) {
            result = instance.getLevel(TestTreeData.testTree, level);
            assertLevels(result, level);
        }
    }


    /**
     * Tests whether the result is null on a level that not exists in the test tree
     */
    @Test
    public void testWithNonExistingLevel () {
        DoGetLevel<Integer> instance = GetLevel.newInstance();

        ListItem<Integer> result;
        // get results on level 0 from the test tree
        result = instance.getLevel(TestTreeData.testTree, TestTreeData.nodesOnLevel.keySet().size());
        assertNull(result);
    }


    /**
     *  Tests whether the items of result list are equal with the items of the corresponding predefined test data
     *  on the desired level
     * @param result
     * @param level
     */
    private void assertLevels (final ListItem<Integer> result, final int level) {
        if(!TestTreeData.nodesOnLevel.keySet().contains(level)) {
            assertNull(result);
            return;
        }

        ArrayList<Integer> nodesListOnLevel = TestTreeData.nodesOnLevel.get(level);
        ListItem<Integer> temp = result;
        for (Integer nodeData : nodesListOnLevel) {
            assertEquals(nodeData, temp.getData());
            temp = temp.getNext();
        }
    }
}
