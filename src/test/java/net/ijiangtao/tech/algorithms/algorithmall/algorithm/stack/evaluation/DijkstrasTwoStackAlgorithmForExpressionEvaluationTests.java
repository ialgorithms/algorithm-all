package net.ijiangtao.tech.algorithms.algorithmall.algorithm.stack.evaluation;

public class DijkstrasTwoStackAlgorithmForExpressionEvaluationTests {

    public  static void main(String[] args){
        DijkstrasTwoStackAlgorithmForExpressionEvaluation expressionEvaluation=new DijkstrasTwoStackAlgorithmForExpressionEvaluation();
        System.out.println(expressionEvaluation.cal("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }

}
