package net.ijiangtao.tech.algorithms.algorithmall.datastructure.vector;

import net.ijiangtao.tech.algorithms.algorithmall.base.BaseTest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Vector;

public class VectorTest extends BaseTest {

    @Test
    public void test1() {
        try {

            ArrayVector arrayVector = new ArrayVector();
            arrayVector.insertAtRank(0, "A");
            arrayVector.insertAtRank(1, "B");
            arrayVector.insertAtRank(2, "C");
            arrayVector.insertAtRank(3, "D");
            arrayVector.insertAtRank(4, "E");
            arrayVector.insertAtRank(5, "F");
            arrayVector.insertAtRank(6, "G");
            System.out.println(arrayVector.getSize());
            System.out.println(arrayVector.getAtRank(2));
            System.out.println(arrayVector.removeAtRank(2));
            System.out.println(arrayVector.getAtRank(2));
            System.out.println(arrayVector.getSize());

            Vector vector = new Vector();

            Integer[] in1 = {1, 2, 3, 4, 5};
            System.out.println("in1=" + new JSONArray(in1).toString());

            Integer[] in2 = new Integer[12];
            System.arraycopy(in1, 1, in2, 1, 4);
            System.out.println("in2=" + new JSONArray(in2).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
