package com.karlasequen.Year2015.Day13;

import com.karlasequen.shared.Constant;
import com.karlasequen.shared.InputData;
import org.jgrapht.alg.tour.TwoApproxMetricTSP;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.List;

/**
 * This works with the sample, but doesn't work with input
 * The solution using JS and make permutations already works
 */
public class Day13 {

    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day13/sample.txt";
//    private static final String FILE_NAME = Constant.BASE_PATH_2015 + "Day13/input.txt";

    public static void main(String[] args) {

        SimpleWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {
            String[] words = line.split(" ");
            String   from  = words[0];
            String   to    = words[10].replace(".", "");
            int      value = "gain".equals(words[2]) ? -Integer.parseInt(words[3]) : Integer.parseInt(words[3]);

            if (!graph.containsVertex(from)) {
                graph.addVertex(from);
            }
            if (!graph.containsVertex(to)) {
                graph.addVertex(to);
            }

            DefaultWeightedEdge edge = graph.getEdge(from, to);

            if (edge != null) {
                graph.setEdgeWeight(edge, graph.getEdgeWeight(edge) + value);
            } else {
                edge = graph.addEdge(from, to);
                graph.setEdgeWeight(edge, value);
            }
        }

        List<String> verticeList = new TwoApproxMetricTSP().getTour(graph).getVertexList();
        verticeList.forEach(System.out::println);

        double sum = 0;
        for (int i = 1; i < verticeList.size(); i++) {
            sum += graph.getEdgeWeight(graph.getEdge(verticeList.get(i - 1), verticeList.get(i)));
        }

        for (DefaultWeightedEdge e : graph.edgeSet()) {
            System.out.println(e);
            System.out.println(graph.getEdgeWeight(e));
        }

        System.out.println("(Part 1). " + Math.abs(sum));

    }

}
